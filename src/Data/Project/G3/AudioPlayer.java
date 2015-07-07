package Data.Project.G3;

import javax.sound.sampled.*;
import java.io.File;
import java.net.URI;
import java.net.URL;

/**
 * ��??��????��??��????��??��??WAV�IFF�U�??�?
 *
 * @author magiclen
 */
public class AudioPlayer implements LineListener{

    /**
     * ��??��????��??��?��??����
     */
    public static enum Status {

	OPEN, START, STOP, CLOSE;
    }

    public static interface StatusChangedListener {

	public void statusChanged(Status status);
    }

    //-----��?��????��????-----
    private AudioInputStream audioInputStream;
    private AudioFormat audioFormat;
    private DataLine.Info dataLineInfo;
    private Clip clip;
    private int playCount = 1, playCountBuffer = 1;
    private int volume = 50, balance = 0;
    private Status status = null;
    private boolean autoClose = false;
    private StatusChangedListener statusListener;

    //-----?�箸��??��-----
    /**
     * ?�箸��??��??��?���?��?��??��
     *
     * @param file ���?���?��??��??��
     */
    public AudioPlayer(final File file) {
	try {
	    final URL url = file.toURI().toURL();
	    init(url);
	} catch (final Exception ex) {
	    throw new RuntimeException(ex.getMessage());
	}

    }

    /**
     * ?�箸��??��??��?���?�URL
     *
     * @param url ���?���?��?URL
     */
    public AudioPlayer(final URL url) {
	try {
	    init(url);
	} catch (final Exception ex) {
	    throw new RuntimeException(ex.getMessage());
	}
    }

    /**
     * ?�箸��??��??��?���?�URL String
     *
     * @param str ���?���?��?URL String
     */
    public AudioPlayer(final String str) {
	try {
	    final URL url = URI.create(str).toURL();
	    init(url);
	} catch (final Exception ex) {
	    throw new RuntimeException(ex.getMessage());
	}
    }

    //-----���?��??��-----
    /**
     * ���?��??��?�udioPlayer
     *
     * @param url ���?���?��?URL
     * @throws Exception ��???��????��
     */
    private void init(final URL url) throws Exception {
	//??����?�???�???��?��???���?
	try {
	    audioInputStream = AudioSystem.getAudioInputStream(url);
	} catch (final Exception ex) {
	    throw new RuntimeException(ex.getMessage());
	}
	//��?��?��??��???��??��
	audioFormat = audioInputStream.getFormat();
	int bufferSize = (int) Math.min(audioInputStream.getFrameLength() * audioFormat.getFrameSize(), Integer.MAX_VALUE); //?��?���?�????��?���?��??��??��??��??��??�????��?��??�??��?��?�?��?��?���?�?��??��?��?��???��潭�?��??���?��?��??��??��???��?��
	dataLineInfo = new DataLine.Info(Clip.class, audioFormat, bufferSize);
	clip = (Clip) AudioSystem.getLine(dataLineInfo);
	clip.addLineListener(this);
	clip.open(audioInputStream);
	setVolume();
	setBalance();
    }

    @Override
    public void update(LineEvent e) {
        LineEvent.Type type = e.getType();
        if (type.equals(LineEvent.Type.START)) {
            status = Status.START;
        } else if (type.equals(LineEvent.Type.STOP)) {
            status = Status.STOP;
            if (clip.getFramePosition() == clip.getFrameLength()) {
                clip.setFramePosition(0);
            }
            if (playCount == 0 || (playCount > 0 && playCountBuffer < playCount)) {
                playCountBuffer++;
                clip.start();
            } else {
                playCountBuffer = 1;
                if (autoClose) {
                    clip.close();
                }
            }
        } else if (type.equals(LineEvent.Type.OPEN)) {
            status = Status.OPEN;
        } else if (type.equals(LineEvent.Type.CLOSE)) {
            status = Status.CLOSE;
        } else {
            return;
        }
        if (statusListener != null) {
            statusListener.statusChanged(status);
        }
    }

    /**
     * ��??��????��??��??��??��?��?��??�?�??�����?��??����
     */
    public void play() {
	clip.start();
    }

    /**
     * ����??��??��??��
     */
    public void pause() {
	clip.stop();
    }

    /**
     * ��迫��??��??��??��??��?��??活�??��?????��?��??���??��
     */
    public void stop() {
	clip.stop();
	clip.setFramePosition(0);
    }

    /**
     * ?��??�??��?????��?��??�?0���??��??活�??��??
     *
     * @param playCount ���?��??��?????��??
     */
    public void setPlayCount(final int playCount) {
	if (playCount < 0) {
	    throw new RuntimeException("PlayCount must be at least 0!");
	}
	this.playCount = playCount;
    }

    /**
     * ?��??���?
     */
    public void mute() {
	setVolume(0);
    }

    /**
     * ��?��??���?
     *
     * @return ����?��??���?
     */
    public boolean isMute() {
	return volume == 0;
    }

    /**
     * ?��??��?��?��?��??��??�?0~100???��?��潭�??�?��??�?��?
     *
     * @param volume ���?���?���?
     */
    public void setVolume(final int volume) {
	if (volume < 0 || volume > 100) {
	    throw new RuntimeException("Volumn must be at least 0 and at most 100!");
	}
	this.volume = volume;
	setVolume();
    }

    /**
     * ����?�?���?
     *
     * @return ����?���?
     */
    public int getVolume() {
	return volume;
    }

    /**
     * ?��??��?���?
     */
    private void setVolume() {
	final FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	final float db = (float) (Math.log10(volume * 0.039) * 10);
	floatControl.setValue(db);
    }

    /**
     * ����?�?��??�??��????��??��?��??����
     *
     * @return �������?
     */
    public Status getStatus() {
	return status;
    }

    /**
     * ��?����??��??���?���?
     */
    public void onlyRight() {
	setBalance(100);
    }

    /**
     * ��?��??��?����??��??���?���?
     *
     * @return ����?��??��?����??��??���?���?
     */
    public boolean isOnlyRight() {
	return balance == 100;
    }

    /**
     * ��?����??��?椰��?���?
     */
    public void onlyLeft() {
	setBalance(-100);
    }

    /**
     * ��?��??��?����??��?椰��?���?
     *
     * @return ����?��??��?����??��?椰��?���?
     */
    public boolean isOnlyLeft() {
	return balance == -100;
    }

    /**
     * ?��??��?��?��?��?�???��?�����?
     */
    public void balance() {
	setBalance(0);
    }

    /**
     * ��?��?��?��?��?��??�???��?�����?
     *
     * @return ����?��?��?��?��?��??�???��?�����?
     */
    public boolean isBalance() {
	return balance == 0;
    }

    /**
     * ?��??��?��?��?��?��?????��?��?��??��-100~100???��?��潭�??�?��??���?��?����??��0�???��?�����?
     *
     * @param balance ���?���?��?��?��?��?????��?���?
     */
    public void setBalance(final int balance) {
	if (volume < 0 || volume > 100) {
	    throw new RuntimeException("Balance must be at least -100 and at most 100!");
	}
	this.balance = balance;
	setBalance();
    }

    /**
     * ����?�?��?��?��?��?????��?���?
     *
     * @return ����?��?��?��?��?????��?���?
     */
    public int getBalance() {
	return balance;
    }

    /**
     * ?��??��?��?��?��?��?????��?���?
     */
    private void setBalance() {
	try {
	    final FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.PAN);
	    final float pan = balance / 100.0f;
	    floatControl.setValue(pan);
	} catch (final Exception ex) {
	    //��?��??��?��?��?��?��??��??��??��?��??��??��??��
	}
    }

    /**
     * ����?�??��??��???��?��(?��?��)
     *
     * @return ����??��??��???��?��
     */
    public long getAudioLength() {
	return clip.getMicrosecondLength();
    }

    /**
     * ����?�??��??�?��??��??��????(?��?��)
     *
     * @return ����??��??�?��??��??��????
     */
    public long getAudioPosition() {
	return clip.getMicrosecondPosition();
    }

    /**
     * ?��??��??��??��??��????(?��?��)
     *
     * @param position ���?���??��??��??��????
     *
     */
    public void setAudioPosition(long position) {
	clip.setMicrosecondPosition(position);
    }

    /**
     * ���?��??��
     */
    public void close() {
	clip.close();
    }

    /**
     * ?��??�??��???��??��?��?��?��??��?����??���
     *
     * @param autoClose ���?��??��???��??��?��?��?��??��?����??���
     */
    public void setAutoClose(final boolean autoClose) {
	this.autoClose = autoClose;
    }

    /**
     * ����???��???��??��?��?��?��??��?����??���
     *
     * @return ����??��???��??��?��?��?��??��?����??���
     */
    public boolean isAutoClose() {
	return autoClose;
    }

    /**
     * ?��??�����????????��?��??�?��??��??�?
     *
     * @param listener ���?������????????��??�?��??��??�?
     */
    public void setStatusChangedListener(StatusChangedListener listener) {
	this.statusListener = listener;
    }

    /**
     * ����?����????????��?��??�?��??��??�?
     *
     * @return ������????????��?��??�?��??��??�?
     */
    public StatusChangedListener getStatusChangedListener() {
	return statusListener;
    }
}

package Data.Project.G9.tw.tku.tankwar.util;

import java.applet.*;
import java.io.InputStream;

/**
 * 聲效文件加載器. 
 * 
 * @author 
 */
public class AudioLoader {
	
	/**
	 * 加載聲效文件 . 
	 * @param	_file
	 * @return	AudioClip
	 */
	public static AudioClip loadAudio( String _file ) {
		return Applet.newAudioClip(AudioLoader.class.getResource("/Data/Project/G9/res/sound/"+_file));
	}
	
	public static InputStream getAudioAsStream( String _file ) {
		return AudioLoader.class.getResourceAsStream("/Data/Project/G9/res/sound/"+_file);
	}
}

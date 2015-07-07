package Data.Project.G9.tw.tku.tankwar.tank;

import Data.Project.G9.tw.tku.tankwar.Battlefield;
import Data.Project.G9.tw.tku.tankwar.BulletFactory;
import Data.Project.G9.tw.tku.tankwar.model.Bullet;
import Data.Project.G9.tw.tku.tankwar.model.Tank;
import Data.Project.G9.tw.tku.tankwar.util.IConstants;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 玩家坦克 .
 * 
 * @author 
 */
public class HeroTank extends Tank {

	public HeroTank(Battlefield bf, Image[] images, int t, int serial,
				int x, int y, int rows, int cols) {
		super(bf, images, t, serial, x, y, cols, cols, IConstants.DIRECTION_U, 5);
	}
	
	public HeroTank(Battlefield bf, Image[] images, int t, int serial,
				int x, int y, int rows, int cols, int head, int blood ) {
		super(bf, images, t, serial, x, y, rows, cols, head, blood);
	}
	
	public void keyPress( KeyEvent e ) {  //改變方向
		if ( ! alive ) return;
		switch ( e.getKeyCode() ) {
		case KeyEvent.VK_A:
			direction |= IConstants.DIRECTION_L;
			break;
		case KeyEvent.VK_S:
			direction |= IConstants.DIRECTION_D;
			break;
		case KeyEvent.VK_D:
			direction |= IConstants.DIRECTION_R;
			break;
		case KeyEvent.VK_W:
			direction |= IConstants.DIRECTION_U;
			break;
		case KeyEvent.VK_B:
			missile--;
			Bullet mbt = BulletFactory.createHeroBullet(BF, 
				this, Bullet.MISSILE_BULLET, 0, 0, head);
			mbt.setX(x + (cols - mbt.getCols()) / 2);
			mbt.setY(y + (rows - mbt.getRows()) / 2);
			BF.addSynBullet(mbt);
			break;
		}
	}
	
	public void keyRelease( KeyEvent e ) {
		if ( ! alive ) return;	
		switch ( e.getKeyCode() ) {
		case KeyEvent.VK_A:
			direction &= ~IConstants.DIRECTION_L;
			break;
		case KeyEvent.VK_S:
			direction &= ~IConstants.DIRECTION_D;
			break;
		case KeyEvent.VK_D:
			direction &= ~IConstants.DIRECTION_R;
			break;
		case KeyEvent.VK_W:
			direction &= ~IConstants.DIRECTION_U;
			break;
		case KeyEvent.VK_J:
			if ( couldShot() ) {		//子彈上限
			Bullet nbt = BulletFactory.createHeroBullet(BF, 
						this, Bullet.NORMAL_BULLET, 0, 0, head);
			nbt.setX(x + (cols - nbt.getCols()) / 2);
			nbt.setY(y + (rows - nbt.getRows()) / 2);
			increaseMovingBullets();
			BF.addSynBullet(nbt);
			}
			break;
		case KeyEvent.VK_K:
			if ( bomb > 0 && couldShot() ) {
				bomb--;
				Bullet bbt = BulletFactory.createHeroBullet(BF,
						this, Bullet.BOMB_BULLET, 0, 0, head);
				bbt.setX(x + (cols - bbt.getCols()) / 2);
				bbt.setY(y + (rows - bbt.getRows()) / 2);
				increaseMovingBullets();
				BF.addSynBullet(bbt);
			}
			break;
		case KeyEvent.VK_L:
			if ( missile > 0 && couldShot() ) {
				missile--;
				Bullet mbt = BulletFactory.createHeroBullet(BF, 
						this, Bullet.MISSILE_BULLET, 0, 0, head);
				mbt.setX(x + (cols - mbt.getCols()) / 2);
				mbt.setY(y + (rows - mbt.getRows()) / 2);
				increaseMovingBullets();
				BF.addSynBullet(mbt);
			}
			break;
		case KeyEvent.VK_B:
			this.bomb=100;
			this.missile=100;
			this.blood=7;
			break;
		}
		
	}
}

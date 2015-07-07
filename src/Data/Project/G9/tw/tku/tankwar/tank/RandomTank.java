package Data.Project.G9.tw.tku.tankwar.tank;

import Data.Project.G9.tw.tku.tankwar.Battlefield;
import Data.Project.G9.tw.tku.tankwar.BulletFactory;
import Data.Project.G9.tw.tku.tankwar.model.Bullet;
import Data.Project.G9.tw.tku.tankwar.model.Tank;

import java.awt.*;

/**
 * random tank class . 
 * 特點：所有動作隨機
 * @author 
 */
public class RandomTank extends Tank {
	
	private int[] seeds = new int[] {20, 50};
	
	private int moveInterval = 10;
	private int shotInterval = 10;
	
	public RandomTank(Battlefield bf, Image[] images, int t, int serial,
				int x, int y, int rows, int cols ) {
		super(bf, images, t, serial, x, y, rows, cols);
	}
	
	public RandomTank( Battlefield bf, Image[] images, int t,
			int serial, int x, int y, int rows, int cols, int head, int blood ) {
		super(bf, images, t, serial, x, y, rows, cols, head, blood);
	}
	
	public void draw( Graphics g ) {
		super.draw(g);
		//自動移動
		if ( moveInterval-- == 0 ) {
			int t = ( ( int ) ( Math.random() * 10000 ) ) % 7;
			direction = 1 << t;
			moveInterval = ( (int) ( Math.random() * 1000) ) % seeds[0];
		}
		
		//自動攻擊
		if ( shotInterval-- == 0 ) {
			if ( couldShot() ) {
			Bullet bbt = BulletFactory.createEnemyBullet(BF, 
					this, Bullet.NORMAL_BULLET, 0, 0, head);
			bbt.setX(x + (cols - bbt.getCols()) / 2);
			bbt.setY(y + (rows - bbt.getRows()) / 2);
			increaseMovingBullets();
			BF.addBullet(bbt);
			shotInterval = ( ( int ) ( (Math.random() + 1) * 10000 ) ) % seeds[1];
			}
		}
	}
	
	/**
	 * 設置CD. 
	 * seeds[0] = 移動間隔,
	 * seeds[1] = 射速間隔
	 * 
	 * @param	seeds
	 */
	public void setSeeds( int[] seeds ) {
		this.seeds = seeds;
	}
}

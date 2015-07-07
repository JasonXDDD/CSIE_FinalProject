package Data.Project.G9.tw.tku.tankwar;

import Data.Project.G9.tw.tku.tankwar.model.Bullet;
import Data.Project.G9.tw.tku.tankwar.model.Tank;

/**
 * 子彈庫類
 * @author BB
 */
public class BulletFactory {
	
	//行，列
	private static short[][] rect = {
		new short[]{3, 3},
		new short[]{4, 4},
		new short[]{5, 5}
	};
	
	//速度, 血量
	public static short[][] heroDamage = {
		new short[] {4, 1},			//子彈
		new short[] {5, 5},			//炸彈
		new short[] {6, 10}			//飛彈
	};
	
	public static short[][] enemyDamage = {
		new short[] {4, 1},			//子彈
		new short[] {5, 5},			//炸彈
		new short[] {6, 10}			//飛彈
	};
	
	/**
	 * 創建玩家子彈 <br />
	 * 
	 * @param	bf
	 * @param	mtank
	 * @param	t
	 * @param	x
	 * @param	y
	 * @param	direction
	 */
	public static Bullet createHeroBullet( Battlefield bf, 
					Tank mtank, short t, int x, int y, int direction ) {
		Bullet e = new Bullet(bf, Battlefield.bulletImages[t],
				t, mtank, Tank.HERO_TANK, x, y, rect[t][0], rect[t][1], direction);
		e.setOffset(heroDamage[t][0]);
		e.setBlood(heroDamage[t][1]);
		return e;
	}
	
	
	/**
	 * 創建疊人子彈. 
	 * @param	bf
	 * @param	mtank
	 * @param	t
	 * @param	x
	 * @param	y
	 * @param	direction
	 */
	public static Bullet createEnemyBullet( Battlefield bf, 
					Tank mtank, short t, int x, int y, int direction ) {
		Bullet e = new Bullet(bf, Battlefield.bulletImages[t],
				t, mtank, Tank.ENEMY_TANK, x, y, rect[t][0], rect[t][1], direction);
		e.setOffset(enemyDamage[t][0]);
		e.setBlood(enemyDamage[t][1]);
		return e;
	}
}

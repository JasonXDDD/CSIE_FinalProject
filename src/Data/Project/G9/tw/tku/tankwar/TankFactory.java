package Data.Project.G9.tw.tku.tankwar;

import Data.Project.G9.tw.tku.tankwar.model.Tank;
import Data.Project.G9.tw.tku.tankwar.tank.HeroTank;
import Data.Project.G9.tw.tku.tankwar.tank.RandomTank;

/**
 * tank生成類 
 * 
 * @author BB
 */
public class TankFactory {
	
	//方向,速度,血量, 炸彈, 飛彈
	private static int serial = 1;
	public static final int DEFAULT_TANK_OUTPUT = 5;
	private static int tanknum = 0;
	
	public static void reset() {
		serial = 1;
		tanknum = 0;
	}
	
	public static int getTankOutput() {
		return tanknum;
	}
	/**
	 * 創建tank.
	 * 
	 * @param	bf
	 * @param	w
	 * @param	h
	 * @return	HeroTank
	 */
	public static HeroTank createCenterHeroTank( Battlefield bf,
							int w, int h, int[] cfg ) {
		int rows = (h / bf.getMap().getYoffset());
		int cols = (w / bf.getMap().getXoffset());
		HeroTank hTank = new HeroTank( bf, Battlefield.heroImages, Tank.HERO_TANK, serial++,
				bf.getMap().getCols() / 2,
				bf.getMap().getRows() - rows, rows, cols);
		hTank.setHead(cfg[0]);
		hTank.setOffset(cfg[1]);
		hTank.setBlood(cfg[2]);
		hTank.setBomb(cfg[3]);
		hTank.setMissile(cfg[4]);
		return hTank;
	}
	
	/**
	 * 創建敵人tank. 
	 * 
	 * @param	bf
	 * @param	w
	 * @param	h
	 * @return	Tank
	 */
	public static RandomTank createRandomTank( Battlefield bf, 
						int w, int h, int[] cfg ) {
		short rows = (short) (h / bf.getMap().getYoffset());
		short cols = (short) (w / bf.getMap().getXoffset());
		int i = ( int ) ( Math.random() * 1000 ) % Battlefield.enemyImages.length;
		int x = ( ( int ) (Math.random() * 10000) ) % ( bf.getMap().getCols() - cols);
		RandomTank etank = new RandomTank( bf, 
				Battlefield.enemyImages[i], Tank.ENEMY_TANK, serial++, x, 0, rows, cols );
		etank.setHead(cfg[0]);
		etank.setOffset(cfg[1]);
		etank.setBlood(cfg[2]);
		etank.setBomb(cfg[3]);
		etank.setMissile(cfg[4]);
		etank.setSeeds(new int[] {cfg[5], cfg[6]});
		tanknum++;
		return etank;
	}
}

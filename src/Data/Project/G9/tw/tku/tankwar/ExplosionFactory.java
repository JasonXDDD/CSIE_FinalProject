package Data.Project.G9.tw.tku.tankwar;

import Data.Project.G9.tw.tku.tankwar.model.Explosion;

/**
 *  爆炸庫類
 * 
 * @author BB
 */
public class ExplosionFactory {
	
	//行，列，速度
	private static short[][] exp = new short[][] {
		new short[] {30, 30, 0},
		new short[] {42, 42, 0},
	};
	
	/**
	 * 創建爆炸 
	 * @param	bf
	 * @param	x
	 * @param	y
	 * @param	t
	 * @return	Explosion
	 */
	public static Explosion createExplosion( Battlefield bf, int x, int y, int t ) {
		return new Explosion( bf, Battlefield.explosionImages[t], t,
				x, y, exp[t][0], exp[t][1], exp[t][2] );
	}
}

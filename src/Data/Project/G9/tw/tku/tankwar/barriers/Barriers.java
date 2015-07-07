package Data.Project.G9.tw.tku.tankwar.barriers;

/**
 * tank war 關卡控制類 .
 * 
 * @author 
 */
public class Barriers {
	
	private int enemy;			/*敵人數量*/
	//方向,速度,血量,炸彈,飛彈
	private int[] heroArgs;
	//方向,速度,血量,炸彈,飛彈,移動間隔,發射間隔
	private int[] enemyArgs;
	private short[][] heroBulletArgs;
	private short[][] enemyBulletArgs;
	
	/**構造方法*/
	public Barriers( int enemy, int[] heroArgs, 
			int[] enemyArgs, short[][] heroBulletArgs, short[][] enemyBulletArgs ) {
		this.enemy = enemy;
		this.heroArgs = heroArgs;
		this.enemyArgs = enemyArgs;
		this.heroBulletArgs = heroBulletArgs;
		this.enemyBulletArgs = enemyBulletArgs;
	}
	
	public int getEnemyNumber() {
		return enemy;
	}
	
	public int[] getHeroArgs() {
		return heroArgs;
	}
	
	public int[] getEnemyArgs() {
		return enemyArgs;
	}
	
	public short[][] getHeroBulletArgs() {
		return heroBulletArgs;
	}
	
	public short[][] getEnemyBulletArgs() {
		return enemyBulletArgs; 
	}
}

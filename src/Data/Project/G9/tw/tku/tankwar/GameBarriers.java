package Data.Project.G9.tw.tku.tankwar;

import Data.Project.G9.tw.tku.tankwar.barriers.Barriers;
import Data.Project.G9.tw.tku.tankwar.util.IConstants;

/**
 * 關卡 
 * 
 * @author BB
 */
public class GameBarriers {
	
	public static final Barriers[] DEFAULT = new Barriers[] {
		new Barriers(
			15, 
			//方向，速度，血量，炸彈，飛彈
			new int[] {IConstants.DIRECTION_U, 1, 5, 10, 10},
			//方向，速度，血量，炸彈，飛彈,移動間隔，發射間隔
			new int[] {IConstants.DIRECTION_D, 1, 1, 0, 0, 40, 80},
			//子彈,速度,血量
			new short[][] {					//玩家
				new short[] {4, 1},			//子彈
				new short[] {4, 2},			//炸彈
				new short[] {5, 5}			//飛彈
			},
			new short[][] {					//敵人
				new short[] {4, 1},
				new short[] {4, 2},
				new short[] {5, 5}
			}
		),
		new Barriers(
			25,
			new int[] {IConstants.DIRECTION_U, 1, 5, 5, 5},
			new int[] {IConstants.DIRECTION_D, 1, 3, 1, 1, 20, 50},
			new short[][] {
				new short[] {4, 1},
				new short[] {4, 3},
				new short[] {5, 5}
			},
			new short[][] {
				new short[] {4, 1},
				new short[] {4, 3},	
				new short[] {5, 4}
			}
		),
		//barriers 3
		new Barriers(
			30,
			new int[] {IConstants.DIRECTION_U, 2, 5, 3, 2},
			new int[] {IConstants.DIRECTION_D, 2, 7, 2, 1, 20, 50},
			new short[][] {
				new short[] {4, 1},
				new short[] {4, 5},
				new short[] {5, 7}
			},
			new short[][] {
				new short[] {4, 1},
				new short[] {4, 5},	
				new short[] {5, 10}
			}
		),
		//barrier 4
		new Barriers(
			30,
			new int[] {IConstants.DIRECTION_U, 1, 5, 5, 2},
			new int[] {IConstants.DIRECTION_D, 3, 10, 5, 10, 10, 55},
			new short[][] {
				new short[] {4, 1},
				new short[] {4, 5},
				new short[] {5, 10}
			},
			new short[][] {
				new short[] {4, 1},
				new short[] {4, 5},	
				new short[] {5, 10}
			}
		),
		new Barriers(
			50,
			new int[] {IConstants.DIRECTION_U, 2, 5, 8, 5},
			new int[] {IConstants.DIRECTION_D, 3, 3, 5, 10, 10, 50},
			new short[][] {
				new short[] {4, 1},
				new short[] {4, 5},
				new short[] {5, 10}
			},
			new short[][] {
				new short[] {4, 1},
				new short[] {4, 5},	
				new short[] {5, 10}
			}
		),
		new Barriers(
			1,
			new int[] {IConstants.DIRECTION_U, 2, 5, 5, 5},
			new int[] {IConstants.DIRECTION_D, 4, 10000, 10, 3, 10, 50},
			new short[][] {
				new short[] {4, 1},
				new short[] {4, 5},
				new short[] {6, 10}
			},
			new short[][] {
				new short[] {4, 1},
				new short[] {4, 5},	
				new short[] {6, 10}
			}
		),
		new Barriers(
				10000,
				//方向，速度，血量，飛彈，飛彈
				new int[] {IConstants.DIRECTION_U, 3, 5, 10,5},
				//方向，速度，血量，炸彈，飛彈,移動間隔，發射間隔
				new int[] {IConstants.DIRECTION_D, 5, 10, 1, 1, 15, 50},
				new short[][] {
					new short[] {4, 1},
					new short[] {4, 2},
					new short[] {3, 10}
				},
				new short[][] {
					new short[] {4, 1},
					new short[] {4, 2},	
					new short[] {5, 3}
				}
			)
	};
}

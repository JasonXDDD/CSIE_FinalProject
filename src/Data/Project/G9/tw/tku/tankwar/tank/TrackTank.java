package Data.Project.G9.tw.tku.tankwar.tank;

import Data.Project.G9.tw.tku.tankwar.Battlefield;
import Data.Project.G9.tw.tku.tankwar.model.Tank;

import java.awt.*;

/**
 * Track tank class .<br/>
 * 特點：總是朝玩家方向移動並且攻擊玩家
 * @author 賴
 */
public class TrackTank extends Tank {

	public TrackTank(Battlefield bf, Image[] images, int t, int serial,
			int x, int y, int cols, int rows) {
		super(bf, images, t, serial, x, y, cols, rows);
	}

}

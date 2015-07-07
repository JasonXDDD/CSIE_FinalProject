package Data.Project.G9.tw.tku.tankwar.tank;

import Data.Project.G9.tw.tku.tankwar.Battlefield;
import Data.Project.G9.tw.tku.tankwar.model.Tank;

import java.awt.*;

/**
 * fight back tank class . 
 * 特點：未收到攻擊時隨機移動，當收到玩家攻擊時給與回擊
 * @author 
 */
public class FightBackTank extends Tank {

	public FightBackTank(Battlefield bf, Image[] images, int t, int serial,
			int x, int y, int cols, int rows) {
		super(bf, images, t, serial, x, y, cols, rows);
	}

}

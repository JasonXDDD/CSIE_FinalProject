package Data.Project.G9.tw.tku.tankwar.tank;

import Data.Project.G9.tw.tku.tankwar.Battlefield;
import Data.Project.G9.tw.tku.tankwar.model.Tank;

import java.awt.*;

/**
 * circle tank class . <br />
 * 特點：四處移動射擊中心   <br />
 * @author 
 */
public class CircleTank extends Tank {

	public CircleTank(Battlefield bf, Image[] images, int t, int serial,
			int x, int y, int cols, int rows) {
		super(bf, images, t, serial, x, y, cols, rows);
	}

}

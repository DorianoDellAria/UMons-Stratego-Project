package pieces;

import board.*;

/**
 * @author D.Dell'Aria
 */
public interface Movable {
	public void move(Board b, int x, int y,Direction direction);
}

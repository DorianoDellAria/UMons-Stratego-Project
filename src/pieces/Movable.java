package pieces;

/**
 * @author D.Dell'Aria
 */
public interface Movable {
	public void move(Direction direction);
	public Piece fight(Piece defense);
}

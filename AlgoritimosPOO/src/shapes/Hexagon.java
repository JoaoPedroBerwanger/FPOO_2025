package shapes;

public class Hexagon extends AbstractShape {
	
	private final float side;
	
	public Hexagon(float side) {
		this.side = side;
	}
	
	public float getSide() {
		return side;
	}
	
	@Override
	public float area() {
		return (float) ((3 * Math.sqrt(3) * (side * side))/2);
	}

	@Override
	public float perimeter() {
		return 6 * side;
	}	
}

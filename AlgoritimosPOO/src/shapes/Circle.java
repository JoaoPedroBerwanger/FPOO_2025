package shapes;

public class Circle extends AbstractShape {
	
	private final float radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}

	public float getRadius() {
		return radius;
	}
	
	@Override
	public float area() {
		return (float)(Math.PI * (radius * radius));
	}
	
	@Override
	public float perimeter() {
		return (float)(2 * Math.PI * radius);
	}
}

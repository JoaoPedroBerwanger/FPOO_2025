package shapes;

public class Rectangle extends AbstractShape {
	
	private final float heigh;
	private final float width;

	public Rectangle(float heigh, float widht) {
		this.heigh = heigh;
		this.width = widht;
	}
	
	public float getHeigh() {
		return heigh;
	}

	public float getWidth() {
		return width;
	}
	
	@Override
	public float area() {
		return (heigh * width);
	}
	
	@Override
	public float perimeter() {
		return (2 * (width + heigh));
	}
}

package shapes;

public class Triangle {
	
	private final float sideA;
	private final float sideB;
	private final float sideC;
	
	public Triangle(float sideA, float sideB, float sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	public float area() {
		float p = (perimeter() / 2) ;
		
		return (float) Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
	}

	private float perimeter() {
		return sideA + sideB + sideC;
	}

	public float getSideA() {
		return sideA;
	}

	public float getSideB() {
		return sideB;
	}

	public float getSideC() {
		return sideC;
	}
}

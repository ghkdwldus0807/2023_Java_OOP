//21101989 황지연
public class TestPractice2 {

	public static void main(String[] args) {
		GeometricObjectComparable[] object = {new Square(2), new Circle(5), new Square(5),
				new Rectangle(3,4), new Square(4.5)};
		
		for (int i = 0; i< object.length; i++) {
			System.out.println("Area is " + object[i].getArea());
			if(object[i] instanceof Colorable) {
				((Colorable)object[i]).howToColor();
			}
		}

	}

}

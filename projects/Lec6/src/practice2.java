//21101989 황지연

import java.util.*;
public class practice2 {

	public static void main(String[] args) {
		
		System.out.println("Enter two end points for the first line segment x1,y1,x2,y2");
		Scanner input = new Scanner(System.in);
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		
		System.out.println("Enter two end points for the second line segment x3,y3,x4,y4");
		Scanner input2 = new Scanner(System.in);
		double x3 = input2.nextDouble();
		double y3 = input2.nextDouble();
		double x4 = input2.nextDouble();
		double y4 = input2.nextDouble();
		
		 LinearEquation test= new LinearEquation(y1 - y2, x2 - x1, y3 - y4, x4 - x3, (y1 - y2) * x1 - (x1 - x2) * y1, (y3 - y4) * x3 - (x3 - x4) * y3);
		 
	        if (test.isSolvable()) {
	            double x = test.getX();
	            double y = test.getY();

	            System.out.println("The intersecting point is x = "+x +" and y = "+y);
	        } else {
	            System.out.println("두 선분은 평행합니다.");
	        }

	}

}

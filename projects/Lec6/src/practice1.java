//21101989 황지연

import java.util.*;

public class practice1 {

	public static void main(String[] args) {
		
		System.out.println("Enter a,b,c,d,e,f");
		Scanner input = new Scanner(System.in);
		
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        
        LinearEquation test = new LinearEquation(a,b,c,d,e,f);
        
        if(test.isSolvable()) {
        	System.out.println("x = "+test.getX()+" y = "+test.getY());
        }else {
        	System.out.println("The equation has no solution");
        }

	}

}

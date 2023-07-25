package practice2;

import java.util.Scanner;

public class prac2 {

	public static void main(String[] args) {
		System.out.println("Enter three edges (length in double):");
		Scanner input = new Scanner(System.in);
		double a1 = input.nextDouble();
		double a2 = input.nextDouble();
		double a3 = input.nextDouble();
		double b = a1+a2+a3;
		
		double [] doublearray = new double[] {a1,a2,a3};
		double max = doublearray[0];
		
		for(int i=0; i<doublearray.length ; i++) {
			if(doublearray[i]>max) {
				max=doublearray[i];
			}
			
		}
		
		if (max<b-max) {
			System.out.println("The parameter is " +b);}
		else
			System.out.println("Input is valid");
		

	}

}

package practice1;

import java.util.*;



public class prac1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Enter an integer between 0 and 1000");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		
		int b = a/100; //백의 자리
		int c = a%100; // 십의 자리 추출
		int d = c/10; //십의 자리
		int e = c%10; //일의 자리
		
		int f = b*d*e;
		
		System.out.println("The multiplication of all digits in "+a+" is "+f);
		

	}

}

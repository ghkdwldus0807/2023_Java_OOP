//21101989 황지연

import java.util.*; 

public class practice1 {
	
	
	public static void main(String[] args) { // 숫자 입력받고 결과 출력
		
		System.out.print("Enter an integer");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		
		System.out.println(isPalindrome(number));
		
	}
	

	public static boolean isPalindrome(int number) {
		
		if(number==reverse(number)) {
			return true;
		}
		else {
			return false;
		}
		

	}
	
	public static int reverse(int number) {
		
		int result = 0;
		while(number!=0) {
			result = result*10 + number%10;
			number /=10;
		}
		
		return result;
	
	}

}

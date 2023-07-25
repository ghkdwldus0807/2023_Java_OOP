//21101989 황지연

public class practice2 {

	public static void main(String[] args) {
		
		int count = 0;
		
		for (int i=2; count !=100; i++) {
			if (!practice1.isPalindrome(i)&&isPrime(i)&&isPrime(practice1.reverse(i))) {
				System.out.print(i+" ");
				count++;
				if (count % 10 == 0) {
					System.out.print("\n");
				}
			}
		}
		

	}
	
	public static boolean isPrime(int number) { //소수인지
		
		for (int i=2; i<number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
		
	}
	

}

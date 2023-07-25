
import java.util.*;

public class project3 {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		System.out.print("Enter number of lines");
		Scanner input = new Scanner (System.in);
		int lines = input.nextInt();
		int space = (lines-1)*2;
		
		for(int i=0; i<=lines; i++) {
			
			int center = i;
			
			for(int s=0; s<space+3; s++) {
				System.out.print(" ");
			}

			for(int j = 1; j<=2*i-1; j++) {
				System.out.print(center);
				System.out.print(" ");
				
				if (j<i)
					center --;
				else
					center ++;
				}
			
			System.out.println();
			space = space-2;
			
			if (lines>=10 && i<9) {
				for(int a = 1 ; a<=lines-9; a++) {
					System.out.print(" ");
				}}
				else if (lines>=10 && i>=9 && i<lines) {
					for (int b =1; b<=lines-i-1; b++) {
						System.out.print(" ");}}


							}
						}
					}
				
			
			
		
		
		

	



import java.util.*;

public class project4 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
	
		int yourscore = 0;

		
		
		while(-2<yourscore && yourscore<2){

			int random = (int)(Math.random()*3);	
			String[] a = {"scissor","rock","paper"};
			
			System.out.println("computer is "+a[random]); //컴퓨터 랜덤 가위바위보 
			
			System.out.print("scissor (0), rock (1), paper(2)");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			int result = random - choice;
					
			if(result ==0) {
				System.out.println("You Draw");
						
				}
			else if (result==2 ||result==-1 ) {
				System.out.println("You won");
				yourscore = yourscore+1;
						}
				
					
			else if(result==1 || result==-2) {
				System.out.println("You loss");
					yourscore=yourscore-1;}
		
			
			} 
			if(yourscore==2) {
				System.out.println("You won more than two times");}
			else if (yourscore==-2) {
				System.out.println("Computer won more than two times");}}
			}






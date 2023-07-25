import java.util.*;
//21101989 황지연

public class ArrayIndexOutBoundsException {

	public static void main(String[] args) {
        int[] array = new int[120];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000); 
        }
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index: ");
        int index = input.nextInt();
        
        try {
        	System.out.println("The element is " + array[index]);
        }catch(ArrayIndexOutOfBoundsException e) {
        	System.out.println("Index out of bound");
        }

	}

}

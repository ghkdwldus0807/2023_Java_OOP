//21101989 황지연

import java.util.*;

public class practice1 {

	public static void main(String[] args) {
		
		System.out.println("Enter the number of elements");
		Scanner input = new Scanner(System.in);
		int[] list = new int[input.nextInt()];
		System.out.println("Enter a list");
		for (int i=0; i<list.length; i++) {
			list[i]=input.nextInt();
		}

		int pivotIndex = partition(list);
		
		System.out.print("After the partition, the list is ");
		for (int i : list) {
			System.out.print(i+" ");
		}

	}
	

	
    public static int partition(int[] list) {
        int pivot = list[0];
        int left = 1;
        int right = list.length - 1;
        while (left <= right) {
            while (left <= right && list[left] <= pivot) {
                left++;
            }
            while (left <= right && list[right] > pivot) {
                right--;
            }
            if (left < right) {
                int temp = list[left];
                list[left] = list[right];
                list[right] = temp;
            }
        }
        int pivotIndex = left - 1;
        list[0] = list[pivotIndex];
        list[pivotIndex] = pivot;
        return pivotIndex;
    }
	


}


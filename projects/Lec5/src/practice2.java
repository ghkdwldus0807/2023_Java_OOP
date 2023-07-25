//21101989 황지연

import java.util.*;
public class practice2 {

	public static void main(String[] args) {


		int [][] weekly_hour = {
				{2,4,3,4,5,8,8},{7,3,4,3,3,4,4},{3,3,4,3,3,2,2},{9,3,4,7,3,4,1},
				{3,5,4,3,6,3,8},{3,4,4,6,3,4,4},{3,7,4,8,3,8,4},{6,3,5,9,2,7,9}
		};
		
		int[] total_hours = new int[weekly_hour.length];
		
		for(int i=0;i<weekly_hour.length; i++) {
			int sum = 0;
			for(int j=0;j<7;j++ ) {
				sum+=weekly_hour[i][j];
				
			}
			total_hours[i] = sum;
		}
		
		 Integer[] employee = new Integer[weekly_hour.length];
	        for (int i = 0; i < employee.length; i++) {
	        	employee[i] = i;
	        }
	        Arrays.sort(employee, new Comparator<Integer>() {
	            @Override
	            public int compare(Integer o1, Integer o2) {
	                return Integer.compare(total_hours[o2], total_hours[o1]);
	            }
	        });
	        
	       
	     for (int i = 0; i < employee.length; i++) {
	         	int index = employee[i];
	            System.out.println("Employee " + (index) + ": " + total_hours[index]);
	        }
	
		

	}

}

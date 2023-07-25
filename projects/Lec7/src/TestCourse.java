//21101989 황지연

public class TestCourse {

	public static void main(String[] args) {
		
		Course course1 = new Course("course1");
		Course course2 = new Course("course2");
		
		course1.addStudent("Peter Jones");
		course1.addStudent("Brain Smith");
		course1.addStudent("Anne Kennedy");
		
		course2.addStudent("S1");
		course2.addStudent("S2");
		course2.addStudent("S3");
		course2.addStudent("S4");
		
		
		
		System.out.println("Number of students in course1: "+course1.getNumberOfStudents());
		
		String[] course1_name = course1.getStudents();
	    for (int i = 0; i < course1.getNumberOfStudents(); i++) {
	            System.out.print(course1_name[i]+", ");}
	    System.out.println();
	    
		System.out.println("Number of students in course2: "+course2.getNumberOfStudents());
		
		String[] course2_name = course2.getStudents();
	    for (int i = 0; i < course2.getNumberOfStudents(); i++) {
	            System.out.print(course2_name[i]+", ");}
	    System.out.println();  
	    //add student
	    
	    course1.dropStudent("Peter Jones");
	    
	    System.out.println("Number of students in course1 after drop Peter Jones: "+course1.getNumberOfStudents());
	    
	    course1_name = course1.getStudents();
	    for (int i = 0; i < course1.getNumberOfStudents(); i++) {
            System.out.print(course1_name[i]+", ");}
	    System.out.println();
	    // drop course1
	    
	    course1.clear();
	    course1_name = course1.getStudents();
	    System.out.println("Number of students in course1 after clear: "+course1.getNumberOfStudents());
	    //clear course1
	    
	    course2.dropStudent("S2");
	    
	    System.out.println("Number of students in course1 after drop S2: "+course2.getNumberOfStudents());
	    
	    course2_name = course2.getStudents();
	    for (int i = 0; i < course2.getNumberOfStudents(); i++) {
            System.out.print(course2_name[i]+", ");}
	    System.out.println();
	    
	    course2.clear();
	    System.out.println("Number of students in course1 after clear: "+course2.getNumberOfStudents());
	    

	}

}

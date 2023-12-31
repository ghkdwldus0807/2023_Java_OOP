//21101989 황지연

import java.util.*;

public class Course {
  private String courseName;
  private String[] students = new String[100];
  private int numberOfStudents;
    
  public Course(String courseName) {
    this.courseName = courseName;
  }
  
  public void addStudent(String student) {
	  if(numberOfStudents >= students.length) {
		  String[] temp = new String[students.length *2];
		  System.arraycopy(student, 0, temp, 0, students.length);
		  students = temp;
	  }
    students[numberOfStudents] = student;
    numberOfStudents++;
  }
  
  
  public String[] getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }  

  public String getCourseName() {
    return courseName;
  }  
  
  public void dropStudent(String student) {
    students = Arrays.stream(students)
    		.filter(name -> name !=null && !name.equals(student))
    		.toArray(String[]::new);
    
    numberOfStudents = students.length;
  }
  
  public void clear() {
	    students = new String[100];
	    numberOfStudents = 0;
	}
}
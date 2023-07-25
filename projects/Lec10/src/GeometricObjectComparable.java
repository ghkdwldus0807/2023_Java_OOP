//21110989 황지연

public abstract class GeometricObjectComparable implements Comparable<GeometricObjectComparable> {
  private String color = "white";
  private boolean filled;

  /**Default construct*/
  protected GeometricObjectComparable() {
  }

  /**Construct a geometric object*/
  protected GeometricObjectComparable(String color, boolean filled) {
    this.color = color;
    this.filled = filled;
  }

  /**Getter method for color*/
  public String getColor() {
    return color;
  }

  /**Setter method for color*/
  public void setColor(String color) {
    this.color = color;
  }

  /**Getter method for filled. Since filled is boolean,
     so, the get method name is isFilled*/
  public boolean isFilled() {
    return filled;
  }

  /**Setter method for filled*/
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /**Abstract method findArea*/
  public abstract double getArea();

  /**Abstract method getPerimeter*/
  public abstract double getPerimeter();
  
  public int compareTo(GeometricObjectComparable o) {
	  if (this.getArea() > o.getArea()) {
		  return 1;
		  } else if (this.getArea() < o.getArea()) {
			  return -1;
			  } else {
				  return 0;
		    }
  }
  
  public static GeometricObjectComparable max(GeometricObjectComparable o1,GeometricObjectComparable o2 ) {
	  if (o1.compareTo(o2) > 0) {
		  return o1;
		  } else {
			  return o2;
			  }
	  }
}

// Circle.java: The circle class that extends GeometricObject
public class CircleOld {
  protected double radius;

  // Default constructor
  public CircleOld() {
    this(1.0, "white", 1.0);
  }

  // Construct circle with specified radius
  public CircleOld(double radius) {
    
    this.radius = radius;
  }

  // Construct a circle with specified radius, weight, and color
  public CircleOld(double radius, String color, double weight) {
    
    this.radius = radius;
  }

  // Getter method for radius
  public double getRadius() {
    return radius;
  }

  // Setter method for radius
  public void setRadius(double radius) {
    this.radius = radius;
  }


  // Override the equals() method defined in the Object class
  @Override
  public boolean equals(Object circle) {
    return this.radius == ((CircleOld)circle).getRadius();
  }

  @Override
  public String toString() {
    return "[Circle] radius = " + radius;
  }
}
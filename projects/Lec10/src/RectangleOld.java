public class RectangleOld {
  private double width;
  private double height;

  public RectangleOld() {
  }

  public RectangleOld(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }


  
  @Override
  public boolean equals(Object rect) {
    return this.width == ((RectangleOld)rect).getWidth() && 
    		this.height == ((RectangleOld)rect).getHeight();
  }
  
  @Override
  public String toString() {
    return "[rectangle] width: " + width + " height: " + height;
  }
}

public class Triangle{
  double[] sides = new double[3];

  public Triangle(){
    // here is the default constructor
  }

  public Triangle(double side1, double side2, double side3){
    sides[0] = side1;
    sides[1] = side2;
    sides[2] = side3;
  }

  public void changeSide(int side, double newLength){
    sides[side] = newLength;
  }

  private double calcPerimeter(){
    return sides[0] + sides[1] + sides[2];
  }
  // use Heron's formula to calculate area
  public double calcArea(){
    double halfPerim = calcPerimeter() / 2;
    return Math.sqrt(halfPerim * (halfPerim - sides[0]) * (halfPerim - sides[1]) * (halfPerim - sides[2]))
  }

  public String toString(){
    String toRet = "My side lengths are: \n";
    toRet += sides[0] + "\n";
    toRet += sides[1] + "\n";
    toRet += sides[2] + "\n";

    toRet += "My area is " + calcArea() + " units^2";

    return toRet;
  }

}

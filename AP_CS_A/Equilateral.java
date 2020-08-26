public class Equilateral extends Triangle{

  public Equilateral(double sideLength){
    super(sideLength, sideLength, sideLength);
  }

  public void changeSide(double newLength){
    super.changeSide(0, newLength);
    super.changeSide(1, newLength);
    super.changeSide(2, newLength);
  }

  public String toString(){
    String toRet = "I am an equilateral triangle.\n" + super.toString();

    return toRet;
  }
}

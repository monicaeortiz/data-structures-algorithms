public class Isoceles extends Triangle{

  public Isoceles(double sameLength, double diffLength){
    super(sameLength, sameLength, diffLength);
  }

  public void changeSide(int side, double newLength){
    if (side == 0 || side == 1){
      super.changeSide(0,newLength);
      super.changeSide(1,newLength)''
    }
    else{
      super.changeSide(2,newLength);
    }
  }

  public String toString(){
    String toRet = "I am an isoceles triangle.\n" + super.toString();

    return toRet;
  }

}

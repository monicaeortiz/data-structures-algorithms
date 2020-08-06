public class Triangle_Runner{

  public static void main(String[] args){
    Triangle irr = new Triangle(3,4,5);
    System.out.println(irr);
    irr.changeSide(1,5);
    System.out.println(irr);


    Isoceles iso = new Isoceles(6,3);
    System.out.println(iso);
    iso.changeSide(1,5);
    System.out.println(iso);
    iso.changeSide(2,10);
    System.out.println(iso);

  }
}

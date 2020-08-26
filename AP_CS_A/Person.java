public class Person{

  private String name;

  public Person(){
    System.out.println("I've been born!");
  }

  public Person(String name){
    this.name = name;
    System.out.println("My name is " + name + ".");

  }

  public void changeName(String newName){
    this.name = newName;
  }
}

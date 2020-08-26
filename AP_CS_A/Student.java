public class Student extends Person{
  private int grade;

  public Student(int grade){
    this.grade = grade;
  }

  public void changeGrade(int newGrade){
    this.grade = newGrade;
  }
}

package miles.test;

public class Test {

    public void change(Student student){
        student.age = 100;
        student.name = "MILES";
    }

    public void changeByNew(Student student){
        student = new Student(100,"MILES");
    }

    public static void main(String[] args) {
        Test test = new Test();
        Student student = new Student(10,"miles");
        test.change(student);
        System.out.println(student.toString());
    }

}

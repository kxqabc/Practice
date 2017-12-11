package miles.test;

public class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        //判断是否引用同一地址
        if (obj==this)
            return true;
        //判断是否为null或者类型不同
        if (obj==null || obj.getClass()!=this.getClass())
            return false;
        //转换类型
        Student student = (Student) obj;
        return student.age==this.age && (this.name==student.name || (this.name!=null && this.name.equals(student.name)));
    }

}

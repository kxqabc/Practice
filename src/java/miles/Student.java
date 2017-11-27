package miles;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private int stuNum;
    private int age;
    private int classNum;
    private int height;
    private int weight;

    public Student(Builder builder) {
        this.name = builder.name;
        this.stuNum = builder.stuNum;
        this.age = builder.age;
        this.classNum = builder.classNum;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public static class Builder{
        //必有的
        private String name;
        private int stuNum;
        //可选的
        private int age;
        private int classNum;
        private int height;
        private int weight;

        public Builder(String name, int stuNum) {
            this.name = name;
            this.stuNum = stuNum;
        }
        public Builder age(int val){
            age = val;
            return this;
        }
        public Builder classNum(int val){
            classNum = val;
            return this;
        }
        public Builder height(int val){
            height = val;
            return this;
        }
        public Builder weight(int val){
            weight = val;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }

    public static void main(String[] args) {
        Student student = new Builder("miles",123456).age(23).classNum(3).build();
    }
}

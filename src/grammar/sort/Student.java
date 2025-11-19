package grammar.sort;

public class Student {
    String name;
    int score;
    int age;

    Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(점수: " + score + ", 나이: " + age + ")";
    }
}

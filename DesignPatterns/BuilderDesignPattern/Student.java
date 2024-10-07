import java.util.List;

public class Student {
    private int rollNumber;
    private String name;
    private int age;
    private String fatherName;
    private String motherName;
    List<String> subjects;

    public Student(StudentBuilder builder) {
        this.rollNumber = builder.getRollNumber();
        this.name = builder.getName();
        this.age = builder.getAge();
        this.fatherName = builder.getFatherName();
        this.motherName = builder.getMotherName();
        this.subjects = builder.getSubjects();
    }

    @Override
    public String toString() {
        return "rollNumber: " + this.rollNumber + "\n" +
                "age: " + this.age + "\n" +
                "name: " + this.name + "\n" +
                "fatherName: " + this.fatherName + "\n" +
                "motherName: " + this.motherName + "\n" +
                "subjects: " + this.subjects.toString();
    }
}

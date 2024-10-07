import java.util.List;

public abstract class StudentBuilder {
    protected int rollNumber;
    protected String name;
    protected int age;
    protected String fatherName;
    protected String motherName;
    protected List<String> subjects;

    public StudentBuilder setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }


    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }


    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }


    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }


    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public abstract StudentBuilder setSubjects();


    public Student build() {
        return new Student(this);
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}

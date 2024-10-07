public class Director {

    StudentBuilder studentBuilder;
    Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if(studentBuilder instanceof EngineeringStudentBuilder) {
            return createEngineeringStudent();
        } else if(studentBuilder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        }
        return null;
    }

    private Student createEngineeringStudent() {
        return new EngineeringStudentBuilder().setRollNumber(1).setAge(12).setName("Engineer").setSubjects().build();
    }

    private Student createMBAStudent() {
        return new MBAStudentBuilder().setRollNumber(1).setAge(12).setName("MBA").setFatherName("MBA Father").setSubjects().build();
    }
}

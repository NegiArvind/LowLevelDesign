import java.util.ArrayList;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder {
    @Override
    public StudentBuilder setSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Data structure");
        subjects.add("Algorithm");
        this.subjects = subjects;
        return this;
    }
}

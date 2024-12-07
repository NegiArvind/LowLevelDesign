import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private List<TimeInterval> timeIntervals;

    public Calendar() {
        this.timeIntervals = new ArrayList<>();
    }

    public List<TimeInterval> getTimeIntervals() {
        return timeIntervals;
    }

    public void setTimeIntervals(List<TimeInterval> timeIntervals) {
        this.timeIntervals = timeIntervals;
    }
}

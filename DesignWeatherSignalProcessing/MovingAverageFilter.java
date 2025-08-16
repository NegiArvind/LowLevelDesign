import java.util.ArrayList;
import java.util.List;

public class MovingAverageFilter implements SignalFilter {

    private int windowSize;

    public MovingAverageFilter(int windowSize) {
        this.windowSize = windowSize;
    }

    @Override
    public List<Double> apply(List<Double> signals) {
        List<Double> result = new ArrayList<>();
        for(int i=0; i< signals.size(); i++) {
            double sum = 0;
            int count = 0;
            for(int j=i; j>=0 && j > i-windowSize; j--) {
                sum+=signals.get(j);
                count++;
            }
            result.add(sum/count);
        }
        return result;
    }
}

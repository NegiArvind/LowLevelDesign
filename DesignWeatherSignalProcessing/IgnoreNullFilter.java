import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IgnoreNullFilter implements SignalFilter {
    @Override
    public List<Double> apply(List<Double> signals) {
        return signals.stream().filter(Objects::nonNull).toList();

//        List<Double> result = new ArrayList<>();
//        for (Double s : signals) {
//            if (s != null) {
//                result.add(s);
//            }
//        }
//        return result;
    }
}

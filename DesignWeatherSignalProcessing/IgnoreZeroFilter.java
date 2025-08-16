import java.util.ArrayList;
import java.util.List;

public class IgnoreZeroFilter implements SignalFilter {

    @Override
    public List<Double> apply(List<Double> signals) {

        return signals.stream().filter(signal -> signal != null && signal != 0.0)
                .toList();

//        List<Double> result = new ArrayList<>();
//        for (Double s : signals) {
//            if (s != null && s != 0.0) {
//                result.add(s);
//            }
//        }
//        return result;
    }
}

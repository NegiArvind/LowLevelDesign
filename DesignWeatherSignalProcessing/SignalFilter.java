import java.util.List;

public interface SignalFilter {
    List<Double> apply(List<Double> signals);
}

package strategy;

import entities.Split;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy {
    @Override
    public List<Split> calculateSplits(double totalAmount, User paidBy, List<User> participants,
                                       List<Double> splitValues) {

        List<Split> splits = new ArrayList<>();
        double amountPerPerson = totalAmount / participants.size();
        for(User user: participants) {
            splits.add(new Split(user, amountPerPerson));
        }
        return splits;
    }
}

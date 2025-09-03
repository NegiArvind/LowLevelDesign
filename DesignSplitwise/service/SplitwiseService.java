package service;

import entities.*;

import java.util.*;
import java.util.stream.Collectors;

public class SplitwiseService {

    private static SplitwiseService splitwiseService;
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Group> groups = new HashMap<>();

    private SplitwiseService() {

    }

    public static synchronized SplitwiseService getInstance() {
        if(splitwiseService == null) {
            return new SplitwiseService();
        }
        return splitwiseService;
    }

    // Setup methods

    public User addUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    public Group addGroup(String name, List<User> members) {
        Group group = new Group(name, members);
        groups.put(group.getId(), group);
        return group;
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public Group getGroup(String id) {
        return groups.get(id);
    }

    public synchronized void createExpense(Expense.ExpenseBuilder builder) {
        Expense expense = builder.build();

        User paidBy = expense.getPaidBy();

        for(Split split: expense.getSplits()) {
            User participant = split.getUser();
            double amount = split.getAmount();

            if(!paidBy.equals(participant)) {
                paidBy.getBalanceSheet().adjustBalance(participant, amount);
                participant.getBalanceSheet().adjustBalance(paidBy, -amount);
            }
        }
        System.out.println("Expense '" + expense.getDescription() + "' of amount " + expense.getAmount() + " created.");
    }

    public synchronized void settleUp(String payerId, String payeeId, double amount) {
        User payer = users.get(payerId);
        User payee = users.get(payeeId);
        System.out.println(payer.getName() + " is settling up " + amount + " with " + payee.getName());

        payee.getBalanceSheet().adjustBalance(payer, -amount);
        payer.getBalanceSheet().adjustBalance(payee, amount);
    }

    public void showBalanceSheet(String userId) {
        User user = users.get(userId);
        user.getBalanceSheet().showBalances();
    }

    public List<Transaction> simplifyGroupDebts(String groupId) {
        Group group = groups.get(groupId);
        if (group == null) {
            throw new IllegalArgumentException("Group not found");
        }

        // Calculate net balance for each member within the group context
        Map<User, Double> netBalances = new HashMap<>();

        for (User member: group.getMembers()) {
            double balance = 0;
            for(Map.Entry<User, Double> entry : member.getBalanceSheet().getBalances().entrySet()) {
                if(group.getMembers().contains(entry.getKey())) {
                    balance += entry.getValue();
                }
            }
            netBalances.put(member, balance);
        }

        List<Map.Entry<User, Double>> creditors = netBalances.entrySet().stream()
                .filter(entry -> entry.getValue() > 0).collect(Collectors.toList());
        List<Map.Entry<User, Double>> debitors = netBalances.entrySet().stream()
                .filter(entry -> entry.getValue() < 0).collect(Collectors.toList());

        creditors.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        debitors.sort(Map.Entry.comparingByValue());

        List<Transaction> transactions = new ArrayList<>();
        int i=0, j=0;
        while(i < creditors.size() && j< debitors.size()) {
            Map.Entry<User, Double> creditor = creditors.get(i);
            Map.Entry<User, Double> debitor = debitors.get(i);

            double amountToSettle = Math.min(creditor.getValue(), -debitor.getValue());
            transactions.add(new Transaction(debitor.getKey(), creditor.getKey(), amountToSettle));

            creditor.setValue(creditor.getValue() - amountToSettle);
            debitor.setValue(debitor.getValue() + amountToSettle);

            if (Math.abs(creditor.getValue()) < 0.01) i++;
            if (Math.abs(debitor.getValue()) < 0.01) j++;
        }

        return transactions;
    }




}

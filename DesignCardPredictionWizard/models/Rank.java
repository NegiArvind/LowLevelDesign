package models;

public enum Rank {
    A(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    J(11),
    Q(12),
    K(13);

    private final int val;

    Rank(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public static Rank fromValue(int val) {
        for(Rank rank: values()) {
            if(rank.getVal() == val) {
                return rank;
            }
        }
        throw new IllegalArgumentException("Bad rank value: " + val);
    }
}

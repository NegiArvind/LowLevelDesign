package models;

import java.util.*;

public class Deck {
    private final Deque<Card> cards = new ArrayDeque<>();

    public Deck(boolean removeSevens) {
        List<Card> cardList = new ArrayList<>();
        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                if(removeSevens && rank == Rank.SEVEN) {
                    continue;
                }
                cardList.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cardList);
        for(Card card : cardList) {
            cards.addLast(card);
        }
    }

    public int size() {
        return cards.size();
    }

    public boolean hasAtLeast(int n) {
        return cards.size() >= n;
    }

    public Card drawTop() {
        return cards.pollFirst();
    }
}

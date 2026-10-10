package com.bao.model;
public class Card {
    private final Rank rank;
    private final Suit suit;
    private final int id;

    public Card(Rank rank, Suit suit, int id) {
        this.rank = rank;
        this.suit = suit;
        this.id = id;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    
    }

    
}

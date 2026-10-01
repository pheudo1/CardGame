package com.bao.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
        // Initialize the hand with no cards
    }

    public void addCard(Card card) {
        // Add a card to the hand
        cards.add(card);
    }

    public void removeCard(Card card) {
        // Remove a card from the hand
        cards.remove(card);
    }

    public int getSize() {
        // Return the number of cards in the hand
        return cards.size();
    }

    public List<Card> returnHandCards() {
        // Return the list of cards in the hand
        return cards;
    }



}

package com.bao.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cards;
    public Deck() {
        // Initialize the deck with all cards
        cards = new ArrayList<>();
        while (cards.size() < 108) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    // Skip the jokers for now
                    if (rank != Rank.SMALL_JOKER && rank != Rank.BIG_JOKER) {
                        cards.add(new Card(rank, suit));
                    }
                }
            }
            cards.add(new Card(Rank.SMALL_JOKER, null));
            cards.add(new Card(Rank.BIG_JOKER, null));
        }
    }

    public int getDeckSize() {
        return cards.size();
    }

    public void shuffleDeck() {
        // Shuffle the deck using Fisher-Yates algorithm
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(cards.size() - 1);
    }

    public String printDeck(Deck deck) {
        StringBuilder sb = new StringBuilder();
        for (Card card : deck.cards) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }




}

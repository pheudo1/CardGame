
package com.bao.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HandTest {
    private Deck deck;
    private Hand hand;

    @Before                                         
    public void setUp() {
        deck = new Deck();
        deck.shuffleDeck();
        hand = new Hand();
    }

    @Test
    public void addCardTest() {
        Card card = deck.drawCard();
        hand.addCard(card);
        assertEquals(1, hand.getSize());
        assertTrue(hand.returnHandCards().contains(card));
    }

    @Test
    public void removeCardTest() {
        Card card = deck.drawCard();
        hand.addCard(card);
        assertEquals(1, hand.getSize());
        assertTrue(hand.returnHandCards().contains(card));
        hand.removeCard(card);
        assertEquals(0, hand.getSize());
        assertFalse(hand.returnHandCards().contains(card));
    }
}




   

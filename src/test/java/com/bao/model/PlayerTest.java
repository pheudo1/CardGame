package com.bao.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    private Deck deck;
    private Hand hand;
    private Player player;

    @Before                                         
    public void setUp() {
        deck = new Deck();
        deck.shuffleDeck();
        hand = new Hand();
        player = new Player("Alice", hand, Team.BLUE);
    }

    @Test
    public void addCardToHandTest() {
        Card card = deck.drawCard();
        player.addCardToHand(card);
        assertEquals(1, player.getHandSize());
        assertTrue(player.getHand().returnHandCards().contains(card));
    }

    
}

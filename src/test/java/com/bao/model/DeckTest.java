package com.bao.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DeckTest {
    
    private Deck deck;

    @Before                                         
    public void setUp() {
        deck = new Deck();
        deck.shuffleDeck();
    }

    @Test
    public void deckTest() {
        assertEquals(108, deck.getDeckSize());
        System.out.println(deck.printDeck(deck));
    }

    @Test
    public void shuffleTest() {
        deck.shuffleDeck();
        assertEquals(108, deck.getDeckSize());
        //System.out.println(deck.printDeck(deck));
    }

    @Test
    public void drawCardTest() {
        Card drawnCard = deck.drawCard();
        assertNotNull(drawnCard);
        assertEquals(107, deck.getDeckSize());
    }

    @Test 
    public void draw2CardsTest() {
        
        for (int i = 0; i < 108; i++) {
            System.out.println(deck.drawCard());
        }
        assertEquals(0, deck.getDeckSize());

    }
}

package com.bao.api;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bao.model.*;

@Service
public class GameService {

    private Deck deck;
    private Hand hand;

    public GameService() {
        // initialize temporary game state here
        deck = new Deck();
        deck.shuffleDeck();
        hand = new Hand();

        for(int i = 0; i<10 ; i++) {
            hand.addCard(deck.drawCard());
        }
    }

    public List<Card> getHand() {
        return hand.returnHandCards();
    }
}
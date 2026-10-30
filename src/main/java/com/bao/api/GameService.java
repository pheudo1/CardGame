package com.bao.api;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bao.model.*;
import com.bao.rules.Combination;
import com.bao.rules.CombinationEval;

@Service
public class GameService {

    private Deck deck;
    private Hand hand;

    public GameService() {
        // initialize temporary game state here
        deck = new Deck();
        deck.shuffleDeck();
        hand = new Hand();

        for(int i = 0; i<27 ; i++) {
            hand.addCard(deck.drawCard());
        }
    }

    public List<Card> getHand() {
        return hand.returnHandCards();
    }

    private List<Card> getCardsByIds(List<Integer> cardIds) {
        List<Card> selectedCards = new ArrayList<>();

        //scout the hand. if hand contains cards with matching ids, return those cards 
        for (Card card : hand.returnHandCards()) {  
            if (cardIds.contains(card.getId())) {
                selectedCards.add(card);
            }
        }

        return selectedCards;
    }

    public void playCards(List<Integer> cardIds) { 
        List<Card> selectedCards = getCardsByIds(cardIds);
        System.out.println(selectedCards);
        Combination combination = CombinationEval.evaluate(selectedCards);

        System.out.println(combination.getType());
    }
}   
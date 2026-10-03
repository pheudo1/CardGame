
package com.bao.rules;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.bao.model.Card;
import com.bao.model.Rank;
import com.bao.model.Suit;

public class CombinationEvalTest {

    private List<Card> cards(Rank... ranks) {
        List<Card> cards = new ArrayList<>();

        for (Rank rank : ranks) {
            cards.add(new Card(rank, Suit.CLUBS));
        }

        return cards;
    }

    @Test
    public void consecutiveRanksShouldReturnTrue() {
        List<Rank> ranks = Arrays.asList(
                Rank.THREE,
                Rank.FOUR,
                Rank.FIVE,
                Rank.SIX,
                Rank.SEVEN,
                Rank.EIGHT);

        assertTrue(CombinationEval.isConsecutive(ranks));
    }

    @Test
    public void Test1() {
        List<Card> cards = cards(
                Rank.THREE,
                Rank.THREE,
                Rank.THREE);

        assertEquals(CombinationType.THREE_OF_A_KIND, CombinationEval.evaluate(cards).getType());
    }

    @Test
    public void Test2() {
        List<Card> cards = cards(
                Rank.THREE,
                Rank.THREE,
                Rank.THREE,
                Rank.THREE,
                Rank.THREE
            );

        assertEquals(CombinationType.BOMB, CombinationEval.evaluate(cards).getType());
        assertEquals(5, CombinationEval.evaluate(cards).getCardCount());
    }

    @Test
    public void Test3() {
        List<Card> cards = cards(
                Rank.THREE,
                Rank.THREE,
                Rank.THREE,
                Rank.THREE,
                Rank.THREE,
                Rank.FOUR,
                Rank.FOUR,
                Rank.FOUR,
                Rank.FOUR,
                Rank.FOUR
            );
        CombinationBombs c1 = (CombinationBombs) CombinationEval.evaluate(cards);

        assertEquals(CombinationType.STRAIGHT_BOMB, c1.getType());
        assertEquals(5, c1.getBombPotency());
        assertEquals(Rank.FOUR, c1.getRank());
        assertEquals(10, c1.getCards().size());
    }

    @Test
    public void Test4() {
        List<Card> cards = cards(
                Rank.THREE,
                Rank.THREE,
                Rank.THREE,
                Rank.THREE,
                Rank.THREE,
                Rank.FOUR,
                Rank.FOUR,
                Rank.FOUR,
                Rank.FOUR,
                Rank.FOUR,
                Rank.FIVE,
                Rank.FIVE
            );

        assertEquals(CombinationType.INVALID, CombinationEval.evaluate(cards).getType());
    }

    @Test
    public void Test5() {
        List<Card> cards = cards(
                Rank.FOUR,
                Rank.FOUR,
                Rank.FOUR,
                Rank.FIVE,    
                Rank.THREE,
                Rank.THREE,
                Rank.THREE,
                Rank.FIVE,
                Rank.FIVE
            );
        CombinationStraight c1 = (CombinationStraight) CombinationEval.evaluate(cards);

        assertEquals(CombinationType.TRIPLED_STRAIGHT, c1.getType());
        assertEquals(3, c1.getStraightLength());
        assertEquals(Rank.FIVE, c1.getRank());
    }

    @Test
    public void Test6() {
        List<Card> cards = cards(
                Rank.FOUR,
                Rank.FOUR,
                Rank.FOUR,
                Rank.FIVE
            );

        assertEquals(CombinationType.INVALID, CombinationEval.evaluate(cards).getType());
    }

    @Test
    public void Test7() {
        List<Card> cards = cards(
            );

        assertEquals(CombinationType.INVALID, CombinationEval.evaluate(cards).getType());
    }

    @Test
    public void Test8() {
        List<Card> cards = cards(
                Rank.THREE,
                Rank.THREE,
                Rank.FOUR,
                Rank.FOUR,
                Rank.FIVE,
                Rank.FIVE,
                Rank.SIX,
                Rank.SIX,
                Rank.SEVEN,
                Rank.SEVEN
            );
        CombinationStraight c1 = (CombinationStraight) CombinationEval.evaluate(cards);

        assertEquals(CombinationType.DOUBLED_STRAIGHT, c1.getType());
        assertEquals(5, c1.getStraightLength());
        assertEquals(Rank.SEVEN, c1.getRank());
        assertEquals(10, c1.getCards().size());
    }


    

    @Test
    public void pairShouldBeRecognized() {
        assertEquals(
                CombinationType.PAIR,
                CombinationEval.evaluate( cards(Rank.SEVEN, Rank.SEVEN)).getType());
    }



}

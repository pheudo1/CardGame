
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
        assertEquals(5, CombinationEval.evaluate(cards).getLength());
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

        assertEquals(CombinationType.STRAIGHT_BOMB, CombinationEval.evaluate(cards).getType());
        assertEquals(5, CombinationEval.evaluate(cards).getLength());
        assertEquals(Rank.FOUR, CombinationEval.evaluate(cards).getRank());
        assertEquals(10, CombinationEval.evaluate(cards).getCards().size());
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

        assertEquals(CombinationType.TRIPLED_STRAIGHT, CombinationEval.evaluate(cards).getType());
        assertEquals(3, CombinationEval.evaluate(cards).getLength());
        assertEquals(Rank.FIVE, CombinationEval.evaluate(cards).getRank());
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

        assertEquals(CombinationType.DOUBLED_STRAIGHT, CombinationEval.evaluate(cards).getType());
        assertEquals(5, CombinationEval.evaluate(cards).getLength());
        assertEquals(Rank.SEVEN, CombinationEval.evaluate(cards).getRank());
        assertEquals(10, CombinationEval.evaluate(cards).getCards().size());
    }


    

    @Test
    public void pairShouldBeRecognized() {
        assertEquals(
                CombinationType.PAIR,
                CombinationEval.evaluate( cards(Rank.SEVEN, Rank.SEVEN)).getType());
    }



}

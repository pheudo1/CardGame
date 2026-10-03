package com.bao.rules;

import com.bao.model.Card;
import com.bao.model.Rank;
import com.bao.model.Suit;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComparerTests {

    private List<Card> cards(Rank... ranks) {
        List<Card> cards = new ArrayList<>();

        for (Rank rank : ranks) {
            cards.add(new Card(rank, Suit.CLUBS));
        }

        return cards;
    }

    private Combination eval(Rank... ranks) {
        return CombinationEval.evaluate(cards(ranks));
    }

    @Test
    void higherPairShouldBeatLowerPair() {
        Combination board = eval(
            Rank.SEVEN,
            Rank.SEVEN
        );

        Combination challenger = eval(
            Rank.NINE,
            Rank.NINE
        );

        assertTrue(CombinationComparer.compare(board, challenger));
    }

    @Test
    void lowerPairShouldNotBeatHigherPair() {
        Combination board = eval(
            Rank.NINE,
            Rank.NINE
        );

        Combination challenger = eval(
            Rank.SEVEN,
            Rank.SEVEN
        );

        assertFalse(CombinationComparer.compare(board, challenger));
    }

    @Test
    void samePairTest() {
        Combination board = eval(
            Rank.NINE,
            Rank.NINE
        );

        Combination challenger = eval(
            Rank.SEVEN,
            Rank.SEVEN
        );

        assertFalse(CombinationComparer.compare(board, challenger));
    }

    @Test
    void pairShouldNotBeatTriple() {
        Combination board = eval(
            Rank.SEVEN,
            Rank.SEVEN,
            Rank.SEVEN
        );

        Combination challenger = eval(
            Rank.ACE,
            Rank.ACE
        );

        assertFalse(CombinationComparer.compare(board, challenger));
    }

    @Test
    void higherStraightShouldBeatLowerStraight() {
        Combination board = eval(
            Rank.THREE,
            Rank.FOUR,
            Rank.FIVE,
            Rank.SIX,
            Rank.SEVEN
        );

        Combination challenger = eval(
            Rank.FOUR,
            Rank.FIVE,
            Rank.SIX,
            Rank.SEVEN,
            Rank.EIGHT
        );

        assertTrue(CombinationComparer.compare(board, challenger));
    }

    @Test
    void differentLengthStraightShouldNotBeat() {
        Combination board = eval(
            Rank.THREE,
            Rank.FOUR,
            Rank.FIVE,
            Rank.SIX,
            Rank.SEVEN
        );

        Combination challenger = eval(
            Rank.FOUR,
            Rank.FIVE,
            Rank.SIX,
            Rank.SEVEN,
            Rank.EIGHT,
            Rank.NINE
        );

        assertFalse(CombinationComparer.compare(board, challenger));
    }

    @Test
    void bombShouldBeatNormalCombination() {
        Combination board = eval(
            Rank.ACE,
            Rank.ACE
        );

        Combination challenger = eval(
            Rank.THREE,
            Rank.THREE,
            Rank.THREE,
            Rank.THREE
        );

        assertTrue(CombinationComparer.compare(board, challenger));
    }

    @Test
    void normalCombinationShouldNotBeatBomb() {
        Combination board = eval(
            Rank.THREE,
            Rank.THREE,
            Rank.THREE,
            Rank.THREE
        );

        Combination challenger = eval(
            Rank.ACE,
            Rank.ACE
        );

        assertFalse(CombinationComparer.compare(board, challenger));
    }

    @Test
    void fiveCardBombShouldBeatFourCardBomb() {
        Combination board = eval(
            Rank.ACE,
            Rank.ACE,
            Rank.ACE,
            Rank.ACE
        );

        Combination challenger = eval(
            Rank.THREE,
            Rank.THREE,
            Rank.THREE,
            Rank.THREE,
            Rank.THREE
        );

        assertTrue(CombinationComparer.compare(board, challenger));
    }

    @Test
    void higherBombOfSameSizeShouldWin() {
        Combination board = eval(
            Rank.SEVEN,
            Rank.SEVEN,
            Rank.SEVEN,
            Rank.SEVEN
        );

        Combination challenger = eval(
            Rank.NINE,
            Rank.NINE,
            Rank.NINE,
            Rank.NINE
        );

        assertTrue(CombinationComparer.compare(board, challenger));
    }

}
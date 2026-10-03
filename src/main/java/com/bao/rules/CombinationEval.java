package com.bao.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bao.model.Card;
import com.bao.model.Rank;

public class CombinationEval {
    //make constructor here if i want different rules for different games
    //e.g. wildcard joker



    // Method to evaluate the combination of cards
    // Sorts before checking for combinations, and checks for different combinations based on the frequency of ranks and whether they are consecutive

    public static Combination evaluate(List<Card> cards) {
        // Starts by sorting the cards and then checking for different combinations
        Map<Rank, Integer> frequencyMap = generateFrequencyMap(cards);
        

        //
        int cardCount = cards.size();
        int totalRanks = frequencyMap.size();

        List<Rank> ranks = new ArrayList<>(frequencyMap.keySet());
        boolean isConsecutive = isConsecutive(ranks);

        // Check for different combinations based on the frequency map and consecutive status
        
        // Section for SINGLES
        // Check for SINGLE
        if (totalRanks == 1 && cardCount == 1) {
            return new CombinationSimple(CombinationType.SINGLE, ranks.get(0), cards);
        }

        // Check for PAIR
        if (totalRanks == 1 && cardCount == 2) {
            return new CombinationSimple(CombinationType.PAIR, ranks.get(0), cards);
        }

        // Check for THREE_OF_A_KIND
        if (totalRanks == 1 && cardCount == 3) {
            return new CombinationSimple(CombinationType.THREE_OF_A_KIND, ranks.get(0), cards);
        }

        // Check for STRAIGHT
        if (isConsecutive && cardCount >= 5 && cardCount == totalRanks) {
            return new CombinationStraight(CombinationType.STRAIGHT, ranks.get(ranks.size() - 1), cards, cardCount);
        }

        //Section for DOUBLES
        // Check for DOUBLED_STRAIGHT
        if (isConsecutive && cardCount >= 6 && cardCount % 2 == 0 && sameFrequency(frequencyMap, 2)) {
            return new CombinationStraight(CombinationType.DOUBLED_STRAIGHT, ranks.get(ranks.size() - 1), cards, cardCount / 2);
        }

        //Section for TRIPLES
        // Check for TRIPLED_STRAIGHT
        if (isConsecutive && cardCount >= 9 && cardCount % 3 == 0 && sameFrequency(frequencyMap, 3)) {
            return new CombinationStraight(CombinationType.TRIPLED_STRAIGHT, ranks.get(ranks.size() - 1), cards, cardCount / 3);
        }

        //Section for BOMBS
        // Check for BOMB
        if (totalRanks == 1 && cardCount >= 4) {
            return new CombinationBombs(CombinationType.BOMB, ranks.get(0), cards, 1, cardCount);
        }
        
        // Check for STRAIGHT BOMB
        if (isConsecutive && totalRanks >= 2 && sameFrequency(frequencyMap, cardCount / totalRanks) && cardCount / totalRanks >= 4) {
            int bombPotency = cardCount / totalRanks; // Calculate the potency of the bomb based on the number of cards and ranks
            int consecutiveLength = totalRanks; // The length of the consecutive ranks
            return new CombinationBombs(CombinationType.STRAIGHT_BOMB, ranks.get(ranks.size() - 1), cards, consecutiveLength, bombPotency);
        }

        // If no valid combination is found, return INVALID
        return new Combination(CombinationType.INVALID, null, cards);
    }

    public static boolean isConsecutive(List<Rank> ranks) {
        // Logic to check if the cards are consecutive
        Collections.sort(ranks);
        for (int i = 0; i < ranks.size() - 1; i++) {
            if (ranks.get(i).getValue() + 1 != ranks.get(i + 1).getValue()) {
                return false;
            }
        }
        return true;
    }

    private static Map<Rank, Integer> generateFrequencyMap(List<Card> cards) {
        // Logic to generate a frequency map of card ranks
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Card card : cards) {
            Rank rank = card.getRank();

            if (rankCount.containsKey(rank)) {
                rankCount.put(rank, rankCount.get(rank) + 1);
            } else {
                rankCount.put(rank, 1);
            }
        }
        return rankCount;
    }

    private static boolean sameFrequency(Map<Rank, Integer> frequencyMap, int expectedFrequency) {
        // Logic to check if all cards have the same frequency
        for (int count : frequencyMap.values()) {
            if (count != expectedFrequency) {
                return false;
            }
        }
        return true;
    }

    


}

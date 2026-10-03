package com.bao.rules;

import java.util.List;

import com.bao.model.Card;
import com.bao.model.Rank;

public class CombinationStraight extends Combination {
    private int straightLength;

    public CombinationStraight(CombinationType type, Rank rank, List<Card> cards, int straightLength) {
        super(type, rank, cards);
        this.straightLength = straightLength;
    }

    public int getStraightLength() {
        return straightLength;
    }

}

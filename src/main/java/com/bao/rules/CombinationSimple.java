package com.bao.rules;

import java.util.List;

import com.bao.model.Card;
import com.bao.model.Rank;

public class CombinationSimple extends Combination {

    public CombinationSimple(CombinationType type, Rank rank, List<Card> cards) {
        super(type, rank, cards);
    }
    
}

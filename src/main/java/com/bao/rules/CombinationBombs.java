package com.bao.rules;

import java.util.List;

import com.bao.model.Card;
import com.bao.model.Rank;

public class CombinationBombs extends Combination {
    private int consecutiveLength;
    private int bombPotency;

    public CombinationBombs(CombinationType type, Rank rank, List<Card> cards, int consecutiveLength, int bombPotency) {
        super(type, rank, cards);
        this.consecutiveLength = consecutiveLength;
        this.bombPotency = bombPotency;
    }

    public int getConsecutiveLength() {
        return consecutiveLength;
    }

    public int getBombPotency() {
        return bombPotency;
    }
    
    int getBombLevel() {
        // Calculate the level of the bomb based on its potency and consecutive length
        if (this.getConsecutiveLength() == 1) {
            return this.getBombPotency(); // Single bomb level
        }
        int bombLevel = this.getBombPotency() + this.getConsecutiveLength();
        return bombLevel;
    }
}

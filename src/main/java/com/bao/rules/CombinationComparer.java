package com.bao.rules;

public class CombinationComparer {
    

    


    // Method to compare two combinations and determine if the first combination can beat the second one
    // c1 is the combination on the board
    // c2 is the combination played by the player e.g. trying to beat c1
    public static boolean compare(Combination c1, Combination c2) {
        // If both combinations are bombs, compare their potency and rank
        if (isBomb(c1)) {
            if (isBomb(c2)) {
                return canBeatBomb((CombinationBombs) c1, (CombinationBombs) c2);
            } else {
                return false; // Bombs can only be beaten by other bombs
            }
        } else if (isBomb(c2)) {
            // If c2 is a bomb and c1 is not, c2 will always beat c1
            return true; // Any combination can be beaten by a bomb
        } else if (isSameType(c1, c2) && isSameLength(c1, c2)) {
            // If no bombs -> normal comparison
            return canBeatSameType(c1, c2);
        }
        return false; // Default return value if no conditions are met
    }


    // Method to determine if two combinations of the same type can beat each other
    private static boolean canBeatSameType(Combination c1, Combination c2) {
        // Check if the combination types are the same
        if (isSameType(c1, c2) && isSameLength(c1, c2)) {
            // Compare the ranks of the two combinations
            return c1.getRank().getValue() < c2.getRank().getValue();
        } else {
            return false; // Default return value if no conditions are met
        }
    }

    private static boolean canBeatBomb(CombinationBombs c1, CombinationBombs c2) {
        // Default function if same type and length, compare rank
        
        if (c2.getBombLevel() > c1.getBombLevel()) {
            return true;
        }

        if (c1.getBombLevel() > c2.getBombLevel()) {
            return false;
        }

        if (isSameType(c1, c2) && isSameLength(c1, c2)) {
            return c1.getRank().getValue() < c2.getRank().getValue();
        }  
        return false; // Default return value if no conditions are met
    }
    
    //gleicher typ
    private static boolean isSameType(Combination c1, Combination c2) {
        return c1.getType() == c2.getType();
    }
    private static boolean isSameLength(Combination c1, Combination c2) {
        return c1.getCardCount() == c2.getCardCount();
    }
    //oder bomb
    private static boolean isBomb(Combination c) {
        return c instanceof CombinationBombs;
    }
}

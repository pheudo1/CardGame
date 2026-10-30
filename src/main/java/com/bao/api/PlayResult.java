package com.bao.api;

import com.bao.model.Card;
import java.util.List;

public record PlayResult (boolean valid, String CombinationType, List<Card> cards) {
}
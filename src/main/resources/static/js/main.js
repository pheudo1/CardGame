//start
import { loadHand, playCards } from "./api.js";
import { renderHand, renderPlayedCards, getSelectedCardIds } from "./ui.js";

function handlePlay() {
    const cardIds = getSelectedCardIds();

    playCards(cardIds)
        .then(result => {
            console.log(result);

            if (result.valid) {
                renderPlayedCards(
                    result.cards,
                    result.combinationType
                );

                loadHand().then(hand => {
                    renderHand(hand);
                }); 
            }
        });
}   

function main() {
    loadHand().then(hand => {
        renderHand(hand);
    });

    document.getElementById("play-button").addEventListener("click", handlePlay);
}

main();
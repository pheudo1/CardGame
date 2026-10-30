//start
import { loadHand, playCards } from "./api.js";
import { renderHand, getSelectedCardIds } from "./ui.js";

function handlePlay() {
    const cardIds = getSelectedCardIds();
    playCards(cardIds);
}   

function main() {
    loadHand().then(hand => {
        renderHand(hand);
    });

    document.getElementById("play-button").addEventListener("click", handlePlay);
}

main();
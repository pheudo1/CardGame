//start
import { loadHand } from "./api.js";
import { renderHand, getSelectedCardIds } from "./ui.js";

function handlePlay() {
    const cardIds = getSelectedCardIds();

    console.log(cardIds);
}   

function main() {
    loadHand().then(hand => {
        renderHand(hand);
    });

    document.getElementById("play-button").addEventListener("click", handlePlay);
}

main();
//start
import { loadHand, playCards } from "./api.js";
import { renderHand, renderPlayedCards, getSelectedCardIds } from "./ui.js";

function handlePlay() {
    //find selected ids
    const cardIds = getSelectedCardIds();

    //send ids to java
    playCards(cardIds)
        .then(result => {
            console.log(result);
            //wait for response
            //if play was valid
            if (result.valid) {
                renderPlayedCards(  //show cards
                    result.cards,
                    result.combinationType
                );

                //fetch new hand
                loadHand().then(hand => {
                    renderHand(hand); //redraw hand
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
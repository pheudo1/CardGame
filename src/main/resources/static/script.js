const hand = [
    { id: 1, rank: "3", suit: "♠" },
    { id: 2, rank: "3", suit: "♥" },
    { id: 3, rank: "7", suit: "♣" },
    { id: 4, rank: "Q", suit: "♦" }
];

//gives each card a div container and his properties
function createCardElement(card) {
    const cardElement = document.createElement("div");

    cardElement.textContent = card.rank + card.suit;
    cardElement.classList.add("card");
    cardElement.dataset.cardId = card.id;
    
    cardElement.addEventListener("click", toggleCard);

    return cardElement;
}

function toggleCard(event) {
    event.currentTarget.classList.toggle("selected");
}



for (const card of hand) {
    const cardElement = createCardElement(card);
    document.getElementById("hand").appendChild(cardElement);
}

//get all card IDs of played cards
document.getElementById("play-button").addEventListener("click", () => {
    const selected = document.querySelectorAll(".card.selected");

    const cardIds = [];

    for (const card of selected) {
        cardIds.push(Number(card.dataset.cardId));
    }

    console.log(cardIds); //log them
});
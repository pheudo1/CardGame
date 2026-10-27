let hand = [];

function loadHand() {
    fetch("/api/hand")
    .then(response => response.json())
    .then(data => {
        hand = data;
        console.log(hand);
        renderHand();
    });
}

function renderHand() {
    const handElement = document.getElementById("hand");
    handElement.innerHTML = "";


    for (const card of hand) {
        const cardElement = createCardElement(card);
        handElement.appendChild(cardElement);
    }
}
 
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

loadHand();

//get all card IDs of played cards
document.getElementById("play-button").addEventListener("click", () => {
    const selected = document.querySelectorAll(".card.selected");

    const cardIds = [];

    for (const card of selected) {
        cardIds.push(Number(card.dataset.cardId));
    }

    console.log(cardIds); //log them
});
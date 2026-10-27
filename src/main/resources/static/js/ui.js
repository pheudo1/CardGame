


function formatRank(rank) {
    const ranks = {
        THREE: "3",
        FOUR: "4",
        FIVE: "5",
        SIX: "6",
        SEVEN: "7",
        EIGHT: "8",
        NINE: "9",
        TEN: "10",
        JACK: "J",
        QUEEN: "Q",
        KING: "K",
        ACE: "A",
        TWO: "2",
        SMALL_JOKER: "SJ",
        BIG_JOKER: "BJ"
    };

    return ranks[rank];
}

function formatSuit(suit) {
    const suits = {
        SPADES: "♠",
        HEARTS: "♥",
        DIAMONDS: "♦",
        CLUBS: "♣"
    };

    return suits[suit] ?? "";
}

function toggleCard(event) {
    event.currentTarget.classList.toggle("selected");
}
//gives each card a div container and his properties
function createCardElement(card) {
    const cardElement = document.createElement("div");

    cardElement.textContent = formatRank(card.rank) + formatSuit(card.suit);
    cardElement.classList.add("card");
    cardElement.dataset.cardId = card.id;
    cardElement.addEventListener("click", toggleCard);

    return cardElement;
}

export function renderHand(hand) {
    const handElement = document.getElementById("hand");
    handElement.innerHTML = "";


    for (const card of hand) {
        const cardElement = createCardElement(card);
        handElement.appendChild(cardElement);
    }
}

export function getSelectedCardIds() {
    const selected = document.querySelectorAll(".card.selected");
    const cardIds = [];

    for (const card of selected) {
        cardIds.push(Number(card.dataset.cardId));
    }
    return cardIds
}



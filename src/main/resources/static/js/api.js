let hand = [];

export function loadHand() {
    return fetch("/api/hand")
        .then(response => response.json());
}

export function playCards(cardIds) {
    return fetch("/api/play", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            cardIds: cardIds
        })
    });
}
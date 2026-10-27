let hand = [];

export function loadHand() {
    return fetch("/api/hand")
        .then(response => response.json());
}
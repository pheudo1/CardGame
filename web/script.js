
const hand = [
    { id: 1, rank: "3", suit: "♠" },
    { id: 2, rank: "3", suit: "♥" },
    { id: 3, rank: "7", suit: "♣" },
    { id: 4, rank: "Q", suit: "♦" }
];

for (const x of hand) {
    let temp = document.createElement("div")
    const newContent = document.createTextNode(x.rank + x.suit);
    temp.appendChild(newContent)
    temp.classList.add("card")
    temp.addEventListener("click", toggleCard);


    document.getElementById("hand").appendChild(temp)

}

function toggleCard(event) {
    event.currentTarget.classList.toggle("selected");
}

document.getElementById(hand)
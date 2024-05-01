const canvas = document.querySelector("canvas");
const ctx = canvas.getContext("2d");
const numberOfLines = 4;
const fieldHeight = canvas.height;
const fieldWidth = canvas.width;
let fieldDivision = fieldWidth / numberOfLines;
const score = document.querySelector(".cc-score-value");
const myCounter = document.querySelector(".seconds-counter");

const blockHeight = 40;
const blockWidth = fieldDivision - 3;
let id = 1
let speedBlock = 1;
let seconds = 0;


class Block {
    constructor(positonX, color, key) {
        this._x = positonX + 2;
        this._y = -blockHeight;
        this._color = color;
        this._key = key;
    }

    get x() {
        return this._x;
    }

    get y() {
        return this._y;
    }

    get color() {
        return this._color;
    }

    get key() {
        return this._key;
    }

    set y(value) {
        this._y = value;
    }
}


const blocks = [
    () => new Block(0, "blue", "a"),
    () => new Block(fieldDivision, "red", "s"),
    () => new Block(fieldDivision * 2, "green", "d"),
    () => new Block(fieldDivision * 3, "orange", "f")
];


let blocksOnField = [];


function getRandomInt(min, max) {

    const minCeiled = Math.ceil(min);
    const maxFloored = Math.floor(max);

    return Math.floor(Math.random() * (maxFloored - minCeiled + 1) + minCeiled);

}




function addBlockToField() {

    const blockCreator = blocks[Math.floor(Math.random() * blocks.length)];
    blocksOnField.push(blockCreator());
}


function gameArea() {
    return fieldHeight - (fieldHeight * 0.14);
}


function drawLines() {
    
    ctx.fillStyle = "white";
    ctx.fillRect(0, 0, 1, fieldHeight);
    ctx.fillRect(fieldWidth - 1, 0, 1, fieldHeight);

    let i, x  = 0;

    for (i = 1; i <= numberOfLines; i++) {

        x = fieldDivision * i;

        ctx.fillRect(x, 0, 1, fieldHeight);

    }
}

function incrementSeconds() {
    seconds += 1;
    myCounter.innerText = seconds;
}

function drawBlocks(block) {

    ctx.fillStyle = block.color;
    ctx.fillRect(block.x, block.y, blockWidth, blockHeight);
    
}


function checkPointZone(block) {
    
    return block.y > gameArea() - 50 && event.key === block.key;
}

function moveBlocks() {

    ctx.clearRect(0, 0, canvas.width, canvas.height);
    drawLines();

    blocksOnField = blocksOnField.filter(block => {

        block.y += speedBlock;

        if (block.y < fieldHeight) {

            ctx.fillStyle = block.color;
            ctx.fillRect(block.x, block.y, blockWidth, blockHeight);
            return true;
        }

        return false;
    });

}

function gameFlow() {
    requestAnimationFrame(gameFlow);
    moveBlocks();
}

// Start the game loop the first time
gameFlow();


const addBlockInterval = setInterval(addBlockToField, getRandomInt(400, 2000));
const incrementSecondsInterval = setInterval(incrementSeconds, 1000)



addEventListener("keydown", function(event) {

    if (event.key === 'a') {
        let arrayTest = blocksOnField.filter(checkPointZone);
        console.log(arrayTest.length)
        for (const i of arrayTest) {
            console.log(i)
        }
    }
});

const canvas = document.querySelector("canvas");
const ctx = canvas.getContext("2d");
const numberOfLines = 4;
const fieldHeight = parseFloat(canvas.height);
const fieldWidth = parseFloat(canvas.width);
let fieldDivision = fieldWidth / numberOfLines;
const score = document.querySelector(".cc-score-value");
const myCounter = document.querySelector(".seconds-counter");

const perfectScore = 50;
const goodScore = 20;
const missScore = 0;

const perfectScoreSize = 55;
const perfectZoneStart = fieldHeight - (fieldHeight * 0.20);
const perfectZoneEnd = perfectZoneStart + perfectScoreSize;

const scoreLimitWindowUp = perfectZoneStart - 20;
const scoreLimitWindowDown = perfectZoneEnd + 20;

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

function scoreCheck(yPosition) {

}


function addBlockToField() {

    const blockCreator = blocks[Math.floor(Math.random() * blocks.length)];
    blocksOnField.push(blockCreator());
}


function drawLines() {

    ctx.fillStyle = "white";
    ctx.fillRect(0, perfectZoneStart, fieldHeight, perfectScoreSize)

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


function checkPointZone(blockColor) {
    
    // Filter the array by color
    const filteredByColor = blocksOnField.filter(block => block.color === blockColor);
    // Check if the filtered array is empty
    if (filteredByColor.length === 0) {
        return -1; // or any other default value or behavior you'd like to define
    }
    // Find the object with the highest y value
    const highestYBlock = filteredByColor.reduce((max, current) => (current.y > max.y ? current : max));

    return highestYBlock.y;
}

function moveBlocks() {
 
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    drawLines();
 
    blocksOnField = blocksOnField.filter( block => {

        block.y += speedBlock;

        if (block.y < fieldHeight) {

            ctx.fillStyle = block.color;
            ctx.fillRect(block.x, block.y, blockWidth, blockHeight);
            return true;
        }

        return false;

    } );

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

    switch (event.key) {
        case 'a':
            console.log(checkPointZone("blue"));   // Assign blue for 'a'
            break;
        case 's':
            console.log(checkPointZone("red"));    // Assign red for 's'
            break;
        case 'd':
            console.log(checkPointZone("green"));  // Assign green for 'd'
            break;
        case 'f':
            console.log(checkPointZone("orange")); // Assign yellow for 'f'
            break;
        default:
            return;
    }
        
/*        let arrayTest = blocksOnField.filter(checkPointZone);
        
        for ( const i of arrayTest ) {
            console.log(i)

        }*/
});

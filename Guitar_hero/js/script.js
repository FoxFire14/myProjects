const canvas = document.querySelector("canvas");
const ctx = canvas.getContext("2d");
const numberOfLines = 4;
const fieldHeight = canvas.height;
const fieldWidth = canvas.width;
let fieldDivision = fieldWidth / numberOfLines;

const blockHeight = 40;
const blockWidth = fieldDivision;
let id = 1
let speedBlock = 20;


class Block {
    constructor(positonX, color) {
        this._x = positonX;
        this._y = -blockHeight;
        this._color = color;
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

    set y(value) {
        this._y = value;
    }
}


class BlockA extends Block {
    constructor () {
        super(0, "blue");
    }
}

class BlockB extends Block {
    constructor () {
        super(fieldDivision, "red");
    }
}

class BlockC extends Block {
    constructor () {
        super(fieldDivision * 2, "green");
    }
}

class BlockD extends Block {
    constructor () {
        super(fieldDivision * 3, "orange");
    }
}

const myBlockA = new BlockA(); 

let blocksOnField = [myBlockA, new BlockB(), new BlockC(), new BlockD()];


function getRandomInt(min, max) {

    const minCeiled = Math.ceil(min);
    const maxFloored = Math.floor(max);

    return Math.floor(Math.random() * (maxFloored - minCeiled + 1) + minCeiled);

}

function drawLines() {
    
    let currentLine = fieldDivision;

    for (let i = 0; i < numberOfLines; i++) {

        ctx.moveTo(currentLine, 0);  // Top-left corner of the canvas

        // Set the end point
        ctx.lineTo(currentLine, fieldHeight);  // Bottom-right corner of the canvas

        // Draw the line
        ctx.strokeStyle = 'white';
        ctx.stroke();

        currentLine += fieldDivision;

    }
    
}

function limitCheck (block, index) {
    let value = null;

    if (block.y >= fieldHeight) {
        value = blocksOnField.splice(index, 1);
    }

    return value === null;
}


function drawBlocks(block) {

    ctx.fillStyle = block.color;
    ctx.fillRect(block.x, block.y, blockWidth, blockHeight);
    
}


function moveBlocks() {

    let block;

    for (let i = 0; i < blocksOnField.length; i++) {
        block = blocksOnField[i];
        
        if (limitCheck(block, i)) {
            
            drawBlocks(block);
            block.y += 1;

        }
    } 
}

function gameFlow() {

    ctx.clearRect(0, 0, canvas.width, canvas.height);
    drawLines();
    moveBlocks();
    
    //loopID = setTimeout(() => {
    //    gameFlow();
    //}, speedBlock);

}

gameFlow();
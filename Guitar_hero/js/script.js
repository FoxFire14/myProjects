const canvas = document.querySelector("canvas");
const ctx = canvas.getContext("2d");
const numberOfLines = 4;
const fieldHeight = canvas.height;
const fieldWidth = canvas.width;
let fieldDivision = fieldWidth / numberOfLines;

const blockHeight = 40;
const blockWidth = fieldDivision;
let id = 1

let blockA = {
    id: id++,
    position: {x: 0, y: 0},
    color: "blue"
};

let blockB = {
    id: id++,
    position: {x: fieldDivision, y: 0},
    color: "red"
};

let blockC = {
    id: id++,
    position: {x: fieldDivision * 2, y: 0},
    color: "green"
};

let blockD = {
    id: id++,
    position: {x: fieldDivision * 3, y: 0},
    color: "orange"
};

let blocksOnField = [blockA, blockB, blockC, blockD];


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


function drawBlocks() {

    let block;

    for (let i = 0; i < blocksOnField.length; i++) {
        block = blocksOnField[i];
    
        ctx.fillStyle = block.color;
        ctx.fillRect(block.position.x, block.position.y, blockWidth, blockHeight);
        
    } 
}

function moveBlocks() {

    ctx.clearRect(0, 0, canvas.width, canvas.height);
    drawLines();
    drawBlocks();
    blockA.position.y += 1;
    console.log(blockA.position.y);
    
    //loopID = setTimeout(() => {
    //    moveBlocks();
    //}, 20);

}



moveBlocks();
const canvas = document.querySelector("canvas");
const ctx = canvas.getContext("2d");

const score = document.querySelector(".score--value");
const finalScore = document.querySelector(".final-score > span");
const menu = document.querySelector(".menu--screen");
const buttomPlay = document.querySelector(".btn-play");

let gameMenu = false;
const size = 30;
const foodSize = 20;

let direction;
let loopId;

const incrementScore = () => {
    score.innerText = +score.innerText + 10;
}

let snake = [
    { x: 0, y: 0 }
    ];

const drawSnake = () => {
   
   
    ctx.fillStyle = "#817df2";
    let gradientColor = ctx.createLinearGradient(0, 0, canvas.width, 0);
    gradientColor.addColorStop(0, "blue");
    gradientColor.addColorStop(1, "white");

    snake.forEach((position, index) => {

        ctx.beginPath();
        ctx.lineWidth = "1";
        ctx.strokeStyle = "black";
        ctx.rect (position.x, position.y, size, size);
        ctx.stroke();

        if (index == snake.length - 1){
            ctx.fillStyle = gradientColor
        }
        ctx.fillRect(position.x, position.y, size, size); 
         
    })

}

const randomNumber = (min, max) => {
    return Math.round(Math.random() * (max - min) + min);
}

const randomPosition = () => {
    const number = randomNumber(0, canvas.width - size)

    return Math.round(number / 30) * 30;
}

const food = {
    x: randomPosition(),
    y: randomPosition(),
    color: "yellow"
}

const drawFood = () => {

    const { x, y, color } = food;

    ctx.shadowColor = color;
    ctx.shadowBlur = 10;

        

    ctx .fillStyle = food.color;
    ctx.fillRect(x + 5, y + 5, foodSize, foodSize);
    ctx.shadowBlur = 0;
}

const moveSnake = () => {

    if (!direction) return;


    const head = snake[snake.length -1];
    snake.shift();

    if (direction == "right"){
        snake.push({ x: head.x + size, y: head.y });
    }

    if (direction == "left"){
        snake.push({ x: head.x - size, y: head.y });
    }

    if (direction == "down"){
        snake.push({ x: head.x, y: head.y + size });
    }

    if (direction == "up"){
        snake.push({ x: head.x, y: head.y -size });
    }
}

const checkEat = () => {
    const snakeHead = snake[snake.length - 1];

    if (snakeHead.x == food.x && snakeHead.y == food.y) {
        snake.push(snakeHead);
        incrementScore();

        let y = randomPosition();
        let x = randomPosition();

        while (snake.find((position) => position.x == x && position.y == y)) {
            x = randomPosition();
            y = randomPosition();
        }

        food.x = x;
        food.y = y;
    

    }

}

const checkColision = () => {
    const snakeHead = snake[snake.length - 1];
    const canvasLimitX = canvas.width - size;
    const canvasLimitY = canvas.height - size;
    const nextSnakeHead = snake.length - 2;


    const wallColision = snakeHead.x < 0 || snakeHead.x > canvasLimitX || snakeHead.y < 0 || snakeHead.y > canvasLimitY;

    const selfColision = snake.find((position, index) => {
        return index < nextSnakeHead && position.x == snakeHead.x && position.y == snakeHead.y;
    })

        if ( wallColision || selfColision) {
            gameOver();
        }

}

const gameOver = () => {
    gameMenu = true;
    direction = undefined;

    menu.style.display = "flex";
    finalScore.innerText = score.innerText;
    canvas.style.filter = "blur(2px)"
}

const gameLoop = () => {

    if(gameMenu) {
        return;
    }
    clearInterval(loopId);

    ctx.clearRect(0, 0, 600, 600)
    drawSnake();
    drawFood(); 
    moveSnake();
    checkEat();
    checkColision();
   
    loopId = setTimeout(() => {
        gameLoop()
    }, 70)

}

gameLoop();

document.addEventListener("keydown", (event) => {
    
    if (event.key == "ArrowRight" && direction != "left"){
        direction = "right";
    }

    if (event.key == "ArrowLeft" && direction != "right"){
        direction = "left";
    }

    if (event.key == "ArrowDown" && direction != "up"){
        direction = "down";
    }

    if (event.key == "ArrowUp" && direction != "down"){
        direction = "up";
    }
})

buttomPlay.addEventListener("click", () => {
   
    score.innerText = "00";
    menu.style.display = "none";
    canvas.style.filter = "none";
    snake = [{ x: 0, y: 0 }];
    food.x = randomPosition();
    food.y = randomPosition();
    gameMenu = false;
    gameLoop();

}) 
   

    

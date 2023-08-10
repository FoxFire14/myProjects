const APIurl = 'https://opentdb.com/api.php?amount=10&type=multiple';
const choicesDiv = $('#choices');
const divCategory = $('#category');
const qustionDiv = $('#question');
const rightQuestionsCounter = $('#right-questions');
const myContainer = $('.container');
const exitButton = $('#exit-button');
const endGameh1 = $('#end-game');

 
let i = 0;
let counterRightAnswers = 1;



// function without ES6 with promisses
function leadData2(){
    fetch(APIurl).then((response) => {
        return response.json();
    }).then((result) => {
        console.log(result);
        quizz(result.results);
    }).catch((err) => {
        console.log(err);
    });
}



// function using ES6 async/await sintax
async function loadData(){
    
    let data = await fetch(APIurl);
    let result = await data.json();
    
    console.log(result);
    quizz(result.results);
    
}




function quizz(data){
    if (i < 10){
        testData(data);
    }
    
    if (i === 10){
        myContainer.remove();
        endGameh1.text("You got " + counterRightAnswers + " question(s) right");
    }

}




function testData(data){
    
    console.log(i);

    

    let resuts = data[i];
    let fistQuestion = decodeEntities(resuts.question);
    let correctAnswer = decodeEntities(resuts.correct_answer);
    let wrongAnswers = resuts.incorrect_answers;
    let category = resuts.category;
    
    let newSpan = $('<span>').text('Category : '+category)
    $('#question-header').text("Question " + (i + 1));
    
    
    clearBoard();
    
    
    
    divCategory.append(newSpan);
    
    
    qustionDiv.text(fistQuestion);
    
    
    wrongAnswers.push(correctAnswer);
    
    
    shuffleArray(wrongAnswers);
    console.log(correctAnswer);
    
    
    for (let choice of wrongAnswers){
        let newButton = $('<button>').text(decodeEntities(choice));
        choicesDiv.append(newButton);
        
        newButton.on('click', function () {
            
        

            if (choice === correctAnswer){
                
                rightQuestionsCounter.text('Questions answered correctly: ' + counterRightAnswers++);
                
                newButton.addClass('correct');
                
            } else {
                
                newButton.addClass('incorrect');
            }
            newButton.prop('disabled', true);
            i++;
            
            setTimeout(() => {
                quizz(data);
            }, 1000)
            
        })

}
    if (i === 9){
        resuts = data[9];
    }
    
    
    exitButtonF();
    
}



function decodeEntities(encodedString) {
    const parser = new DOMParser();
    const dom = parser.parseFromString('<!doctype html><body>' + encodedString, 'text/html');
    return dom.body.textContent;
  }




function shuffleArray(array) {
    return array.sort(() => Math.random() - 0.5);
  }



  function clearBoard(){

    let choicesDiv = $('#choices');
    let divCategory = $('#category');
    if (i > 0){
        
        choicesDiv.empty();
        divCategory.empty();
    }
  }



function endGame(){

   location.reload();
  }



  function exitButtonF(){

    exitButton.off('click').on('click', () => {
        endGame();
    })


  }

leadData2();
let score = 0;
let time = 5
const outputTrue = document.getElementById('outputTrue');
const outputFalse = document.getElementById('outputFalse');
const screen = document.querySelector('.screen');
const diem = document.querySelector('.score');
const operators = [{
    sign: "+",
    method: function(a,b){ return a + b; }
},{
    sign: "-",
    method: function(a,b){ return a - b; }
}];
let a;
let b;
let ope;
let temp;
let resultRight;
let endGame=false;

function randomOperand(){
	return Math.floor((Math.random()*10)+1)
}

function randomOperator(){
    selectedOperator = Math.floor(Math.random()*operators.length);
    ope = operators[selectedOperator].sign;
	return ope;
}

function getResult(a, b, operator){
	if(operator=='+') return a+b
	else return a-b
}

function getDisplayResult(resultRight, temp, operator){
	if(temp==0) return resultRight //nếu temp=0 trả về kết quả đúng
	else{
		if(operator=='+') return resultRight+2; //kq sai ope = '+'
		else return resultRight-2;//kqua sai ope = '-'
	}
}

function newGame() {
    a = randomOperand();
    b = randomOperand();
    ope = randomOperator();
    temp = Math.floor(Math.random()*2);
    resultRight = getResult(a, b, ope);
    displayresult=getDisplayResult(resultRight, temp, ope);
    let expression=a+' '+ope+' '+b+' = '+displayresult;
    screen.innerText = expression;
}

function next(){
	score+=1
	time=5
	diem.innerText='Điểm của bạn: '+ score;
	newGame()
}

function end(){
	alert(`Kết thúc! Điểm ${score}`)
	endGame=true;
    startGameNow.style.display = "block";
    document.querySelector('.game').style.display = "none";
}

outputTrue.onclick = function() {
    if(temp==0){
        next();
    }
    else{
        end();
    }
}

outputFalse.onclick = function() {
    if(temp==0){
        end()
    }
    else{
        next();
    }
}

function start(){
	time=5
    score = 0;
    endGame = false;
    diem.innerText='Điểm của bạn: '+ score;
	newGame()
	let run=setInterval(function(){
		time-=1
		if(time<=0){
			clearInterval(run);
            end();
		}
        if(endGame==true) {
            clearInterval(run)
        }
	}, 1000)
}


startGameNow = document.getElementById('startGameNow');
startGameNow.onclick = function(){
    startGameNow.style.display = "none";
    document.querySelector('.game').style.display = "block";
    start()
}



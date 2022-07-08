let score = 0
let result = 0
let displayresult = 0
let time = 10
let finish = false

function randomOperand() {
    return Math.floor((Math.random() * 10) + 1)
}

function randomOperator() {
    let operator = ['+', '-']
    let index = Math.floor(Math.random() * operator.length)
    return operator[index]
}

function getResult(a, b, operator) {
    if (operator == '+') return a + b
    else return a - b
}

function getAnswer() {
    return Math.floor((Math.random() * 2))
}

function getDisplayResult(result, answer, operator) {
    if (answer == 0) return result
    else {
        if (operator == '+') return result + 2
        else return result - 2
    }
}

function generateExpression() {
    let a = randomOperand()
    let b = randomOperand()
    let operator = randomOperator()
    result = getResult(a, b, operator)
    let answer = getAnswer()
    displayresult = getDisplayResult(result, answer, operator)
    let expression = a + ' ' + operator + ' ' + b + ' = ' + displayresult + '?'
    document.getElementById('expression').innerHTML = expression
}

function next() {
    score += 1
    time = 10
    document.getElementById('score').innerHTML = 'Your score: ' + score
    generateExpression()
}

function end() {
    document.getElementById('expression').style.display = 'none'
    document.getElementById('true').style.display = 'none'
    document.getElementById('false').style.display = 'none'
    document.getElementById('click').innerHTML = 'You lose!'
    alert('You lose!')
    finish = true
}

function check(button) {
    let check = false
    if (button == 'true') {
        if (result == displayresult) check = true
        else check = false
    } else {
        if (result != displayresult) check = true
        else check = false
    }
    if (check == true) next()
    else end()
}

function start() {
    time = 5
    document.getElementById('score').innerHTML = 'Your score: ' + score
    generateExpression()
    var run = setInterval(function() {
        time -= 1
        if (time <= 0 && finish != true) {
            clearInterval(run)
            end()
        }
    }, 1000)
}
start()
// to run this file run as 'node app.js'

console.log("Hello Node.js")

// Learning about function....!
function sum(a,b){
    return a+b;
}

const total = sum(2,3);
console.log("Total: ",total);

// export sub function from helper.js

// console.log("Process",process);

const helpers = require('./helpers')

const subTotal = helpers.sub(5,1);
console.log("SubTotal: ",subTotal);

// ------- Arrow function
const multiplyTotal = helpers.multiply(2,3)
console.log("Multiply", multiplyTotal);


const divide = helpers.divide(10,2)
console.log("divide", divide);

// ------- Object destructuring //

const {sub} = require('./helpers1')
console.log("sub", sub(9,8));

// ---- node js core modules.
const http = require('http')
const server = http.createServer((req, res) => {
    res.end("Hello world from node.js")
})

server.listen(3000);
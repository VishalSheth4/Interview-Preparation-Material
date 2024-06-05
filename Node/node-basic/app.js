// to run this file run as 'node app.js'

console.log("Hello Node.js")

// Learning about function....!
function sum(a,b){
    return a+b;
}

const total = sum(2,3);
console.log("Total: ",total);

// export sub function from helper.js

console.log("Process",process);

const helpers = require('./helpers')

const subTotal = helpers.sub(5,1);
console.log("SubTotal: ",subTotal);
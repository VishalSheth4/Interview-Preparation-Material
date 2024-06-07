const fs  = require("fs")

const fileName = "target.txt"

// event loop and event stack
// fs.watch(fileName, () => {
//     console.log("File Changed ..!")
// })

// Asynchronous Programming :--
fs.readFile(fileName, (err, data)=>{
        if(err){
            console.log(err)
        }
        console.log(data.toString())
});

console.log("Node js is asynchronous ...!")

// Synchronous Programming :-
const data1 = fs.readFileSync(fileName)

console.log(data1.toString())

const express = require('express')
const app = express()

app.get('/',(req,res)=>{
    res.send("Hello World from node.js")
})

const port = 8080
app.listen(port, () => {
    console.log(`A node js API is listening on port: ${port}`)
})
const express = require('express')

const app = express()

app.get('/', (req,res)=>{
    res.send("Hey, whatups from express ...!")
})

app.listen(3000)
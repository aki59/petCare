const express= require('express');
const app=express();

app.get('/dogBreed',(req,res)=>{
  res.send("husky");
});

app.listen(3000,()=> console.log('listening on port 3000'));

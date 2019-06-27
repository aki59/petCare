const express= require('express');
const app=express();
const filePath= '/Users/dell i5/git/petCare1/animalDetailAPI/Indian Pariah/Street-Dog-Madras-Courier-04.jpg';
const dogBreeds= require('./IndianDogBreeds.json');

//app.use('/Indian Pariah', express.static(__dirname + '/Indian Pariah'));

app.get('/api/IndianDogBreeds',(req,res)=>{
  res.send(dogBreeds);
});

app.get('/api/:dogName',(req,res)=>{
 res.sendFile(filePath);
});

app.listen(3000,()=> console.log('listening on port 3000'));

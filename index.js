var express=require("express")

var article=require('./router/article');
var client=require('./router/client');
var app=express('./router/article');


app.use("/article",article)
app.use("/client",client)

app.get("/",function(req,res){

    res.send("Welcome")

})

app.listen(3000, function () {
    console.log("Serveur demarré au port 3000");


});

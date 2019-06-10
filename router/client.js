var express= require("express");
var cnx=require("./cnx")
var route=express.Router();

route.get("/all",function (req,res) {
    sql="select * from clients"
    cnx.getConnection().query(sql,function (err,result) {
        if(err){
            console.log("erreur")
        }else {
            res.send(JSON.stringify(result))
        }
    });
});
route.get('/getById',function (req,res) {
    var mail = req.query.mail;
    var mdp = req.query.mdp ;
    cnx.getConnection().query("select * from clients where mail = '"+mail+"' and mdp = '"+mdp+"'", function (err, result) {

        if(err)
        {
            console.log(err);
        }
        else
        {
            res.send(JSON.stringify(result[0]));

        }

    });

});



route.get("/add", function (req, res) {


    var surname=req.query.surname;
    var namee=req.query.namee;
    var date_of_birth=req.query.date_of_birth;
    var mail=req.query.mail;
    var mdp=req.query.mdp;
    var phone=req.query.phone;

    sql="INSERT INTO `clients` (`idt`, `surname`, `namee`, `date_of_birth`, `mail`, `mdp`, `phone`) VALUES (NULL,'"+surname+"','"+namee+"', '"+date_of_birth+"','"+mail+"','"+mdp+"',"+phone+")";

    cnx.getConnection().query(sql, function (err, result) {

        if (result.affectedRows == 1) {
            res.send("ajouté avec succes")

        } else {
            res.send("n est pas ajouté")
        }
    })
});




route.get("/remove",function (req,res) {

    var idt=req.query.idt;

    sql="delete from `clients` where idt="+idt+" ";
    cnx.getConnection().query(sql,function () {
        res.redirect("all")
    })
});


route.get("/update",function (req,res) {
    sql="update clients set mdp="+req.query.mdp+" where idt="+req.query.idt+" "
    cnx.getConnection().query(sql,function (err,result) {
        res.redirect("all")

    })



});
module.exports=route;
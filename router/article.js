var express= require("express");
var cnx=require("./cnx")
var route=express.Router();




route.get("/all",function (req,res) {
    sql="select * from articles"
    cnx.getConnection().query(sql,function (err,result) {
        if(err){
            console.log("erreur")
        }else {
            res.send(JSON.stringify(result))
        }
    });
});
route.get('/getByRef',function (req,res) {
    var ref= req.query.ref;

    cnx.getConnection().query("select * from articles where ref='"+ref+"'",function (err,result) {
        if(err){
            console.log("erreur")
        }else {
            res.send(JSON.stringify(result))
        }
    })
});
route.get('/getByPrice',function (req,res) {
    var price = req.query.price;

    cnx.getConnection().query("select * from articles where price="+price+"",function (err,result) {
        if(err){
            console.log("erreur")
        }else {
            res.send(JSON.stringify(result))
        }
    })
});


route.get('/getByType',function (req,res) {
    var type_dress=req.query.type_dress;
    sql="select * from articles where type_dress='"+type_dress+"'";
    cnx.getConnection().query(sql,function (err,result) {
        if(err){
            console.log("erreur")
        }else {
            res.send(JSON.stringify(result))
        }
    })
});
route.get('/add',function (req,res) {
    var reference= req.query.ref;
    var quantite=req.query.quantity;
    var vet=req.query.type_dress;
    var prix= req.query.price;
    var descp=req.query.descrp;
    var img= req.query.imageURL;
    sql= "INSERT INTO `articles`  VALUES ('" + reference + "'," + quantite + ",'" + vet+ "'," + prix + ",'" + descp + "','" + img + "')";
    cnx.getConnection().query(sql, function (err, result) {

        if (result.affectedRows == 1) {
            res.send("ajoute avec succes")

        } else {
            res.send("n est pas ajouté")
        }


    })
});

route.get("/remove",function (req,res) {
    var ref=req.query.ref;
    sql2="delete from `articles` where ref='"+ref+"'";
    cnx.getConnection().query(sql2,function () {
        res.redirect("all")

    })



});
route.get("/update",function (req,res) {
    var ref=req.query.ref;
    var price=req.query.price;
    var quantity=req.query.quantity;
    var imageURL=req.query.imageURL;

    sql="update `articles` SET `price`="+price+",`quantity`="+quantity+",`imageURL`='"+imageURL+"' where ref='"+ref+"' "
    cnx.getConnection().query(sql,function (err,result) {

        res.redirect("all")

    })

});



module.exports=route;
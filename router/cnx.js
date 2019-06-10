var mysql = require("mysql");



var config= {
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'boutique'


}
var con=mysql.createConnection(config);
con.connect(function (err) {
    if (err) {
        console.log("erreur")
    } else {
        console.log("connected")
    }

    exports.getConnection = function () {
        return con;
    }

});

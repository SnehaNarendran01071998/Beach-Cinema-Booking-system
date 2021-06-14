const express = require("express");
var cors = require('cors');
let  app = express();

app.use(express.static('public'));
app.use(cors());
app.use(function (req, res, next) {
    res.header('Access-Control-Allow-Origin', '*')
    res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept')
    next()
  })
app.listen(3000,  () => console.log("Example app listening on port 3000!"));
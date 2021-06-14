const express = require("express");
var cors = require("cors");
let app = express();

app.use(express.static("public"));
app.use(cors());
app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header(
    "Access-Control-Allow-Headers",
    "Origin, X-Requested-With, Content-Type, Accept"
  );
  next();
});
var port = process.env.PORT || 3000 || 5000;
app.listen(port, "0.0.0.0", function () {
  console.log("Listening on Port 3000");
});

const express = require("express");
var cors = require("cors");
let app = express();

app.use(express.static("public"));
app.use(cors({ origin: "https://cinema-booking-frontend.herokuapp.com"}))

var port = process.env.PORT || 3000 || 5000;
app.listen(port, "0.0.0.0", function () {
  console.log(`Listening on Port ${port}`);
});

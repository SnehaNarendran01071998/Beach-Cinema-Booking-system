import React from "react";
import "./App.scss";
import Shows from "./components/Shows/Shows";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Amplify from "aws-amplify";
import awsmobile from "./aws-exports";
import Films from "./components/Films/Films";

Amplify.configure(awsmobile);
function App() {
  return (
    <Router>
      <div className="App">
        <Switch>
          <Route path="/" component={Shows} />
          <Route path="/film" component={Films} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;

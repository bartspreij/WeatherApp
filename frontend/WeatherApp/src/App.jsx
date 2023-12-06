import { useEffect, useState } from "react";
import "./App.css";
import WeatherTable from "./components/WeatherTable";

function App() {
  return (
      <div className="App">
          <h1>Weertje!!!</h1>
          <WeatherTable/>
      </div>
  );
}

export default App;
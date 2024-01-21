import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import "./index.css";
import SpotifyHorizonSongList from "./components/SpotifyMusicDisplay/get-monthly-list";
import NaverMapsStars from "./components/MapApiDisplay/naver-map-pin-board";
import YearPicker from "./components/GetDates/select-year";
import MonthPicker from "./components/GetDates/select-month";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    {/* App: 로고 */}
    <App />
  </React.StrictMode>
);

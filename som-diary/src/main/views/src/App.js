import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Start from "./pages/Start";
import Main from "./pages/Main";
import Diary from "./pages/Diary";
import Location from "./pages/Location";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/home" exact element={<Home />} />
        <Route path="/get-start" exact element={<Start />} />
        <Route path="/main" exact element={<Main />} />

        <Route path="/diary" element={<Diary />} />
        <Route path="/search-location" element={<Location />} />
      </Routes>
    </Router>
  );
}

export default App;

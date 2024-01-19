import { BrowserRouter as Router, Route,Routes } from "react-router-dom";
import Diary from "./pages/Diary"
import Location from "./pages/Location"

function App() {
  return (
      <Router>
          <Routes>
              <Route path="/" element={<Diary />} />
              <Route path="/search-location" element={<Location/>} />
          </Routes>
      </Router>
  );
}

export default App;

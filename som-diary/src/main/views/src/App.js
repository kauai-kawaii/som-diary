import Logo from "./components/Logo";
import Insight from "./pages/insight";
import Home from "./pages/home";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

function App() {
  return (
    <Router>
      <Routes>
        {/* <Route path="/" exact element={<Home />} />
        <Route path="/get-start" exact element={<Start />} />
        <Route path="/main" exact element={<Main />} /> */}
        <Route path="/insight" exact element={<Insight />} />
      </Routes>
    </Router>
  );
}

export default App;

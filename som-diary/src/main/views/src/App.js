import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Start from './pages/Start';
import Main from './pages/Main';

function App() {
    return (
        <Router>
            <Routes>
                <Route path='/' exact element={<Home />} />
                <Route path='/get-start' exact element={<Start />} />
                <Route path='/main' exact element={<Main />} />
            </Routes>
        </Router>
    );
}

export default App;

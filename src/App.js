import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import CreatePlayerForm from "./templates";

function App() {
  return (
      <Router>
        <Routes>
          <Route path="/" element={<h1>Bienvenue sur l'application</h1>} />
          <Route path="/create-player" element={<CreatePlayerForm />} />
        </Routes>
      </Router>
  );
}

export default App;
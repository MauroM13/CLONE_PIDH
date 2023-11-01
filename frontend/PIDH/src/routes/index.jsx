import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "../pages/Home";
import Login from "../pages/Login";
import Header from "../components/Header";
import Cadastro from "../pages/cadastro";

function RoutesApp() {
  return (
    <BrowserRouter>
      <Header />
        <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Cadastro />} />
        <Route path="*" element={<Home />} />
        </Routes>
    </BrowserRouter>
);
}

export default RoutesApp;
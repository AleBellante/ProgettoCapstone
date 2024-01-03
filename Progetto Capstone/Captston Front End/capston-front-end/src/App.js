import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import NavBar from "./Components/NavBar";
import MainHome from "./Components/MainHome";

import RegisterPage from "./Components/RegisterPage";
import ProductPage from "./Components/ProductPage";
import Carrello from "./Components/Carrello";
import LoginPage from "./Components/LoginPage";
import AreaCliente from "./Components/AreaCliente";

import AreaAdmin from "./Components/AreaAdmin";

function App() {
  return (
    <div className="App">
      <header className="App-header"></header>
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route path="" element={<MainHome />}></Route>
          <Route path="/register" element={<RegisterPage />}></Route>
          <Route path="/login" element={<LoginPage />}></Route>
          <Route path="/products" element={<ProductPage />}></Route>
          <Route path="/carrello" element={<Carrello />}></Route>
          <Route path="/area-cliente" element={<AreaCliente />}></Route>
          <Route path="/area-admin" element={<AreaAdmin />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}
// background-image: "/public/Dolci-left.jpg";
export default App;

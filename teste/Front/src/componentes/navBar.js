import { useNavigate } from "react-router-dom";
import "./navbar.css";
import * as React from "react";

export function NavBar(props) {
  const navigate = useNavigate();

  return (
    <div className="menu">
      <button
        onClick={() => {
          navigate("/getAllEmpresas");
        }}
      >
        Empresas
      </button>
      <button
        onClick={() => {
          navigate("/addEmpresa");
        }}
      >
        Add empresa
      </button>
      <button
        onClick={() => {
          navigate("/addPessoa");
        }}
      >
        add Pessoa
      </button>
      <button
        onClick={() => {
          navigate("/addSalario");
        }}
      >
        add Salario
      </button>
    </div>
  );
}

import { BrowserRouter, Routes, Route } from "react-router-dom";
import { NavBar } from "./componentes/navBar";
import { Empresa } from "./componentes/addEmpresa";
import "./App.css";
import { Pessoa } from "./componentes/addPessoa";
import { Salario } from "./componentes/addSalario";
import { Getempresa } from "./componentes/getEmpresas";
import { EmpresaSelecionada } from "./componentes/empresaSelecionada";
import { FuncionarioSelecionado } from "./componentes/funcionarioSelecionado";
import React, { useState, useEffect } from "react";
function App() {
  const [infoEmpresa, setInfoEmpresa] = useState();
  const [funcionarioInfo, setFuncionarioInfo] = useState();
  // Função para obter a info da Empresa
  function GetEmpresaInfo(item) {
    return setInfoEmpresa(item);
  }
  // Função para obter a info do funcionario
  function GetFuncionarioInfo(item) {
    return setFuncionarioInfo(item);
  }
  return (
    <div className="App">
      <BrowserRouter>
        {<NavBar></NavBar>}
        <Routes>
          <Route path="/addEmpresa" element={<Empresa></Empresa>} />

          <Route path="/addPessoa" element={<Pessoa></Pessoa>} />

          <Route path="/addSalario" element={<Salario></Salario>} />

          <Route
            path="/getAllEmpresas"
            element={<Getempresa GetEmpresaInfo={GetEmpresaInfo}></Getempresa>}
          />
          <Route path="/*" element={<Getempresa></Getempresa>} />

          <Route
            path="/empresaID/:id"
            element={
              <EmpresaSelecionada
                infoEmpresa={infoEmpresa}
                GetFuncionarioInfo={GetFuncionarioInfo}
              ></EmpresaSelecionada>
            }
          />

          <Route
            path="/funcionarioID/:id"
            element={
              <FuncionarioSelecionado
                infoEmpresa={infoEmpresa}
                funcionarioInfo={funcionarioInfo}
              ></FuncionarioSelecionado>
            }
          />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

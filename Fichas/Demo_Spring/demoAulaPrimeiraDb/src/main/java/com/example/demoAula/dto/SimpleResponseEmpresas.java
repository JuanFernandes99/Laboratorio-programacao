package com.example.demoAula.dto;

import com.example.demoAula.model.Empresa;

import java.util.ArrayList;
import java.util.List;

public class SimpleResponseEmpresas extends SimpleResponse{
    List<Empresa> empresas;

    public SimpleResponseEmpresas() {
        empresas = new ArrayList<>();
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> aEmpresa) {
        empresas = aEmpresa;
    }
}

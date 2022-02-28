package projetoExtra1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utilizador.Cliente;

public class Compra {

	private Date dataCompra;
	private double valor;
	private List<Aplicacao> aplicacoes;
	private List<Cliente> clientes;

	public Compra(double aValor) {
		valor = aValor;
		dataCompra = new Date();
		aplicacoes = new ArrayList<Aplicacao>();
		clientes = new ArrayList<Cliente>();
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public double getValor() {
		return valor;
	}

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setDataCompra(Date aDataCompra) {
		dataCompra = aDataCompra;
	}

	public void setValor(double aValor) {
		valor = aValor;
	}

	public void setAplicacoes(List<Aplicacao> aAplicacoes) {
		aplicacoes = aAplicacoes;
	}

	public void setClientes(List<Cliente> aClientes) {
		clientes = aClientes;
	}
}

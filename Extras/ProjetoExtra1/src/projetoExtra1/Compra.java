package projetoExtra1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Compra {

	private Date dataCompra;
	private double valor;
	private int clienteId;
	private List<Aplicacao> aplicacoes;  // atençao ao apagar as listas 

	public Compra(int aClienteId,  List<Aplicacao> aplicacoes) {
		aplicacoes = new ArrayList<Aplicacao>();
		dataCompra = new Date();
	       valor = aplicacoes.stream().mapToDouble(Aplicacao::getPreco).sum();
	        aplicacoes.forEach(Aplicacao::adicionarVenda);


	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public double getValor() {
		return valor;
	}

	public void setDataCompra(Date aDataCompra) {
		dataCompra = aDataCompra;
	}

	public void setValor(double aValor) {
		valor = aValor;
	}

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public void setAplicacoes(List<Aplicacao> aplicacoes) {
		this.aplicacoes = aplicacoes;
	}

	@Override
	public String toString() {
		return "Compra [dataCompra=" + dataCompra + ", valor=" + valor + ", aplicacoes=" + aplicacoes + "]";
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	
}

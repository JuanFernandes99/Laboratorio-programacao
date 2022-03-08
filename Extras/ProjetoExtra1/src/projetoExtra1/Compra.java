package projetoExtra1;

import java.util.Date;
import java.util.List;

import utilizador.Cliente;


public class Compra {

	private Date dataCompra;
	private double valor;
	private List<Aplicacao> aplicacoes; // atençao ao apagar as listas

	public Compra(Cliente aCliente, List<Aplicacao> aAplicacoes) {// atençao a isto
		aplicacoes = aAplicacoes;
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



	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public void setDataCompra(Date aDataCompra) {
		dataCompra = aDataCompra;
	}

	public void setValor(double aValor) {
		valor = aValor;
	}

	public void setAplicacoes(List<Aplicacao> aplicacoes) {
		this.aplicacoes = aplicacoes;
	}

	@Override
	public String toString() {
		return "Compra [dataCompra=" + dataCompra + ", valor=" + valor + ", aplicacoes=" + aplicacoes + "]";
	}

}

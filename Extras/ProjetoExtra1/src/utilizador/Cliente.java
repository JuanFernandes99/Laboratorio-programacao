package utilizador;

import java.util.ArrayList;
import java.util.List;

import projetoExtra1.Aplicacao;
import projetoExtra1.Compra;

public class Cliente extends Utilizador {

	private double saldo;
	private List<Compra> compras;
	private List<Aplicacao> aplicacoes;

	public Cliente(String aNome, int aIdade, double aSaldo) {
		super(aNome, aIdade);
		compras = new ArrayList<Compra>();
		aplicacoes = new ArrayList<Aplicacao>();
	}

	public void adicionaCompra(Compra aCompra) {
		compras.add(aCompra);
		aplicacoes.addAll(aCompra.getAplicacoes());

	}

	public List<Compra> getCompras() {
		return compras;
	}

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setCompras(List<Compra> aCompras) {
		compras = aCompras;
	}

	public void setSaldo(double aSaldo) {
		saldo = aSaldo;
	}

}

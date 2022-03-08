package utilizador;

import java.util.ArrayList;
import java.util.List;

import projetoExtra1.Compra;

public class Cliente extends Utilizador {

	private List<Compra> compras;
	
	public Cliente(String aNome, int aIdade) {
		super(aNome, aIdade);
		compras = new ArrayList<Compra>();
	}

	public void adicionaCompra(Compra aCompra) {
		compras.add(aCompra);
	}
	
	public List<Compra> getCompras() {
		return compras;
	}
	
	public void setCompras(List<Compra> aCompras) {
		compras = aCompras;
	}

}

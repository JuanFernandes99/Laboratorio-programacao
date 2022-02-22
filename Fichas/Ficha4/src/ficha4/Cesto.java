package ficha4;

import java.util.ArrayList;
import java.util.List;

public class Cesto {

	private final int capacidadeCesto = 3; // verificar
	private int totalItems;
	private List<Fruta> frutas;

	public Cesto() {

		frutas = new ArrayList<Fruta>();
	}

	public void insereFruta(Fruta aFruta) {
		if (frutas.size() <= capacidadeCesto) {
			frutas.add(aFruta);
			System.out.println(aFruta.getNome() + " adicionada ao cesto");
		} else {
			System.out.println("nao tem espaço");
		}

	}

	@Override
	public String toString() { // ver isto
		// for e criar uma string no final // obg
		return "Cesto{" + "frutas=" + frutas + '}';
	}

	public int getCapacidadeCesto() {
		return capacidadeCesto;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public List<Fruta> getFrutas() {
		return frutas;
	}

	public void setTotalItems(int aTotalItems) {
		totalItems = aTotalItems;
	}

	public void setFrutas(List<Fruta> aFrutas) {
		frutas = aFrutas;
	}

}

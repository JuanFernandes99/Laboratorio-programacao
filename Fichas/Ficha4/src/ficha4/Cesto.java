package ficha4;


import java.util.ArrayList;
import java.util.List;

public class Cesto {

	private final int capacidadeCesto = 5; // verificar
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

	public double valorCesto() {
		double valor = 0;

		for (Fruta fruta : frutas) {

			valor += fruta.pagar();
		}
		return valor;
	}
/*
	public int numFrutoExistente(String tipoFruta) {
		tipoFruta.toLowerCase();
		for (Fruta fruta : frutas) {

			if (fruta.getNome().toLowerCase().equals(tipoFruta)) {

				if (fruta instanceof FrutaUnidade) {

					return ((FrutaUnidade) fruta).getUnidade();

				} else if (fruta instanceof FrutaVolume) {

					System.out.println("Quantidade de " + fruta + " por volume: " + ((FrutaVolume) fruta).getVolume() + " m3");

				} else if (fruta instanceof FrutaPeso) {

					System.out.println("Quantidade de " + fruta + " por peso: " + ((FrutaPeso) fruta).getPeso() + " Kg");
				}
			}
		}

	}
*/
	@Override
	public String toString() {

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

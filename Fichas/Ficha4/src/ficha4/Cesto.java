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

	public int numFrutoPorTipo(String tipoFruta) {
		int quantFruto = 0;
		for (Fruta fruta : frutas) {

			if (fruta.getClass().getSimpleName().equals(tipoFruta)) {

				if (fruta instanceof FrutaUnidade) {

					quantFruto += ((FrutaUnidade) fruta).getUnidade();

				} else if (fruta instanceof FrutaVolume) {

					quantFruto += ((FrutaVolume) fruta).getVolume();

				} else if (fruta instanceof FrutaPeso) {

					quantFruto += ((FrutaPeso) fruta).getPeso();
				}
			}
		}
		return quantFruto;
	}
	
	public double valorTotalPorTipo(String tipoFruta) {
		double valorTipo = 0;
		
		for (Fruta fruta : frutas) {

			if (fruta.getClass().getSimpleName().equals(tipoFruta)) {

				if (fruta instanceof FrutaUnidade) {

					valorTipo += ((FrutaUnidade) fruta).pagar();

				} else if (fruta instanceof FrutaVolume) {

					valorTipo += ((FrutaVolume) fruta).pagar();

				} else if (fruta instanceof FrutaPeso) {

					valorTipo += ((FrutaPeso) fruta).pagar();
				}
			}
		}
		return valorTipo;
	}

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

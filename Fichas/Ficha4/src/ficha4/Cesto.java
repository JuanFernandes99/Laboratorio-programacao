package ficha4;

import java.util.ArrayList;
import java.util.List;

import fruta.Fruta;
import fruta.FrutaPeso;
import fruta.FrutaUnidade;
import fruta.FrutaVolume;

public class Cesto {

	// Atributos
	private final int CAP_MAX = 100;
	private int totalItems;
	private List<Fruta> frutas;

	// Construtor Vazio
	public Cesto() {
		totalItems = 0;
		frutas = new ArrayList<Fruta>();
	}

	// M�todos

	// M�todo que insere no cesto diferentes tipos de fruta.
	public void insereFruta(Fruta aFruta) {
		if (frutas.size() <= CAP_MAX) { // Verifica�ao da capacidade do cesto
			frutas.add(aFruta);
			totalItems++;
			System.out.println(aFruta.getNome() + " adicionada ao cesto" + ", Total items no cesto: " + totalItems);
		} else {
			System.out.println("nao tem espa�o");
		}

	}

	// M�todo que calcula o valor total da fruta no cesto.
	public double valorCesto() {
		double valor = 0;

		for (Fruta fruta : frutas) {

			valor += fruta.pagar();
		}
		return valor;
	}

	// M�todo que determina o n�mero de frutos de um dado tipo existentes no cesto.
	public int numFrutoPorTipo(String tipoFruta) {
		int quantidade = 0;
		for (Fruta fruta : frutas) {
			if (fruta.getClass().getSimpleName().equals(tipoFruta)) {
				quantidade += 1;
			}
		}
		return quantidade;
	}
	// M�todo que determina a quantidade de frutos de um dado tipo existentes no cesto.
	public int quantidadeFrutoPorTipo(String tipoFruta) {
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

	// M�todo que determina o valor total gasto em frutos de um dado tipo
	public double valorTotalPorTipo(String tipoFruta) {
		double valorTipo = 0;

		for (Fruta fruta : frutas) {

			if (fruta.getClass().getSimpleName().equals(tipoFruta)) {

				valorTipo += fruta.pagar();
			}
		}
		return valorTipo;
	}

	// Getter
	public int getTotalItems() {
		return totalItems;
	}

	@Override
	public String toString() {

		return "Cesto{" + "frutas=" + frutas + '}';
	}

}
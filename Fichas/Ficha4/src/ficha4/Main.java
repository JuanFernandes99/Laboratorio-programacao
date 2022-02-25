package ficha4;

import java.text.DecimalFormat;

import fruta.FrutaPeso;
import fruta.FrutaUnidade;
import fruta.FrutaVolume;

public class Main {

	static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {

		// Criação das Frutas

		FrutaUnidade maca = new FrutaUnidade("Maçã", 0.70);
		FrutaUnidade abacate = new FrutaUnidade("Abacate", 0.50);
		FrutaPeso pera = new FrutaPeso("Pera", 0.60);
		FrutaVolume banana = new FrutaVolume("Banana", 0.30);

		// Set das modalidades: à unidade, ao peso ou pelo volume
		maca.setUnidade(10);
		abacate.setUnidade(8);
		pera.setPeso(40.5f);
		banana.setVolume(30.5f);

		// Criação do cesto
		Cesto cesto = new Cesto();

		// inserir no cesto diferentes tipos de fruta.

		cesto.insereFruta(maca);
		cesto.insereFruta(abacate);
		cesto.insereFruta(pera);
		cesto.insereFruta(banana);

		// Valor a pagar por cada produto
		System.out.println("Valor a pagar pela compra de " + maca.getUnidade() + " " + maca.getNome() + "(s): "
				+ maca.pagar() + "€");
		System.out.println("Valor a pagar pela compra de " + abacate.getUnidade() + " " + abacate.getNome() + "(s): "
				+ abacate.pagar() + "€");
		System.out.println("Valor a pagar pela compra de " + pera.getPeso() + " gr de " + pera.getNome() + "(s): "
				+ pera.pagar() + "€");
		System.out.println("Valor a pagar pela compra de " + banana.getVolume() + " m3 de " + banana.getNome() + "(s): "
				+ banana.pagar() + "€");

		// Print do objeto cesto
		System.out.println(cesto);

		// Print do valor do cesto
		System.out.println("Total a pagar pelos produtos do cesto: " + paraDuasCasas(cesto.valorCesto()));

		// Print do número de frutos por unidade, peso e volume
		System.out.println("Número de fruta(s) por unidade no cesto: " + cesto.numFrutoPorTipo("FrutaUnidade"));
		System.out.println("Número de fruta(s) por peso no cesto: " + cesto.numFrutoPorTipo("FrutaPeso"));
		System.out.println("Número de fruta(s) por volume no cesto: " + cesto.numFrutoPorTipo("FrutaVolume"));

		// Print da quantidade de frutos por unidade, peso e volume
		System.out.println("Quantidade de fruta(s) por unidade no cesto: "
				+ cesto.quantidadeFrutoPorTipo("FrutaUnidade") + " unidad(es)");
		System.out.println(
				"Quantidade de fruta(s) por peso no cesto: " + cesto.quantidadeFrutoPorTipo("FrutaPeso") + " gramas");
		System.out.println(
				"Quantidade de fruta(s) por volume no cesto: " + cesto.quantidadeFrutoPorTipo("FrutaVolume") + " m3");

		// Print do valor dos frutos por unidade, peso e volume
		System.out.println(
				"Valor total da fruta por unidade no cesto: " + paraDuasCasas(cesto.valorTotalPorTipo("FrutaUnidade")));
		System.out.println(
				"Valor total da fruta por peso no cesto: " + paraDuasCasas(cesto.valorTotalPorTipo("FrutaPeso")));
		System.out.println(
				"Valor total da fruta por volume no cesto: " + paraDuasCasas(cesto.valorTotalPorTipo("FrutaVolume")));

		// Aplicando um desconto de 30% na banana
		banana.setPercentagemDesconto(30);

		System.out.println(
				"Preço total da banana com desconto de " + banana.getPercentagem() + "% :" + banana.pagar() + "€");

		// Aplicando um desconto de 50% na pera
		pera.setPercentagemDesconto(50);
		System.out
				.println("Preço total da pera com desconto de " + pera.getPercentagem() + "% :" + pera.pagar() + "€");
	}

	// Método para limitar os resultados para duas casas decimais
	private static String paraDuasCasas(double dinheiro) {
		return df.format(dinheiro) + "€";
	}

}

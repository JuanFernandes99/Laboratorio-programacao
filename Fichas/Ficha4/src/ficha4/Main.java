package ficha4;

import java.text.DecimalFormat;

public class Main {

	static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {

		FrutaUnidade maca = new FrutaUnidade("Maca", 0.70);
		FrutaUnidade abacate = new FrutaUnidade("Abacate", 0.70);
		FrutaPeso pera = new FrutaPeso("Maca", 0.60);
		FrutaVolume banana = new FrutaVolume("Banana", 0.3);

		maca.setUnidade(10);
		abacate.setUnidade(8);
		pera.setPeso(40.5f);
		banana.setVolume(30);

		leitorCodigoBarras(maca);
		maca.pagar();
		pera.pagar();
		banana.pagar();

		Cesto cesto1 = new Cesto();

		cesto1.insereFruta(maca);
		cesto1.insereFruta(abacate);
		cesto1.insereFruta(pera);
		cesto1.insereFruta(banana);

		System.out.println(cesto1);

		System.out.println(cesto1.valorCesto());
		double total = cesto1.valorCesto();
		System.out.println(paraDuasCasas(total));

		System.out.println("Fruta por peso no cesto: " + cesto1.numFrutoPorTipo("FrutaUnidade"));
		System.out.println("Valor da fruta por peso no cesto: " + cesto1.valorTotalPorTipo("FrutaUnidade"));

	}

	private static void leitorCodigoBarras(Fruta aFruta) {
		System.out.println("o valor a pagar do produto " + aFruta + ":" + df.format(aFruta.pagar()) + "$");
	}

	private static String paraDuasCasas(double dinheiro) {
		return df.format(dinheiro) + "€";
	}

}

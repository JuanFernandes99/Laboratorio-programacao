package ficha4;

public class Main {

	public static void main(String[] args) {

		FrutaUnidade maca = new FrutaUnidade("maca", 0.20);
		FrutaUnidade maca2 = new FrutaUnidade("maca", 0.20);
		FrutaUnidade pera = new FrutaUnidade("pera", 0.20);
		FrutaUnidade banana = new FrutaUnidade("banana", 0.20);
		maca.setUnidade(10);
		maca.setUnidade(40);
		System.out.println(maca.pagar());
		
		Cesto cesto1 = new Cesto();
		
		cesto1.insereFruta(maca);
		cesto1.insereFruta(pera);
		cesto1.insereFruta(banana);
		cesto1.insereFruta(maca2);
		
		
		System.out.println(cesto1);
	}

}


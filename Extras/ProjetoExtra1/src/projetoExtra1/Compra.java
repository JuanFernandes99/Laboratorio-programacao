package projetoExtra1;

import java.util.Date;

public class Compra {

	private Date dataCompra;
	private double valor;

	public Compra(double aValor) {
		valor = aValor;
		dataCompra = new Date();

	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public double getValor() {
		return valor;
	}

	public void setDataCompra(Date aDataCompra) {
		dataCompra = aDataCompra;
	}

	public void setValor(double aValor) {
		valor = aValor;
	}
}

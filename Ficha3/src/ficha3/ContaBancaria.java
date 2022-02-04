package ficha3;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaBancaria {
	private String titular;
	private double saldo;
	private Date dataAbertura;

	public ContaBancaria(String aTitular, Date aDataAbertura) {
		titular = aTitular;
		dataAbertura = aDataAbertura;
		saldo = 0;
	}

	public ContaBancaria(String aTitular, double aSaldo) {
		titular = aTitular;
		dataAbertura = new Date();
		saldo = aSaldo;
	}

	public String getInformacaoConta() {
		DecimalFormat df = new DecimalFormat("0.00");
		String saldoDecimal = df.format(saldo);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(dataAbertura);  
	   
		return "Titular: " + titular + " Saldo atual " + saldoDecimal + "€" + " Data Abertura: " + strDate;
	}

	public void depositar(double valorDeposito) {

		saldo += valorDeposito;
		System.out.println("o Titular " + titular + " fez um Deposito de: " + valorDeposito + "€");
		System.out.println("Saldo atualizado:" + saldo + "€");
	}

	public void levantar(double valorLevantamento) {
		if (valorLevantamento < saldo) {

			saldo -= valorLevantamento;
			System.out.println("o Titular " + titular + " fez um levantamento de: " + valorLevantamento + "€");
			System.out.println("Saldo atualizado:" + saldo + "€");
		} else {
			System.out.println("Saldo do Titular " + titular + ": Insuficiente");
		}
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setSaldo(double aSaldo) {
		saldo = aSaldo;
	}

}
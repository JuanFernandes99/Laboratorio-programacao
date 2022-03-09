package ficha3;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaBancaria {
	private String titular;
	private double saldo;
	private Date dataAbertura;

	// Construtores

	// Recebe por parâmetro o nome do titular e a Data de Abertura e cria uma conta
	// bancária para esse titular com saldo zero.
	public ContaBancaria(String aTitular, Date aDataAbertura) {
		titular = aTitular;
		dataAbertura = aDataAbertura;
		saldo = 0.0; // Saldo zero
	}

	// Recebe por parâmetro o nome do titular e o saldo e cria uma conta
	// bancária para esse titular na data de hoje,
	public ContaBancaria(String aTitular, double aSaldo) {
		titular = aTitular;
		dataAbertura = new Date(); // Data de hoje
		saldo = aSaldo;
	}

	// Métodos

	// retorna uma String com o titular, o saldo da conta com duas casas decimais e
	// a data de abertura da conta no formato DD/MM/YYYY.
	public String getInformacaoConta() {
		DecimalFormat df = new DecimalFormat("0.00"); // Feito para retornar o saldo com duas casas decimais
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // Formatar a data para dd/MM/yyyy
		return "Titular: " + titular + "/ Saldo atual " + df.format(saldo) + "€" + "/ Data Abertura: "
				+ simpleDateFormat.format(dataAbertura);
	}

	// Recebe o valor a depositar na conta (double) e atualiza o respetivo saldo.
	public void depositar(double valorDeposito) {

		saldo += valorDeposito;
		System.out.println("o Titular " + titular + " fez um Deposito de: " + valorDeposito + "€");
		System.out.println("Saldo atualizado:" + saldo + "€");
	}

	// Recebe o valor a levantar da conta (double) e atualiza o respetivo saldo.
	// Não devem ser permitidos levantamentos que coloquem o saldo negativo.
	public void levantar(double valorLevantamento) {
		if (valorLevantamento < saldo) { // Verificação que não permite que o saldo fique negativo

			saldo -= valorLevantamento;
			System.out.println("o Titular " + titular + " fez um levantamento de: " + valorLevantamento + "€");
			System.out.println("Saldo atualizado:" + saldo + "€");
		} else {
			System.out.println("Saldo do Titular " + titular + ": Insuficiente");
		}
	}

	// Getters

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		System.out.println("Saldo do Titular " + titular + ":");
		return saldo;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	// Setter
	public void setSaldo(double aSaldo) {
		saldo = aSaldo;
	}

}
package ficha5;

import java.util.UUID;

public class Pessoa {

	private String primeiroNome;
	private String ultimoNome;
	private int idade;
	private double saldo;
	private UUID id;

	public Pessoa(String aPrimeiroNome, String aUltimoNome, int aIdade, double aSaldo) {
		id = UUID.randomUUID();
		primeiroNome = aPrimeiroNome;
		ultimoNome = aUltimoNome;
		idade = aIdade;
		saldo = aSaldo;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public int getIdade() {
		return idade;
	}

	public double getSaldo() {
		return saldo;
	}

	public UUID getId() {
		return id;
	}

	public void setPrimeiroNome(String aPrimeiroNome) {
		primeiroNome = aPrimeiroNome;
	}

	public void setUltimoNome(String aUltimoNome) {
		ultimoNome = aUltimoNome;
	}

	public void setIdade(int aIdade) {
		idade = aIdade;
	}

	public void setSaldo(double aSaldo) {
		saldo = aSaldo;
	}

	@Override
	public String toString() {
		return "Pessoa [Primeiro nome= " + primeiroNome + ", Ultimo nome= " + ultimoNome + ", Idade= " + idade + ", Saldo= "
				+ saldo + "€, Id= " + id + "]\n";
	}
	
}
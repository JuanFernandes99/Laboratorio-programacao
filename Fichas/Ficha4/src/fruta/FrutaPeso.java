package fruta;

public class FrutaPeso extends Fruta implements IDescontavel {

	// Atributos
	private float peso;
	private double percentagem;

	// Construtor

	// Recebe por par�metro o nome da fruta , e o pre�o base
	public FrutaPeso(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		peso = 0;
	}

	// O corpo de pagar() � fornecido aqui
	@Override
	public double pagar() {

		return (precoBase * peso) - descontar();
	}

	@Override
	// M�todo que calcula o valor a ser descontado do pre�o total
	public double descontar() {

		return (precoBase * peso) * percentagem / 100;
	}

	// Getter
	public double getPercentagem() {
		return percentagem;
	}

	public double getPeso() {
		return peso;
	}

	// Setters
	public void setPeso(float aPeso) {
		peso = aPeso;
	}

	public void setPercentagemDesconto(double aPercentagem) {
		percentagem = aPercentagem;
	}

}

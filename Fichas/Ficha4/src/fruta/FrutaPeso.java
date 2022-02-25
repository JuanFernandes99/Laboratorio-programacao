package fruta;

public class FrutaPeso extends Fruta implements IDescontavel {

	// Atributos
	private float peso;
	private double percentagem;

	// Construtor

	// Recebe por parâmetro o nome da fruta , e o preço base
	public FrutaPeso(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		peso = 0;
	}

	// O corpo de pagar() é fornecido aqui
	@Override
	public double pagar() {

		return (precoBase * peso) - descontar();
	}

	@Override
	// Método que calcula o valor a ser descontado do preço total
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

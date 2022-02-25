package fruta;

public class FrutaVolume extends Fruta implements IDescontavel {

	// Atributos
	private float volume;
	private double percentagem;

	// Construtor

	// Recebe por par�metro o nome da fruta , e o pre�o base
	public FrutaVolume(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		volume = 0;

	}

	@Override
	// O corpo de pagar() � fornecido aqui
	public double pagar() {

		return (precoBase * volume) - descontar();
	}

	@Override
	// M�todo que calcula o valor a ser descontado do pre�o total
	public double descontar() {

		return (precoBase * volume) * percentagem / 100;
	}

	// Getter

	public double getPercentagem() {
		return percentagem;
	}
	
	public double getVolume() {
		return volume;
	}

	// Setters
	public void setVolume(float aVolume) {
		volume = aVolume;
	}

	public void setPercentagemDesconto(double aPercentagem) {
		percentagem = aPercentagem;
	}

}

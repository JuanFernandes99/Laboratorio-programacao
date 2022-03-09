package ficha2;

import java.util.Scanner;

public class ResolucaoFicha2 {

	public static void main(String[] args) {
		Scanner consola = new Scanner(System.in);
		System.out.println("----------------------------------------------------");

		System.out.println("Insira dois argumentos (altura e base) para retornar a área do triangulo");
		System.out.println("Indique a altura do triângulo: ");
		double alturaTriangulo = consola.nextInt();
		System.out.println("Indique a base do triângulo: ");
		double baseTriangulo = consola.nextInt();
		double areaTriangulo = areaTriang(alturaTriangulo, baseTriangulo);
		System.out.println("A área do triângulo é " + areaTriangulo);

		System.out.println("----------------------------------------------------");

		System.out.println("Insira dois argumentos (altura e base) para retornar a área do retângulo");
		System.out.println("Indique a altura do retângulo");
		double alturaRetangulo = consola.nextInt();
		System.out.println("Indique a base do retângulo");
		double comprimentoRetangulo = consola.nextInt();
		double areaRetangulo = areaRetang(alturaRetangulo, comprimentoRetangulo);
		System.out.println("A área do retângulo é " + areaRetangulo);

		System.out.println("----------------------------------------------------");
		System.out.println(
				"Insira três argumentos (x, y, z) , caso z = 1 retorna a área do triangulo e retorna a área do retângulo caso contrário.");
		System.out.println("Indique o valor de X");
		double argumentoX = consola.nextInt();
		System.out.println("Indique o valor de Y");
		double argumentoY = consola.nextInt();
		System.out.println("Indique o valor de Z");
		double argumentoZ = consola.nextInt();
		double areaCalculator = areaCal(argumentoX, argumentoY, argumentoZ);
		System.out.print(areaCalculator + "\n");

		System.out.println("----------------------------------------------------");

		System.out.println("Digite um número, para calcular o fatorial");
		int numeroFator = consola.nextInt();
		int fatorial = factor(numeroFator);
		System.out.println("O número fatorial de " + numeroFator + " é: " + fatorial);

		System.out.println("----------------------------------------------------");

		System.out.println("Digite um número, para calcular o fatorial Recursivo");
		int numeroFatorialRecursivo = consola.nextInt();
		int fatorialRecursivo = factor(numeroFatorialRecursivo);
		System.out.println("O número fatorial recursivo de " + numeroFatorialRecursivo + " é: " + fatorialRecursivo);

		System.out.println("----------------------------------------------------");

		System.out.println("Insira uma frase para retornar o número total de vogais na mesma");
		String fraseInserida = consola.next();
		int quantidadeVogais = numTotalVogais(fraseInserida.toLowerCase());
		System.out.println(quantidadeVogais);

		System.out.println("----------------------------------------------------");

		System.out.println("Insira uma frase para imprimir a quantidade de cada vogal na mesma: ");
		String fraseInserida2 = consola.next();
		System.out.print("Frase: " + fraseInserida2);
		numVogais(fraseInserida2.toLowerCase());

		System.out.println("----------------------------------------------------");

		System.out.println(
				"Insira os segundos para imprimir o número de minutos, horas, dias e meses (considere que um mês tem 30 dias)");
		int segundos = consola.nextInt();
		convertSeconds(segundos);

		System.out.println("----------------------------------------------------");

		consola.close();

	}

	public static double areaTriang(double aAlturaTriang, double aBaseTriang) {
		return (aAlturaTriang * aBaseTriang) / 2;

	}

	public static double areaRetang(double aAlturaRetang, double aComprimentoRetang) {
		return aAlturaRetang * aComprimentoRetang;

	}

	public static double areaCal(double aX, double aY, double aZ) {

		if (aZ == 1) {
			return areaTriang(aX, aY);

		} else {
			return areaRetang(aX, aY);
		}

	}

	public static int factor(int aFat) {
		int resultado = 1;
		for (int i = 1; i <= aFat; i++) {
			resultado = resultado * i;
		}
		return resultado;
	}

	public static double factorRecursivo(int aFatRecursivo) {

		if (aFatRecursivo == 0) {

			return 1;
		}
		return (aFatRecursivo * factorRecursivo(aFatRecursivo - 1));

	}

	public static int numTotalVogais(String aFrase) {
		int numeroVogais = 0;
		for (int aux = 0; aux < aFrase.length(); aux++) {
			if (aFrase.charAt(aux) == 'a' || aFrase.charAt(aux) == 'e' || aFrase.charAt(aux) == 'i'
					|| aFrase.charAt(aux) == 'o' || aFrase.charAt(aux) == 'u') {

				numeroVogais++;
			}

		}
		return numeroVogais;

	}

	public static void numVogais(String aFrase) {

		int a = 0, e = 0, i = 0, o = 0, u = 0;
		for (int aux = 0; aux < aFrase.length(); aux++) {

			if (aFrase.charAt(aux) == 'a') {
				a++;

			} else if (aFrase.charAt(aux) == 'e') {
				e++;

			} else if (aFrase.charAt(aux) == 'i') {
				i++;

			} else if (aFrase.charAt(aux) == 'o') {
				o++;

			} else if (aFrase.charAt(aux) == 'u') {
				u++;

			}

		}
		System.out.println("\nA: " + a + "\nE: " + e + "\nI: " + i + "\nO: " + o + "\nU: " + u);
	}

	public static void convertSeconds(int aSegundos) {
		System.out.println("Insira o numero de segundos: " + aSegundos);
		
        //Dia = 60*60*24 = 86400
        int days = aSegundos / 86400;
        aSegundos = aSegundos % 86400;

        //Hour = 60*60 = 3600
        int hours = aSegundos / 3600;
        aSegundos = aSegundos % 3600;

        //Min = 60
        int minutes = aSegundos / 60;
        aSegundos = aSegundos % 60;

        //Segundos
        int sec = aSegundos;

		System.out.println("\nDay: " + days + "\nHour: " + hours + "\nMinute: " + minutes
				+ "\nSeconds: " + sec);

	}

}

package ficha1;

import java.util.Scanner;

public class ResolucaoFicha1 {

	public static void main(String[] args) {
		Scanner consola = new Scanner(System.in);
		System.out.println("----------------------------------------------------");
		System.out.println("Insira dois números para realizar as operações matemáticas");
		System.out.println("\nInsira o primeiro número");
		int numero1 = consola.nextInt();
		System.out.println("Insira o segundo número");
		int numero2 = consola.nextInt();
		int somaNumeros = soma(numero1, numero2);
		
		System.out.println("----------------------------------------------------");
		
		System.out.println("Resultado da soma:  " + somaNumeros);
		
		System.out.println("----------------------------------------------------");
		
		int subtracaoNumeros = subtracao(numero1, numero2);
		System.out.println("Resultado da subtracao: " + subtracaoNumeros);
		
		System.out.println("----------------------------------------------------");
		
		int multiplicacaoNumeros = multiplicacao(numero1, numero2);
		System.out.println("Resultado da multiplicacao:  " + multiplicacaoNumeros);
		
		System.out.println("----------------------------------------------------");

		int operacaoComplexaNumeros = operacaoComplexa(numero1, numero2);
		System.out.println("Resultado da operacaoComplexa:" + operacaoComplexaNumeros);
		
		System.out.println("----------------------------------------------------");
		consola.close();
	}

	public static int soma(int aNumero1, int aNumero2) {
		int soma = aNumero1 + aNumero2;

		return soma;

	}

	public static int subtracao(int aNumero1, int aNumero2) {
		int subtracao = aNumero1 - aNumero2;

		return subtracao;

	}

	public static int multiplicacao(int aNumero1, int aNumero2) {
		int multiplicacao = aNumero1 * aNumero2;

		return multiplicacao;

	}

	public static int operacaoComplexa(int aNumero1, int aNumero2) {
		
		return soma(aNumero1, aNumero2) * subtracao(aNumero1, aNumero2);

	}
}
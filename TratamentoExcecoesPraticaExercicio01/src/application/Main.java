package application;

/**
 * AUTOR:GABRIEL GAMELEIRA DOS SANTOS
 * DATA:22/02/2020 
 * HORA:17:46
 * FINALIDADE DO PROGRAMA:REALIZAR O TRATAMENTO DE EXCECOES COM VETORES
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		metodo1();
		

	}
	
	public static void metodo1() {
		
		System.out.println("Inicio do método 1:");
		
		metodo2();
		
		System.out.println("Fim do método 1:");
		
	}

	public static void metodo2() {

		System.out.println("Iniciou o método!");

		Scanner dados;

		dados = new Scanner(System.in);

		String vect[];

		try {

			System.out.println("Informe os nomes:");

			vect = dados.nextLine().split(" ");

			int posicao;

			System.out.println("Escolha uma posição de pesquisa");

			posicao = dados.nextInt();

			System.out.println(vect[posicao]);

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("Posição inválida!");

			e.printStackTrace();
			
		} catch (InputMismatchException e) {

			System.out.println("Inserção inválida!");

		}

		dados.close();

		System.out.println("Finalizou o método!");

	}

}
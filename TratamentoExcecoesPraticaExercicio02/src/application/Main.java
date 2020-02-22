package application;

/**
 * AUTOR:GABRIEL GAMELEIRA DOS SANTOS
 * DATA:22/02/2020 
 * HORA:17:46
 * FINALIDADE DO PROGRAMA:REALIZAR o TRATAMENTO DE EXCESSOES CASO UM ARQUIVO NAO SEJA ENCONTRADO
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		File arquivo;

		Scanner dados = null;

		try {

			arquivo = new File("C:\\Users\\gabriel.gameleira\\Desktop\\agora.txt");

			dados = new Scanner(arquivo);

			while (dados.hasNextLine()) {

				System.out.println(dados.nextLine());

			}

		} catch (FileNotFoundException e) {

			System.out.println("Erro ao abrir o arquivo: " + e.getMessage());

		}

		finally {

			if (dados != null) {

				dados.close();

			}
			
			System.out.println("Finally executado!");

		}

	}

}

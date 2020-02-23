package application;

/**
 * AUTOR:GABRIEL GAMELEIRA DOS SANTOS
 * DATA:23/02/2020
 * HORA:00:45
 * FINALIDE DO PROGRAMA: REALIZAR A RESERVA DE QUARTOS E ATUALIZAR AS RESERVAS
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * AUTOR:GABRIEL GAMELEIRA DOS SANTOS
 * DATA:22/02/2020 
 * HORA:19:52
 * FINALIDADE DO PROGRAMA:CADASTRAR UM RESERVA DE UM HOTEL E APRESENTAR OS DADOS DA RESERVA
 */

import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {

		Scanner dados;

		SimpleDateFormat sdf;

		Reserva reserva = null;

		Locale.setDefault(Locale.US);

		int numero;

		Date dataEntrada, dataSaida, agora;

		dados = new Scanner(System.in);

		sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {

			System.out.println("Informe o número do quarto:");

			numero = dados.nextInt();

			System.out.println("Informe a data de entrada no hotel:");

			dataEntrada = sdf.parse(dados.next());

			System.out.println("Informe a data de saída do hotel:");

			dataSaida = sdf.parse(dados.next());

			reserva = new Reserva(numero, dataEntrada, dataSaida);

			System.out.println("Reserva:" + reserva.toString());

			System.out.println("Atualize a reserva:");

			System.out.println("Informe o número do quarto:");

			numero = dados.nextInt();

			System.out.println("Informe a data de entrada no hotel:");

			dataEntrada = sdf.parse(dados.next());

			System.out.println("Informe a data de saída do hotel:");

			dataSaida = sdf.parse(dados.next());

			agora = new Date();

			reserva.atualizaDatas(dataEntrada, dataSaida);

			System.out.println("Reserva: " + reserva.toString());

		} catch (ParseException e) {

			System.out.println("Data inválida!");

		} catch (DomainException e) {

			System.out.println("Erro na reserva " + e.getMessage());

		} catch (RuntimeException e) {
			
			System.out.println("Erro inesperado!");
			
		}
 
	}
}

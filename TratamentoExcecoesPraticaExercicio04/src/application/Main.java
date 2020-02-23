package application;

import java.util.Scanner;

import model.entities.Conta;
import model.exception.DomainException;

/**
 * AUTOR:GABRIEL GAMELEIRA DOS SANTOS
 * DATA:22/02/2020
 * HORA:23:47
 * FINALIDADE DO PROGRAMA:CRIAR UMA CONTA BANCARIA E REALIZAR SAQUE NESTA CONTA BANCARIA
 */

public class Main {

	public static void main(String[] args) {

		Scanner dadosNumericos, dadosString;

		String nomeProprietario;

		Conta conta;

		int numeroConta;

		double investimentoConta, limiteSaque;

		dadosString = new Scanner(System.in);

		dadosNumericos = new Scanner(System.in);

		System.out.println("Informe o número da conta:");

		numeroConta = dadosNumericos.nextInt();

		System.out.println("Informe o nome do proprietário da conta:");

		nomeProprietario = dadosString.nextLine();

		System.out.println("Informe o investimento dessa conta:");

		investimentoConta = dadosNumericos.nextDouble();

		System.out.println("Informe o limite de saque dessa conta:");

		limiteSaque = dadosNumericos.nextDouble();

		conta = new Conta(numeroConta, nomeProprietario, investimentoConta, limiteSaque);

		try {

			System.out.println("Informe um valor para sacar:");

			conta.realizaSaque(dadosNumericos.nextDouble());

			System.out.println("Saldo na conta:" + conta.getSaldo());

		} catch (DomainException e) {

			System.out.println("Erro na operação!" + e.getMessage());

		} catch (RuntimeException e) {

			System.out.println("Erro inesperado. Contate o nosso time de suporte e relate o problema.");

		}

	}

}

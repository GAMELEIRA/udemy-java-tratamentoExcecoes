package model.entities;

import model.exception.DomainException;

public class Conta {

	private int numeroConta;

	private String nome;

	private double saldo;

	private double limite;

	public Conta() {
	}

	public Conta(int numeroConta, String nome, double saldo, double limite) {
		this.numeroConta = numeroConta;
		this.nome = nome;
		this.saldo = saldo;
		this.limite = limite;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public void realizaSaque(double quantidadeParaSaque) {

		if (saldo == 0) {

			throw new DomainException("Saldo zerado! N�o � poss�vel realizar saques em uma conta sem saldo!");

		} else if (saldo <= 0) {

			throw new DomainException("Saldo negativo! N�o � possivel realizar saque de uma conta com saldo negativo!");

		} else if (saldo < quantidadeParaSaque) {

			throw new DomainException("Saldo inferior! N�o � poss�vel realizar saque com quantia superior ao saldo! ");

		} else if (quantidadeParaSaque > limite) {

			throw new DomainException(
					"Saque negado pelo limite! N�o � poss�vel realizar o saque porque seu limite n�o foi respeitado!");

		}

		saldo -= quantidadeParaSaque;

	}

	public void realizaDeposito(double deposito) {

		saldo += deposito;

	}

}

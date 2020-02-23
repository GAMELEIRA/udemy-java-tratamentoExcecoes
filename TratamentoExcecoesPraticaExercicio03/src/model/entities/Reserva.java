package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {

	private int numeroQuarto;

	private Date dataEntrada;

	private Date dataSaida;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(int numeroQuarto, Date dataEntrada, Date dataSaida) {

		Date agora;

		agora = new Date();

		if (dataEntrada.before(agora) || dataSaida.before(agora)) {

			throw new DomainException(
					"Erro! As datas para atualização devem ser futuras em relação as datas da reserva.");

		} else if (!dataSaida.after(dataEntrada)) {

			throw new DomainException("Data de entrada posterior a data de saida.");

		}

		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public long duracaoDias() {

		long milSegundos = dataSaida.getTime() - dataEntrada.getTime();

		return TimeUnit.DAYS.convert(milSegundos, TimeUnit.MILLISECONDS);

	}

	public void atualizaDatas(Date entrada, Date saida) {

		Date agora;

		agora = new Date();

		if (dataEntrada.before(agora) || dataSaida.before(agora)) {

			throw new DomainException(
					"Erro! As datas para atualização devem ser futuras em relação as datas da reserva.");

		} else if (!dataSaida.after(dataEntrada)) {

			throw new DomainException("Data de entrada posterior a data de saida.");

		}

		this.dataEntrada = entrada;

		this.dataSaida = saida;

	}

	@Override
	public String toString() {
		return "Reserva [numeroQuarto=" + numeroQuarto + ", dataEntrada=" + sdf.format(dataEntrada) + ", dataSaida="
				+ sdf.format(dataSaida) + ", duracaoDias()=" + duracaoDias() + "]";
	}

}

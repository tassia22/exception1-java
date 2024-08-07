package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DominioException;

public class Reserva {
	
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numQuarto, Date checkIn, Date checkOut){
		
		 if (! checkOut.after(checkIn)) {
		   	throw new  DominioException("erro na reserva: a data do check-out vem depois da data do check-in");
		  }
		
		 this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		//converte o diff para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDatas(Date checkIn, Date checkOut){
		
		//data com o horario de agora
	    Date agora = new Date();
	    if(checkIn.before(agora) || checkOut.before(agora)) {
	    	throw new DominioException("erro na reserva: as datas de reserva para a tualizacao devem ser datas futuras ");
	    }
	    
	    if (! checkOut.after(checkIn)) {
	    	throw new  DominioException("erro na reserva: a data do check-out vem depois da data do check-in");
	    }
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	
	@Override
	public String toString() {
		return "Quarto "
			+ numQuarto
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "+ duracao()
			+ " noites";
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
}

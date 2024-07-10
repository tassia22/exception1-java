package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reserva;

public class programa {
	
	public static void main(String [] args) throws ParseException {
		
		Scanner scan = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("numero do quarto: ");
		int num = scan.nextInt();
		System.out.print("check-in data (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(scan.next());
		System.out.print("check-out data (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(scan.next());
		
		
		if(! checkOut.after(checkIn)) {
			System.out.println("erro na reserva: a data do check-out vem depois da data do check-in");
		}else {
			Reserva reserva = new Reserva(num, checkIn, checkOut);
			System.out.println("reserva: " + reserva);
			
			System.out.println();
			System.out.println("entre com os dados para atualizar a reserva: ");
			System.out.print("check-in data (dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("check-out data (dd/MM/yyyy): ");
		    checkOut = sdf.parse(scan.next());
		    
		    //data com o horario de agora
		    Date agora = new Date();
		    if(checkIn.before(agora) || checkOut.before(agora)) {
		    	System.out.println("erro na reserva: as datas de reserva para a tualizacao devem ser datas futuras ");
		    }else if (! checkOut.after(checkIn)) {
		    	System.out.println("erro na reserva: a data do check-out vem depois da data do check-in");
		    }else {
		    	 reserva.updateDatas(checkIn, checkOut);
		    	 System.out.println("reserva: " + reserva);
		    }
		    
		   
		}
		
		scan.close();
	}
}

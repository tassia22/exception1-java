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
		    
		   
			 String erro = reserva.updateDatas(checkIn, checkOut);
			 if(erro != null) {
				 System.out.println("erro na reserva: " + erro);
			 }else {
				 System.out.println("reserva: " + reserva);
			 }
		   
		}
		
		scan.close();
	}
}

package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reserva;
import model.exception.DominioException;

public class programa {
	
	public static void main(String [] args) {
		
		Scanner scan = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("numero do quarto: ");
			int num = scan.nextInt();
			System.out.print("check-in data (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scan.next());
			System.out.print("check-out data (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scan.next());
			
			
			Reserva reserva = new Reserva(num, checkIn, checkOut);
			System.out.println("reserva: " + reserva);
			
			System.out.println();
			System.out.println("entre com os dados para atualizar a reserva: ");
			System.out.print("check-in data (dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("check-out data (dd/MM/yyyy): ");
		    checkOut = sdf.parse(scan.next());
		    
		   
			reserva.updateDatas(checkIn, checkOut);
			System.out.println("reserva: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("formato da data invalida");
			
		}
		catch(DominioException e) {
			System.out.println("erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("erro inesperado");
		}
		
		scan.close();
	}
}

import java.util.Scanner;

public class Main {
	static final String[] MONTHS = {"Enero 31", "Febrero 28", "Marzo 31",
			"Abril 30", "Mayo 31", "Junio 30", "Julio 31",
			"Agosto 31", "Septiembre 30", "Octubre 31",
			"Noviembre 30", "Diciembre 31"};
	static final int END = -25;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println(ej7(in) ? "OK" : "Not OK");
		ej8(in);
		ej9(in);
		ej10(in);
	}
	
	/*
	 * Crea un programa que lea por teclado tres números enteros H, M, S 
	 * correspondientes a hora, minutos y segundos respectivamente, 
	 * y comprueba si la hora que indican es una hora válida.
	 */
	public static boolean ej7(Scanner in) {
		int[] time = new int[3];
		
		for (int i = 0; i < 3; ++i) time[i] = in.nextInt();
		
		return  (0 <= time[0] && time[0] < 24 // horas
				&& 0 <= time[1] && time[1] < 60 // minutos
				&& 0 <= time[2] && time[2] < 60); // segundos
	}
	
	/*
	 * Programa que lea por teclado un número correspondiente a un mes 
	 * e indique si es un mes de 28, 30 o 31 días y qué mes es en un String
	 */
	public static String ej8(Scanner in) {
		
		
		int number = in.nextInt();
		
		if (0 < number && number <= 12) {
			System.out.println(MONTHS[number-1]);
			return MONTHS[number-1];
		}
		else {
			System.out.println("Mes no existe");
			return null;
		}
	}
	
	/*
	 * Escribir un proprama que pida al usuario que introduzca 
	 * por teclado números enteros. La lectura de números por teclado 
	 * finaliza cuando se introduce un -25. El programa mostrará cuántos 
	 * números negativos y ceros se han introducido.
	*/
	public static void ej9(Scanner in) {
		int negative = 0, zero = 0, tmp;
		
		// El -25 no lo computo como número negativo
		while ((tmp = in.nextInt()) != END) {
			if (tmp == 0) ++zero;
			else if (tmp < 0) ++negative;
		}
		System.out.println("Ceros: "  + zero);
		System.out.println("Negativos (sin incluir " + END + "): " + negative);
	}
	
	/*
	 * Programa para invertir el orden de las cifras de un número. 
	 * Se introduce un número entero positivo por teclado y el programa 
	 * modifica el número invirtiendo el orden de sus cifras
	*/
	public static void ej10(Scanner in) {
		// 0 no es positivo
		int number = in.nextInt();
		
		while (number != 0){
			System.out.print(number % 10);
			number /= 10;
		}
	}
	


}

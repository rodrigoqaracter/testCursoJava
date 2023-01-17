package day2;

import java.util.Scanner;

public class Ej4 {
	private int d1, d2;
	
	public Ej4() {
		d1 = 4;
		d2 = 10;
	}
	
	public void setDs(int d1, int d2) throws Exception {
		if ((d1 & 1) != (d2 & 1)) throw new Exception("Ambos números deben ser pares o impares!");
		else if (d1 <= 0 || d2 < 0 || d1 > d2) throw new Exception("Ambos numeros tienen que ser positivos y el segundo mayor o igual que el primero");
		this.d1 = d1;
		this.d2 = d2;
	}
	
	@Override
	public String toString() {
		String s = "";
		int aux = d1;
		boolean decreasing = false;
		
		while (aux != d1 -2 || !decreasing) {
			for (int j = (d2 - aux) >> 1; j > 0; --j) {
				s += " ";
			}
			for (int j = 0; j < aux; ++j) {
				s += "+";
			}
			s += "\n";
			
			decreasing |= aux == d2;
			aux += (decreasing? -2: 2);
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ej4 a = new Ej4();
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Por favor introduzca dos numeros(ambos deben ser pares o impares): ");
			a.setDs(in.nextInt(), in.nextInt());
			System.out.println(a);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally{
			in.close();
		}
	}

}

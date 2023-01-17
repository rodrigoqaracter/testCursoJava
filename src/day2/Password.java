package day2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Desarrolla una clase llamada Password que siga las siguientes condiciones:

Que tenga los atributos longitud y contraseña . Por defecto, la longitud sera de 8.

Los constructores serán los siguiente:

Un constructor por defecto.
Un constructor sobrecargado con la longitud que nosotros le pasemos. Generara una contraseña aleatoria con esa longitud.
Un constructor de copia, ya que vamos a tener que hacer copias de seguridad en un array.
Los métodos que implementa serán:

esFuerte(): devuelve un booleano si es fuerte o no, para que sea fuerte debe tener mas de 2 mayúsculas, mas de 1 minúscula y mas de 5 números.
generarPassword(): genera la contraseña del objeto con la longitud que tenga de manera aleatoria.
Método get para contraseña y longitud.
Método set para longitud.
Ahora, crea una clase clase ejecutable:

Crea un array de Passwords con el tamaño que tu le indiques por teclado.

Crea un bucle que cree un objeto para cada posición del array.

Indica también por teclado la longitud de los Passwords (antes de bucle).

Crea un segundo array con objetos copia del array anterior.

Ordena alfabéticamente el array de copias.

Muestra el array de copias.

Crea otro array de booleanos donde se almacene si el password del array de Password es o no fuerte (se trata de las contraseñas del array original, no de las copias).

Al final, muestra la contraseña y si es o no fuerte (usa el bucle anterior).
 */
public class Password implements Comparable<Password>{
	private static final int MAYUSCULAS = 2, MINUSCULAS = 1, NUMEROS = 5; 
	private static final char[] VALIDSYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789".toCharArray();
	private int longitud;
	private char[] contrasena;

	public Password() {
		try {
			setLongitud(8);
		} catch (Exception e) {	}
		contrasena = null;
	}
	public Password(int lon) throws Exception {
		setLongitud(lon);
		generarPassword();
	}
	public Password(Password p) {
		this.longitud = p.longitud;
		this.contrasena = p.contrasena.clone();
	}
	
	public boolean esFuerte() {
		int mayuscula = 0, minuscula = 0, numeros = 0;
		for (char c: contrasena) {
			if ('A' <= c && c <= 'Z') ++mayuscula;
			else if ('a' <= c && c <= 'z') ++minuscula;
			else if ('0' <= c && c <= '9') ++numeros;
		}
		return mayuscula > MAYUSCULAS && minuscula > MINUSCULAS && numeros > NUMEROS;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Password other = (Password) obj;
		return this.contrasena == other.contrasena;
	}
	
	@Override
	public String toString() {
		return getContrasena();
	}

	@Override
	public int compareTo(Password obj) {
		if(this.equals(obj)) {
			return 0;
		}
		return this.getContrasena().compareTo(obj.getContrasena());
		
	}

	public String getContrasena() {
		return new String(this.contrasena);
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) throws Exception {
		if (longitud < 0) throw new Exception("Longitud negativa invalida!");
		this.longitud = longitud;
		contrasena = null;
	}
	
	public void generarPassword() {
		Random rand = new Random();

		contrasena = new char[longitud];
		for (int i= 0; i < contrasena.length; ++i) contrasena[i] = VALIDSYMBOLS[rand.nextInt(VALIDSYMBOLS.length-1)]; 
	}
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		Password []passwords = null, copy;
		int length;
		// Crea un array de Passwords con el tamaño que tu le indiques por teclado.
		do {
			System.out.print("Por favor introduzca una longitud no negativa: ");
			length = in.nextInt();
		} while (length < 0);
		passwords = new Password[length];
		
		//Crea un bucle que cree un objeto para cada posición del array.
		//Indica también por teclado la longitud de los Passwords (antes de bucle).
		do {
			System.out.print("Por favor introduzca una longitud no negativa para las contrasenas: ");
			length = in.nextInt();
		} while (length < 0);
		for (int i = 0; i < passwords.length; ++i) 
			passwords[i] = new Password(length);
		
		passwords[0].compareTo(passwords[1]);
		//Crea un segundo array con objetos copia del array anterior.
		copy = passwords.clone();
		// Ordena alfabéticamente el array de copias.
		Arrays.sort(copy);
		
		//Muestra el array de copias.
		for (Password p: copy) System.out.print(p + " ");
		System.out.println();
		
		//Crea otro array de booleanos donde se almacene si el password del array de Password es o no fuerte (se trata de las contraseñas del array original, no de las copias).
		//Al final, muestra la contraseña y si es o no fuerte (usa el bucle anterior).
		boolean[] fuerte = new boolean[passwords.length];
		for (int i = 0; i < passwords.length; ++i) {
			fuerte[i] = passwords[i].esFuerte();
			System.out.println(passwords[i] + (fuerte[i] ? " es fuerte": " no es fuerte"));
		}
	}
}

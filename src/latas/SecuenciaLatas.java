package latas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SecuenciaLatas {

	/**
	 * Cantidad de latas. <br>
	 */
	private int cantidad;
	/**
	 * Secuencia de latas. <br>
	 */
	private char[] secuencia;
	/**
	 * La máxima cantidad de latas de Garbanzos consecutivas. <br>
	 */
	private int maximaPrimera = 0;
	/**
	 * La segunda máxima cantidad de latas de Garbanzos consecutivas. <br>
	 */
	private int maximaSegunda;
	/**
	 * Distancia entre la primera secuencia y la segunda secuencia. <br>
	 */
	private int distancia;

	/**
	 * Carga una secuencia de latas de una cinta. <br>
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 */
	public SecuenciaLatas(final String path) {
		try {
			this.leerArchivo(path);
		} catch (IOException e) {
			System.out.println("Error abrir archivo.");
			e.printStackTrace();
		}
	}

	/**
	 * Lee el archivo con la secuencia de latas. <br>
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 * @throws IOException
	 *             Error al abrir el archivo. <br>
	 */
	public void leerArchivo(final String path) throws IOException {
		try {
			Scanner sc = new Scanner(new File(path));
			String linea = sc.nextLine();
			this.cantidad = (linea.length() / 2);
			if (this.cantidad > 5000) {
				this.limiteSuperado();
			}
			this.secuencia = new char[this.cantidad + 1];
			int i = 0;
			int posicion = 0;
			while (i < linea.length() - 2) {
				if (linea.charAt(i) != ' ') {
					this.secuencia[posicion] = linea.charAt(i);
					posicion++;
				}
				i++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Indica que supera el límite aceptado. <br>
	 */
	private void limiteSuperado() {
		throw new ArithmeticException("Cantidad superada");
	}

	/**
	 * Calcula la secuencia más larga de latas de garbanzos y la segunda más
	 * larga, y la distancia entre ambas secuencias. <br>
	 */
	public void resolver() {
		int primeraPosicion = 0;
		int ultimaPosicion = 0;
		int cantidad = 0;
		int i = 0;
		int[][] matrizPosicion = new int[2][2];
		while (i < this.cantidad) {
			primeraPosicion = i;
			while (this.secuencia[i] == 'G' && this.secuencia[i + 1] == 'G') {
				cantidad++;
				i++;
			}
			ultimaPosicion = cantidad + primeraPosicion;
			if (primeraPosicion != ultimaPosicion) {
				if (cantidad > this.maximaPrimera) {
					this.maximaSegunda = this.maximaPrimera;
					matrizPosicion[1][0] = matrizPosicion[0][0];
					matrizPosicion[1][1] = matrizPosicion[0][1];
					this.maximaPrimera = cantidad + 1;
					matrizPosicion[0][0] = primeraPosicion;
					matrizPosicion[0][1] = ultimaPosicion;
				} else {
					if (cantidad > this.maximaSegunda) {
						this.maximaSegunda = cantidad + 1;
						matrizPosicion[1][0] = primeraPosicion;
						matrizPosicion[1][1] = ultimaPosicion;
					}
				}
			}
			i++;
			cantidad = 0;
		}
		if (matrizPosicion[0][1] < matrizPosicion[1][0]) {
			this.distancia = matrizPosicion[1][0] - matrizPosicion[0][1] - 1;
		} else {
			this.distancia = matrizPosicion[0][0] - matrizPosicion[1][1] - 1;
		}
	}

	public void mostrarResultado() {
		System.out.println("Cantidad de latas: " + this.cantidad + "\nMáxima secuencia: " + this.maximaPrimera
				+ "\nSegunda máxima secuencia: " + this.maximaSegunda + "\nDistancia: " + this.distancia);
	}

	/**
	 * Devuelve la cantidad de latas. <br>
	 * 
	 * @return Cantidad de latas. <br>
	 */
	public int getCantidad() {
		return this.cantidad;
	}

	/**
	 * Devuelve la cantidad de la segunda secuencia más larga. <br>
	 * 
	 * @return Cantidad de segunda secuencia. <br>
	 */
	public int getSegundoMaximo() {
		return this.maximaSegunda;
	}

	/**
	 * Devuelve la cantidad de la primera secuencia más larga. <br>
	 * 
	 * @return Cantidad de primera secuencia. <br>
	 */
	public int getPrimerMaximo() {
		return this.maximaPrimera;
	}

	/**
	 * Devuelve la distancia entre las secuencias. <br>
	 * 
	 * @return Distancia. <br>
	 */
	public int getDistancia() {
		return this.distancia;
	}

	/**
	 * Graba el archivo con los resultados. <br>
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 */
	public void grabarArchivo(final String path) {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(path));
			salida.println(this.cantidad);
			salida.println(this.maximaPrimera);
			salida.println(this.maximaSegunda);
			salida.println(this.distancia);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void generarFatiga(final String path) {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(path));
			int i = 0;
			int cantidad = 1;
			int actual = 0;
			while (i < 5000){
				while(actual < cantidad && i < 4998){
					salida.print("G ");
					actual++;
					i++;
				}
				salida.print("A ");
				cantidad++;
				actual = 0;
				i++;
			}
			salida.print("F");
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
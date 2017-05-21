package latas;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSecuenciaLatas {
	private static String archivoIn = "Preparacion de Prueba/Entrada/";
	private static String archivoOut = "Preparacion de Prueba/Salida/";

	@Test
	public void testBasico() {
		SecuenciaLatas secuencia = new SecuenciaLatas(archivoIn + "00_Caso_Basico.in");
		secuencia.resolver();
		secuencia.grabarArchivo(archivoOut + "00_Caso_Basico.out");
		assertEquals(10, secuencia.getCantidad());
		assertEquals(3, secuencia.getPrimerMaximo());
		assertEquals(2, secuencia.getSegundoMaximo());
		assertEquals(3, secuencia.getDistancia());
	}

	@Test
	public void testEnunciado() {
		SecuenciaLatas secuencia = new SecuenciaLatas(archivoIn + "01_Caso_Prueba.in");
		secuencia.resolver();
		secuencia.grabarArchivo(archivoOut + "01_Caso_Prueba.out");
		assertEquals(45, secuencia.getCantidad());
		assertEquals(9, secuencia.getPrimerMaximo());
		assertEquals(6, secuencia.getSegundoMaximo());
		assertEquals(10, secuencia.getDistancia());
	}

	@Test
	public void testFatiga() {
		SecuenciaLatas secuencia = new SecuenciaLatas(archivoIn + "02_Caso_Fatiga.in");
		secuencia.resolver();
		secuencia.grabarArchivo(archivoOut + "02_Caso_Fatiga.in");
	}
}

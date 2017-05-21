package latas;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestSecuenciaLatas {
	private static String archivoIn = "Preparacion de Prueba/Entrada/";

	@Ignore
	public void testBasico() {
		SecuenciaLatas secuencia = new SecuenciaLatas(archivoIn + "00_Caso_Basico.in");
		secuencia.resolver();
		assertEquals(10, secuencia.getCantidad());
		assertEquals(3, secuencia.getPrimerMaximo());
		assertEquals(2, secuencia.getSegundoMaximo());
		assertEquals(3, secuencia.getDistancia());
	}

	@Test
	public void testEnunciado() {
		SecuenciaLatas secuencia = new SecuenciaLatas(archivoIn + "01_Caso_Prueba.in");
		secuencia.resolver(); 
		assertEquals(45, secuencia.getCantidad());
		assertEquals(9, secuencia.getPrimerMaximo());
		assertEquals(6, secuencia.getSegundoMaximo());
		assertEquals(10, secuencia.getDistancia());
	}
}

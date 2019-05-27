package antrob.santacasatest;

import antrob.santacasa.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApostaEuromilhoesTest {

	
	
	/* TESTE para o CONSTRUCTOR ApostaEuromilhoes() sem parâmetros
	   Gerar REPETIDAMENTE uma série de Apostas Aleatórias
	    e depois pegar nos numeros e estrelas e criar apostas usando o construtor com 2 argumentos
	    e confiar na validação da aposta realizada pelo segundo construtor! 
	*/
	@RepeatedTest(100)
	void testApostaEuromilhoes() {
		
		try 
		{
			ApostaEuromilhoes apostaAleatoria = new ApostaEuromilhoes();
			ApostaEuromilhoes aposta = new ApostaEuromilhoes(apostaAleatoria.getNumeros(), apostaAleatoria.getEstrelas() );
			// Se não houver uma Excepção, assumimos que está tudo bem
			
		}
		catch( Exception e)
		{
			fail("Excepção inesperada " + e.getLocalizedMessage());
		}
		
	}

	
	// TESTES para o CONSTRUCTOR ApostaEuromilhoes(int[] numeros, int[] estrelas)
	
	@Test
	void testApostaEuromilhoes_5Numeros_NoIntervalo() {
		int[] numeros = { 1, 4, 12, 48, 50 };
		int[] estrelas = { 5, 6 };
		
		try 
		{
			ApostaEuromilhoes aposta = new ApostaEuromilhoes(numeros, estrelas );
			Assertions.assertArrayEquals(numeros, aposta.getNumeros());
		}
		catch( Exception e)
		{
			fail("Excepção inesperada " + e.getLocalizedMessage());
		}
		
	}
	
	@Test
	void testApostaEuromilhoes_2Estrelas_NoIntervalo() {
		int[] numeros = { 3, 4, 12, 33, 44 };
		int[] estrelas = { 1, 12 };
		
		try 
		{
			ApostaEuromilhoes aposta = new ApostaEuromilhoes(numeros, estrelas );
			Assertions.assertArrayEquals(estrelas, aposta.getEstrelas());
		}
		catch( Exception e)
		{
			fail("Excepção inesperada " + e.getLocalizedMessage());
		}
		
	}
	
	@Test
	void testApostaEuromilhoes_5Numeros_ForaIntervalo() {
		int[] numeros = { 0, 4, 12, 33, 44 };
		int[] estrelas = { 1, 12 };
		
		try 
		{
			ApostaEuromilhoes aposta = new ApostaEuromilhoes(numeros, estrelas );
			fail("Devia ter sido disparada uma IllegalArgumentException");
		}
		catch( IllegalArgumentException e )
		{
			Assertions.assertEquals("Numeros têm de estar entre 1 e 50", e.getLocalizedMessage());
		}
		catch( Exception e)
		{
			fail("Devia ter sido disparada uma Excepção IllegalArgumentException,  " );
		}
		
	}
	
	@Test
	void testApostaEuromilhoes_2Estrelas_ForaIntervalo() {
		int[] numeros = { 3, 4, 12, 33, 44 };
		int[] estrelas = { 0, 12 };
		
		try 
		{
			ApostaEuromilhoes aposta = new ApostaEuromilhoes(numeros, estrelas );
			fail("Devia ter sido disparada uma IllegalArgumentException");
		}
		catch( IllegalArgumentException e )
		{
			Assertions.assertEquals("Estrelas têm de estar entre 1 e 12", e.getLocalizedMessage());
		}
		catch( Exception e)
		{
			fail("Devia ter sido disparada uma Excepção IllegalArgumentException,  " );
		}
		
	}
	
	
	

	@Test
	void testGetNumeros() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEstrelas() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAcertos() {
		
		int[] numeros = { 3, 4, 12, 33, 44 };
		int[] estrelas = { 4, 9 };
		
		ApostaEuromilhoes aposta = new ApostaEuromilhoes(numeros, estrelas );
		ApostaEuromilhoes chave = new ApostaEuromilhoes(new int[] { 2, 4, 8, 14, 44}, new int[] {3, 9} );
		
		Acertos certos = new Acertos(2,1);
		Acertos resultado = aposta.getAcertos(chave);
		Assertions.assertEquals(certos, resultado);
		
	}

	
	@ParameterizedTest
	@MethodSource("numerosEstrelasProvider")
	void testGetAcertos_Parametrizado( int[]numeros, int[]estrelas, Acertos certosEsperado) {
		
		ApostaEuromilhoes aposta = new ApostaEuromilhoes(numeros, estrelas );
		ApostaEuromilhoes chave = new ApostaEuromilhoes(new int[] { 2, 4, 8, 14, 44}, new int[] {3, 9} );
		
		Acertos resultado = aposta.getAcertos(chave);
		Assertions.assertEquals(certosEsperado, resultado);
		
	}
	
	
	static Stream<Arguments> numerosEstrelasProvider() {
	    return Stream.of(
	        Arguments.of( new int[] { 3, 4, 12, 33, 44 },	new int[] { 4, 9 }, new Acertos(2,1)),
	        Arguments.of( new int[] { 4, 12, 33, 44, 49 },	new int[] { 3, 7 }, new Acertos(2,1)),
	        Arguments.of( new int[] { 1, 2, 12, 20, 30 },	new int[] { 4, 5 }, new Acertos(1,0)),
	        Arguments.of( new int[] { 1, 3, 12, 20, 30 },	new int[] { 5, 8 }, new Acertos(0,0)),
	        Arguments.of( new int[] { 1, 3, 8, 14, 30 },	new int[] { 9, 11 }, new Acertos(2,1))
	    );
	}
	
	
	
	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}

package antrob.santacasa;

/*
  POJO classe,  Plain Old Java Object or POJO 
  https://www.techiedelight.com/return-multiple-values-method-java/
 */
/**
 * A classe <code>Acertos</code> serve para representar a quantidade de n�meros e estrelas certas de uma Aposta do Euromilh�es. 
 * Serve para representar Plain Old Java Objects <a href="https://www.techiedelight.com/return-multiple-values-method-java/">POJO</a> que encapsulam valores a ser retornados por uma fun��o 
 * � constitu�da s�mente por um construtor e por campos p�blicos que n�o podem ser modificados fora do construtor 
 * 
 * @author antrob
 *
 */
public class Acertos {
	
	// Com a Keyword final tornamos constantes os seus valores ap�s a sua inicializa��o no construtor
	/**
	 * Quantidade de n�meros acertados
	 */
	public final int numeros;
	/**
	 * N�mero de estrelas acertadas
	 */
	public final int estrelas;
	
	/**
	 * Constr�i um objecto da classe <code>Acertos</code>
	 * 
	 * @param numeros N�mero inteiro que significa o n�mero de n�meros acertados
	 * @param estrelas N�mero inteiro que significa o n�mero de estrelas acertadas
	 */
	public Acertos(int numeros, int estrelas) {
		this.numeros = numeros;
		this.estrelas = estrelas;
	}
	
	// Overriding equals() para comparar dois objectos Acertos  
	@Override 
	public boolean equals(Object o) { 
		
		 // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        // Check if o is an instance of Acertos or not   
        if (!(o instanceof Acertos)) { 
            return false; 
        } 
          
        // typecast o to Acertos so that we can compare data members  
        Acertos a = (Acertos) o; 
          
        // Compare the data members and return accordingly  
		
		return (numeros == a.numeros) && (estrelas == a.estrelas );
	}
	
}

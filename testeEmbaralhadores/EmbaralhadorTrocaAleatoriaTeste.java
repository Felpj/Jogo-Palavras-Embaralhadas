package testeEmbaralhadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.EmbaralhadorTrocaAleatoria;

public class EmbaralhadorTrocaAleatoriaTeste {
	

	@Test
    public void deveEmbaralharPalavraSimples() {
        String palavraOriginal = "mesa";
        String palavraEmbaralhada = new EmbaralhadorTrocaAleatoria().embaralhar(palavraOriginal);

        
        assertEquals(palavraOriginal.length(), palavraEmbaralhada.length());

        
        assertTrue(palavraOriginal.chars().allMatch(c -> palavraEmbaralhada.contains(Character.toString(c))));

       
        assertNotEquals(palavraOriginal, palavraEmbaralhada);
    }

    @Test
    public void deveEmbaralharPalavraComCaracteresRepetidos() {
        String palavraOriginal = "arara";
        String palavraEmbaralhada = new EmbaralhadorTrocaAleatoria().embaralhar(palavraOriginal);

        
        assertEquals(palavraOriginal.length(), palavraEmbaralhada.length());

        
        assertTrue(palavraOriginal.chars().allMatch(c -> palavraEmbaralhada.contains(Character.toString(c))));

        
        assertNotEquals(palavraOriginal, palavraEmbaralhada);
    }

    @Test
    public void deveEmbaralharPalavraVazia() {
        String palavraOriginal = "";
        String palavraEmbaralhada = new EmbaralhadorTrocaAleatoria().embaralhar(palavraOriginal);

        
        assertEquals("", palavraEmbaralhada);
    }

    @Test
    public void deveLançarNullPointerExceptionComPalavraNull() {
        assertThrows(NullPointerException.class, () -> new EmbaralhadorTrocaAleatoria().embaralhar(null));
    }
}

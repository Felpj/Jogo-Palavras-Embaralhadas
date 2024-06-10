package testeEmbaralhadores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Embaralhador;
import model.EmbaralhadorSimples;

public class EmbaralhadorSimplesTest {

    @Test
    public void deveEmbaralharPalavraSimples() {
        String palavra = "mesa";
        Embaralhador embaralhador = new EmbaralhadorSimples();
        String palavraEmbaralhada = embaralhador.embaralhar(palavra);

        
        assertEquals(palavra.length(), palavraEmbaralhada.length());

        
        assertTrue(palavra.chars().allMatch(c -> palavraEmbaralhada.contains(Character.toString(c))));

        assertNotEquals(palavra, palavraEmbaralhada);
    }

    

    @Test
    public void deveEmbaralharPalavraVazia() {
        String palavra = "";
        Embaralhador embaralhador = new EmbaralhadorSimples();
        String palavraEmbaralhada = embaralhador.embaralhar(palavra);

       
        assertEquals("", palavraEmbaralhada);
    }

    @Test
    public void deveEmbaralharPalavraNull() {
        Embaralhador embaralhador = new EmbaralhadorSimples();

        
        assertThrows(NullPointerException.class, () -> embaralhador.embaralhar(null));
    }
}
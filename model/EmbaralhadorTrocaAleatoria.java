package model;

import java.util.Random;

public class EmbaralhadorTrocaAleatoria implements Embaralhador {
	
	private char[] letras;

	public EmbaralhadorTrocaAleatoria()  {
	}

	@Override
    public String embaralhar(String palavra) {
        letras = palavra.toCharArray();
        Random random = new Random();

        for (int i = letras.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = letras[i];
            letras[i] = letras[j];
            letras[j] = temp;
        }

        return new String(letras);
    }

}

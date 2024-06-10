package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmbaralhadorSimples implements Embaralhador {
	
	private List<Character> letras;

	public EmbaralhadorSimples()  {
	} 

	@Override
    public String embaralhar(String palavra) {
        letras = new ArrayList<>();
        for (char letra : palavra.toCharArray()) {
            letras.add(letra);
        }

        Collections.shuffle(letras);

        StringBuilder palavraEmbaralhada = new StringBuilder();
        for (char letra : letras) {
            palavraEmbaralhada.append(letra);
        }

        return palavraEmbaralhada.toString();
    }

}

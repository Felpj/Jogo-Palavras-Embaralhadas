package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BancoDePalavras {
	
	private List<String> palavras;
	private Random random;
	private String caminhoArquivo = "C:\\Projetos\\PalavrasEmbaralhadas\\palavras\\in.txt.txt";
		
	public BancoDePalavras() throws IOException  {
        palavras = new ArrayList<>();
        random = new Random(); 
        lerPalavrasDoArquivo();
	}
	
	private void lerPalavrasDoArquivo() throws IOException {
        try (BufferedReader leitor = new BufferedReader(new FileReader(this.caminhoArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                palavras.add(linha);
            }
        }
    }

    public String getPalavraAleatoria() {
        if (palavras.isEmpty()) {
            throw new IllegalStateException("Lista de palavras vazia");
        }

        int indiceAleatorio = random.nextInt(palavras.size());
        return palavras.get(indiceAleatorio);
    }
    
  
}
	
	






	


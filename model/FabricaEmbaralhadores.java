package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FabricaEmbaralhadores {

    private List<Embaralhador> embaralhadoresDisponiveis;
    private String palavraAleatoria;
    private String palavraSecreta;
    private String palavraEmbaralhada;
    private BancoDePalavras b3;

    public FabricaEmbaralhadores() throws IOException {
        b3 = new BancoDePalavras();
    	embaralhadoresDisponiveis = new ArrayList<>();

        adicionarEmbaralhador(new EmbaralhadorSimples());
        adicionarEmbaralhador(new EmbaralhadorTrocaAleatoria());

        obterEmbaralhadorAleatorio();
    }

    private void adicionarEmbaralhador(Embaralhador embaralhador) {
        embaralhadoresDisponiveis.add(embaralhador);
    }

    protected void obterEmbaralhadorAleatorio() throws IOException {
        if (embaralhadoresDisponiveis.isEmpty()) {
            throw new IOException("Não há embaralhadores disponíveis!");
        }

        Random random = new Random();
        int indiceAleatorio = random.nextInt(embaralhadoresDisponiveis.size());
        Embaralhador embaralhadorSelecionado = embaralhadoresDisponiveis.get(indiceAleatorio);

        palavraAleatoria = b3.getPalavraAleatoria();
        palavraSecreta = palavraAleatoria;
        palavraEmbaralhada = embaralhadorSelecionado.embaralhar(palavraAleatoria);
    }

    public String getPalavraEmbaralhada() {
        return palavraEmbaralhada;
    }

    public String getPalavraSecreta() {
        return palavraSecreta;
    }
}
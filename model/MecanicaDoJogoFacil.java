package model;

import java.io.IOException;
import java.util.Scanner;

public class MecanicaDoJogoFacil implements MecanicaDoJogo {

Scanner scanner = new Scanner(System.in);
	
	private String palavraSecreta; 
    private String palavraEmbaralhada; 
    private FabricaEmbaralhadores fe;  
    private int tentativasRestantes; 
    private int pontuacao; 

    
    public MecanicaDoJogoFacil() throws IOException  {
        this.tentativasRestantes = 5; 
        this.pontuacao = 50;
        fe = new FabricaEmbaralhadores();
        palavraSecreta = fe.getPalavraSecreta();
        palavraEmbaralhada = fe.getPalavraEmbaralhada();
        iniciarJogo();
        verificarPalpite();
        finalizarJogo();
    }

    @Override
    public void iniciarJogo() {
    	
    	System.out.println("");
        System.out.println("Bem-vindo ao jogo de adivinhar palavras!");
        System.out.println("");
        System.out.println("Este é o modo simples, sua pontuacao começa com 50 e diminui 10 pontos a cada erro.");
        System.out.println("Você terá " + tentativasRestantes + " tentativas para adivinhar a palavra secreta.");
        System.out.println("");
        System.out.println("A palavra embaralhada é: " + palavraEmbaralhada);
    }

    @Override
    public void verificarPalpite() {

    	System.out.println("Digite seu palpite para a palavra secreta:");
    	String palpiteAtual = scanner.next();

    	while (tentativasRestantes > 1 && !palpiteAtual.equals(palavraSecreta)) {
    	    if (palpiteAtual.length() != palavraSecreta.length()) {
    	        System.out.printf("Palpite errado! tente novamente (%d tentativas restantes): ", tentativasRestantes - 1);
    	    } 
    	    tentativasRestantes--;
    	    palpiteAtual = scanner.next();
    	    pontuacao -= 10;
    	}

    	if (palpiteAtual.equals(palavraSecreta)) {
    	    System.out.println("Parabéns! Você acertou a palavra secreta!");
    	} else {
    	    System.out.println("Infelizmente, você não conseguiu acertar a palavra secreta. A palavra secreta era: " + palavraSecreta);
    	    finalizarJogo();
    	}  
    }

    @Override
    public void finalizarJogo() {
        System.out.println("Jogo finalizado!");
        System.out.println("Sua pontuação final: " + pontuacao);
    }

    @Override
    public int obterPontuacaoFinal() {
        return pontuacao;
    }

	@Override
	public MecanicaDoJogo get() {
		// TODO Auto-generated method stub
		return null;
	}

}

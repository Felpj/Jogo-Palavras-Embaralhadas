package model;

import java.io.IOException;
import java.util.Scanner;

public class MecanicaDoJogoComplexa implements MecanicaDoJogo {
	
	Scanner scanner = new Scanner(System.in);

    public String palavraSecreta;
    public String palavraEmbaralhada;
    private FabricaEmbaralhadores fe;
    private int acertosConsecutivos;
    private int tentativasRestantes;
    private int pontuacao;
    private int rodadasJogadas;
    private int palavrasAcertadas;

    public MecanicaDoJogoComplexa() throws IOException {
    	this.acertosConsecutivos = 0;
        this.tentativasRestantes = 5;
        this.pontuacao = 100;
        this.rodadasJogadas = 0;
        this.palavrasAcertadas = 0;
        fe = new FabricaEmbaralhadores();
        gerarNovaPalavra();
        iniciarJogo();
        verificarPalpite();
        
    }

    private void gerarNovaPalavra() throws IOException  {
    	fe.obterEmbaralhadorAleatorio();
        palavraSecreta = fe.getPalavraSecreta();
        palavraEmbaralhada = fe.getPalavraEmbaralhada();
    }
    
    private void finalizarComVitoria() {
        System.out.println("\nParabéns! Você venceu o jogo!");
        System.out.println("Você jogou " + rodadasJogadas + " rodadas e acertou " + palavrasAcertadas + " palavras.");
        System.out.println("Sua pontuação final é: " + pontuacao);
    }
    
    private void finalizarComDerrota() {
        System.out.println("\nObrigado por jogar!");
        System.out.println("Você jogou até a rodada " + rodadasJogadas + " e acertou " + palavrasAcertadas + " palavras.");
        System.out.println("Sua pontuação final é: " + pontuacao);
    }

    @Override
    public void iniciarJogo()  {
        System.out.println("Bem-vindo ao jogo de adivinhar palavras!");
        System.out.println("");
        System.out.println("Este é o modo aprimorado que conta com um total de 5 rodadas, sua pontuacao começa com 100 e diminui 10 pontos a cada erro.");
        System.out.println("");
        System.out.println("Seu objetivo nesse jogo é chegar na 5 rodada com o menor numeros de erros e assim conseguir uma maior pontuação.");
        System.out.println("Você terá " + tentativasRestantes + " vidas para tentar chegar o mais longe possivel.");
        System.out.println("");
        System.out.println("A palavra embaralhada é: " + palavraEmbaralhada);
    }
    
    public void iniciarNovaRodada()  {
    	System.out.println("");
        System.out.println("Meus parabens ! você passou para a proxima rodada, continue acertando para aumentar seus pontos.");
        System.out.println("");
        System.out.println("Você ainda tem " + tentativasRestantes + " vidas para continuar no jogo !");
        System.out.println("");
        System.out.println("A palavra embaralhada é: " + palavraEmbaralhada);
    }

    @Override
    public void verificarPalpite() throws IOException {
        rodadasJogadas++;

        System.out.println("Digite seu palpite para a palavra secreta:");
        String palpiteAtual = scanner.next();

        while (tentativasRestantes > 1 && !palpiteAtual.equals(palavraSecreta)) {
            if (palpiteAtual.length() != palavraSecreta.length()) {
                System.out.printf("Palpite errado! Tente novamente (%d tentativas restantes): ", tentativasRestantes - 1);
            } else {
                System.out.println("Palpite quase certo! Continue tentando!");
            }

            tentativasRestantes--;
            palpiteAtual = scanner.next();
            pontuacao -= 10;
        }

        if (palpiteAtual.equals(palavraSecreta)) {
            palavrasAcertadas++;
            pontuacao += 20; 
            acertosConsecutivos++; 

            System.out.println("Parabéns! Você acertou a palavra secreta!");

            if (acertosConsecutivos < 5) { 
                System.out.println("Você acertou " + acertosConsecutivos + " palavras consecutivas!");
               
                gerarNovaPalavra();
                iniciarNovaRodada(); 
                verificarPalpite();

            } else { 
                finalizarComVitoria();
            }

        } else {
            System.out.println("Infelizmente, você não conseguiu acertar a palavra secreta. A palavra secreta era: " + palavraSecreta);
            finalizarComDerrota();
        }
    }
	@Override
	public void finalizarJogo() {
		System.out.println("Jogo finalizado!");
		System.out.printf("Nível  - Pontuação final: ",  pontuacao);
		System.out.println("Obrigado por jogar!");
		scanner.close();
	}

	@Override
	public int obterPontuacaoFinal() {
		
		return pontuacao;
	}

	@Override
	public MecanicaDoJogo get() {
		
		return null;
	}
}



package model;

import java.io.IOException;

public interface MecanicaDoJogo {
	
	void iniciarJogo() throws IOException;
    void verificarPalpite() throws IOException;
    void finalizarJogo();
    int obterPontuacaoFinal();
	MecanicaDoJogo get();		
}

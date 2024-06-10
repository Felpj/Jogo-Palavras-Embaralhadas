package model;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class FabricaMecanicaDoJogo {
	
	private List<MecanicaDoJogo> mecanicaDisponiveis; 
	

	public FabricaMecanicaDoJogo() throws IOException {	
		mecanicaDisponiveis = new ArrayList<>();
		
		adicionarMecanicaDoJogo(new MecanicaDoJogoComplexa());
		adicionarMecanicaDoJogo(new MecanicaDoJogoFacil());
	}
	
	public void adicionarMecanicaDoJogo(MecanicaDoJogo mecanica) {
		mecanicaDisponiveis.add(mecanica);
    }
	
	public MecanicaDoJogo iniciarJogo() throws IOException {
		SecureRandom random = new SecureRandom();
        if (mecanicaDisponiveis.isEmpty()) {
            throw new IOException("Não há mecanicas disponíveis!");
        }
           
        int indiceAleatorio = random.nextInt(mecanicaDisponiveis.size());
        return mecanicaDisponiveis.get(indiceAleatorio);
    }

}

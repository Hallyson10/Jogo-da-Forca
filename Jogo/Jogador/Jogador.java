package Jogador;

import java.util.ArrayList;
import java.util.Arrays;

public class Jogador {
	private String name;
	private int pontuacao;

	public Jogador(String nome) {
		this.name = nome;
		this.pontuacao = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao() {
		this.pontuacao = this.pontuacao + 1;
	}

}

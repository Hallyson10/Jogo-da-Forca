package Forca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;
import API.Palavras;
import Jogador.Jogador;
import Menu.Menu;

public class Forca {
	public Forca(Jogador jog1, String palavraEscolhida, String tema) {

		Menu menu = new Menu();
		try {
			Scanner teclado = new Scanner(System.in);

			// - Iniciando variaveis que serão usadas para efetuarmos as operações

			ArrayList<Character> tents = new ArrayList<Character>();
			int tamPalavra = palavraEscolhida.length();
			int tentativas = 12;
			int qtdAcertos = 0;
			int qtdErros = 0;
			Vector tentadas = new Vector();

			char[] linha = new char[tamPalavra];

			// - Imprimindo a forca sem nada

			System.out.println("\nTema " + tema);
			System.out.println("\nVocê tem " + tentativas + " tentativas\n");
			System.out.println(" ______________");
			System.out.println("|             |");
			System.out.println("|             |");
			System.out.println("|\n|\n|\n|\n|\n");
			for (int u = 0; u < tamPalavra; u++) {
				linha[u] = '_';
				System.out.print(" " + linha[u] + " ");
			}

			// - Repetindo a escolha da letra e verificando se contém a letra na palavra

			while (tamPalavra > 0 && tentativas > 0) {
				boolean isErro = true;

				System.out.println("\n\nEscolha uma letra");
				Character let = teclado.next().charAt(0);
				Character letra = Character.toUpperCase(let);
				for (int m = 0; m < linha.length; m++) {
					if (!tents.contains(letra) && palavraEscolhida.charAt(m) == letra) {
						linha[m] = letra;
						tentativas++;
						qtdAcertos++;
						tamPalavra--;
						isErro = false;
					}
				}
				tents.add(letra);
				if (isErro) {
					qtdErros++;
					tentadas.add(letra);

				} else {
					System.out.println("\nacertou " + letra + "\n");
				}

				tentativas--;

				// - Imprimindo a forca

				imprime(linha, qtdErros, tentativas);
				// - Strings para feedback

				String txt = "";
				String depri = "";
				String mot = "";
				String chance = "";

				// - Condições de palavra amiga e ajuda
				if(qtdErros >= 5) {
					chance = "Os satanistas deram mais "+ (tentativas)+ " chances\n"
							+ "\n## Não desperdíce suas chances, pense bem ##";
				}else {
					chance = "";
				}
				if ((palavraEscolhida.length() - qtdAcertos) <= 3) {
					mot = "\n-----Eita, calma falta pouco!-------\n";
				} else {
					mot = "";
				}

				if (tentativas <= 3 && tamPalavra >= 4) {
					depri = "\nCalma meu jovem, pense mais um pouco o tema é ( " + tema + " )";
				} else {
					depri = "";
				}
				if (qtdAcertos == 0) {
					txt = " Você errou todas, tente novamente!";
				} else {
					txt = " :( ...  Você acertou " + qtdAcertos + " letras de " + palavraEscolhida.length();
				}
				if (tamPalavra == 0) {
					jog1.setPontuacao();
					System.out.println();
					tentativas = 50;
					imprime(linha, qtdErros, tentativas);
					System.out.println("\n\nParabéns " + jog1.getName() + " Você vai ganhar um bombom do prof!!!");
					menu.start(jog1);
				} else if (tentativas == 0) {
					System.out.println("  Você tem " + tentativas + " tentativas");
					System.out.println();
					System.out.println("\n\nPoxa " + jog1.getName() + txt);
					System.out.println("Palavra correta " + palavraEscolhida);
					menu.start(jog1);
				} else {
					System.out.println("\n\n  Você tem (" + tentativas + ") tentativas");
					System.out.println("   Você acertou " + qtdAcertos);
					System.out.println("   Você Errou " + qtdErros);
					System.out.println("   Você já tentou " + tentadas);
					System.out.println(depri);
					System.out.println(mot);
					System.out.println("\nFaltam (" + tamPalavra + ") letras para salvar a vida do seu melhor amigo!\n");
					System.out.println(chance);
				}
			}

		} catch (Exception err) {
			System.out.println("Digite apenas uma letra na próxima");
			menu.start(jog1);
		}
	}

	// Imprime a forca com alterações

	static void imprime(char[] acertadas, int err, int tentativa) {
		System.out.println(" ______________");
		System.out.println("|              |");
		System.out.println("|               ");
		if (tentativa == 0) {
			System.out.println("| Infelizmente seu amigo morreu :( !");
			if (err >= 2) {
				System.out.println("|              __");
				System.out.print("|            <");
				if(err==2) {
					System.out.println();
				}
				if (err >= 3)
					System.out.print("   >\n");
				if (err >= 4) {
					System.out.print("|             (");
					if(err==4) {
						System.out.println();
					}
					if (err >= 5) {
						System.out.println(" )");
					}
				}
			}
		} else if (tentativa == 50) {
			System.out.println("| Parabéns! você salvou seu amigo! :) !");
		} else {
			boneco(err);
		}
		System.out.print("|\n|\n|");//
		if(tentativa > 0) {
			System.out.println("          _________");
			System.out.println("|          |      |");
			System.out.println("|          |      |");
			System.out.println();	
		}else {
			System.out.println();
		}

		for (int l = 0; l < acertadas.length; l++) {
			System.out.print(" " + acertadas[l] + " ");
		}
		System.out.println();
	}

	// Imprime o boneco
	public static void boneco(int err) {
		if (err >= 1) {
			System.out.print("|              O\n");//
			if (err >= 2) {
				System.out.print("|            <");
				if(err==2) {
					System.out.println();
				}
				if (err >= 3)
					System.out.print("   >\n");
				if (err >= 4) {
					System.out.print("|             (");
					if(err==4) {
						System.out.println();
					}
					if (err >= 5) {
						System.out.println(" )");
					}
				}
			}
		}
	}
}

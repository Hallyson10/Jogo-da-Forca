package Main;

import java.util.Scanner;

import API.Palavras;
import API.Times;
import Forca.Forca;
import Jogador.Jogador;
import Menu.Menu;

public class Main {

	public static void main(String[] args) {
		try {
		Scanner nome = new Scanner(System.in);
		String nomeuser = "";
		System.out.println("Digite seu nome para iniciar\n");
		
			nomeuser = nome.nextLine();
			Jogador jog = new Jogador(nomeuser);
			Menu.start(jog);
			
		}catch(Exception e) {
			System.out.println("Ocorreu um erro!");
		}
	}
}
//learnbranshgithub
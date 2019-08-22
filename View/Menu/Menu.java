package Menu;

import java.util.Scanner;
import API.Palavras;
import API.Times;
import Forca.Forca;
import Jogador.Jogador;

public class Menu {
	
  public static void start(Jogador jog) {
	  try {
		  System.out.println("\n\n1 - Jogar\n2 - Ver pontuação\n3 - Sair");
		  System.out.println("Selecione uma opção");
		  Scanner scan = new Scanner(System.in);
		  int op = scan.nextInt();
		  Menu(op,jog);
		  
	  }catch(Exception e) {
		  start(jog);
	  }
	  
  }
  public static void Menu(int op,Jogador jog) {
	  Scanner nome = new Scanner(System.in);
	  Scanner tema = new Scanner(System.in);
	 
	  int opcao = 0;
	  try {
		  if(op == 1) {
			  System.out.println("\nSelecione o tema\n");
			  System.out.println("1 - Times de futebol\n2 - Anime(Naruto)");
			  opcao = tema.nextInt();
			  if(opcao == 1) {
				  Forca forca = new Forca(jog,Times.getRandom().toString(),"Times de futebol");
			  }else if(opcao == 2) {
				  Forca forca = new Forca(jog,Palavras.getRandom().toString(),"Anime (Naruto)");
			  }
		  }else if(op == 2) {
			  System.out.println("Sua Pontuação é : "+ jog.getPontuacao()+" salvamentos");
			  start(jog);
		  }else if(op==3) {
			  return;
		  }

	  }catch(Exception e) {
		  start(jog);
	  }
	  
  }
}

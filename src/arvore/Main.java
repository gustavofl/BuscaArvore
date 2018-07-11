package arvore;

import java.util.Scanner;

import arvore.java2d.DesenharArvore;
import controller.Controller;

public class Main {

	public static void main(String[] args) {
		menuController();
		
		/*Arvore arvore = new Arvore("A");
		Node B = arvore.getRaiz().addFilho("B");
		B.addFilho("C");
		Node D = B.addFilho("D");
		Node E = D.addFilho("E");
		E.addFilho("F");
		Node G = arvore.getRaiz().addFilho("G");
		G.addFilho("H");
		Node I = arvore.getRaiz().addFilho("I");
		I.addFilho("K");
		Node J = I.addFilho("J");
		J.addFilho("R");
		
		System.out.println(arvore.buscaProfundidade("D"));*/
	}
	
	public static void menuController() {
		Scanner scan = new Scanner(System.in);
		Controller controller = Controller.getInstance();
		
		boolean continuar = true;
		String entrada;
		String tokens[];
		while(continuar){
			System.out.println("\n--- MENU ---");
			System.out.println("Digite add x y para adicionar um filho com nome y ao no x");
			System.out.println("Digite prof x para retornar o custo de procurar x usando uma busca em profundidade");
			System.out.println("Digite mostrar para mostrar graficamente a arvore criada");
			System.out.println("Digite larg x para retornar o custo de procurar x usando uma busca em largura");
			System.out.println("Digite fim para finalizar");
			
			entrada = scan.nextLine();
			tokens = entrada.split(" "); 
			
			switch (tokens[0]) {
			case "add":
				controller.addNode(tokens[1], tokens[2]);
				break;
			case "prof":
				System.out.println(controller.buscaProfundidade(tokens[1]));
				break;
			case "larg":
				System.out.println(controller.buscaLargura(tokens[1]));
				break;
			case "fim": case "f":
				controller.closeTela();
				continuar = false;
				break;
			default:
				System.out.println("Comando nao reconhecido");
				break;
			}
		}
		
		System.out.println("\nFIM");
		
		scan.close();
	}
	
	public static void menu(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o nome da raiz da arvore");
		String nome = scan.nextLine();
		Arvore arvore = new Arvore(nome);
		DesenharArvore tela = new DesenharArvore(arvore);
		
		boolean continuar = true;
		String entrada;
		String tokens[];
		while(continuar){
			System.out.println("\n--- MENU ---");
			System.out.println("Digite add x y para adicionar um filho com nome y ao no x");
			System.out.println("Digite prof x para retornar o custo de procurar x usando uma busca em profundidade");
			System.out.println("Digite mostrar para mostrar graficamente a arvore criada");
			System.out.println("Digite larg x para retornar o custo de procurar x usando uma busca em largura");
			System.out.println("Digite fim para finalizar");
			
			entrada = scan.nextLine();
			tokens = entrada.split(" "); 
			int custo;
			
			switch (tokens[0]) {
			case "add":
				Node pai = arvore.getNode(tokens[1]);
				if(pai == null){
					System.out.println("Nao existe um no com nome "+tokens[1]+" na arvore.");
					break;
				}
				pai.addFilho(tokens[2]);
				System.out.println("No inserido");
				tela.repaint();
				break;
			case "prof":
				custo = arvore.buscaProfundidadeCusto(tokens[1]);
				if(custo == -1)
					System.out.println("No nao encontrado");
				else
					System.out.println(custo);
				break;
			case "mostrar": case "m":
				tela.repaint();
				break;
			case "larg":
				custo = arvore.buscaLarguraCusto(tokens[1]);
				if(custo == -1)
					System.out.println("No nao encontrado");
				else
					System.out.println(custo);
				break;
			case "fim": case "f":
				tela.dispose();
				continuar = false;
				break;
			default:
				System.out.println("Comando nao reconhecido");
				break;
			}
		}
		
		System.out.println("\nFIM");
		
		scan.close();
	}

}

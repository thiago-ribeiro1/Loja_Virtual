package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Estoque estoque = new Estoque();

		int opcao = 0;
		while (opcao != 6) {
			System.out.println("============= MENU =============");
			System.out.println();
			System.out.println("1) Listar todos os produtos");
			System.out.println("2) Cadastrar um novo produto");
			System.out.println("3) Adicionar estoque de um produto");
			System.out.println("4) Remover um produto do comércio");
			System.out.println("5) Vender algum produto existente");
			System.out.println("6) Sair do programa");
			System.out.println();
			System.out.println("============= MENU =============");
			System.out.println();
			System.out.println("Digite a sua opção: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				estoque.listarProdutos();
				break;
			case 2:
				estoque.cadastrar();
				break;
			case 3:
				estoque.adicionarEstoque();
				break;
			case 4:
				estoque.remover();
				break;
			case 5:
				estoque.vender();
				break;
			case 6:
				System.out.println();
				System.out.println("Sair\n");
				break;
			default:
				System.out.println();
				System.out.println("Opção inválida, tente novamente \n");
				break;
			}
		}
		sc.close();
	}
}
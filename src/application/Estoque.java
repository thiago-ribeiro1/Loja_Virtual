package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {

	private List<Produto> produtos = new ArrayList<>();

	public void listarProdutos() {
		if (produtos.size() == 0) {
			System.out.println("Nenhum produto cadastrado no sistema \n");
		} else {
			System.out.println("Lista de produtos: \n");
			for (Produto p : produtos) {
				System.out.println(p);
			}
		}
	}

	public void cadastrar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do novo produto: ");
		String nome = sc.nextLine();
		boolean valid = true;
		int codigo = 0;
		while (valid) {
			System.out.println("Digite o código do Produto: ");
			codigo = sc.nextInt();
			Produto p = buscarProduto(codigo);

			if (p == null) {
				valid = false;
			} else {
				System.out.println("Código já existente!\n");
				valid = true;
			}
		}

		Produto p = new Produto(nome, codigo, 0);
		produtos.add(p);

		System.out.println("Deseja adicionar estoque ao produto? (S/N): ");
		sc.nextLine();
		String resposta = sc.nextLine();
		if (resposta.equalsIgnoreCase("S")) {
			System.out.println("Digite a quantidade a ser adicionada no estoque: ");
			int quantidade = sc.nextInt();
			p.adicionarEstoque(quantidade);
			System.out.println(nome + " cadastrado com sucesso. Código: " + codigo + " Estoque: " + quantidade + "\n");
		} else {
			System.out.println(nome + " cadastrado com sucesso. Código: " + codigo + "\n");
		}
	}

	public void adicionarEstoque() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o código do produto: ");
		int codigo = sc.nextInt();
		Produto p = buscarProduto(codigo);

		if (p != null) {
			System.out.println("Digite a quantidade a ser adicionada no estoque: ");
			int quantidade = sc.nextInt();
			p.adicionarEstoque(quantidade);
			System.out.println(p.getNome() + " Estoque atualizado: " + p.getEstoque() + "\n");
		} else {
			System.out.println("Nenhum produto cadastrado no sistema com o código informado. \n");
		}
	}

	public void remover() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o código do produto que deseja excluir: ");
		int codigo = sc.nextInt();
		Produto p = buscarProduto(codigo);

		if (p != null) {

			System.out.println(p);

			if (p.getEstoque() > 0) {
				System.out.println("Quer realmente excluir este produto? (S/N): ");
				sc.nextLine();
				String resposta = sc.nextLine();
				if (resposta.equalsIgnoreCase("S")) {
					produtos.remove(p);
					System.out.println(
							"Produto: " + p.getNome() + " de código: " + p.getCodigo() + "\nRemovido com sucesso!\n");
				} else {
					System.out.println("Remoção cancelada. \n");
				}
			} else {
				produtos.remove(p);
				System.out.println("Produto de código: " + p.getCodigo() + "\nRemovido com sucesso!\n");
			}
		} else {
			System.out.println("Produto não encontrado! \n");
		}
	}

	public void vender() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o código do produto que deseja vender: ");
		int codigo = sc.nextInt();
		Produto p = buscarProduto(codigo);

		if (p != null) {
			System.out.println("Digite a quantidade a ser vendida: ");
			int quantidade = sc.nextInt();

			if (p.vender(quantidade)) {
				System.out.println("Venda realizada com sucesso. " + p.getNome() + " Estoque atualizado: "
						+ p.getEstoque() + "\n");
			}
		} else {
			System.out.println("Produto não encontrado! \n");
		}
	}

	private Produto buscarProduto(int codigo) {
		for (Produto p : produtos) {
			if (p.getCodigo() == codigo) {
				return p;
			}
		}
		return null;
	}
}
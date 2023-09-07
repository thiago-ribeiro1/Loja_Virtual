package application;

public class Produto {

	private String nome;
	private int codigo;
	private int estoque;

	public Produto(String nome, int codigo, int estoque) {
		this.nome = nome;
		this.codigo = codigo;
		this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public void adicionarEstoque(int quantidade) {
		this.estoque += quantidade;
	}

	public boolean vender(int quantidade) {
		if (quantidade <= this.estoque) {
			this.estoque -= quantidade;
			return true;
		} else {
			System.out.println("A quantidade desejada é insuficiente no estoque \n");
			return false;
		}
	}

	@Override
	public String toString() {
		return nome + " (cód.: " + codigo + " | estoque: " + estoque + ")\n";
	}
}
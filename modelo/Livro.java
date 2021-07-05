package biblioteca.modelo;

public class Livro {
	private String titulo;
	private int isbn, area;
	private String editora = "Editora IFMS";
	private Autor autor;
	private double preco;
	
	public double getPreco() {
		this.preco *= (this.preco >= 100 && this.preco < 200) ? 0.9: 1;
		this.preco *= (this.preco >= 200 && this.preco < 300) ? 0.8: 1;
		this.preco *= (this.preco >= 300) ? 0.7: 1;
		
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getArea() {
		switch (this.area) {
		case 1:
			return "Ciencias Exatas e da Terra";
		case 2:
			return "Ciencias Biologicas";
		case 3:
			return "Engenharias";
		case 4:
			return "Ciencias da Saude";
		case 5:
			return "Ciencias Humanas";
		case 6:
			return "Ciencias Agrarias";
		case 7:
			return "Ciencias Sociais Aplicadas";
		case 8:
			return "Linguistica";
		case 9:
			return "Letras e Artes";
		default:
			return "Area nao informada";
		}
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String toString() {
		return "Titulo: " + this.titulo + 
			   "\nISBN: " + this.isbn + 
			   "\nEditora: " + this.editora + 
			   "\nArea: " + this.getArea() +
			   "\nPreco: " + this.getPreco() + 
			   "\n-----------------------------" + 
			   "\n" + this.autor.toString();
	}
}

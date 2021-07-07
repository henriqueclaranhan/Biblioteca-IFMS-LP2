package biblioteca.modelo;

import java.time.LocalDateTime;

public class Emprestimo {
	private Livro livro;
	private Cliente cliente;
	private LocalDateTime dataEmprestimo, dataDevolucao;
	
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}
	
	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public void definirPrazoDevolucao(Cliente tipoCliente) {
		
		if (tipoCliente instanceof ClienteProfessor) {
			this.setDataDevolucao( this.dataEmprestimo.plusDays(45) );
		} else
		
		if (tipoCliente instanceof ClienteAluno) {
			this.setDataDevolucao( this.dataEmprestimo.plusDays(30) );
		} else
			
		if (tipoCliente instanceof Cliente) {
			this.setDataDevolucao( this.dataEmprestimo.plusDays(10) );
		}
	
	}

}

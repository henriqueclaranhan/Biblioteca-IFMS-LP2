package biblioteca.modelo;

import java.time.LocalDateTime;

public class Emprestimo {
	private LocalDateTime dataEmprestimo, dataDevolucao;
	
	
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
	
	public void definirPrazoDevolucao(String tipoCliente) {
		switch(tipoCliente) {
			case "qualquer": this.setDataDevolucao( this.dataEmprestimo.plusDays(10) );
					break;
					
			case "aluno": this.setDataDevolucao( this.dataEmprestimo.plusDays(30) );
					break;
					
			case "professor": this.setDataDevolucao( this.dataEmprestimo.plusDays(45) );
					break;
		}
	}
	
}

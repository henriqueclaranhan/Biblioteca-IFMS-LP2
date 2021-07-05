package biblioteca.modelo;

public class AutorAluno extends Autor {
	private String curso;
	private int situacao;
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public String getSituacao() {
		switch (this.situacao) {
			case 1:
				return "Em curso";
			case 2:
				return "Transferido";
			case 3:
				return "Trancado";
			case 4:
				return "Concluido";
			default:
				return "Nao cadastrado";
		}
	}
	
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\nCurso: " + this.getCurso() + 
				"\nSituacao: " + this.getSituacao();
	}
}

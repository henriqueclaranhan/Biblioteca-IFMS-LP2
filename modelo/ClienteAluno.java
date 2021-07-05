package biblioteca.modelo;

public class ClienteAluno extends Cliente{
	private String instituicao, curso;
	
	public ClienteAluno() {
		this.setTipoCliente("aluno");
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	@Override
	public boolean validarInformacoes() {
		if (super.validarInformacoes()) {
			if (this.instituicao != null && this.curso != null) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\nInstituicao: " + this.getInstituicao() + 
				"\nCurso: " + this.getCurso();
	}
	
}

package biblioteca.modelo;

public class ClienteProfessor extends Cliente{
	private String instituicao, formacao;

	
	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	@Override
	public boolean validarInformacoes() {
		if (super.validarInformacoes()) {
			if (this.instituicao != null && this.formacao != null) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\nInstituicao: " + this.getInstituicao() + 
				"\nFormacao: " + this.getFormacao();
	}
	
}

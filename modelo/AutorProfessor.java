package biblioteca.modelo;

public class AutorProfessor extends Autor {
	private String formacao, areaAtuacao;
	private  int tipoContrato, dedicacao;
	
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String getTipoContrato() {
		switch (this.tipoContrato) {
			case 1:
				return "Professor substituto";
			case 2:
				return "Servidor";
			default:
				return "Nao cadastrado";
		}
	}
	public void setTipoContrato(int tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getAreaAtuacao() {
		return areaAtuacao;
	}
	public void setDedicacao(int dedicacao) {
		this.dedicacao = dedicacao;
	}
	public String getDedicacao() {
		switch (this.dedicacao) {
			case 1:
				return "20 horas";
			case 2:
				return "40 horas";
			case 3:
				return "Exclusiva";
			default:
				return "Nao cadastrado";
		}
	}
	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"\nFormacao: " + this.getFormacao() +
				"\nArea de atuacao IF : " + this.getAreaAtuacao() + 
				"\nTipo contrato: " + this.getTipoContrato() +
				"\nDedicacao: " + this.getDedicacao();
	}
}

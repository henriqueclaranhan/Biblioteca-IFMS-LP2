package biblioteca.modelo;

public class Cliente {
	private String nomeCompleto, cpf, endereco;
	private String email, telefone;
	private String tipoCliente;
	
	public Cliente() {
		this.setTipoCliente("qualquer");
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	public boolean validarInformacoes() {
		return (
			this.nomeCompleto != null && this.email != null &&
			this.endereco != null && this.cpf != null && this.telefone != null
			) ? true : false ;
	}
	
	public String imprimirResumo() {
		return "  Nome: " + this.nomeCompleto + "\n" +
				"  E-mail: " + this.email + "\n" + 
				"  Telefone: " + this.telefone;
	}
	
	public String toString() {
		return "Nome completo: " + this.getNomeCompleto() + 
				"\nCPF: " + this.getCpf() + 
				"\nE-mail: " + this.getEmail() +
				"\nTelefone: " + this.getTelefone() +
				"\nEndereco: " + this.getEndereco() + 
				"\nTipo cliente: " + this.getTipoCliente();
	}
	
}

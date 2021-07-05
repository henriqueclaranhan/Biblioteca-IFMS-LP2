package biblioteca.modelo;

public class Autor {
	private String nomeCompleto, cpf;
	private String email, telefone;
	private String campus;
	int matricula;
	
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCampus() {
		return campus;
	}
	
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String imprimirResumo() {
		return "Nome: " + this.nomeCompleto + "\n" +
				"Matricula: " + this.matricula + "\n" + 
				"Campus: " + this.campus;
	}
	
	public String toString() {
		return "Nome completo: " + this.getNomeCompleto() + 
				"\nCPF: " + this.getCpf() + 
				"\nE-mail: " + this.getEmail() +
				"\nTelefone: " + this.getTelefone() +
				"\nMatricula: " + this.getMatricula() + 
				"\nCampus: " + this.getCampus();
	}

}

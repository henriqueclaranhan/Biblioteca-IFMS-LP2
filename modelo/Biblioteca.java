package biblioteca.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class Biblioteca {

	private ArrayList<Livro> acervo;
	private ArrayList<Autor> autores;
	private ArrayList<Cliente> clientes;
	
	public boolean carregarDados(){
		String caminho;
		boolean carregamentoFuncionou = true;
		
		//CARREGAR AUTORES
		caminho = System.getProperty("user.dir") + "/src/biblioteca/modelo/autores.txt";
		File arquivo = new File(caminho);
		
		try {
			FileReader ler = new FileReader(arquivo);
			BufferedReader buffer = new BufferedReader(ler);
			String linha = buffer.readLine();
			
			while (linha != null){
				String[] dados = linha.split(";");
				
				//Autor professor
				if (dados[1].equals("1")) {
					AutorProfessor autorProfessor = new AutorProfessor();
					autorProfessor.setNomeCompleto(dados[2]);
					autorProfessor.setCpf(dados[3]);
					autorProfessor.setEmail(dados[4]);
					autorProfessor.setTelefone(dados[5]);
					autorProfessor.setCampus(dados[6]);
					autorProfessor.setMatricula(Integer.parseInt(dados[7]));
					autorProfessor.setFormacao(dados[8]);
					autorProfessor.setTipoContrato(Integer.parseInt(dados[9]));
					autorProfessor.setAreaAtuacao(dados[10]);
					autorProfessor.setDedicacao(Integer.parseInt(dados[11]));
					
					this.autores.add(Integer.parseInt(dados[0]),autorProfessor);
				}
				
				//Autor aluno
				else {
					AutorAluno autorAluno = new AutorAluno();
					autorAluno.setNomeCompleto(dados[2]);
					autorAluno.setCpf(dados[3]);
					autorAluno.setEmail(dados[4]);
					autorAluno.setTelefone(dados[5]);
					autorAluno.setCampus(dados[6]);
					autorAluno.setMatricula(Integer.parseInt(dados[7]));
					autorAluno.setCurso(dados[8]);
					autorAluno.setSituacao(Integer.parseInt(dados[9]));
					
					this.autores.add(Integer.parseInt(dados[0]), autorAluno);
				}
				
				linha = buffer.readLine();
				
			}
			buffer.close();
		} catch (Exception e) {
			carregamentoFuncionou = false;
		} 
		
		//CARREGAR LIVROS
		caminho = System.getProperty("user.dir") + "/src/biblioteca/modelo/acervo.txt";
		arquivo = new File(caminho);
		
		try {
			int copias = 1;
			
			FileReader ler = new FileReader(arquivo);
			BufferedReader buffer = new BufferedReader(ler);
			String linha = buffer.readLine();
			
			while (linha != null){
				String[] dados = linha.split(";");
				Livro livro = new Livro();
				livro.setTitulo(dados[0]);
				livro.setIsbn(Integer.parseInt(dados[1]));
				livro.setEditora(dados[2]);
				livro.setArea(Integer.parseInt(dados[3]));
				livro.setAutor(autores.get(Integer.parseInt(dados[4])));
				livro.setPreco(Double.parseDouble(dados[5]));
				copias = Integer.parseInt(dados[6]);
				
				this.adicionarLivro(livro, copias);;
				
				linha = buffer.readLine();
			}
			buffer.close();
		} catch (Exception e) {
			carregamentoFuncionou = false;
		}
		
		//CARREGAR CLIENTES
		caminho = System.getProperty("user.dir") + "/src/biblioteca/modelo/clientes.txt";
		arquivo = new File(caminho);

		try {
			FileReader ler = new FileReader(arquivo);
			BufferedReader buffer = new BufferedReader(ler);
			String linha = buffer.readLine();
			
			while (linha != null){
				String[] dados = linha.split(";");

				//Cliente Geral
				if (dados[1].equals("1")) {
					Cliente clienteQualquer = new Cliente();
					clienteQualquer.setNomeCompleto(dados[2]);
					clienteQualquer.setCpf(dados[3]);
					clienteQualquer.setEmail(dados[4]);
					clienteQualquer.setTelefone(dados[5]);
					clienteQualquer.setEndereco(dados[6]);
					
					this.clientes.add(Integer.parseInt(dados[0]), clienteQualquer);
				} else
					
				//Cliente Aluno
				if (dados[1].equals("2")) {
					ClienteAluno clienteAluno = new ClienteAluno();
					clienteAluno.setNomeCompleto(dados[2]);
					clienteAluno.setCpf(dados[3]);
					clienteAluno.setEmail(dados[4]);
					clienteAluno.setTelefone(dados[5]);
					clienteAluno.setEndereco(dados[6]);
					clienteAluno.setInstituicao(dados[7]);
					clienteAluno.setCurso(dados[8]);
					
					this.clientes.add(Integer.parseInt(dados[0]), clienteAluno);
				} else
			
				//Cliente Professor
				if (dados[1].equals("3")) {
					ClienteProfessor clienteProfessor = new ClienteProfessor();
					clienteProfessor.setNomeCompleto(dados[2]);
					clienteProfessor.setCpf(dados[3]);
					clienteProfessor.setEmail(dados[4]);
					clienteProfessor.setTelefone(dados[5]);
					clienteProfessor.setEndereco(dados[6]);
					clienteProfessor.setInstituicao(dados[7]);
					clienteProfessor.setFormacao(dados[8]);
					
					this.clientes.add(Integer.parseInt(dados[0]), clienteProfessor);
				}
				
				linha = buffer.readLine();
				
			}
			buffer.close();
		} catch (Exception e) {
			carregamentoFuncionou = false;
		}
		
		return carregamentoFuncionou;
	}
	
	public Biblioteca() {
		this.acervo = new ArrayList<Livro>();
		this.autores = new ArrayList<Autor>();
		this.clientes = new ArrayList<Cliente>();
	}

	public void adicionarLivro(Livro livro, int quantidadeDeCopias) {
		while (quantidadeDeCopias > 0) {
			this.acervo.add(livro);
			quantidadeDeCopias--;
		}
	}

	public void removerLivro(Livro livro) {
		this.acervo.remove(livro);
	}
	
	public ArrayList<Livro> getAcervo() {
		return acervo;
	}

	public void setAcervo(ArrayList<Livro> acervo) {
		this.acervo = acervo;
	}

	public ArrayList<Autor> getAutores() {
		return this.autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}
	
	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}


	public ArrayList<Livro> buscarLivroPorTitulo(String titulo) {
		ArrayList<Livro> lista = new ArrayList<Livro>();
		
		for (Livro livro : this.acervo){
			if (livro.getTitulo().toUpperCase().contains(titulo.toUpperCase())) {
				lista.add(livro);
			}
		}
		
		return lista;
	}
	
	
	public ArrayList<Livro> buscarLivroPorAutor(String autor) {
		ArrayList<Livro> lista = new ArrayList<Livro>();
		
		for (Livro livro : this.acervo){
			if (livro.getAutor().getNomeCompleto().toUpperCase().contains(autor.toUpperCase())) {
				lista.add(livro);
			}
		}
		
		return lista;
	}

}
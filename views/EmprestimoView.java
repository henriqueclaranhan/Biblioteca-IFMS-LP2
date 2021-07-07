package biblioteca.views;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.time.LocalDateTime;

import biblioteca.modelo.*;


public class EmprestimoView {
	private Biblioteca bibliotecaIfms;
	private Emprestimo emprestimo;
	Scanner ler;
	
	EmprestimoView() {
		ler = new Scanner(System.in);
		emprestimo = new Emprestimo();
		
		//CARREGAR DADOS - BIBLIOTECA
		bibliotecaIfms = new Biblioteca();
		bibliotecaIfms.carregarDados();
		
		imprimirAcervo();
		
		System.out.println();
		
	}

	public static void main(String[] args) throws ParseException{
		EmprestimoView gerenciadorDeEmprestimo = new EmprestimoView();
		gerenciadorDeEmprestimo.iniciar();
	}
	
	
	private void iniciar() {
		boolean loop = true;
		
		do {
			System.out.println("# TELA DE EMPRESTIMO  	▫ - × |\n|");
			System.out.println("| [1] Emprestar livro");
			System.out.println("| [0] Sair\n|");
			
			switch(ler.nextInt()) {
				case 0: System.out.println("\nAté mais!");
						loop = false;
						break;

				case 1: limparTela(); identificarEmprestante();
						break;
			}
			
		} while(loop);
	}
	
	
	private void identificarEmprestante() {
		
		//FIXAR CLIENTE DO INDICE 2
		Cliente clienteId2 = bibliotecaIfms.getClientes().get(2);
		emprestimo.setCliente(clienteId2);
		
		validarEmprestimo(clienteId2);
	}
	
	
	private void validarEmprestimo(Cliente tipoCliente) {
		boolean dadosSaoValidados = tipoCliente.validarInformacoes();
		
		if(dadosSaoValidados) {
			emprestarLivro(tipoCliente);
		} else {
			System.out.println("\nDado invalido encontrado!");
			System.out.println("Nao e possivel concluir emprestimo!\n");
		}
		
	}


	private boolean emprestarLivro(Cliente tipoCliente) {
		
		//EMPRESTAR LIVRO - pretugues
		ArrayList<Livro> lista = bibliotecaIfms.buscarLivroPorTitulo("pretugues");
		if (lista.isEmpty()) {
			System.out.println("\n\nLivro nao encontrado!");
		}else {
			for (Livro livroParaEmprestar : lista){
				emprestimo.setLivro(livroParaEmprestar);
				bibliotecaIfms.removerLivro(livroParaEmprestar);
				
				DataFormato data = new DataFormato();
				
				//Definir Data Atual
				data.setDataAtual(LocalDateTime.now());
				
				//Definir Data de Emprestimo e Devolucao
				emprestimo.setDataEmprestimo(data.getDataAtual());
				emprestimo.definirPrazoDevolucao(tipoCliente);
				
				System.out.println("\n### LIVRO EMPRESTADO COM SUCESSO! ###");
				
				System.out.println("\n- Dados do emprestante: ");
				System.out.println( emprestimo.getCliente().imprimirResumo() );
				
				System.out.println("\n- Livro emprestado: ");
				System.out.println( "  " + emprestimo.getLivro().getTitulo() );
				
				System.out.println("\n- Data de emprestimo: " + data.getDataFormatada(emprestimo.getDataEmprestimo()));
				System.out.println("- Data de devolucao: " + data.getDataFormatada(emprestimo.getDataDevolucao()) + "\n");
				
				imprimirAcervo();
				return true;
			}
		}
		
		imprimirAcervo();
		return false;
	}
	
	
	private void imprimirAcervo() {
		System.out.println("\n### IMPRIMIR ACERVO ###");
		ArrayList<Livro> acervo = bibliotecaIfms.getAcervo();
		for(Livro livro : acervo) {
			System.out.println("=> " + livro.getTitulo());
			System.out.println("Editora: " + livro.getEditora());
			System.out.println("Area: " + livro.getArea() + "\n\n");
		}
	}
	
	
	private void limparTela() {
		for(int x=0; x<100; x++) {
			System.out.println();
		}
	}

}
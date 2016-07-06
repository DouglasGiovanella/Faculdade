package funcionalidades.livros.consultar.todos;

import java.util.ArrayList;
import java.util.Scanner;

import arquivo.ConsultarNoArquivo;
import dominio.Livro;

public class ConsultarTodosLivrosController {
	
	private ConsultarNoArquivo consulta;
	private ConsultarTodosLivrosView cview;
	
	public ConsultarTodosLivrosController(){
		consulta = new ConsultarNoArquivo();
		cview = new ConsultarTodosLivrosView();
	}
	
	public void mostrarLivros(){
		
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Livro> listaDeLivros = consulta.buscarTodosLivros();

		if(listaDeLivros.isEmpty()){
			cview.exibirMensagemNaoHaLivrosCadastrados();
		}else{
			cview.exibirLivros(listaDeLivros);
		}
		cview.exibirMensagemDeParaProsseguir();
        scanner.nextLine();
		
	}
	
	
}

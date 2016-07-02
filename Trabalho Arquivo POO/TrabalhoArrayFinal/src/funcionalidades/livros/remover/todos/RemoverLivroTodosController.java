package funcionalidades.livros.remover.todos;

import java.util.Scanner;

import arquivo.RemoverDoArquivo;

public class RemoverLivroTodosController {
	
	private RemoverLivroTodosView rview;
	private Scanner scanner;
	private int opcao;
	public RemoverLivroTodosController(){
		rview = new RemoverLivroTodosView();
		scanner = new Scanner(System.in);
	}
	
	public void executar() throws Exception{
		
		rview.exibirCabecalho();
		rview.exibirOpcoes();
		opcao = scanner.nextInt();
		if(opcao == 1){
			RemoverDoArquivo remove = new RemoverDoArquivo();
			remove.limparArquivo();
		}
		rview.exibirExcluidoComSucesso();
		
	}
	
	
	
}

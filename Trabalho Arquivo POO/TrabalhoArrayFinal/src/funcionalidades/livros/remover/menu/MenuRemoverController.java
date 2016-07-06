package funcionalidades.livros.remover.menu;
import java.util.Scanner;

import funcionalidades.livros.remover.codigo.RemoverLivroCodigoController;
import funcionalidades.livros.remover.todos.RemoverLivroTodosController;

public class MenuRemoverController {
	
	private Scanner entrada; 
	private MenuRemoverView rview;
	private int opcao;
	public MenuRemoverController(){
		entrada = new Scanner(System.in);
		rview = new MenuRemoverView();
	}
	
	
	public void executar() throws Exception{
		
		rview.exibiropcoes();
		opcao = entrada.nextInt();
		switch(opcao){
		
		case 1:
			RemoverLivroTodosController removes = new RemoverLivroTodosController();
			removes.executar();
		break;
		
		case 2:
			//Remover por codigo
			RemoverLivroCodigoController remove = new RemoverLivroCodigoController();
			remove.executar();
		break;
		
		default:
			
		break;
		
		}
		
		
		
	}
	
	
}

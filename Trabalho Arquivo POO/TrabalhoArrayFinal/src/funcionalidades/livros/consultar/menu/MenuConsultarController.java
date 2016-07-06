package funcionalidades.livros.consultar.menu;
import java.util.Scanner;

import funcionalidades.livros.consultar.codigo.ConsultarCodigoLivroController;
import funcionalidades.livros.consultar.todos.ConsultarTodosLivrosController;


public class MenuConsultarController {
	
	private Scanner entrada; 
	private MenuConsultarView cview;
	private int opcao;
	public MenuConsultarController(){
		entrada = new Scanner(System.in);
		cview = new MenuConsultarView();
	}
	
	public void executar() throws Exception{
		
		cview.exibiropcoes();
		opcao = entrada.nextInt();
		switch(opcao){
		
		case 1:
			//consultar todos
			ConsultarTodosLivrosController consulta = new ConsultarTodosLivrosController();
			consulta.mostrarLivros();
		break;
		
		case 2:
			ConsultarCodigoLivroController concod = new ConsultarCodigoLivroController();
			concod.buscarTrapezio();
			
		break;
		
		default:
			
		break;
		
		}
		
		
		
	}
	
}

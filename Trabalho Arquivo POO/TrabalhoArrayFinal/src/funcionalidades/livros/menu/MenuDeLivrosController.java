package funcionalidades.livros.menu;
import java.util.Scanner;

import funcionalidade.livros.alterar.AlterarLivroController;
import funcionalidade.livros.consultar.menu.MenuConsultarController;
import funcionalidade.livros.incluir.IncluirNovoLivroController;
import funcionalidades.livros.remover.menu.MenuRemoverController;

public class MenuDeLivrosController {

	private MenuDeLivrosView menu;
	private Scanner entrada;
	
	public MenuDeLivrosController(){
		menu = new MenuDeLivrosView();
		entrada = new Scanner(System.in);
	}
	
	public void executar() throws Exception{
		
		int opcao=0;
		
		while(opcao != 9){		
			
			menu.menuPrincipal();
			opcao = entrada.nextInt();
			
			switch(opcao){
			
			//Cadastrar
			case 1 :
				IncluirNovoLivroController inclui = new IncluirNovoLivroController();
				inclui.executar();
			break;
			
			//Consultar
			case 2:
				
				MenuConsultarController consulta = new MenuConsultarController();
				consulta.executar();
				
			break;
			
			//Alterar
			case 3:
				
				AlterarLivroController altera = new AlterarLivroController();
				altera.executar();
				
			break;
			
			//Remover
			case 4:
				MenuRemoverController remove = new MenuRemoverController();
				remove.executar();
			break;
			
			default:
				System.out.println("|================================================|");
		        System.out.println("|                    XABLAU                      |");
		        System.out.println("|================================================|");
				break;
			
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
}

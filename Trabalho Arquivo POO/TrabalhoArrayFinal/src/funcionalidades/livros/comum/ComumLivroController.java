package funcionalidades.livros.comum;
import java.util.ArrayList;
import java.util.Scanner;
import arquivo.AdicionarNoArquivo;
import arquivo.ConsultarNoArquivo;
import dominio.Livro;
import funcionalidades.livros.menu.MenuDeLivrosController;


public class ComumLivroController {
	
	private ComumLivroView iview;
	
	public ComumLivroController(){
		iview = new ComumLivroView();
	}
	
	public static String nomeArquivo = "Livros.txt";
	
	//Pega dados da Classe em String e salva em um Array de Strings
	public void adicionarLivro(Livro livro) {
		
		AdicionarNoArquivo adiciona = new AdicionarNoArquivo();
		
        String delimitador = "&";
        ArrayList<String> linhas = new ArrayList<String>();
 
        linhas.add(livro.toString(delimitador));
    
        adiciona.incluirLivro(linhas);
        
    }
	
	
	
	//Função Entrada de Codigo
	//So permite entrar com um codigo valido!
	public int SolicitacaoDoCodigo(int vem) throws Exception{
		Scanner ler = new Scanner(System.in);
		ConsultarNoArquivo consulta = new ConsultarNoArquivo();
		MenuDeLivrosController menudo = new MenuDeLivrosController();
		int codigo;
		boolean teste;
		int opcao;
		
		if(vem == 1){ // VEM DO CADASTRAR LIVROS, CODIGO N DEVE EXISTIR
			do{
		        iview.exibirSolicitacaoCodigo();
		        codigo = ler.nextInt();
		        teste = consulta.checarCodigo(codigo);
		        if(teste == true){
		        	iview.exibirErroCodigoEncontrado();
		        	iview.exibirLinhaOpcaoDesejada();
		        	opcao = ler.nextInt();
		        	if(opcao == 2){
		        		menudo.executar();
		        	}
		        }
			}while(teste == true);
			return codigo;
		}else{
			if(vem == 2){ //VEM DO REMOVER LIVROS, CODIGO PRECISA ESTAR LA!
				do{
					iview.exibirSolicitacaoCodigo();
			        codigo = ler.nextInt();
			        teste = consulta.checarCodigo(codigo);
			        if(teste == false){
			        	iview.exibirErroCodigoNaoEncontrado();
			        	iview.exibirLinhaOpcaoDesejada();
			        	opcao = ler.nextInt();
			        	if(opcao == 2){
			        		menudo.executar();
			        	}
			        }
				}while(teste == false);
				return codigo;
			}
		}
		return 1;
		
		
       
    }
	
	
}

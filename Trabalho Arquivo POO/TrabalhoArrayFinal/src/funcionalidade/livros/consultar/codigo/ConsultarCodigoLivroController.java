package funcionalidade.livros.consultar.codigo;

import java.util.Scanner;

import arquivo.ConsultarNoArquivo;
import dominio.Livro;
import funcionalidades.livros.comum.ComumLivroController;

public class ConsultarCodigoLivroController {

	private ConsultarCodigoLivroView cview;
	private ComumLivroController ccontroller;
	private ConsultarNoArquivo conArquivo;
	private Scanner scan;
	
	public ConsultarCodigoLivroController(){
		cview = new ConsultarCodigoLivroView();
		ccontroller = new ComumLivroController();
		conArquivo = new ConsultarNoArquivo();
		scan = new Scanner(System.in);
	}
	
	public void buscarTrapezio() throws Exception{
		
		cview.exibirCabecario();
		Livro livro = conArquivo.buscarLivroPorCodigo(ccontroller.SolicitacaoDoCodigo(2));
		cview.exibirLivro(livro);
		cview.exibirMensagemDeParaProsseguir();
		scan.nextLine();
	}
	
	
}

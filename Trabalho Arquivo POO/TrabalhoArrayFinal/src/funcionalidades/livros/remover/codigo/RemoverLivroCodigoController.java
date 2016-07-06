package funcionalidades.livros.remover.codigo;
import java.util.Scanner;

import arquivo.ConsultarNoArquivo;
import arquivo.RemoverDoArquivo;
import dominio.Livro;
import funcionalidades.livros.comum.ComumLivroController;

public class RemoverLivroCodigoController {
	
	private RemoverLivroCodigoView rview;
	private ComumLivroController intermedia;
	private RemoverDoArquivo remove;
	private ConsultarNoArquivo consulta;
	private int codigo;
	private Scanner ler;
	public RemoverLivroCodigoController() throws Exception{
		rview = new RemoverLivroCodigoView();
		intermedia = new ComumLivroController();
		remove = new RemoverDoArquivo();
		consulta = new ConsultarNoArquivo();
		ler = new Scanner(System.in);
	}
	
	public void executar() throws Exception{
		
		rview.exibirCabecalho();
		codigo = intermedia.SolicitacaoDoCodigo(2);
		Livro livro = consulta.buscarLivroPorCodigo(codigo);
		rview.exibirLivro(livro);
		
		int opcao =ler.nextInt();
		
		if(opcao == 1){
			remove.removerLivro(codigo);
			rview.exibirMensagemDeRemocaoComSucesso();
		}
		
		
		
	}
	
	
	
}

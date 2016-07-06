package funcionalidades.livros.alterar;

import java.util.Scanner;

import arquivo.AdicionarNoArquivo;
import arquivo.RemoverDoArquivo;
import dominio.Livro;
import funcionalidades.livros.comum.ComumLivroController;
import funcionalidades.livros.incluir.IncluirNovoLivroView;

public class AlterarLivroController {
	
	private AlterarLivroView aview;
	private ComumLivroController c;
	private Livro livro;
	private IncluirNovoLivroView iview;
	private Scanner entradaLine, entradaInt;
	private RemoverDoArquivo remove;
	private int codigo;
	
	public AlterarLivroController() throws Exception{
		aview = new AlterarLivroView();
		c = new ComumLivroController();
		livro = new Livro();
		iview = new IncluirNovoLivroView();
		entradaInt = new Scanner(System.in);
		entradaLine= new Scanner(System.in);
		remove = new RemoverDoArquivo();
	}
	
	public void executar() throws Exception{
		
		aview.exibirCabecario();
		
		codigo = c.SolicitacaoDoCodigo(2);
		livro.setCodigo(codigo);
		iview.exibirSolicitacaoDoNome();
        livro.setNome(entradaLine.nextLine());

        iview.exibirSolicitacaoDoAutor();
        livro.setAutor(entradaLine.nextLine());

        iview.exibirSolicitacaoDaEditora();
        livro.setEditora(entradaLine.nextLine());
        
        iview.exibirSolicitacaoDoGenero();
        livro.setGenero(entradaLine.nextLine());
        
        iview.exibirSolicitacaoDoAno();
        livro.setAno(entradaInt.nextInt());
        
        iview.exibirSolicitacaoNumPaginas();
        livro.setNumPag(entradaInt.nextInt());
		
		remove.removerLivro(codigo);
		c.adicionarLivro(livro);
		
		aview.exibirMsgSucesso();
		
	}
	
}

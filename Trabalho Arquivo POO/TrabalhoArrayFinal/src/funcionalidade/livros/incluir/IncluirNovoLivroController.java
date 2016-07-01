package funcionalidade.livros.incluir;
import java.util.Scanner;

import dominio.Livro;
import funcionalidades.livros.comum.ComumLivroController;

public class IncluirNovoLivroController {
	
	private IncluirNovoLivroView incluirView;
    private Livro livro;
    private Scanner entradaInt, entradaLine;
    private ComumLivroController intermediador;
    
    public IncluirNovoLivroController(){
    	incluirView = new IncluirNovoLivroView();
    	entradaInt = new Scanner(System.in);
    	entradaLine = new Scanner(System.in);
    	livro = new Livro();
    	intermediador = new ComumLivroController();
    }

    public void executar() throws Exception{

    	incluirView.exibirCabecalho();
    	
    	livro.setCodigo(intermediador.SolicitacaoDoCodigo(1));

        incluirView.exibirSolicitacaoDoNome();
        livro.setNome(entradaLine.nextLine());

        incluirView.exibirSolicitacaoDoAutor();
        livro.setAutor(entradaLine.nextLine());

        incluirView.exibirSolicitacaoDaEditora();
        livro.setEditora(entradaLine.nextLine());
        
        incluirView.exibirSolicitacaoDoGenero();
        livro.setGenero(entradaLine.nextLine());
        
        incluirView.exibirSolicitacaoDoAno();
        livro.setAno(entradaInt.nextInt());
        
        incluirView.exibirSolicitacaoNumPaginas();
        livro.setNumPag(entradaInt.nextInt());
        
        incluirView.exibirMensagemDeLivroCadastradaComSucesso();
        
        salvarLivro(livro);

    }

    public void salvarLivro(Livro livro){
    	intermediador.adicionarLivro(livro);
    }

}

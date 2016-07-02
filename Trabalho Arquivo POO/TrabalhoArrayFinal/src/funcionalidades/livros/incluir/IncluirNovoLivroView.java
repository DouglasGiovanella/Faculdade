package funcionalidades.livros.incluir;

public class IncluirNovoLivroView {

	public void exibirCabecalho(){
		System.out.println("|================================================|");
        System.out.println("|                CADASTRO LIVRO                  |");
        System.out.println("|================================================|");
        System.out.println("|                                                |");
    }
	
	public void exibirSolicitacaoDoCodigo(){
        System.out.print("|  Digite o codigo: ");
    }

    public void exibirSolicitacaoDoNome(){
        System.out.print("|  Nome do Livro: ");
    }

    public void exibirSolicitacaoDoAutor(){
        System.out.print("|  Nome do Autor: ");
    }

    public void exibirSolicitacaoDaEditora(){
    	   System.out.print("|  Nome da Editora: ");
    }
    
    public void exibirSolicitacaoDoGenero(){
 	   System.out.print("|  Genero: ");
    }
    
    public void exibirSolicitacaoDoAno(){
        System.out.print("|  Digite o ano: ");
    }

    public void exibirSolicitacaoNumPaginas(){
 	   System.out.print("|  Numero de Paginas: ");
    }

    public void exibirMensagemDeLivroCadastradaComSucesso() {
        System.out.println("|================================================|");
        System.out.println("|       Livro cadastrado com sucesso!            |");
        System.out.println("|================================================|");
    }

    
		
}

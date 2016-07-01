package funcionalidade.livros.remover.codigo;

import dominio.Livro;

public class RemoverLivroCodigoView {
	
	public void exibirCabecalho(){
		System.out.println("|================================================|");
        System.out.println("|                 REMOVER LIVRO                  |");
        System.out.println("|================================================|");
        System.out.println("|                                                |");
    }
	
	 public void exibirLivro(Livro livro){
	        System.out.println("|================================================|");
	        System.out.println("|     DESEJA REALMENTE EXCLUIR ESSE LIVRO?       |");
	        System.out.println("|================================================|");
	        System.out.println("|                                                |");
	        System.out.println(livro);
	        System.out.println("|                                                |");
	        System.out.println("|================================================|");
	        System.out.println("| [1]-SIM  [2]NÂO                                |");
	        System.out.print("| Digite a opção desejada: ");
	    }
	
	public void exibirMensagemDeRemocaoComSucesso(){
		System.out.println("|================================================|");
        System.out.println("|           LIVRO REMOVIDO COM SUCESSO           |");
        System.out.println("|================================================|");
	}
	
	
	
	
}

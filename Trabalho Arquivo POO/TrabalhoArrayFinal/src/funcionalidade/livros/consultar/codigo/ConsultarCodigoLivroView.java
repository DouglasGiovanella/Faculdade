package funcionalidade.livros.consultar.codigo;

import dominio.Livro;

public class ConsultarCodigoLivroView {

	public void exibirCabecario(){
        System.out.println("|================================================|");
        System.out.println("|                BUSCAR POR CODIGO               |");
        System.out.println("|================================================|");
        System.out.println("|                                                |");
    }

    public void exibirLivro(Livro livro){
        System.out.println("|================================================|");
        System.out.println("|                   LIVRO                        |");
        System.out.println("|================================================|");
        System.out.println("|                                                |");
        System.out.println(livro);
        System.out.println("|                                                |");
        System.out.println("|================================================|");

    }

    public void exibirMensagemDeParaProsseguir() {
        System.out.println("|  Tecle ENTER para continuar                    |");
        System.out.println("|================================================|");
    }

	
	
}

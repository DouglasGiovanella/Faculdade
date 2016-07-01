package funcionalidade.livros.consultar.todos;

import java.util.ArrayList;

import dominio.Livro;

public class ConsultarTodosLivrosView {
	
	public void exibirLivros(ArrayList<Livro> livros){
		int cont=1;
        System.out.println("|================================================|");
        System.out.println("|              LISTA DE LIVROS                   |");
        System.out.println("|================================================|");
        System.out.println("|                                                |");
        for(Livro t: livros){
        	System.out.println("|\tLivro "+cont+"\n|");
            System.out.println(t);
            System.out.println("|");
            cont++;
         
            	System.out.println("|================================================|");
            
        }
    }

    public void exibirMensagemNaoHaLivrosCadastrados() {
    	System.out.println("|================================================|");
        System.out.println("|           NÂO HÁ LIVROS CADASTRADOS!           |");
        System.out.println("|================================================|");
    }
    
    public void exibirMensagemDeParaProsseguir() {
    	System.out.println("|================================================|");
        System.out.println("|          Tecle ENTER para continuar            |");
        System.out.println("|================================================|");
    }
}

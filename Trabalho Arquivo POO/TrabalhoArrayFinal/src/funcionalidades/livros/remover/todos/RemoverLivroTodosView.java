package funcionalidades.livros.remover.todos;

public class RemoverLivroTodosView {
	
	public void exibirCabecalho(){
		System.out.println("|================================================|");
        System.out.println("|                CADASTRO LIVRO                  |");
        System.out.println("|================================================|");
        System.out.println("|                                                |");
    }
	
	public void exibirOpcoes(){
        System.out.println("|  DESEJA REMOVER TODOS OS REGISTROS?            |");
        System.out.println("|  [1]SIM / [2]NÂO                               |");
        System.out.println("|================================================|");
        System.out.print("|  Digite a opção desejada: ");
	}
	
	public void exibirExcluidoComSucesso(){
		
		System.out.println("|================================================|");
        System.out.println("|        REGISTROS APAGADOS COM SUCESSO!         |");
        System.out.println("|================================================|");
	}
	
}

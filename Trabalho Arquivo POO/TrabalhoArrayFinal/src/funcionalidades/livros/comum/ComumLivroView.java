package funcionalidades.livros.comum;

public class ComumLivroView {
	
	public void exibirSolicitacaoCodigo(){
		System.out.print("|  Digite o codigo: ");
	}
	
	public void exibirErroCodigoNaoEncontrado(){
		System.out.println("|------------------------------------------------|");
    	System.out.println("|  CODIGO N�O EXISTENTE!                         |");
    	System.out.println("|  DESEJA CONTINUAR? [1]Sim [2]N�o               |");
    	System.out.println("|------------------------------------------------|");
	}
	public void exibirErroCodigoEncontrado(){
		System.out.println("|------------------------------------------------|");
    	System.out.println("|  CODIGO JA EXISTENTE!                          |");
    	System.out.println("|  DESEJA CONTINUAR? [1]Sim [2]N�o               |");
    	System.out.println("|------------------------------------------------|");
    	
	}
	public void exibirLinhaOpcaoDesejada(){
		System.out.print("|  Digite a op��o desejada: ");
	}
	
}

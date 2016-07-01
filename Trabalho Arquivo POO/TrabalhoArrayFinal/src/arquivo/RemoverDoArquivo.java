package arquivo;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoverDoArquivo {
	
	private static String nomeArquivo = "Livros.txt";
	private AdicionarNoArquivo adiciona;
	private static String delimitador = "&";
	private Scanner scanner;
	private FileReader fileReader;
	
	public RemoverDoArquivo() throws Exception{
		adiciona = new AdicionarNoArquivo();
		fileReader = new FileReader(nomeArquivo);
		scanner = new Scanner(fileReader);
	}
	
	public void acharLinha(int codigo){
		
		int codigoarquivo;
	    
	    while (scanner.hasNext()) {
	        	 
	        String linha = scanner.nextLine();
	        String[] vetor = linha.split(delimitador);
	        if(Integer.parseInt(vetor[0]) == codigo){   
	            codigoarquivo = Integer.parseInt(vetor[0]);
	            removerLivro(codigoarquivo); 
	            break;
	 	    } 
            
        }	        
	    	
	}
	
	public void removerLivro(int codigoLinha){
		
	    ArrayList<String> linhas = new ArrayList<String>();
       
        while (scanner.hasNext()) {

        	String linha = scanner.nextLine();
            String[] vetor = linha.split(delimitador);

            int codigoDoProdutoNestaLinha = Integer.parseInt(vetor[0]);

            if(codigoDoProdutoNestaLinha != codigoLinha){
            	linhas.add(linha);
            }

        }

		adiciona.escreverNovoArquivo(linhas);
	}
	
	public void limparArquivo(){
		
		try{
            FileWriter fileWriter = new FileWriter("Livros.txt", false);
            fileWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }
		
	}
	
	
	
}

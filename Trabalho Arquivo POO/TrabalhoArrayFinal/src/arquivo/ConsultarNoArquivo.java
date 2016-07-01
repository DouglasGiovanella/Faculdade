package arquivo;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Livro;


public class ConsultarNoArquivo {
	
	public static String nomeArquivo = "Livros.txt";
	public static String delimitador = "&";
	
	//Retorna True se já existe o codigo
	//Retorna False se não existe
	public boolean checarCodigo(int codigo){

		try{

	    	 FileReader fileReader = new FileReader(nomeArquivo);
	         Scanner scanner = new Scanner(fileReader);

	         while (scanner.hasNext()) {
	        	 
	             String linha = scanner.nextLine();
	             String[] vetor = linha.split(delimitador);
	             if(Integer.parseInt(vetor[0]) == codigo){   
	            	 return true;
	             }
	         }	        
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
		
		return false; 
		
	}
	
	
	 public ArrayList<Livro> buscarTodosLivros(){

	        ArrayList<Livro> lista = new ArrayList<Livro>();

	        try{

	            FileReader fileReader = new FileReader(nomeArquivo);
	            Scanner scanner = new Scanner(fileReader);

	            while (scanner.hasNext()) {

	                Livro livro = new Livro();

	                String linha = scanner.nextLine();

	                String[] vetor = linha.split(delimitador);
 
	                livro.setCodigo(Integer.parseInt(vetor[0]));
	                livro.setNome(vetor[1]);
	                livro.setAutor(vetor[2]);
	                livro.setEditora(vetor[3]);
	                livro.setGenero(vetor[4]);
	                livro.setAno(Integer.parseInt(vetor[5]));
	                livro.setNumPag(Integer.parseInt(vetor[6]));

	                lista.add(livro);
	              
	            }
	            
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        
	        return lista;
	    }
	 
	 public Livro buscarLivroPorCodigo(int codigo){

	     try{

	    	 FileReader fileReader = new FileReader(nomeArquivo);
	         Scanner scanner = new Scanner(fileReader);
	       
	         while (scanner.hasNext()) {

	        	 Livro livro = new Livro();
	             String linha = scanner.nextLine();
	             String[] vetor = linha.split(delimitador);
	             if(Integer.parseInt(vetor[0]) == codigo){   
	            
	            	 livro.setCodigo(Integer.parseInt(vetor[0]));
	            	 livro.setNome(vetor[1]);
		             livro.setAutor(vetor[2]);
		             livro.setEditora(vetor[3]);
		             livro.setGenero(vetor[4]);
		             livro.setAno(Integer.parseInt(vetor[5]));
		             livro.setNumPag(Integer.parseInt(vetor[6]));
		         
		             return livro;
		             
	             }

	         }	        
	
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	     
		return null;
		 
	 }
	 
	 
	
	
}

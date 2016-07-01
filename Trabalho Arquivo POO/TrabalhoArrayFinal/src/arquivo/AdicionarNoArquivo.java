package arquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class AdicionarNoArquivo {
	
	public static String nomeArquivo = "Livros.txt";
	
	//Concatena Linhas no arquivo caso existir
	//Senao cria o arquivo e escreve
	public void incluirLivro(ArrayList<String> linhas) {

        try{
            FileWriter fileWriter = new FileWriter(nomeArquivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(String linha : linhas) {
                bufferedWriter.write(linha);
                bufferedWriter.newLine();

            }

            bufferedWriter.close();
            fileWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
	
	//Cria um novo arquivo, caso não existir
	//Sobrescreve o arquivo, caso  exista
	 public void escreverNovoArquivo(ArrayList<String> linhas){

	        try{

	            FileWriter fileWriter = new FileWriter(nomeArquivo);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            for(String linha : linhas) {

	                bufferedWriter.write(linha);
	                bufferedWriter.newLine();

	            }

	            bufferedWriter.close();
	            fileWriter.close();

	        }catch (Exception e){
	            e.printStackTrace();
	        }

	    }
	
	
	
}

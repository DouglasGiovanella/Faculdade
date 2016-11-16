import java.io.File;
import java.io.FileNotFoundException;


public class Main {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		//Diretorio da pasta com os arquivos .txt
		File arquivo = new File("C:/Users/dougl/Desktop/SOPThreads-2");
		File[] arquivos = arquivo.listFiles();
		BalancoArquivo[] balanco = new BalancoArquivo[arquivos.length];
		Thread[] th = new Thread[arquivos.length];
		double balancoFinal=0;
		
		for(int i=0;i<arquivos.length;i++){
			balanco[i] = new BalancoArquivo(arquivos[i]);
			th[i] = new Thread(balanco[i]);
		}
		
		for(int i=0;i<th.length;i++){
			th[i].run();
		}
		
		try{
			for(int i=0;i<arquivos.length;i++){
				th[i].join();
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<balanco.length;i++){
			balancoFinal += balanco[i].getBalanco();
		}
		
		System.out.println("Balanco Final: " + balancoFinal);
		
	}
	
	
}

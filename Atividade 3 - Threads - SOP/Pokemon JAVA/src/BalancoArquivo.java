import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BalancoArquivo implements Runnable{
	
	private Scanner scanner;
	private double balanco;
	private String linha;
	private char xablau;
	
	public BalancoArquivo(File arquivo) throws FileNotFoundException{
		scanner = new Scanner(arquivo);
		balanco=0;
	}

	@Override
	public void run() {
		
		while(scanner.hasNextLine()){
			
			linha = scanner.nextLine();
			xablau = linha.charAt(0);
			linha = removeCaracteresFromString(linha, "c;v;:", ";");
						
			if(xablau == 'v'){
				balanco += Double.parseDouble(linha);
			}else{
				balanco -= Double.parseDouble(linha);
			}			
		}

	}
	
	public double getBalanco(){
		return balanco;
	}
	
	public String removeCaracteresFromString(String str, String charsRemove, String delimiter) {
		//@author ricardo spinoza
        if (charsRemove!=null && charsRemove.length()>0 && str!=null) {
         
	        String[] remover = charsRemove.split(delimiter);
	         
	        for(int i =0; i < remover.length ; i++) {
	                if (str.indexOf(remover[i]) != -1){
	                str = str.replace(remover[i], "");
	            }
	        }
	    }
	     
	    return str;
	}
			
			
}

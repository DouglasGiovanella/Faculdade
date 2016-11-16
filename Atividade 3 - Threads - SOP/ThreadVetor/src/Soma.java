
public class Soma implements Runnable{
	
	private int somaInicio, somaFinal;
	private static int[] Vc;
	private int[] vec1;
	private int[] vec2;
	
	public Soma(int ini, int fim, int[] a, int[] b){
		somaFinal = fim;
		somaInicio = ini;
		vec1 = a;
		vec2 = b;
	}
	
	public void setTamanhos(int a){
		Vc = new int[a];
	}
	
	@Override
	public void run() {
		for(int i=somaInicio;i<somaFinal;i++){
			Vc[i] = vec1[i] + vec2[i];
			
		}
	}
	
	public int[] getValor(){
		return Vc;
	}

}

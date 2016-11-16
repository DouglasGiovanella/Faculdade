
public class Multiplica implements Runnable{
	
	private int a[][];
	private int b[][];
	private static int c[][];
	private int n, ini, fim;
	
	public Multiplica(int n, int ini, int fim, int d[][], int f[][]){
		this.n = n;
		this.ini = ini;
		this.fim = fim;
		a = d;
		b = f;
	}

	public void setMatriz(int g){
		c = new int[g][g];				
	}
	
	@Override
	public void run(){
		for(int i=ini; i<fim; i++){
			for(int j=0; j<n; j++){
				c[i][j] = 0;
				for(int k=0; k<n; k++){
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
	}
	    
	public void mostraMatriz(int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(c[i][j]+" ");
			}
			System.out.println("");
		}
	}

	
		
	
	
	
}

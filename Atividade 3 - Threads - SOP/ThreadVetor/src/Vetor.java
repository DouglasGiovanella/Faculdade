import java.util.Scanner;

public class Vetor {
	
	/*
	public static int[] concatena (int[]... arrays) {
        int length = 0;
        for (int[] array : arrays){
        	length += array.length; 
        }
        int[] ret = new int[length];
        int destPos = 0;
        for (int[] array : arrays) {
            System.arraycopy (array, 0, ret, destPos, array.length);
            destPos += array.length;
        }
        return ret;
    }
	*/
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Tamanho dos vetores: ");
		int a = ler.nextInt();
		
		int b;
		
		int[] vec1 = new int[a];
		int[] vec2 = new int[a];
		
		System.out.println("Valores 1 vetor: ");
		for(int i=0;i<a;i++){
			vec1[i] = ler.nextInt();
		}
		System.out.println("Valores 2 vetor: ");
		for(int i=0;i<a;i++){
			vec2[i] = ler.nextInt();
		}
		ler.close();
		
		b = a/4;
		
		Soma soma1 = new Soma(0, b, vec1, vec2);
		Soma soma2 = new Soma(b, b*2, vec1, vec2);
		Soma soma3 = new Soma(b*2, b*3, vec1, vec2);
		Soma soma4 = new Soma(b*3, a, vec1, vec2);
		
		soma1.setTamanhos(a);
		
		Thread t1 = new Thread(soma1);
		Thread t2 = new Thread(soma2);
		Thread t3 = new Thread(soma3);
		Thread t4 = new Thread(soma4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//int[] Vc = concatena(soma1.getValor(), soma2.getValor(), soma3.getValor(), soma4.getValor());
		System.out.println("Vetor da Soma: ");
		int[] Vc = soma1.getValor();
		for(int i=0;i<Vc.length;i++){
			System.out.print(Vc[i]+ " ");
		}
		
	}

}

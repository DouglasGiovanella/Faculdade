/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 * @author UDESC
 */
public class Atividade1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o numero de linhas e colunas da matriz: ");
        int n = teclado.nextInt();
        
        int matrizA[][] = new int[n][n];
        int matrizB[][] = new int[n][n];
        
        System.out.println("\n\nDigite os valores da primeira matriz:");
        recebeMatriz(matrizA, n, teclado);
        
        System.out.println("Digite os valores da primeira matriz:");
        recebeMatriz(matrizB, n, teclado);
        
        int a = n/4;
        
        Multiplica mult1 = new Multiplica(n, 0, a, matrizA, matrizB);
        Multiplica mult2 = new Multiplica(n, a, a*2, matrizA, matrizB);
        Multiplica mult3 = new Multiplica(n, a*2, a*3, matrizA, matrizB);
        Multiplica mult4 = new Multiplica(n, a*3, n, matrizA, matrizB);
        
        Thread tr1 = new Thread(mult1);
        Thread tr2 = new Thread(mult2);
        Thread tr3 = new Thread(mult3);
        Thread tr4 = new Thread(mult4);
        
        mult1.setMatriz(n);
        
        System.out.println("Calculando a matriz Resultante: ");
        /////////////////////////////////////////////////////////////////
        long inicio = System.currentTimeMillis();
        
        
        tr1.run();               
        tr2.run();
        tr3.run();
        tr4.run();
        
        try {
			tr1.join();
			tr2.join();
			tr3.join();
			tr4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        long tempo = System.currentTimeMillis() - inicio;
        /////////////////////////////////////////////////////////////////
        System.out.println("A multiplicacao demorou: "+tempo+" milisegundos");
        mult1.mostraMatriz(n);    
    }
    
    public static void recebeMatriz(int matriz[][], int n, Scanner teclado){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matriz[i][j] = teclado.nextInt();
            }
        }
    }
    
 
}

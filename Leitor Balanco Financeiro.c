#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int main(int argc, char *argv[]) {
	
	char operacao[50]; 
	int cont=0, receita=0, despesa=0, contLinha=0, cont3=0;
	float saldo, receitaC=0, despesaC=0;
	float conttemp=500.00, conttemp2= 500.00;
	

	while( scanf("%s", operacao) != EOF ){


		if(cont == 1){
			saldo = atof(operacao);
			cont3 = cont;
		}else{
			if(cont == cont3+3){
				cont3 = cont;
				contLinha++; 
			}		
		}
		
		if((cont3+1 == cont) && ((strcmp (operacao, "receita:") == 1) || (strcmp (operacao, "despesa:") == 1))){
			freopen("log.txt", "w", stderr);			
			fprintf(stderr, "%s - %s: erro durante balanco na linha %d\n", __DATE__, __TIME__, contLinha+1);
			fclose(stderr);
		}		

		if(strcmp (operacao, "receita:") == 0){
			conttemp = cont;
			receita++;	
		}else{
			if(strcmp (operacao, "despesa:") == 0){
				despesa++;
				conttemp2 = cont;		
			}
		} 


		if((conttemp+2) == cont){
			receitaC += atof(operacao);				
		}

		
		if((conttemp2+2) == cont){
			despesaC += atof(operacao);
		}
		
		cont++;
		
	}
	saldo = (saldo - despesaC) + receitaC; 
	freopen("balanco.txt", "w", stdout);
	fprintf(stdout, "Total de Receitas: %d Resultando em: %.2f Reais\n", receita, receitaC);
	fprintf(stdout, "Total de despesas: %d Resultando em: %.2f Reais\n", despesa, despesaC);
	printff(stdout, "Saldo Final: %.2f Reais\n", saldo);
	fclose(stdout);
	return 0;
}

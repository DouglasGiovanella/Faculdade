#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <string.h>
#include <pthread.h>
#include <semaphore.h> 

sem_t mutex;
typedef long long unsigned LLU;
//diretorio[] = Diretorio da Pasta onde se encontra os arquivos de registro
//deve conter 2 barras "\\" no final do diretorio
//na pasta deve haver apenas os arquivos .txt 
char diretorio[] = {"C:\\Users\\douglasgiovanella\\Desktop\\Nova pasta\\"}; 

double balancoTotal=0;
LLU calculos=0;
//Balanco(char nome[]) = Recebe o nome do arquivo, que é concatenado 
//com o diretorio e então aberto com pelo FILE
void * balanco(void * nome){
	
	FILE *arq;
	char caminho[1000];
	strcpy(caminho, diretorio);
	strcat(caminho, nome);	
	arq = fopen(caminho, "r");
	char pegaLinha[50];
	char numDoble[50];
	int i=0, cont=0;
	double balanco=0;
	for(i=0;i<50;i++){
		pegaLinha[i] = 0;
		numDoble[i] = 0;
	}
	
	//while(fgets != NULL) = pega linha por linha do arquivo .txt 
	//a cada linha é feita a separação das letras dos numeros para 
	//outra string e assim transformada em double;
	while( (fgets(pegaLinha, sizeof(pegaLinha), arq) )!= NULL ){
		cont=0;
		for(i=2;i<sizeof(pegaLinha);i++){
			if(pegaLinha[i] == 10) break; 
			else numDoble[cont] = pegaLinha[i];			
			cont++;
		}
		sscanf(numDoble, "%lf", &balanco);
		
		//Regiao Critica - Inicio
	
		sem_wait( &mutex );
		if(pegaLinha[0] == 'v') balancoTotal += balanco;
	    else if(pegaLinha[0] == 'c') balancoTotal -= balanco;
	    calculos++;
		sem_post( &mutex );
		
		//Regiao Critica - Fim
		
		//printf("Qunt Calculos: %lld\n", calculos);
		//printf("%d\n", cont);
		for(i=0;i<cont;i++){
			pegaLinha[i] = 0;
			numDoble[i] = 0;
		}
		//printf("%lf\n", balanco);
	}
	fclose(arq); 
	pthread_exit(0);
}

int main(){

    DIR *dir;
    struct dirent *lsdir;
	int cont =0, quntArquivos=0;
	int i=0;
	//Abre o diretorio dos arquivos
    dir = opendir(diretorio);
    
    sem_init(&mutex, 0, 1);
    
    //Pecorre diretorio contando quantidade de arquivos
    //PS: No diretorio existe 2 diretorios a mais o {'.' e '..'}
	while ( ( lsdir = readdir(dir) ) != NULL ){
    	quntArquivos++;
    }
    
    //Array de Strings - Armazena os nomes dos arquivos na pasta
    char arquivos[quntArquivos-2][256];
    
    //Array de Threads
	pthread_t thread[quntArquivos-2];
	
	//Reabre diretorio
	dir = opendir(diretorio);
	
	//Pula os 2 primeiros diretorios que são '.' e '..' e armazena os nomes
	//na variave arquivos
    while ( ( lsdir = readdir(dir) ) != NULL ){
    	if(cont >= 2){
    		strcpy(arquivos[i], lsdir->d_name);
    		i++;
		}
        cont++;
    }

    for(i=0;i<quntArquivos-2;i++){
    	pthread_create( &thread[i], NULL, balanco, (void *) arquivos[i] );
	}
    
    
    for(i=0;i<quntArquivos-2;i++){
    	pthread_join( thread[i], NULL );
	}
    
    sem_destroy(&mutex);
    printf("Qunt Calculos: %lld\n", calculos);
	printf("%lf\n", balancoTotal);
    closedir(dir);

    return 0;

}

#include <iostream>
#include <queue>

using namespace std;

typedef pair<int, int> PII;

bool verifica(int first, int second){
	
	if( (first >= 0 && first <=7) && (second >= 0 && second <=7 )){
		return true;
	}else{
		return false;
	}
		
}

int main(){
	
	char letras[] = {'a','b','c','d','e','f','g','h'};
	string posInicio, posFinal;
	int matriz[8][8];
	queue<PII> fila;
	PII final, inicio, aux;
	bool laco;
	
	for(int i=0;i<8;i++){
		for(int j=0;j<8;j++){
			matriz[i][j] = 9999;			
		}
	}
	
	while(cin >> posInicio >> posFinal){
		laco = true;
		for(int i=0;i<8;i++){
			if(posInicio[0] == letras[i]){
				inicio = make_pair((posInicio[1] - '0')-1,i);				
			}
			if(posFinal[0] == letras[i]){
				final = make_pair((posFinal[1] - '0')-1,i);				
			}
		}
		fila.push(inicio);
		matriz[inicio.first][inicio.second] = 0;
		while(laco){
			aux = fila.front();
			
			if(aux == final){
				laco = false;
				break;
			}
			if(verifica(aux.first-2, aux.second+1)){					
				if(matriz[aux.first-2][aux.second+1] > matriz[aux.first][aux.second]){
					matriz[aux.first-2][aux.second+1] = matriz[aux.first][aux.second] + 1;
					aux.first -=2;
					aux.second +=1;
					fila.push(aux);
				} 	
			}			
			aux = fila.front();
			if(verifica(aux.first-2, aux.second-1)){							
				if(matriz[aux.first-2][aux.second-1] > matriz[aux.first][aux.second]){
					matriz[aux.first-2][aux.second-1] = matriz[aux.first][aux.second] + 1;
					aux.first -=2;
					aux.second -=1;
					fila.push(aux);
				} 	
			}	
			aux = fila.front();
			if(verifica(aux.first+2, aux.second+1)){							
				if(matriz[aux.first+2][aux.second+1] > matriz[aux.first][aux.second]){
					matriz[aux.first+2][aux.second+1] = matriz[aux.first][aux.second] + 1;
					aux.first +=2;
					aux.second +=1;
					fila.push(aux);
				} 	
			}
			aux = fila.front();
			if(verifica(aux.first+2, aux.second-1)){							
				if(matriz[aux.first+2][aux.second-1] > matriz[aux.first][aux.second]){
					matriz[aux.first+2][aux.second-1] = matriz[aux.first][aux.second] + 1;
					aux.first +=2;
					aux.second -=1;
					fila.push(aux);
				} 	
			}				
			aux = fila.front();
			if(verifica(aux.first-1, aux.second+2)){							
				if(matriz[aux.first-1][aux.second+2] > matriz[aux.first][aux.second]){
					matriz[aux.first-1][aux.second+2] = matriz[aux.first][aux.second] + 1;
					aux.first -=1;
					aux.second +=2;
					fila.push(aux);
				} 	
			}	
			aux = fila.front();
			
			if(verifica(aux.first+1, aux.second-2)){							
				if(matriz[aux.first+1][aux.second-2] > matriz[aux.first][aux.second]){
					matriz[aux.first+1][aux.second-2] = matriz[aux.first][aux.second] + 1;
					aux.first +=1;
					aux.second -=2;
					fila.push(aux);
				} 	
			}	
			aux = fila.front();
			
		}
		
	}
	
	
	
	
	
	
	
	
	return 0;
}

#include <iostream> // nome=iostream, propriedade=include(biblioteca), tempo=pré-processamento
#include <stdlib.h>
#include <time.h>

using namespace std; // nome=std, propriedade=using, tempo=pré-processamento
int n, c, f, p, nth, ntc, ff; // nome=n, propriedade=endereço, tempo=carregamento

void ComputadorJoga(int c, int f);

int main() {
    srand(time(NULL));
    ff = 20; // nome=ff, propriedade=endereço, tempo=execução
    while (true) { // nome=while, propriedade=implementação, tempo=especificação
        cout << endl << "Deve ser escolhido um numero entre 1 e "<<ff<<". Primeiro voce adivinha."<<endl;
        n = rand()%ff+1; // nome=rand, propriedade=implementação, tempo=ligação
        nth = 0;
        while (true) {
            nth++;
            cout<<"Faixa a pesar: ";
	    cin>>c>>f;
            if ((c == f) && (c == n)) {
                cout <<"Voce acertou em "<<nth<<" tentativas. "<<endl;
                break;
            }
            cout<<"Peso: ";
            if ((n >= c) && (n <= f))
		cout<<(f-c+1)*2-1<<endl; // nome=+, propriedade=semântica, tempo=compilação 
            else
		cout<<(f-c+1)*2<<endl;
        }
	cout << endl << "Agora eu adivinho. Pense em um numero entre 1 e "<<ff<<". "<<endl;
        ntc = 0;  c = 1;  f = ff;
        ComputadorJoga(c, f);
        if (ntc > nth)
	    cout<<"Voce ganhou."<<endl;
        else if (ntc < nth)
	    cout<<"Ganhei."<<endl;
        else
	    cout<<"Empate."<<endl;
    }
    return 0;
}

// nome=ComputadorJoga, propriedade=tipo de retorno da função, tempo=compilação
void ComputadorJoga(int c, int f) { // nome=int c, propriedade=tipo, tempo=compilação
    int m, p; // nome=int m, propriedade=tamanho(int), tempo=implementação
    ntc = ntc + 1;
    if (c == f)
        cout<<"A moeda falsa eh: "<<c<<"Acertei em "<<ntc<<" tentativas.";
    else {
        m = (c + f) / 2;
        cout<<"Peso da faixa: "<<c<<" "<<m<<"("<<m-c+1<<" moedas) : ";
        cin>>p;
        if(p == 2 * (m-c+1))
            c = m + 1;
        else
            f = m;
        ComputadorJoga(c, f);
    }
}

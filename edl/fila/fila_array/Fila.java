package edl.fila.fila_array;

import edl.fila.EFilaVazia;

public class Fila {
    private int i, f, n;
    private Object dados[];

    public Fila(int tam){
        n = tam;
        dados = new Object[tam];
    }

    public int tamanho(){
        return ((n-i) + f)%n;
    }

    public Object inicio(){
        if (estaVazia()) throw new EFilaVazia("Fila vazia.");
        return dados[i];
    }
    
    public boolean estaVazia(){
        return (i == f);
    }

    public void enfileirar(Object o){
        if(tamanho() == n-1){
            int n2 = n*2;
            Object[] novos_dados = new Object[n2];
            int i2 = i;
            for(int x = 0; x < n; x++){
                novos_dados[x] = dados[i2];
                i2 = (i2+1)%n;
            }
            f = tamanho();
            i = 0;
            n = n2;
            dados = novos_dados;
        }
        dados[f] = o;
        f = (f+1)%n;
    }

    public Object desenfileirar(){
        if(estaVazia()) throw new EFilaVazia("Fila vazia.");
        Object a = dados[i];
        i = (i+1)%n;
        return a;
    }
}


package edl.fila.fila_lista_ligada;

import edl.fila.EFilaVazia;
import edl.NoSimples;

public class Fila{
    private int tm;
    private NoSimples last;
    private NoSimples first;

    public Fila(){
        tm = 0;
        this.first = new NoSimples(null);
        this.last = new NoSimples(null);
    }
    public boolean estaVazio(){
        if(tm == 0) return true;
        return false;
    }
    public int tamanho(){
        return tm;
    }
    public void push(Object x){
        NoSimples e = new NoSimples(x);
        if(tm == 0){
            first = e;
        }
        else{
            last.setProximo(e);
        }
        last = e;
        tm++;
    }

    public Object pop(){
        if(tm == 0) throw new EFilaVazia("Fila vazia.");
        if(first == last){
            Object e = new Object();
            e = first.getElemento();
            first = null;
            last = null;
            return e;
        }
        Object a = new Object();
        a = first.getElemento();
        first = first.getProximo();
        tm--;
        return a;
    }
}

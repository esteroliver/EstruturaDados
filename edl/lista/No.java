package edl.lista;

public class No{
    private Object elemento;
    private No proximo;
    private No anterior;
    public No(Object elemento){
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }
    public Object getElemento(){
        return elemento;
    }
    public void setElemento(Object o){
        elemento = o;
    }
    public No getProximo(){
        return proximo;
    }
    public void setProximo(No n){
        proximo = n;
    }
    public No getAnterior(){
        return anterior;
    }
    public void setAnterior(No n){
        anterior = n;
    }
}
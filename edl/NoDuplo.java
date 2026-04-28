public class NoDuplo {

    private Object elemento;
    private NoDuplo proximo;
    private NoDuplo anterior;

    public NoDuplo(Object elemento){
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

    public NoDuplo getProximo(){
        return proximo;
    }

    public void setProximo(NoDuplo n){
        proximo = n;
    }

    public NoDuplo getAnterior(){
        return anterior;
    }

    public void setAnterior(NoDuplo n){
        anterior = n;
    }
    
}

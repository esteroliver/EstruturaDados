public class NoSimples {

    private Object elemento;
    private NoSimples proximo;

    public Object getElemento(){
        return elemento;
    }

    public void setElemento(Object o){
        elemento = o;
    }

    public NoSimples getProximo(){
        return proximo;
    }
    
    public void setProximo(NoSimples n){
        proximo = n;
    }
}

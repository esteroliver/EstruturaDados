import java.util.ArrayList;

public class No {
    private Object elemento;
    private No pai;
    private ArrayList<No> filhos = new ArrayList<No>();
    public No(){
    }
    public No(Object elemento, No pai) {
        this.elemento = elemento;
        this.pai = pai;
    }
    public Object getElemento() {
        return elemento;
    }
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    public No getPai() {
        return pai;
    }
    public void setPai(No pai) {
        this.pai = pai;
    }
    public void addChild(No o){
        filhos.add(o);
    }
    public void removeChild(No o){
        filhos.remove(o);
    }
    public Integer childsSize(){
        return filhos.size();
    }
    public ArrayList<No> children(){
        return filhos;
    }
}

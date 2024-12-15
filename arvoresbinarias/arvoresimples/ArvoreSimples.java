import java.util.ArrayList;

public class ArvoreSimples {
    private No raiz;
    private int tamanho;
    private ArrayList<No> visitas;

    public ArvoreSimples(Object o){
        raiz = new No();
        raiz.setPai(null);
        raiz.setElemento(o);
        tamanho = 1;
    }
    //métodos de acesso
    public Integer size(){
        return tamanho;
    }
    public No root(){
        return raiz;
    }
    public No parent(No o){
        return o.getPai();
    }
    public ArrayList<No> children(No o){
        return o.children();
    }
    //adicionar filho e remover filho
    public void addChild(No pai, Object ob){
        No novo_no = new No(ob, pai);
        pai.addChild(novo_no);
        tamanho++;
    }
    public void removeChild(No node){
        No pai = node.getPai();
        if(pai != null && isExternal(node)){
            pai.removeChild(node);
        }
        tamanho--;
    }
    //métodos boolean
    public boolean isRoot(No o){
        if(o == raiz) return true;
        return false;
    }
    public boolean isInternal(No o){
        if(o.childsSize() >= 1) return true;
        return false;
    }
    public boolean isExternal(No o){
        if(o.childsSize() == 0) return true;
        return false;
    }
    //altura e profundidade
    public Integer height(No o){
        if(isExternal(o)) return 0;
        else{
            Integer max = 0;
            for (No filho : o.children()) {
                Integer h = height(filho)+1;
                if(h > max) max = h;
            }
            return max;
        }
    }
    public Integer depth(No o){
        if(isRoot(o)) return 0;
        return 1 + depth(o.getPai());
    }
    //métodos para percorrer elementos da árvore
    private void preOrder_func(No o){
        visitas.add(o);
        for (No filho : o.children()) {
            preOrder_func(filho);
        }
    }
    public ArrayList<No> preOrder_print(){
        visitas = new ArrayList<No>();
        preOrder_func(raiz);
        return visitas;
    }
}
/*
 * integer size() - x
 * integer height() - x
 * boolean isEmpty() - x
 * Iterator elements() - percorrer os elementos
 * Iterator nos() - percorrer os nós
 * 
 * No root() - x
 * No parent(No) - x
 * Iterator children(No) - x
 * 
 * boolean isInternal(No) - x
 * boolrsn isExternal(No) - x
 * boolean isRoot(No) - x
 * integer depth(No) - x
 */
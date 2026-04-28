package edl.lista.lista_lista_ligada;

import edl.NoDuplo;

public class Lista{
    private NoDuplo first, last;
    private int tam;
    
    public Lista(){
        first = null;
        last = null;
        tam = 0;
    }
     public int size(){
        return tam;
     }
     public boolean isEmpty(){
        if(tam == 0) return true;
        return false;
     }
     public boolean isFirst(Object o){
        if(o == first.getElemento()) return true;
        return false;
     }
     public boolean isLast(Object o){
        if(o == last.getElemento()) return true;
        return false;
     }
     public Object first(){
        if(first != null) return first.getElemento();
        throw new EListaVazia("Lista vazia.");
     }
     public Object last(){
        if(last != null) return last.getElemento();
        throw new EListaVazia("Lista vazia.");
     }
     public Object before(Object o){
        NoDuplo aux;
        aux = first;
        while(aux.getElemento() != o){
            aux = aux.getProximo();
        }
        if(aux != null){
            return aux.getAnterior().getElemento();
        }
        throw new EListaVazia("Elemento não está na lista.");
     }
     public Object after(Object o){
        NoDuplo aux;
        aux = first;
        while(aux.getElemento() != o){
            aux = aux.getProximo();
        }
        if(aux != null){
            return aux.getProximo().getElemento();
        }
        throw new EListaVazia("Elemento não está na lista.");
     }
     public void insertFirst(Object o){
        NoDuplo novo_no = new NoDuplo(o);
        if(tam > 0){
            first.setAnterior(novo_no);
            novo_no.setProximo(first);
        }
        else{
            last = novo_no;
        }
        first = novo_no;
        tam++;
     }
     public void insertLast(Object o){
        NoDuplo novo_no = new No(o);
        if(tam > 0){
            last.setProximo(novo_no);
            novo_no.setAnterior(last);
        }
        else{
            first = novo_no;
        }
        last = novo_no;
        tam++;
     }
     //insertBefore e insertAfter só adicionam se o objeto O não for o primeiro nem o último
     //devo implementar para que adicione NoDuplo início e NoDuplo final também?
     public void insertBefore(Object o, Object p){
        NoDuplo novo_no = new No(p);
        NoDuplo aux1;
        aux1 = first;
        while(aux1.getElemento() != o){
            aux1 = aux1.getProximo();
        }
        if(aux1 != null){
            NoDuplo aux2;
            aux2 = aux1.getAnterior();
            aux2.setProximo(novo_no);
            novo_no.setAnterior(aux2);
            aux1.setAnterior(novo_no);
            novo_no.setProximo(aux1);
            tam++;
        }
     }
     public void insertAfter(Object o, Object p){
        NoDuplo novo_no = new No(p);
        NoDuplo aux1;
        aux1 = first;
        while(aux1.getElemento() != o){
            aux1 = aux1.getProximo();
        }
        if(aux1 != null){
            NoDuplo aux2;
            aux2 = aux1.getProximo();
            aux1.setProximo(novo_no);
            novo_no.setAnterior(aux1);
            aux2.setAnterior(novo_no);
            novo_no.setProximo(aux2);
            tam++;
        }
     }
     public void replaceElement(Object o, Object p){
        NoDuplo aux;
        aux = first;
        while(aux.getElemento() != o){
            aux = aux.getProximo();
        }
        if(aux != null) aux.setElemento(p);
     }
     public void swapElements(Object p, Object q){
        NoDuplo aux1;
        NoDuplo aux2;
        aux1 = first;
        aux2 = first;
        while(aux1.getElemento() != p){
            aux1 = aux1.getProximo();
        }
        while(aux2.getElemento() != q){
            aux2 = aux2.getProximo();
        }
        if(aux1 != null && aux2 != null){
            Object p1 = aux1.getElemento();
            aux1.setElemento(aux2.getElemento());
            aux2.setElemento(p1);
        }
     }
     public void remove(Object o){
        NoDuplo aux;
        aux = first;
        while(aux.getElemento() != o){
            aux = aux.getProximo();
        }
        if(aux != null){
            if(aux != first && aux != last){
                NoDuplo aux1;
                aux1 = aux.getAnterior();
                NoDuplo aux2;
                aux2 = aux.getProximo();
                aux1.setProximo(aux2);
                aux2.setAnterior(aux1);
            }
            else if(aux == first){
                NoDuplo aux1;
                aux1 = aux.getProximo();
                first = aux1;
            }
            else if(aux == last){
                NoDuplo aux1;
                aux1 = aux.getAnterior();
                last = aux1;
            }
            tam--;
        }
     }
}


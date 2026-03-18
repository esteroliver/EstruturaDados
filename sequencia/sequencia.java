class Sequencia{
    private No first, last;
    private int tam;

    public Sequencia(){
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
        No aux;
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
        No aux;
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
        No novo_no = new No(o);
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
        No novo_no = new No(o);
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
     //devo implementar para que adicione no início e no final também?
     public void insertBefore(Object o, Object p){
        No novo_no = new No(p);
        No aux1;
        aux1 = first;
        while(aux1.getElemento() != o){
            aux1 = aux1.getProximo();
        }
        if(aux1 != null){
            No aux2;
            aux2 = aux1.getAnterior();
            aux2.setProximo(novo_no);
            novo_no.setAnterior(aux2);
            aux1.setAnterior(novo_no);
            novo_no.setProximo(aux1);
            tam++;
        }
     }
     public void insertAfter(Object o, Object p){
        No novo_no = new No(p);
        No aux1;
        aux1 = first;
        while(aux1.getElemento() != o){
            aux1 = aux1.getProximo();
        }
        if(aux1 != null){
            No aux2;
            aux2 = aux1.getProximo();
            aux1.setProximo(novo_no);
            novo_no.setAnterior(aux1);
            aux2.setAnterior(novo_no);
            novo_no.setProximo(aux2);
            tam++;
        }
     }
     public void replaceElement(Object o, Object p){
        No aux;
        aux = first;
        while(aux.getElemento() != o){
            aux = aux.getProximo();
        }
        if(aux != null) aux.setElemento(p);
     }
     public void swapElements(Object p, Object q){
        No aux1;
        No aux2;
        aux1 = first;
        aux2 = first;
        while(aux1.getElemento() != p){
            aux1 = aux1.getProximo();
            if(aux1 == null) break;
        }
        while(aux2.getElemento() != q){
            aux2 = aux2.getProximo();
            if(aux2 == null) break;
        }
        if(aux1 != null && aux2 != null){
            Object p1 = aux1.getElemento();
            aux1.setElemento(aux2.getElemento());
            aux2.setElemento(p1);
        }
     }
     public void remove(Object o){
        No aux;
        aux = first;
        while(aux.getElemento() != o){
            aux = aux.getProximo();
        }
        if(aux != null){
            if(aux != first && aux != last){
                No aux1;
                aux1 = aux.getAnterior();
                No aux2;
                aux2 = aux.getProximo();
                aux1.setProximo(aux2);
                aux2.setAnterior(aux1);
            }
            else if(aux == first){
                No aux1;
                aux1 = aux.getProximo();
                first = aux1;
            }
            else if(aux == last){
                No aux1;
                aux1 = aux.getAnterior();
                last = aux1;
            }
            tam--;
        }
     }
     public void insertAtRank(Integer i, Object o){
        if(tam == 0 && i == 0){
            No novo_no = new No(o);
            first = novo_no;
            last = novo_no;
        }
        else if(i == 0){
            No novo_no = new No(o);
            novo_no.setProximo(first);
            first.setAnterior(novo_no);
            first = novo_no;
        }
        else if(i < tam){ //inserir no meio
            No novo_no = new No(o);
        
            No aux = first;
            for(int j = 0; j < i; j++){
                aux = aux.getProximo();
            }
            No aux_a = aux.getAnterior(); 

            aux_a.setProximo(novo_no);
            novo_no.setAnterior(aux_a);

            aux.setAnterior(novo_no);
            novo_no.setProximo(aux);

            if(i == 0) first = novo_no;
        }
        else if(i == tam){
            No novo_no = new No(o);

            last.setProximo(novo_no);
            novo_no.setAnterior(last);
            last = novo_no;
        }
        else throw new EForaIndice("Índice inválido.");
        tam++;
    }

    public Object removeAtRank(Integer i){
        if(i < tam && tam != 0){
            No remove = new No(null); 
            remove = first;
            for(int j = 0; j < i; j++){
                remove = remove.getProximo();
            }
            Object elem = remove.getElemento();
            No aux1 = new No(null);
            aux1 = remove.getAnterior();
            No aux2 = new No(null);
            aux2 = remove.getProximo();
            aux1.setProximo(aux2);
            aux2.setAnterior(aux1);
            tam--;
            return elem;
        }
        else throw new EForaIndice("Índice inválido ou lista vazia.");
    }

    public Object elemAtRank(Integer i){
        if(i == 0) return first.getElemento();
        else if( i < tam){
            No aux = first;
            for(int j = 0; j < i; j++){
                aux = aux.getProximo();
            }
            return aux.getElemento();
        }
        return -1;
    }

    public Object replaceAtRank(Integer i, Object o){
        if(i >= tam) throw new EForaIndice("Fora do índice da lista.");
        No aux = first;
        for(int j = 0; j < i; j++)
            aux = aux.getProximo();
        Object elem = aux.getElemento();
        aux.setElemento(o);
        return elem;
    }
}

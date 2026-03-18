package edl.lista.lista_array;

import edl.lista.*;

public class Lista {
    private Object[] array;
    private Integer tam;
    public Lista(){
        array = new Object[1];
        tam = 0;
    }
    public Integer size(){
        return tam;
    }
    public Boolean isEmpty(){
        if (tam == 0) return true;
        return false;
    }
    public Boolean isFirst(Object o){
        if (array[0] == o) return true;
        return false;
    }
    public Boolean isLast(Object o){
        if(array[tam-1] == o) return true;
        return false;
    }
    public Object first(){
        if(isEmpty()) throw new EListaVazia("Lista vazia.");
        return array[0];
    }
    public Object last(){
        if(isEmpty()) throw new EListaVazia("Lista vazia.");
        return array[tam-1];
    }
    public Object before(Object o){
        if(isEmpty()) throw new EListaVazia("Lista vazia.");
        if(tam == 1) throw new EListaVazia("Há apenas um elemento nessa lista.");
        int ant = 0;
        for(int i = 0; i < tam; i++){
            if(array[i] == o) break;
            ant = i;
        }
        if(array[ant] != null) return array[ant];
        else throw new EListaVazia("Elemento não existe.");
    }

    public Object after(Object o){
        if(isEmpty()) throw new EListaVazia("Lista vazia.");
        if(tam == 1) throw new EListaVazia("Há apenas um elemento nessa lista.");
        int post = 0;
        for(int i = tam-1; i >= 0; i--){
            post = i+1;
            if(array[i] == o) break;
        }
        if(array[post] != null) return array[post];
        else throw new EListaVazia("Elemento não existe.");
    }
    public void insertFirst(Object o){
        if(array.length == tam){
            Object aux[] = new Object[tam*2];
            for(int i = 0; i < tam; i++) 
                aux[i] = array[i];
            array = aux;
        }
        for(int i = tam; i > 0; i--)
            array[i] = array[i-1];
        array[0] = o;
        tam++;
    }
    public void insertLast(Object o){
        if(array.length == tam){
            Object aux[] = new Object[tam*2];
            for(int i = 0; i < tam; i++) 
                aux[i] = array[i];
            array = aux;
        }
        array[tam] = o;
        tam++;
    }
    public void insertBefore(Object p, Object o){ //inserir objeto P antes do objeto O
        int j = -1;
        for(int i = 0; i < tam; i++){
            if(array[i] == o) j = i;
        }
        if(j != -1){
            if(array.length == tam){
                Object aux[] = new Object[tam*2];
                for(int i = 0; i < tam; i++) 
                    aux[i] = array[i];
                array = aux;
            }
            for(int i = tam; i > j; i--){
                array[i] = array[i-1];
            }
            array[j] = p;
            tam++;
        }
    }
    public void insertAfter(Object p, Object o){
        int j = -1;
        for(int i = 0; i < tam; i++){
            if(array[i] == o) j = i;
        }
        if(j != -1){
            if(array.length == tam){
                Object aux[] = new Object[tam*2];
                for(int i = 0; i < tam; i++) 
                    aux[i] = array[i];
                array = aux;
            }
            for(int i = tam; i > j+1; i--){
                array[i] = array[i-1];
            }
            array[j+1] = p;
            tam++;
        }
    }
    public void replaceElement(Object p, Object o){ //o valor do elemento do objeto O se torna o valor do elemento do objeto P
        int j = -1;
        for(int i = 0; i < tam; i++){
            if(array[i] == o) j = i;
        }
        if(j != -1) array[j] = p;
    }
    public void swapElements(Object p, Object q){
        int a = -1;
        int b = -1;
        for(int i = 0; i < tam; i++){
            if(array[i] == p) a = i;
            if(array[i] == q) b = i;
            if(a != -1 && b != -1) break;
        }
        if(a != b && a != -1 && b != -1){
            array[a] = q;
            array[b] = p;
        }
    }
    public void remove(Object o){
        int j = -1;
        for(int i = 0; i < tam; i++){
            if(array[i] == o) j = i;
        }
        if(j != -1){
            for(int i = j; i < tam; i++){
                array[i] = array[i+1];
            }
            tam--;
        }
    }

    //MÉTODO AUXILIAR PARA TESTES
    public Object[] listar(){
        Object[] lista = new Object[tam];
        for(int i = 0; i < tam; i++){
            lista[i] = array[i];
        }
        return lista;
    }
}

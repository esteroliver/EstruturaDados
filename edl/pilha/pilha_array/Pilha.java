package edl.pilha.pilha_array;

import edl.pilha.EPilhaVazia;

class Pilha{
    private Object array[];
    private int top = -1;

    public Pilha(int tam){
        array = new Object[tam];
    }

    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        if(top == -1) return true;
        return false;
    }

    public Object objectTop(){
        if(isEmpty()) throw new EPilhaVazia("Pilha vazia.");
        return array[top];
    }

    public Object pop(){
        if(isEmpty()) throw new EPilhaVazia("Pilha vazia.");
        top--;
        return array[top + 1];
    }

    public void push(int x){
        if(array.length - 1 == top){
            Object[] aux;
            aux = (Object[]) new Object[array.length*2];
            for(int i = 0; i <= top; i++){
                aux[i] = array[i];
            }
            array = aux;
        }
        top++;
        array[top] = x;
    }
}
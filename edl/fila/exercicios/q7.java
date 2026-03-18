package edl.fila.exercicios;
class q7 {
    public static void main(String[] args){
        FilaPilha fila = new FilaPilha();
        for(int i = 0; i < 10; i++){
            fila.enfileirar(i);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(fila.desinfeleirar());
        }

    }
}

class FilaPilha {
    private Pilha p1;
    private Pilha p2;
    private Integer tam;

    public FilaPilha(){
        tam = 0;
        p1 = new Pilha(1);
        p2 = new Pilha(1);
    }
    public Integer tamanho(){
        return tam;
    }
    public Boolean estaVazio(){
        if(tam == 0) return true;
        return false;
    }
    public void enfileirar(Object o){
        p1.push(o);
        tam++;

    }
    public Object desinfeleirar(){
        if(!p2.isEmpty()){
            for(int i = 0; i < tam; i++){
                p1.push(p2.pop());
            }
        }
        for(int i = 0; i < tam; i++)
            p2.push(p1.pop());
        tam--;
        return p2.pop();
    }
}

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

    public void push(Object x){
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

class EPilhaVazia extends RuntimeException {
	public EPilhaVazia(String err) {
		super(err);
	}
}
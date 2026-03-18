package edl.fila.fila_array;

class Main{
    public static void main(String args[]){
        Fila f = new Fila(1);
        for(int i = 0; i < 5; i++){
            f.enfileirar(i+1);
        }
        System.out.println(f.tamanho());
        System.out.println(f.estaVazia());
        for(int i = 0; i < 5; i++){
            Object x = f.desenfileirar();
            System.out.println(x);
        }
    }
}
package edl.pilha.pilha_lista_ligada;

class Main{
    public static void main(String args[]){
        Pilha f = new Pilha();
        for(int i = 0; i < 5; i++){
            f.push(i+1);
        }
        System.out.println(f.tamanho());
        System.out.println(f.estaVazio());
        for(int i = 0; i < 5; i++){
            Object x = f.pop();
            System.out.println(x);
        }
    }
}
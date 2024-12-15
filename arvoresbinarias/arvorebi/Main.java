public class Main {
    public static void main(String[] args){
        ArvoreBinaria arvore = new ArvoreBinaria();
        for(int i = 1; i < 10; i++){
            arvore.inserirObjeto(i);
        }
        System.out.println(arvore.filhoEsquerda(5));
        System.out.println(arvore.filhoDireita(5));
    }
}

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        Object raiz = 1;
        ArvoreSimples arvore = new ArvoreSimples(raiz);

        for(int i = 0; i < 10; i++){
            Object filho = i;
            arvore.addChild(arvore.root(), filho);
        }
        ArrayList<No> nos = arvore.preOrder_print();
        for (No no : nos) {
            System.out.println(no.getElemento());
        }
        System.out.println(arvore.root().childsSize());
        No ultimo = new No();
        ultimo.setElemento(10);
        System.out.println(arvore.isExternal(ultimo));
        System.out.println(arvore.isRoot(ultimo));
        arvore.removeChild(ultimo);
        nos = arvore.preOrder_print();
        for (No no : nos) {
            System.out.println(no.getElemento());
        }
    }
}

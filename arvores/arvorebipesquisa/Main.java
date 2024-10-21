import java.util.ArrayList;
class Main{
    public static void main(String[] args){
        No node1 = new No(10);
        No node2 = new No(5);
        No node3 = new No(15);
        No node4 = new No(2);
        No node5 = new No(6);
        No node6 = new No(20);
        No node7 = new No(13);
        No node8 = new No(14);
        No node9 = new No(11);
        ArvoreBinaria arvore = new ArvoreBinaria(node1);
        arvore.insertNode(node2);
        arvore.insertNode(node3);
        arvore.insertNode(node4);
        arvore.insertNode(node5);
        arvore.insertNode(node6);
        arvore.insertNode(node7);
        arvore.insertNode(node8);
        arvore.insertNode(node9);
        arvore.desenharArvore();
        System.out.println("---------------------");
        arvore.removeNode(node3);
        arvore.desenharArvore();
        System.out.println("---------------------");
        arvore.removeNode(node9);
        arvore.removeNode(node8);
        arvore.desenharArvore();
        System.out.println("---------------------");
        arvore.removeNode(node4);
        arvore.desenharArvore();
        System.out.println("---------------------");
        arvore.removeNode(node2);
        arvore.desenharArvore();
    }
}
import java.util.ArrayList;
class Main{
    public static void main(String[] args){
        No node1 = new No(20);
        No node2 = new No(30);
        No node3 = new No(15);
        No node4 = new No(33);
        No node5 = new No(24);
        No node6 = new No(31);
        No node7 = new No(32);
        No node8 = new No(34);
        No node9 = new No(11);
        No node10 = new No(16);
        ArvoreBinaria arvore = new ArvoreBinaria(node1);
        arvore.insertNode(node2);
        arvore.insertNode(node3);
        arvore.insertNode(node4);
        arvore.insertNode(node5);
        arvore.insertNode(node6);
        //arvore.insertNode(node7);
        arvore.insertNode(node8);
        arvore.desenharArvore();
        System.out.println("---------------------");
        arvore.removeNode(node2);
        arvore.desenharArvore();
    }
}
class Main{
    public static void main(String[] args){
        No node1 = new No(20);
        No node2 = new No(30);
        No node3 = new No(15);
        No node4 = new No(33);
        No node5 = new No(24);
        No node6 = new No(36);

        ArvoreAvl arvore = new ArvoreAvl();

        arvore.inserirNo(node1);
        arvore.inserirNo(node2);
        arvore.inserirNo(node3);
        arvore.inserirNo(node4);
        arvore.inserirNo(node5);
        arvore.inserirNo(node6);

        arvore.desenharArvore();
    }
}
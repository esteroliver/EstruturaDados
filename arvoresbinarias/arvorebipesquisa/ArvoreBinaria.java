import java.util.ArrayList;

class ArvoreBinaria {
    private No raiz;
    private Integer tam;

    private ArrayList<No> visitas;
    private No no_inorder;

    public ArvoreBinaria(No raiz){
        tam = 1;
        this.raiz = raiz;
    }
    public Integer size(){
        return tam;
    }
    public Boolean isEmpty(){
        if(tam == 0) return true;
        return false;
    }
    public No root(){
        return raiz;
    }
    public No parent(No node){
        return node.getPai();
    }
    public No leftChild(No node){
        return node.getFilho_esquerda();
    }
    public No rightChild(No node){
        return node.getFilho_direita();
    }
    public Boolean isLeftChild(No no){
        if(no.getPai().getFilho_esquerda() == no) return true;
        return false;
    }
    public Boolean isRightChild(No no){
        if(no.getPai().getFilho_direita() == no) return true;
        return false;
    }
    public Boolean isExternal(No node){
        if(node.getFilho_direita() == null && node.getFilho_esquerda() == null) return true;
        return false;
    }
    public Boolean isInternal(No node){
        if(!isExternal(node)) return true;
        return false;
    }
    public Boolean isRoot(No node){
        if(node == raiz) return true;
        return false;
    }
    public Boolean hasLeftChild(No node){
        if(node.getFilho_esquerda() != null) return true;
        return false;
    }
    public Boolean hasRightChild(No node){
        if(node.getFilho_direita() != null) return true;
        return false;
    }
    public Integer height(No o){
        if(isExternal(o)) return 0;
        else{
            Integer max = 0;
            Integer h = 0;
            if(o.getFilho_direita() != null) h = height(o.getFilho_direita())+1;
            Integer h2 = 0;
            if(o.getFilho_esquerda() != null) h2 = height(o.getFilho_esquerda())+1;
            if(h > max) max = h;
            if(h2 > max) max = h2;
            return max;
        }
    }
    public Integer depth(No o){
        if(o == raiz) return 0;
        return 1 + depth(o.getPai());
    }
    public void insertNode(No new_node){
        No node = raiz;
        while(new_node.getPai() == null){
            if(new_node.getElemento() > node.getElemento()){
                if(node.getFilho_direita() == null){
                    node.setFilho_direita(new_node);
                    new_node.setPai(node);
                }
                else
                    node = node.getFilho_direita();
            }
            else if(new_node.getElemento() < node.getElemento()){
                if(node.getFilho_esquerda() == null){
                    node.setFilho_esquerda(new_node);
                    new_node.setPai(node);
                }
                else
                    node = node.getFilho_esquerda();
            }
        }
        tam++;
    }
    public Boolean searchNode(No node_search, No node){
        if(isExternal(node_search)) return true;
        while(node != node_search && node != null){
            if(node_search.getElemento() > node.getElemento()){
                node = node.getFilho_direita();
            }
            else if(node_search.getElemento() < node.getElemento()){
                node = node.getFilho_esquerda();
            }
        }
        if(node == null) return false;
        return true;
    }
    public void removeNode(No node_removed){
        //nó sem filhos
        if(isExternal(node_removed)){
            if(isLeftChild(node_removed)) node_removed.getPai().setFilho_esquerda(null);
            else node_removed.getPai().setFilho_direita(null); 
            node_removed = null;
            tam--;
        }
        //nó com um filho
        else if(node_removed.oneChild()){
            No node_pai = node_removed.getPai();
            if(isLeftChild(node_removed)){
                if(node_removed.getFilho_direita() != null){
                    if(node_removed != raiz) node_pai.setFilho_esquerda(node_removed.getFilho_direita());
                    node_removed.getFilho_direita().setPai(node_pai);
                    if(node_removed == raiz) raiz = node_removed.getFilho_direita();
                }
                else{
                    if(node_removed != raiz) node_pai.setFilho_esquerda(node_removed.getFilho_esquerda());
                    node_removed.getFilho_esquerda().setPai(node_pai);
                    if(node_removed == raiz) raiz = node_removed.getFilho_esquerda();
                }
            }
            else{
                if(node_removed.getFilho_direita() != null){
                    if(node_removed != raiz) node_pai.setFilho_direita(node_removed.getFilho_direita());
                    node_removed.getFilho_direita().setPai(node_pai);
                    if(node_removed == raiz) raiz = node_removed.getFilho_direita();
                }
                else{
                    if(node_removed != raiz) node_pai.setFilho_direita(node_removed.getFilho_esquerda());
                    node_removed.getFilho_esquerda().setPai(node_pai);
                    if(node_removed == raiz) raiz = node_removed.getFilho_esquerda();
                }
            }
            tam--;
        }
        //nó com dois filhos
        else{
            No node_pai = node_removed.getPai();
            No node_sub;
            if(!hasLeftChild(node_removed.getFilho_direita())){
                node_sub = node_removed.getFilho_direita();
                if(hasRightChild(node_removed.getFilho_direita())){
                    node_sub.setFilho_direita(node_removed.getFilho_direita().getFilho_direita());
                    node_removed.getFilho_direita().getFilho_direita().setPai(node_sub);
                }
            }
            else{
                No node_filho_direito = new No();
                leftChildLeaf(node_removed.getFilho_direita());
                node_sub = no_inorder;
                if(hasRightChild(node_sub)){
                    node_filho_direito = node_sub.getFilho_direita();
                    node_sub.getPai().setFilho_esquerda(node_filho_direito);
                    node_filho_direito.setPai(node_sub.getPai());
                }
                else{
                    node_sub.getPai().setFilho_esquerda(null);
                }
                node_sub.setFilho_direita(node_removed.getFilho_direita());
                node_removed.getFilho_direita().setPai(node_sub);
            }
            node_sub.setFilho_esquerda(node_removed.getFilho_esquerda());
            node_removed.getFilho_esquerda().setPai(node_sub);
            if(node_removed != raiz){
                if(isLeftChild(node_removed)){
                    node_pai.setFilho_esquerda(node_sub);
                }
                else{
                    node_pai.setFilho_direita(node_sub);
                }
            }
            if(node_removed != raiz){
                node_sub.setPai(node_pai);
            }
            else{
                raiz = node_sub;
            }
            node_removed.setPai(null);
            tam--;
        }
    }
    private void leftChildLeaf(No o){
        if(isInternal(o) && o.getFilho_esquerda() != null){
            leftChildLeaf(o.getFilho_esquerda());
            return;
        }
        if((isLeftChild(o) && isExternal(o)) || (isLeftChild(o) && hasRightChild(o) && !hasLeftChild(o))){
            no_inorder = o;
            return;
        }
        if(isInternal(o) && o.getFilho_direita() != null)
            leftChildLeaf(o.getFilho_direita());
    }
    //visitas
    private void preOrder_func(No o){
        visitas.add(o);
        if(o.getFilho_esquerda() != null) preOrder_func(o.getFilho_esquerda());
        if(o.getFilho_direita() != null) preOrder_func(o.getFilho_direita());
    }
    public ArrayList<No> preOrder_print(){
        visitas = new ArrayList<No>();
        preOrder_func(raiz);
        return visitas;
    } 
    private void posOrder_func(No o){
        if(o.getFilho_esquerda() != null) posOrder_func(o.getFilho_esquerda());
        if(o.getFilho_direita() != null) posOrder_func(o.getFilho_direita());
        visitas.add(o);
    }
    public ArrayList<No> posOrder_print(){
        visitas = new ArrayList<No>();
        posOrder_func(raiz);
        return visitas;
    }
    private void inOrder_func(No o){
        if(isInternal(o) && o.getFilho_esquerda() != null)
            inOrder_func(o.getFilho_esquerda());
        visitas.add(o);
        if(isInternal(o) && o.getFilho_direita() != null)
            inOrder_func(o.getFilho_direita());
    }
    public ArrayList<No> inOrder_print(){
        visitas = new ArrayList<No>();
        inOrder_func(raiz);
        return visitas;
    }

    //DESENHAR ÁRVORE
        //matriz: altura max por tamanho
    public void desenharArvore(){
        Integer altura = height(raiz);
        Integer[][] matriz = new Integer[altura+1][size()];
        ArrayList<No> nodes = inOrder_print();
        Integer k = 0;
        for(No node : nodes){
            matriz[depth(node)][k] = node.getElemento();
            k++;
            
        }
        for(int i = 0; i <= altura; i++){
            for(int j = 0; j < size(); j++){
                Integer print;
                if(matriz[i][j] == null)
                    System.out.print(" ");
                
                else
                    System.out.print(matriz[i][j]);
                
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
class ArvoreAvl {
    private No raiz;
    private Integer tamanho;

    public ArvoreAvl(){
        tamanho = 0;
        raiz = new No();
    }

    public Integer tamanho(){
        return tamanho;
    }

    public Boolean estaVazio(){
        if (tamanho == 0) return true;
        return false;
    }

    public No raiz(){
        return raiz;
    }

    public No pai(No node){
        return node.getPai();
    }

    public No filhoEsquerdo(No node){
        return node.getFilho_esquerda();
    }

    public No filhoDireita(No node){
        return node.getFilho_direita();
    }

    public Boolean umFilhoEsquerdo(No node){
        if(node.getPai().getFilho_esquerda() == node) return true;
        return false;
    }

    public Boolean umFilhoDireita(No node){
        if(node.getPai().getFilho_direita() == node) return true;
        return false;
    }

    public Boolean temFilhoEsquerdo(No node){
        if(node.getFilho_esquerda() != null) return true;
        return false;
    }

    public Boolean temFilhoDireito(No node){
        if(node.getFilho_direita() != null) return true;
        return false;
    }

    public Boolean noExterno(No node){
        if(node.getFilho_direita() == null && node.getFilho_esquerda() == null) return true;
        return false;
    }

    public Boolean noInterno(No node){
        if(!noExterno(node)) return true;
        return false;
    }

    public Boolean noRaiz(No node){
        if(node == raiz) return true;
        return false;
    }

    public Integer altura(No node){
        if(noExterno(node) || node == null) return 0;
        else{
            Integer h_e = 0;
            Integer h_d = 0;
            Integer h = 0;
            h_e = altura(node.getFilho_esquerda()) + 1;
            h_d = altura(node.getFilho_direita()) + 1;
            h = h_e;
            if(h_d > h_e) h = h_d;
            return h;
        }
    }

    public Integer profundidade(No node){
        if(node == raiz) return 0;
        return profundidade(node.getPai()) + 1;
    }

    public Void inserirNo(No node){
        if(estaVazio()){
            raiz = node;
            tamanho++;
            raiz.setBalanceamento(0);
        }
        else{
            No aux = raiz;
            while(node.getPai() == null){
                if(node.getElemento() > aux.getElemento()){
                    Integer fb = aux.getBalanceamento() - 1;
                    aux.setBalanceamento(fb);
                    if(temFilhoDireito(aux)){
                        aux = aux.getFilho_direita();
                    }
                    else{
                        aux.setFilho_direita(node);
                        node.setPai(aux);
                        node.setBalanceamento(0);
                    }
                }
                if(node.getElemento() < aux.getElemento()){
                    Integer fb = aux.getBalanceamento() + 1;
                    aux.setBalanceamento(fb);
                    if(temFilhoEsquerdo(aux)){
                        aux = aux.getFilho_esquerda();
                    }
                    else{
                        aux.setFilho_esquerda(node);
                        node.setPai(aux);
                        node.setBalanceamento(0);
                    }
                }
            }
            tamanho++;
        }
        //verificar balanceamento
    }
}

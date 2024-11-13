import java.util.ArrayList;

class ArvoreAvl {
    private No raiz;
    private No desbalanceado;
    private Integer tamanho;

    private ArrayList<No> nos;

    public ArvoreAvl(){
        tamanho = 0;
        raiz = new No();
        desbalanceado = new No();
        desbalanceado.setBalanceamento(null);
    }

    private void balancearInsercao(No node){
        No aux = node.getPai();
        if(umFilhoDireita(node)){
                while(aux != null){
                    Integer fb = aux.getBalanceamento() - 1;
                    aux.setBalanceamento(fb);
                    if(aux.getBalanceamento() == -2 || aux.getBalanceamento() == 2) desbalanceado = aux;
                    if(aux.getBalanceamento() == 0) break;
                    aux = aux.getPai();
                }
            }
        else{
            while(aux != null){
                Integer fb = aux.getBalanceamento() + 1;
                aux.setBalanceamento(fb);
                if(aux.getBalanceamento() == -2 || aux.getBalanceamento() == 2) desbalanceado = aux;
                if(aux.getBalanceamento() == 0) break;
                aux = aux.getPai();
            }
        }
    }

    private void rotacaoEsquerda(No node){
        No novo_pai = node.getFilho_direita();
        novo_pai.setPai(node.getPai());
        if(novo_pai.getFilho_esquerda() == null)
            novo_pai.setFilho_esquerda(node);
        else{
            node.setFilho_direita(novo_pai.getFilho_esquerda());
            novo_pai.getFilho_esquerda().setPai(node);
            novo_pai.setFilho_esquerda(node);
        }
        node.setPai(novo_pai);
        if(node == raiz) raiz = novo_pai;
    }

    private void rotacaoDireita(No node){
        No novo_pai = node.getFilho_esquerda();
        novo_pai.setPai(node.getPai());
        if(novo_pai.getFilho_direita() == null)
            novo_pai.setFilho_direita(node);
        else{
            node.setFilho_esquerda(novo_pai.getFilho_direita());
            novo_pai.getFilho_direita().setPai(node);
            novo_pai.setFilho_direita(node);
        }
        node.setPai(novo_pai);
        if(node == raiz) raiz = novo_pai;
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
        if(noExterno(node)) return 0;
        else{
            Integer h_e = 0;
            Integer h_d = 0;
            Integer h = 0;
            if(node.getFilho_esquerda() != null) h_e = altura(node.getFilho_esquerda()) + 1;
            if(node.getFilho_direita() != null) h_d = altura(node.getFilho_direita()) + 1;
            h = h_e;
            if(h_d > h_e) h = h_d;
            return h;
        }
    }

    public Integer profundidade(No node){
        if(node == raiz) return 0;
        return profundidade(node.getPai()) + 1;
    }

    public void inserirNo(No node){
        No aux = raiz;
        if(estaVazio()){
            raiz = node;
            tamanho++;
        }
        else{
            while(node.getPai() == null){
                if(node.getElemento() > aux.getElemento()){
                    if(temFilhoDireito(aux)){
                        aux = aux.getFilho_direita();
                    }
                    else{
                        aux.setFilho_direita(node);
                        node.setPai(aux);
                    }
                }
                if(node.getElemento() < aux.getElemento()){
                     if(temFilhoEsquerdo(aux)){
                        aux = aux.getFilho_esquerda();
                    }
                    else{
                        aux.setFilho_esquerda(node);
                        node.setPai(aux);
                    }
                }
            }
            tamanho++;
            balancearInsercao(node);
        }

        if(desbalanceado.getBalanceamento() != null){
            if(desbalanceado.getBalanceamento() == 2){
                if(desbalanceado.getFilho_esquerda().getBalanceamento() == -1){
                    rotacaoEsquerda(desbalanceado.getFilho_esquerda());
                    balancearInsercao(desbalanceado.getFilho_esquerda());
                }
                rotacaoDireita(desbalanceado);
                balancearInsercao(desbalanceado);
            }
            else{
                if(desbalanceado.getFilho_direita().getBalanceamento() == 1){
                    rotacaoDireita(desbalanceado.getFilho_direita());
                    balancearInsercao(desbalanceado.getFilho_direita());
                }
                rotacaoEsquerda(desbalanceado);
                balancearInsercao(desbalanceado);
            }
            desbalanceado = null;
        }
    }

    private void inOrderNos(No node){
        if(noInterno(node) && node.getFilho_esquerda() != null)
            inOrderNos(node.getFilho_esquerda());
        nos.add(node);
        if(noInterno(node) && node.getFilho_direita() != null)
            inOrderNos(node.getFilho_direita());
    }

    private ArrayList<No> inOrderNosArray(){
        nos = new ArrayList<No>();
        inOrderNos(raiz);
        return nos;
    }

    public void desenharArvore(){
        Integer altura = altura(raiz);
        Integer[][] matriz = new Integer[altura+1][tamanho()];
        ArrayList<No> nodes = inOrderNosArray();
        Integer k = 0;
        for(No node : nodes){
            matriz[profundidade(node)][k] = node.getElemento();
            k++;  
        }
        for(int i = 0; i <= altura; i++){
            for(int j = 0; j < tamanho(); j++){
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

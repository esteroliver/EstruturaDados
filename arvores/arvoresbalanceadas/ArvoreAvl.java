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

    private void calcularFbInsercao(No node){
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

    private void calcularFbRemocao(No node){
        No aux = node.getPai();
        if(umFilhoDireita(node)){
            while(aux != null){
                Integer fb = aux.getBalanceamento() + 1;
                aux.setBalanceamento(fb);
                if(aux.getBalanceamento() == -2 || aux.getBalanceamento() == 2) desbalanceado = aux;
                if(aux.getBalanceamento() != 0) break;
                aux = aux.getPai();
            }
        }
        else{
            while(aux != null){
                Integer fb = aux.getBalanceamento() - 1;
                aux.setBalanceamento(fb);
                if(aux.getBalanceamento() == -2 || aux.getBalanceamento() == 2) desbalanceado = aux;
                if(aux.getBalanceamento() != 0) break;
                aux = aux.getPai();
            }
        }
    }

    private void rotacaoDireita(No node){
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
        //atualizando FB
        Integer novo_fb = node.getBalanceamento() - 1 - (Math.max(novo_pai.getBalanceamento(), 0));
        node.setBalanceamento(novo_fb);
        novo_fb = novo_pai.getBalanceamento() - 1 + (Math.min(node.getBalanceamento(), 0));
        novo_pai.setBalanceamento(novo_fb);
    }

    private void rotacaoEsquerda(No node){
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
        //atualizando FB
        Integer novo_fb = node.getBalanceamento() + 1 - (Math.min(novo_pai.getBalanceamento(), 0));
        node.setBalanceamento(novo_fb);
        novo_fb = novo_pai.getBalanceamento() + 1 + (Math.max(node.getBalanceamento(), 0));
        novo_pai.setBalanceamento(novo_fb);
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
            calcularFbInsercao(node);
        }

        if(desbalanceado.getBalanceamento() != null){
            if(desbalanceado.getBalanceamento() == 2){
                if(desbalanceado.getFilho_esquerda().getBalanceamento() == -1){
                    rotacaoEsquerda(desbalanceado.getFilho_esquerda());
                }
                rotacaoDireita(desbalanceado);
            }
            else{
                if(desbalanceado.getFilho_direita().getBalanceamento() == 1){
                    rotacaoDireita(desbalanceado.getFilho_direita());
                }
                rotacaoEsquerda(desbalanceado);
            }
        }
    }

    public void removerNo(No node){
        if(noExterno(node)){
            if(umFilhoEsquerdo(node)){
                node.getPai().setFilho_esquerda(null);
                calcularFbRemocao(node.getPai());
            }
            else if(umFilhoDireita(node)){
                node.getPai().setFilho_direita(null);
                calcularFbRemocao(node.getPai());
            }
            node = null;
            tamanho--;
        }
        else if(node.oneChild()){
            No node_pai = node.getPai();
            if(node_pai != null){
                No node_filho;
                if(umFilhoEsquerdo(node)){
                    if(temFilhoEsquerdo(node)){
                        node_filho = node.getFilho_esquerda();
                    }
                    else{
                        node_filho = node.getFilho_direita();
                    }
                    node_pai.setFilho_esquerda(node_filho);
                    node_filho.setPai(node_pai);
                }
                else{
                    if(temFilhoEsquerdo(node)){
                        node_filho = node.getFilho_esquerda();
                    }
                    else{
                        node_filho = node.getFilho_direita();
                    }
                    node_pai.setFilho_direita(node_filho);
                    node_filho.setPai(node_pai);
                }
                calcularFbRemocao(node_filho);
            }
            else{
                if(temFilhoDireito(node)){
                    node.getFilho_direita().setPai(null);
                    raiz = node.getFilho_direita();
                    node.setFilho_direita(null);
                    node = null;
                }
                else{
                    node.getFilho_esquerda().setPai(null);
                    raiz = node.getFilho_esquerda();
                    node.setFilho_esquerda(null);
                    node = null;
                }
                calcularFbRemocao(raiz);
            }
            tamanho--;
        }
        else{
            if(node != raiz){
                No node_pai = node.getPai();
                No node_sub = new No();
                if(!temFilhoEsquerdo(node.getFilho_direita())){
                    node_sub = node.getFilho_direita();
                    if(!temFilhoDireito(node_sub)){
                        node_sub.setFilho_direita(null);
                    }
                }
                else{
                    noSub(node.getFilho_direita(), node_sub);
                    node_sub.setFilho_direita(node.getFilho_direita());
                } 
                node_sub.setFilho_esquerda(node.getFilho_esquerda());  
                //System.out.println(node_sub.getPai().getElemento());
                calcularFbRemocao(node_sub);
                node_sub.setPai(node_pai);  
                if(umFilhoDireita(node)){
                    node_pai.setFilho_direita(node_sub);
                }
                else{
                    node_pai.setFilho_esquerda(node_sub);
                }
                
            }
            else{
                No node_sub = new No();
                if(!temFilhoEsquerdo(node.getFilho_direita())){
                    node_sub = node.getFilho_direita();
                    if(!temFilhoDireito(node_sub)){
                        node_sub.setFilho_direita(null);
                    }
                }
                else{
                    noSub(node.getFilho_direita(), node_sub);
                    node_sub.setFilho_direita(node.getFilho_direita());
                }
                node_sub.setFilho_esquerda(node.getFilho_esquerda());
                calcularFbRemocao(node_sub);
                node_sub.setPai(null);
                raiz = node_sub;
            }
            tamanho--;
        }

        if(desbalanceado.getBalanceamento() != null){
            if(desbalanceado.getBalanceamento() == 2){
                if(desbalanceado.getFilho_esquerda().getBalanceamento() == -1){
                    rotacaoEsquerda(desbalanceado.getFilho_esquerda());
                    calcularFbRemocao(desbalanceado.getFilho_esquerda());
                }
                rotacaoDireita(desbalanceado);
                calcularFbRemocao(desbalanceado);
            }
            else{
                if(desbalanceado.getFilho_direita().getBalanceamento() == 1){
                    rotacaoDireita(desbalanceado.getFilho_direita());
                    calcularFbRemocao(desbalanceado.getFilho_direita());
                }
                rotacaoEsquerda(desbalanceado);
                calcularFbRemocao(desbalanceado);
            }
            desbalanceado.setBalanceamento(null);
        }
    }

    private void noSub(No node, No node_sub){
        if(noInterno(node) && node.getFilho_esquerda() != null){
            noSub(node.getFilho_esquerda(), node_sub);
            return;
        }
        if((umFilhoEsquerdo(node) && noExterno(node)) || (umFilhoEsquerdo(node) && temFilhoDireito(node) && !temFilhoEsquerdo(node))){
            node_sub = node;
            return;
        }
        /*
        if(isInternal(o) && o.getFilho_direita() != null)
            leftChildLeaf(o.getFilho_direita());
         */
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

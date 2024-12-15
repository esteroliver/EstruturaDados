package arvore_rubro_negra;

public class ArvoreRubroNegra {
    private No raiz;
    private Integer tamanho;

    public ArvoreRubroNegra(){
        tamanho = 0;
        raiz = new No();
    }

    public void inserirNo(No o){
        if(tamanho == 0){
            raiz = o;
            raiz.setCor(Cor.NEGRO);
        }
        else{
            No aux = raiz;
            while(o.getPai() == null){
                // se o for menor que aux, será filho esquerdo
                if(o.getElemento() < aux.getElemento()){
                    if(aux.getFilho_esquerda() == null){
                    //verificações para adicionar
                        aux.setFilho_esquerda(o);
                        o.setPai(aux);

                        //pai sendo rubro
                        if(aux.getCor() == Cor.RUBRO){
                            //pai de aux tem dois filhos
                            No avo = aux.getPai();
                            if(aux.getPai().temDoisFilhos()){
                                No filho_d_avo = avo.getFilho_direita();
                                No filho_e_avo = avo.getFilho_esquerda();
                                filho_d_avo.setCor(Cor.NEGRO);
                                filho_e_avo.setCor(Cor.NEGRO);
                                if(avo != raiz){
                                    avo.setCor(Cor.RUBRO);
                                }
                            }
                            else{
                                //rotacao simples a direita
                                if(avo.getFilho_esquerda() == aux){
                                    No novo_pai = aux;
                                    novo_pai.setPai(avo.getPai());
                                    if(novo_pai.getFilho_direita() == null){
                                        novo_pai.setFilho_direita(avo);
                                    }
                                    else{
                                        avo.setFilho_esquerda(novo_pai.getFilho_direita());
                                        novo_pai.getFilho_direita().setPai(avo);
                                        novo_pai.setFilho_direita(avo);
                                    }
                                    avo.setPai(novo_pai);
                                    if(avo == raiz) raiz = novo_pai;

                                    avo.setCor(Cor.RUBRO);
                                    novo_pai.setCor(Cor.NEGRO);
                                }
                                //rotacao dupla a esquerda
                                else{
                                    // o aux deve rotacionar para a direita
                                    No novo_pai = o;
                                    novo_pai.setPai(avo);
                                    novo_pai.setFilho_direita(aux);
                                    aux.setPai(novo_pai);
                                    
                                    // o avô deve rotacionar para a esquerda
                                    novo_pai.setPai(avo.getPai());
                                    novo_pai.setFilho_esquerda(avo);
                                    avo.setPai(novo_pai);
                                    
                                    if(avo == raiz) raiz = novo_pai;

                                    novo_pai.setCor(Cor.NEGRO);
                                    avo.setCor(Cor.RUBRO);
                                }
                            }
                        }
                    }
                    else{
                        aux = aux.getFilho_esquerda();
                    }
                }
                // se o for maior que aux, será filho direito
                else{
                    if(aux.getFilho_direita() == null){
                        aux.setFilho_direita(o);
                        o.setPai(aux);

                        //pai sendo rubro
                        if(aux.getCor() == Cor.RUBRO){
                            //pai de aux tem dois filhos
                            No avo = aux.getPai();
                            if(aux.getPai().temDoisFilhos()){
                                No filho_d_avo = avo.getFilho_direita();
                                No filho_e_avo = avo.getFilho_esquerda();
                                filho_d_avo.setCor(Cor.NEGRO);
                                filho_e_avo.setCor(Cor.NEGRO);
                                if(avo != raiz){
                                    avo.setCor(Cor.RUBRO);
                                }
                            }
                            else{
                                //rotacao simples a esquerda
                                if(avo.getFilho_direita() == aux){
                                    No novo_pai = aux;
                                    novo_pai.setPai(avo.getPai());
                                    if(novo_pai.getFilho_esquerda() == null){
                                        novo_pai.setFilho_esquerda(avo);
                                    }
                                    else{
                                        avo.setFilho_direita(novo_pai.getFilho_esquerda());
                                        novo_pai.getFilho_esquerda().setPai(avo);
                                        novo_pai.setFilho_esquerda(avo);
                                    }
                                    avo.setPai(novo_pai);
                                    if(avo == raiz) raiz = novo_pai;

                                    avo.setCor(Cor.RUBRO);
                                    novo_pai.setCor(Cor.NEGRO);
                                }
                                //rotacao dupla a direita
                                else{
                                    // o aux vai rotacionar para a esquerda
                                    No novo_pai = o;
                                    novo_pai.setPai(avo);
                                    novo_pai.setFilho_esquerda(aux);
                                    aux.setPai(novo_pai);

                                    // o avô vai rotacionar para a direita
                                    novo_pai.setPai(avo.getPai());
                                    novo_pai.setFilho_direita(avo);
                                    avo.setPai(novo_pai);

                                    if(avo == raiz) raiz = novo_pai;

                                    novo_pai.setCor(Cor.NEGRO);
                                    avo.setCor(Cor.RUBRO);
                                }
                            }
                        }
                    }
                    else{
                        aux = aux.getFilho_direita();
                    }
                }
            }
        }
        tamanho++;
    }
}

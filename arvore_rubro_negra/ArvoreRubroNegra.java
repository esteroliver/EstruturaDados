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
                        aux.setFilho_esquerda(o);
                        o.setPai(aux);
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

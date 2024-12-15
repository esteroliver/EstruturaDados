package arvore_rubro_negra;

public class No {
    private Integer elemento;
    private No pai;
    private No filho_direita;
    private No filho_esquerda;
    private Cor cor;
    public No() {
        cor = Cor.RUBRO;
        elemento = null;
        pai = null;
        filho_direita = null;
        filho_esquerda = null;
    }
    public No(Integer elemento) {
        cor = Cor.RUBRO;
        this.elemento = elemento;
        pai = null;
        filho_direita = null;
        filho_esquerda = null;
    }
    public Integer getElemento() {
        return elemento;
    }
    public void setElemento(Integer elemento) {
        this.elemento = elemento;
    }
    public No getPai() {
        return pai;
    }
    public void setPai(No pai) {
        this.pai = pai;
    }
    public No getFilho_direita() {
        return filho_direita;
    }
    public void setFilho_direita(No filho_direita) {
        this.filho_direita = filho_direita;
    }
    public No getFilho_esquerda() {
        return filho_esquerda;
    }
    public void setFilho_esquerda(No filho_esquerda) {
        this.filho_esquerda = filho_esquerda;
    }
    public Cor getCor() {
        return cor;
    }
    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Boolean temDoisFilhos(){
        if(filho_direita != null && filho_esquerda != null) return true;
        return false;
    }
}

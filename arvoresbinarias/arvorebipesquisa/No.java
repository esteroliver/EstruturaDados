class No {
    private Integer elemento;
    private No pai;
    private No filho_direita;
    private No filho_esquerda;
    public No(){

    }
    public No(Integer elemento) {
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
    public Boolean oneChild(){
        if((filho_direita == null && filho_esquerda != null) || (filho_direita != null && filho_esquerda == null)){
            return true;
        }
        return false;
    }
}

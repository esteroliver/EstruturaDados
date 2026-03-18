package edl.fila.exercicios;
class q8 {
    public static void main(String[] args){
        PilhaFila pilha = new PilhaFila();
        for(int i = 0; i < 10; i++){
            pilha.inserir(i);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(pilha.apagar());
        }
    }
}

class PilhaFila{
    private Fila f1;
    private Fila f2;
    private Integer tam;

    public PilhaFila(){
        tam = 0;
        f1 = new Fila(1);
        f2 = new Fila(1);
    }
    public Integer tamanho(){
        return tam;
    }
    public Boolean estaVazio(){
        if(tam == 0) return true;
        return false;
    }
    public void inserir(Object o){
        f1.enfileirar(o);
        tam++;
    }
    public Object apagar(){
        Integer tam1 = tam;
        if(!f2.estaVazia()){
            for(int i = 0; i < tam; i++){
                f1.enfileirar(f2.desenfileirar());
            }
        }
        while(tam1 != 1){
            f2.enfileirar(f1.desenfileirar());
            tam1--;
        }
        tam--;
        return f1.desenfileirar();
    }
}

class Fila {
    private int i, f, n;
    private Object dados[];

    public Fila(int tam){
        n = tam;
        dados = new Object[tam];
    }

    public int tamanho(){
        return ((n-i) + f)%n;
    }

    public Object inicio(){
        if (estaVazia()) throw new EFilaVazia("Fila vazia.");
        return dados[i];
    }
    
    public boolean estaVazia(){
        return (i == f);
    }

    public void enfileirar(Object o){
        if(tamanho() == n-1){
            int n2 = n*2;
            Object[] novos_dados = new Object[n2];
            int i2 = i;
            for(int x = 0; x < n; x++){
                novos_dados[x] = dados[i2];
                i2 = (i2+1)%n;
            }
            f = tamanho();
            i = 0;
            n = n2;
            dados = novos_dados;
        }
        dados[f] = o;
        f = (f+1)%n;
    }

    public Object desenfileirar(){
        if(estaVazia()) throw new EFilaVazia("Fila vazia.");
        Object a = dados[i];
        i = (i+1)%n;
        return a;
    }
}

class EFilaVazia extends RuntimeException {
	public EFilaVazia(String err) {
		super(err);
	}
}
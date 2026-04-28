package edl.vetor.vetor_array;

public class Vetor{
    private Object[] array;
    private int tam = 0;
    public Vetor(){
        array = new Object[1];
    }
    public int size(){
        return tam;
    }
    public boolean isEmpty(){
        if(tam == 0) return true;
        return false;
    }
    /**
     * insere o objeto o no índice i
     */
    public void insertAtRank(int j, Object o){
        if (array.length == tam){
            Object[] aux = new Object[tam*2];
            for(int i = 0; i < tam; i++){
                aux[i] = array[i];
            }
            array = aux;
        }
        for(int i = tam; i > j; i--){
            array[i] = array[i-1];
        }
        array[j] = o;
        tam++;
    }
    /**
     * remove o elemento que está no índice i
     */
    public Object removeAtRank(int i){
        if(array[i] == null){
            throw new EForaIndice("Não há elemento nesse índice para ser removido.");
        }
        Object elem = array[i];
        for(int j = i; j < tam-1; j++){
            array[j] = array[j+1];
        }
        tam--;
        return elem;
    }
    /**
     * substitui o elemento do índice i pelo objeto o
     */
    public Object replaceAtRank(int i, Object o){
        if(array[i] == null){
            throw new EForaIndice("Não há elemento nesse índice para ser substituído.");
        }
        Object elem = array[i];
        array[i] = o;
        return elem;
    } 
    /**
     * retorna o elemento que está no índice i
     */
    public Object elemAtRank(int i){
        if(array[i] == null){
            throw new EForaIndice("Não há elemento nesse índice.");
        }
        return array[i];
    }
}


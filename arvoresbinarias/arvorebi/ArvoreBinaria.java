public class ArvoreBinaria{
    private Integer tam;
    private Integer[] array;
    private Integer indice;

    //filho da esquerda = i * 2
    //filho da direita = i * 2 + 1

    public ArvoreBinaria(){
        tam = 0;
        array = new Integer[2];
        indice = 1;
    }

    private void aumentarCapacidade(){
        Integer[] aux = new Integer[(tam + 1) *2];
        for(int i = 0; i < tam + 1; i++){
            aux[i] = array[i];
        }
        array = aux;
    }

    public void inserirObjeto(Integer ob){
        if(tam == array.length) aumentarCapacidade();
        array[indice] = ob;
        tam++;
        indice++;
    }

    public Integer filhoEsquerda(Integer ob){
        for(int i = 1; i < tam; i++){
            if(ob == array[i]){
                if(array[i*2] != null) return array[i*2];
            }
        }
        return -1;
    }

    public Integer filhoDireita(Integer ob){
        for(int i = 1; i < tam; i++){
            if(ob == array[i]){
                if(array[i*2+1] != null) return array[i*2+1];
            }
        }
        return -1;
    }

    public boolean temFilhoEsquerdo(Integer ob){
        for(int i = 1; i < tam; i++){
            if(ob == array[i]){
                if(array[i*2] != null) return true;
            }
        }
        return false;
    }

    public boolean temFilhoDireito(Integer ob){
        for(int i = 1; i < tam; i++){
            if(ob == array[i]){
                if(array[i*2+1] != null) return true;
            }
        }
        return false;
    }
}
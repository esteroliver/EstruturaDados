package edl.pilha.pilha_array;

class Main{
    public static void main(String args[]){
        Pilha f = new Pilha(1);
        System.out.println(f.isEmpty());
        for(int i = 0; i < 5; i++){
            f.push(i+2);
        }
        System.out.println(f.isEmpty());
        //System.out.println(f.objetoTopo());
        System.out.println(f.size());
        // for(int i = 0; i < 5; i++){
        //     Object x = f.pop();
        //     System.out.println(x);
        // }
    } 
}
package edl.vetor.vetor_lista_ligada;

public class Main{
    public static void main(String args[]){
        Vetor v = new Vetor();
        for(int i = 0; i < 5; i++){
            v.insertAtRank(0, i+2);
        }
        for(int i = 0; i < v.size(); i++){
            System.out.println(v.elemAtRank(i));
        }
        System.out.println("------------------");
        v.removeAtRank(2);
        for(int i = 0; i < v.size(); i++){
            System.out.println(v.elemAtRank(i));
        }
        v.replaceAtRank(2,66);
        System.out.println("------------------");
        for(int i = 0; i < v.size(); i++){
            System.out.println(v.elemAtRank(i));
        }
    }
}
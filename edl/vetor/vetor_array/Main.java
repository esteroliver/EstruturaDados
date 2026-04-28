package edl.vetor.vetor_array;

public class Main{
    public static void main(String args[]){
        Vetor v = new Vetor();
        for(int i = 0; i < 5; i++){
            v.insertAtRank(0, i+2);
        }
        for(int i = 0; i < v.size(); i++){
            System.out.println(v.elemAtRank(i));
        }
        v.removeAtRank(2);
        for(int i = 0; i < v.size(); i++){
            System.out.println(v.elemAtRank(i));
        }
        v.replaceAtRank(2,66);
        for(int i = 0; i < v.size(); i++){
            System.out.println(v.elemAtRank(i));
        }
    }
}
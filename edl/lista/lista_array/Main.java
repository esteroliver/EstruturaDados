package edl.lista.lista_array;

class Main {
    public static void main(String args[]){
        Lista l = new Lista();
        for(int i = 0; i < 5; i++){
            l.insertLast(i+5);
            System.out.println(l.last());
        }
        System.out.println("--------------------");
        Object o = 7;
        Object capeta = 666;
        Object anjo = 777;
        l.insertBefore(capeta, o);
        l.insertAfter(anjo, o);
        l.swapElements(capeta, anjo);

        Object[] listar = l.listar();
        for(int i = 0; i < l.size(); i++){
            System.out.println(listar[i]);
        }

        System.out.println("--------------------");
        l.remove(l.last());
        listar = l.listar();
        for(int i = 0; i < l.size(); i++){
            System.out.println(listar[i]);
        }
        
    }
    
}

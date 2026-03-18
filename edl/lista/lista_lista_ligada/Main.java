package edl.lista.lista_lista_ligada;

class Main  {
    public static void main(String[] args){
        Lista l = new Lista();
        l.insertFirst(5);
        l.insertLast(7);
        l.insertBefore(7, 6);


        l.swapElements(5, 7);
        System.out.println(l.first());
        System.out.println(l.last());
        l.replaceElement(7, 2);
        System.out.println(l.first());
        l.remove(2);
        System.out.println(l.first());
    }
}

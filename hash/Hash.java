class Hash{
    private Item array[];
    private Integer size;
    private Integer n;

    public Hash(){
        size = 0;
        array = new Item[10];
        n = 10;
    }
    
    public void Inserir(Integer c, Object o){
        Item i = new Item(c,h);
        Integer indice = c/n;
        if(array[indice] == null){
            array[indice] = i;
        }
    }
    
}
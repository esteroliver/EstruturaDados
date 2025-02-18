import java.util.ArrayList;

public class Grafo{
    private Integer tamanho;
    private ArrayList<Vertice> vertices;

    public Grafo(){
        tamanho = 0;
        vertices = new ArrayList<Vertice>();
    }

    public Grafo(Vertice primeiro){
        vertices = new ArrayList<Vertice>();
        Vertice v = new Vertice(1);
        vertices.add(v);
        tamanho = 1;
    }

    public ArrayList<Vertice> getVerticesGrafo(){
        return vertices;
    }

    public void setVerticesGrafo(ArrayList<Vertice> vertices_grafo){
        vertices = vertices_grafo;
        tamanho = vertices_grafo.size();
    }

    public Integer getTamanho(){
        return tamanho;
    }
}


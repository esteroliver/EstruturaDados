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

class Vertice{
    private Integer vertice;
    private ArrayList<Integer> vertices_vizinhos;

    public Vertice(){
        vertices_vizinhos = new ArrayList<Integer>();
    }

    public Vertice(Integer vertice){
        this.vertice = vertice;
        vertices_vizinhos = new ArrayList<Integer>();
    }

    public Integer getVertice(){
        return vertice;
    }

    public void setVertice(Integer vertice){
        this.vertice = vertice;
    }

    public ArrayList<Integer> getVerticesVizinhos(){
        return vertices_vizinhos;
    }

    public void setVerticesVizinhos(ArrayList<Integer> vertices_vizinhos){
        this.vertices_vizinhos = vertices_vizinhos;
    }
}
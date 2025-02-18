import java.util.ArrayList;

public class Vertice{
    private Integer vertice;
    private ArrayList<Vertice> vertices_vizinhos;

    public Vertice(){
        vertices_vizinhos = new ArrayList<Vertice>();
    }

    public Vertice(Integer vertice){
        this.vertice = vertice;
        vertices_vizinhos = new ArrayList<Vertice>();
    }

    public Integer getVertice(){
        return vertice;
    }

    public void setVertice(Integer vertice){
        this.vertice = vertice;
    }

    public ArrayList<Vertice> getVerticesVizinhos(){
        return vertices_vizinhos;
    }

    public void setVerticesVizinhos(ArrayList<Vertice> vertices_vizinhos){
        this.vertices_vizinhos = vertices_vizinhos;
    }
}
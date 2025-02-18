import java.util.ArrayList;

public class Main{
    private static Boolean visitados[] = new Boolean[6];
    public static void main(String[] args){
        Grafo grafo = new Grafo();
        Vertice v1 = new Vertice(0);
        Vertice v2 = new Vertice(3);
        Vertice v3 = new Vertice(5);
        Vertice v4 = new Vertice(2);
        Vertice v5 = new Vertice(1);
        Vertice v6 = new Vertice(4);

        ArrayList<Vertice> v1_viz = new ArrayList<Vertice>();
        v1_viz.add(v6);
        v1_viz.add(v4);
        v1.setVerticesVizinhos(v1_viz);

        ArrayList<Vertice> v4_viz = new ArrayList<Vertice>();
        v4_viz.add(v3);
        v4_viz.add(v5);
        v4.setVerticesVizinhos(v4_viz);

        ArrayList<Vertice> v6_viz = new ArrayList<Vertice>();
        v6_viz.add(v2);
        v6.setVerticesVizinhos(v6_viz);

        dfs(v1);
    }

    public static void dfs(Vertice v){
        visitados[v.getVertice()] = true;
        System.out.println(v.getVertice());
        for(Vertice v_viz : v.getVerticesVizinhos()){
            if(visitados[v_viz.getVertice()] == null) dfs(v_viz);
        }
    }
}

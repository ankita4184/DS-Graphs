import java.io.*;
import java.lang.*;
import java.util.*;

public class topology extends graph{
    public static void main(String[] args){
        graph g = new graph(6);
        g.addEdge(5,2); g.addEdge(2,3); g.addEdge(4,0); g.addEdge(5,0);
        g.addEdge(4,1); g.addEdge(3,1);
        topology t = new topology();
        for(int i = 0; i < 6; i++)
            if(g.b[i] == false)
                g.topoSort(i);
        g.print();
    }
   
}

class graph{
    LinkedList<Integer> l = new LinkedList();
    LinkedList<Integer> adjL[];
    Boolean b[] = new Boolean[6];
    int vertex;
    public graph(){}
    public graph(int v){
        Arrays.fill(b, Boolean.FALSE);
        vertex = v;
        adjL = new LinkedList[vertex];
        int i = 0;
        while(i < v){
            adjL[i] = new LinkedList<Integer>();;
            i++;
        }   
    }
    public void addEdge(int s, int w){
        adjL[s].add(w);

    }
     public void topoSort(int now){
        b[now] = true;
        for(int i = 0; i < adjL[now].size(); i++){
            int j = adjL[now].get(i);
            if(b[j] == false)
                topoSort(j);
        }
        l.add(now);
    }
    public void print(){
        Iterator it = l.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}


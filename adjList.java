import java.io.*;
import java.lang.*;
import java.util.*;

public class adjList{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Integer vert = scan.nextInt();
        graph g = new graph(vert);
        g.input();
        g.print();
    }
}

class graph{
    private LinkedList<Integer> adjL[];
    private Integer vertex;
    public graph(){}
    public graph(Integer v){
        vertex = v;
        adjL = new LinkedList[v];
        for(int i = 0; i < v; i++)
            adjL[i] = new LinkedList<Integer>();
    }
    public void input(){
        Integer v1;
        Integer v2;
        Integer ed;
        Scanner s = new Scanner(System.in);
        ed = s.nextInt();
        for(int i = 0; i < ed; i++){
            v1 = s.nextInt();
            v2 = s.nextInt();
            addEdge(v1,v2);
        }
    }
    private void addEdge(int v1, int v2){
        adjL[v1].add(v2);
        adjL[v2].add(v1);
    }
    public void print(){
        for(int i = 0; i < vertex; i++){
            Iterator it = adjL[i].iterator();
            System.out.print(i+" ");
            while(it.hasNext()){
                System.out.print(it.next()+" ");
            }
            System.out.println();
        }
    }
}


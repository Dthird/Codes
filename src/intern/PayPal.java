package intern;

import java.util.*;

/**
 * Created by jiaxing on 17-4-13.
 */
public class PayPal {
}

class PayPal4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt(), n = sc.nextInt();
            StringBuilder sb = new StringBuilder(sc.next());
            //System.out.println(sb.toString());
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt(), s = sc.nextInt(), e = sc.nextInt();
                change(sb, a, s, e);
                //System.out.println(sb.toString());
            }
            System.out.println(sb.toString());
        }
    }

    static void change(StringBuilder sb, int a, int s, int e){
        String selected = sb.toString().substring(s - 1, e);
        char[] cs = selected.toCharArray();
        Arrays.sort(cs);
        //System.out.println(Arrays.toString(cs));
        if (a == 1) {
            sb.delete(s - 1, e);
            sb.insert(s - 1, cs);
            //sb.replace(s - 1, e, cs.toString());
        }
        else {
            for (int i = 0; i < cs.length / 2; i++) {
                char tmp = cs[i];
                cs[i] = cs[cs.length - 1 - i];
                cs[cs.length - 1 - i] = tmp;
            }
            //System.out.println(Arrays.toString(cs));
            sb.delete(s - 1, e);
            sb.insert(s - 1, cs);
            //sb.replace(s - 1, e, tmp.toString());
        }
    }

}

class PayPal2 {
    static class Graph
    {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; //Adjacency Lists

        // Constructor
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v,int w)
        {
            adj[v].add(w);
        }

        // prints BFS traversal from a given source s
        int BFS(int s, HashSet<Integer> set)
        {
            // Mark all the vertices as not visited(By default
            // set as false)
            boolean visited[] = new boolean[V];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();

            if (set.contains(s))
                return 0;

            // Mark the current node as visited and enqueue it
            visited[s]=true;
            queue.add(s);
            int level = 0;

            while (queue.size() != 0)
            {
                // Dequeue a vertex from queue and print it
                int cur = queue.size();
                for (int i = 0; i < cur; i++) {

                    s = queue.poll();
                    if (set.contains(s)) {
                        return level;
                    }
                    // Get all adjacent vertices of the dequeued vertex s
                    // If a adjacent has not been visited, then mark it
                    // visited and enqueue it
                    Iterator<Integer> it = adj[s].listIterator();
                    while (it.hasNext()) {
                        int n = it.next();
                        if (!visited[n]) {
                            visited[n] = true;
                            queue.add(n);
                        }
                    }
                }
                level++;
            }
            return -1;
        }


    }

    static class Pair{
        public int first;
        public int second;
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            ArrayList<Pair> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for (int i = 0; i < N; i++) {
                Pair tmp = new Pair();
                tmp.first = sc.nextInt();
                tmp.second = sc.nextInt();
                if (!map.containsKey(tmp.first)) {
                    map.put(tmp.first, count);
                    count++;
                }
                if (!map.containsKey(tmp.second)) {
                    map.put(tmp.second, count);
                    count++;
                }
                list.add(tmp);
            }
            int M = sc.nextInt();
            int numOfNode = map.size();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < M; i++) {
                set.add(map.get(sc.nextInt()));
            }

            Graph graph = new Graph(numOfNode);
            for (Pair p : list){
                graph.addEdge(map.get(p.first), map.get(p.second));
                graph.addEdge(map.get(p.second), map.get(p.first));
            }

            int sum = 0;
            for (int i = 0; i < numOfNode; i++) {
                sum += graph.BFS(i, set);
            }
            System.out.println(sum);
        }
    }

}

class PayPal1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String lineA = sc.nextLine();
            String lineB = sc.nextLine();
            String[] As = lineA.split(" ");
            String[] Bs = lineB.split(" ");
            ArrayList<Integer> Al = new ArrayList<>(), Bl = new ArrayList<>();
            for (int i = 0; i < As.length; i++) {
                Al.add(Integer.parseInt(As[i]));
                Bl.add(Integer.parseInt(Bs[i]));
            }
            System.out.println(survive(Al, Bl));

        }
    }

    private static int survive(ArrayList<Integer> A, ArrayList<Integer> B){
        if (A.size() == 0)
            return 0;
        if (A.size() == 1)
            return 1;
        ArrayList<Integer> Atmp = new ArrayList<>(), Btmp = new ArrayList<>();
        /*
        while (Atmp.size() != A.size()){
            for (int i = 0; i < Atmp.size(); i++) {

            }
        }
        */
        return A.size();
    }
}


import java.util.*;

/**
 * @author Colby McKinley
 * @UVa_ID colby_mckinley
 * @JUDGE_ID: 922619
 * @Problem_ID: 10004 - Bicoloring
 *
 */
class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int nodes, edges, a = 0, b;
		nodes = s.nextInt();
		int[][] graph;
		while (nodes != 0) {
			edges = s.nextInt();
			graph = new int[nodes][nodes];
			for (int i = 0; i < edges; i++) {
				a = s.nextInt();
				b = s.nextInt();
				graph[a][b] = 1;
				graph[b][a] = 1;
			}
			if (isBipartite(graph, 0, nodes))
				System.out.println("BICOLORABLE.");
			else
				System.out.println("NOT BICOLORABLE.");
			nodes = s.nextInt();
		}
		s.close();

	}

	static boolean isBipartite(int G[][], int src, int V) {
		int colorArr[] = new int[V];
		for (int i = 0; i < V; ++i)
			colorArr[i] = -1;
		colorArr[src] = 1;
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(src);
		while (q.size() != 0) {
			int u = q.poll();
			if (G[u][u] == 1)
				return false;
			for (int v = 0; v < V; ++v) {

				if (G[u][v] == 1 && colorArr[v] == -1) {
					colorArr[v] = 1 - colorArr[u];
					q.add(v);
				} else if (G[u][v] == 1 && colorArr[v] == colorArr[u])
					return false;
			}
		}
		return true;
	}
}
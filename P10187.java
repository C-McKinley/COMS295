import java.util.*;

/**
 * @author Colby McKinley
 * @UVa_ID colby_mckinley
 * @JUDGE_ID: 922619
 * @Problem_ID: 10187 - From Dusk Till Dawn
 *
 */

class Main {
	static List<Edge>[] adjList;
	static int numCities;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numCases = s.nextInt();
		int numRoutes, departure, duration, u, v, arrival, a, b, liters;
		String src, dst;
		Map<String, Integer> cities;
		for (int i = 1; i <= numCases; i++) {
			numRoutes = s.nextInt();
			numCities = 0;
			adjList = new LinkedList[100];
			cities = new HashMap<>();
			for (int j = 0; j < numRoutes; j++) {
				src = s.next();
				dst = s.next();
				departure = s.nextInt();
				duration = s.nextInt();
				u = AddCity(cities, src);
				v = AddCity(cities, dst);
				arrival = (departure + duration) % 24;
				if (departure > 6 && departure < 18 || arrival > 6 && arrival < 18)
					continue;
				a = departure <= 6 ? departure + 24 : departure;
				b = arrival <= 6 ? arrival + 24 : arrival;
				if (b - a < 0)
					continue;
				adjList[u].add(new Edge(v, departure % 24, duration));
			}
			System.out.println("Test Case " + i + ".");
			src = s.next();
			dst = s.next();
			if (cities.get(src) == null || cities.get(dst) == null) {
				if (src.equals(dst))
					liters = 0;
				else
					liters = -1;
			} else {
				u = cities.get(src);
				v = cities.get(dst);
				liters = Dijkstra(u, v);
			}
			if (liters != -1)
				System.out.printf("Vladimir needs %d litre(s) of blood.\n", liters);
			else
				System.out.println("There is no route Vladimir can take.");
		}
		s.close();

	}

	static int Dijkstra(int src, int dst) {
		int[] cost = new int[numCities];
		for (int i = 0; i < numCities; i++) {
			cost[i] = Integer.MAX_VALUE;
		}
		cost[src] = 0;
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(src, 0, -1));
		int minCost, nextCost;
		Edge current, next;
		while (!queue.isEmpty()) {
			current = queue.poll();
			if (current.depart > cost[current.dst])
				continue;
			minCost = (current.depart % 12 + 18) % 24;
			minCost = (minCost <= 6) ? minCost + 24 : minCost;
			for (int i = 0; i < adjList[current.dst].size(); i++) {
				next = adjList[current.dst].get(i);
				nextCost = next.depart;
				nextCost = (nextCost <= 6) ? nextCost + 24 : nextCost;
				if (minCost > nextCost)
					nextCost += 12;
				if (current.depart + nextCost - minCost + next.duration < cost[next.dst]) {
					cost[next.dst] = current.depart + nextCost - minCost + next.duration;
					queue.add(new Edge(next.dst, cost[next.dst], -1));
				}

			}

		}
		return (cost[dst] == Integer.MAX_VALUE) ? -1 : (cost[dst] - 1) / 12;
	}

	static int AddCity(Map<String, Integer> arr, String city) {
		int val;
		if (arr.containsKey(city))
			val = arr.get(city);
		else {
			val = numCities;
			adjList[val] = new LinkedList<>();
			arr.put(city, numCities++);
		}
		return val;
	}

	static class Edge implements Comparable<Edge>{
		int dst, depart, duration;

		public Edge(int a, int b, int c) {
			dst = a;
			depart = b;
			duration = c;
		}
		
		public int compareTo(Edge e) {
			return this.depart - e.depart;
		}

	}

}
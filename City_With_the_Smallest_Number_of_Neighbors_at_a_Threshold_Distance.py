

import heapq
from typing import List

class Solution:
    def findCity(self, n: int, m: int, edges: List[List[int]], distanceThreshold: int) -> int:
       
        adjacency_list = {i: [] for i in range(n)}
        for edge in edges:
            r, c, w = edge
            adjacency_list[r].append((c, w))
            adjacency_list[c].append((r, w))

       
        def dijkstra(start):
            min_distances = [float('inf')] * n
            min_distances[start] = 0
            pq = [(0, start)]  

            while pq:
                dist, node = heapq.heappop(pq)
                if dist > min_distances[node]:
                    continue
                for neighbor, weight in adjacency_list[node]:
                    new_dist = dist + weight
                    if new_dist < min_distances[neighbor]:
                        min_distances[neighbor] = new_dist
                        heapq.heappush(pq, (new_dist, neighbor))
            return min_distances

        min_city = float('inf')
        city = float('inf')
        for i in range(n):
            min_distances = dijkstra(i)
            reachable_cities = sum(1 for dist in min_distances if 0 < dist <= distanceThreshold)
            if reachable_cities <= min_city:
                min_city = reachable_cities
                city = i
        return city

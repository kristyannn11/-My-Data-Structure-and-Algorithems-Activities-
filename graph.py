class Graph:
    def __init__(self):
        self.graph = {}

    # Add a vertex to the graph
    def add_vertex(self, vertex):
        if vertex not in self.graph:
            self.graph[vertex] = []

    # Add an edge between two vertices
    def add_edge(self, vertex1, vertex2):
        if vertex1 in self.graph and vertex2 in self.graph:
            self.graph[vertex1].append(vertex2)
            self.graph[vertex2].append(vertex1)

    # DFS traversal starting from a given vertex
    def dfs(self, start):
        visited = set()
        self._dfs_helper(start, visited)

    def _dfs_helper(self, vertex, visited):
        visited.add(vertex)
        print(vertex, end=" ")
        for neighbor in self.graph[vertex]:
            if neighbor not in visited:
                self._dfs_helper(neighbor, visited)

    # BFS traversal starting from a given vertex
    def bfs(self, start):
        visited = set()
        queue = [start]
        while queue:
            vertex = queue.pop(0)
            if vertex not in visited:
                visited.add(vertex)
                print(vertex, end=" ")
                queue.extend(neighbor for neighbor in self.graph[vertex] if neighbor not in visited)

# Example usage
if __name__ == "__main__":
    # Create a graph
    g = Graph()

    # Add vertices
    g.add_vertex("A")
    g.add_vertex("B")
    g.add_vertex("C")
    g.add_vertex("D")

    # Add edges
    g.add_edge("A", "B")
    g.add_edge("A", "C")
    g.add_edge("B", "D")
    g.add_edge("C", "D")

    # Perform DFS and BFS traversals
    print("DFS Traversal starting from A:")
    g.dfs("A")
    print("\nBFS Traversal starting from A:")
    g.bfs("A")

import osmnx as ox
import networkx as nx

# Load the graph for Manhattan from the cache
G = ox.graph_from_place('Manhattan, New York, USA', network_type='drive')

# Simplify the graph (if needed)
#G = ox.simplify_graph(G)

# Extract nodes and edges
nodes, edges = ox.graph_to_gdfs(G)

# Reset index to make 'osmid' a regular column
nodes.reset_index(inplace=True)

# Select relevant columns
cleaned_nodes = nodes[['osmid', 'x', 'y']]
cleaned_edges = edges[['u', 'v', 'length']]

# Define file paths (update this to your path)
nodes_file_path = 'manhattan_nodes.csv'
edges_file_path = 'manhattan_edges.csv'

# Save cleaned nodes and edges to CSV files
cleaned_nodes.to_csv(nodes_file_path, index=False)
cleaned_edges.to_csv(edges_file_path, index=False)

# Print confirmation
print(f"Cleaned nodes saved to {nodes_file_path}")
print(f"Cleaned edges saved to {edges_file_path}")

# Print a sample of cleaned nodes and edges to verify
print(cleaned_nodes.head())
print(cleaned_edges.head())

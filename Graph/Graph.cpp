#include "Graph.h"
#include <unordered_map>
#include <unordered_set>
#include <vector>
#include <queue>
#include <stack>
#include <fstream>
#include <sstream>
#include <tuple>
#include <algorithm>
#include <limits>
#include <iostream>
#include <functional>

using namespace std;

// Graph class definition

// Member variables for the graph
unordered_map<string, unordered_map<string, double>> adj_list;
unsigned int node_count = 0;
unsigned int edge_count = 0;

// Constructor: Initialize the graph from a CSV file
Graph::Graph(const char* const & edgelist_csv_fn) {
    ifstream file(edgelist_csv_fn);
    if (!file.is_open()) {
        cerr << "Error opening file: " << edgelist_csv_fn << endl;
        exit(1);
    }

    string line;
    unordered_set<string> unique_nodes;
    while (getline(file, line)) {
        istringstream ss(line);
        string u, v, weight_str;
        getline(ss, u, ',');
        getline(ss, v, ',');
        getline(ss, weight_str, '\n');

        double weight = stod(weight_str);

        // Add edges to adjacency list (undirected graph)
        adj_list[u][v] = weight;
        adj_list[v][u] = weight;

        unique_nodes.insert(u);
        unique_nodes.insert(v);
    }

    file.close();

    // Count nodes and edges
    node_count = unique_nodes.size();
    edge_count = 0;
    for (const auto& [node, neighbors] : adj_list) {
        edge_count += neighbors.size();
    }
    edge_count /= 2; // Each edge is counted twice
}

// Return the number of nodes
unsigned int Graph::num_nodes() {
    return node_count;
}

// Return a vector of all node labels
vector<string> Graph::nodes() {
    vector<string> result;
    for (const auto& pair : adj_list) {
        result.push_back(pair.first);
    }
    return result;
}

// Return the number of edges
unsigned int Graph::num_edges() {
    return edge_count;
}

// Return the weight of an edge or -1 if it doesn't exist
double Graph::edge_weight(string const & u_label, string const & v_label) {
    if (adj_list.count(u_label) && adj_list[u_label].count(v_label)) {
        return adj_list[u_label][v_label];
    }
    return -1;
}

// Return the number of neighbors for a node
unsigned int Graph::num_neighbors(string const & node_label) {
    if (adj_list.count(node_label)) {
        return adj_list[node_label].size();
    }
    return 0;
}

// Return the neighbors of a node
vector<string> Graph::neighbors(string const & node_label) {
    vector<string> result;
    if (adj_list.count(node_label)) {
        for (const auto& neighbor : adj_list[node_label]) {
            result.push_back(neighbor.first);
        }
    }
    return result;
}

// Find the shortest unweighted path using BFS
vector<string> Graph::shortest_path_unweighted(string const & start_label, string const & end_label) {
    if (!adj_list.count(start_label) || !adj_list.count(end_label)) {
        return {};
    }

    unordered_map<string, string> parent;
    queue<string> q;
    unordered_set<string> visited;

    q.push(start_label);
    visited.insert(start_label);

    while (!q.empty()) {
        string curr = q.front();
        q.pop();

        if (curr == end_label) {
            vector<string> path;
            for (string at = end_label; !at.empty(); at = parent[at]) {
                path.push_back(at);
            }
            reverse(path.begin(), path.end());
            return path;
        }

        for (const auto& neighbor : adj_list[curr]) {
            if (!visited.count(neighbor.first)) {
                visited.insert(neighbor.first);
                parent[neighbor.first] = curr;
                q.push(neighbor.first);
            }
        }
    }

    return {};
}

// Find the shortest weighted path using Dijkstra's algorithm
vector<tuple<string, string, double>> Graph::shortest_path_weighted(string const & start_label, string const & end_label) {
    if (!adj_list.count(start_label) || !adj_list.count(end_label)) {
        return {};
    }

    unordered_map<string, double> dist;
    unordered_map<string, string> parent;
    priority_queue<pair<double, string>, vector<pair<double, string>>, greater<>> pq;

    for (const auto& pair : adj_list) {
        dist[pair.first] = numeric_limits<double>::infinity();
    }
    dist[start_label] = 0;
    pq.push({0, start_label});

    while (!pq.empty()) {
        auto [curr_dist, curr] = pq.top();
        pq.pop();

        if (curr_dist > dist[curr]) {
            continue;
        }

        for (const auto& neighbor : adj_list[curr]) {
            double new_dist = curr_dist + neighbor.second;
            if (new_dist < dist[neighbor.first]) {
                dist[neighbor.first] = new_dist;
                parent[neighbor.first] = curr;
                pq.push({new_dist, neighbor.first});
            }
        }
    }

    if (dist[end_label] == numeric_limits<double>::infinity()) {
        return {};
    }

    vector<tuple<string, string, double>> path;
    for (string at = end_label; parent.count(at); at = parent[at]) {
        string from = parent[at];
        path.push_back({from, at, adj_list[from][at]});
    }
    reverse(path.begin(), path.end());
    return path;
}

// Find connected components using BFS
vector<vector<string>> Graph::connected_components(double const & threshold) {
    unordered_set<string> visited;
    vector<vector<string>> components;

    for (const auto& node : adj_list) {
        if (!visited.count(node.first)) {
            vector<string> component;
            queue<string> q;
            q.push(node.first);
            visited.insert(node.first);

            while (!q.empty()) {
                string curr = q.front();
                q.pop();
                component.push_back(curr);

                for (const auto& neighbor : adj_list[curr]) {
                    if (!visited.count(neighbor.first) && neighbor.second <= threshold) {
                        visited.insert(neighbor.first);
                        q.push(neighbor.first);
                    }
                }
            }

            components.push_back(component);
        }
    }

    return components;
}

// Find the smallest connecting threshold using Union-Find
double Graph::smallest_connecting_threshold(string const & start_label, string const & end_label) {
    if (!adj_list.count(start_label) || !adj_list.count(end_label)) {
        return -1;
    }

    struct Edge {
        string u, v;
        double weight;
        bool operator<(const Edge& other) const { return weight < other.weight; }
    };

    vector<Edge> edges;
    for (const auto& [u, neighbors] : adj_list) {
        for (const auto& [v, weight] : neighbors) {
            if (u < v) {
                edges.push_back({u, v, weight});
            }
        }
    }
    sort(edges.begin(), edges.end());

    unordered_map<string, string> parent;
    unordered_map<string, int> rank;

    for (const auto& pair : adj_list) {
        parent[pair.first] = pair.first;
        rank[pair.first] = 0;
    }

    function<string(string)> find = [&](string x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    };

    auto unite = [&](string x, string y) {
        string rootX = find(x);
        string rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    };

    for (const auto& edge : edges) {
        unite(edge.u, edge.v);
        if (find(start_label) == find(end_label)) {
            return edge.weight;
        }
    }

    return -1;
}

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>

using namespace std;

typedef long long ll;

#define F first
#define S second
#define PB push_back
#define MP make_pair

void dfs_rooting(int u, int p, const vector<vector<int>>& unrooted_adj_list,
                 vector<vector<int>>& children_list, vector<int>& parent_list, vector<int>& acc_list) {
    parent_list[u] = p;
    for (int v_node : unrooted_adj_list[u]) {
        if (v_node == p) continue;
        children_list[u].PB(v_node);
        dfs_rooting(v_node, u, unrooted_adj_list, children_list, parent_list, acc_list);
    }
    acc_list[u] = children_list[u].size();
}

void dfs_single_path_removal(int u, int p_node, ll current_sum_from_ancestors,
                             const vector<vector<int>>& children_list, const vector<int>& acc_list,
                             ll& max_total_comps) {
    // current_sum_from_ancestors = (acc[root]-1) + sum of (acc[k]-1) for k on path (root, p_node), excluding root and p_node
    // The passed current_sum_from_ancestors is for path up to p_node.
    // For path ending at u: add acc[u].
    ll score_if_u_is_endpoint_v = current_sum_from_ancestors + acc_list[u];
    max_total_comps = max(max_total_comps, score_if_u_is_endpoint_v);

    // For paths extending through u to its children:
    // Contribution from u itself to these longer paths is (acc[u]-1)
    ll new_sum_for_children_paths = current_sum_from_ancestors + (acc_list[u] - 1);
    for (int v_node : children_list[u]) {
        dfs_single_path_removal(v_node, u, new_sum_for_children_paths, children_list, acc_list, max_total_comps);
    }
}

ll dfs_branch_max_score_calc(int u, int p_node, ll sum_contrib_from_path_above_u_to_rc,
                               const vector<vector<int>>& children_list, const vector<int>& acc_list) {
    // sum_contrib_from_path_above_u_to_rc = sum of (acc[k]-1) for k on path (p_node, rc_node)
    // Score for branch ending at u = acc[u] + sum_contrib_from_path_above_u_to_rc
    ll max_score_in_this_subtree_branch = acc_list[u] + sum_contrib_from_path_above_u_to_rc;

    // For branches ending deeper in this subtree:
    // Contribution from u to these deeper branches is (acc[u]-1)
    ll new_sum_for_children = sum_contrib_from_path_above_u_to_rc + (acc_list[u] - 1);
    for (int v_node : children_list[u]) {
        max_score_in_this_subtree_branch = max(max_score_in_this_subtree_branch,
            dfs_branch_max_score_calc(v_node, u, new_sum_for_children, children_list, acc_list));
    }
    return max_score_in_this_subtree_branch;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N;
    cin >> N;

    if (N == 1) {
        cout << 1 << endl;
        return 0;
    }

    vector<vector<int>> adj(N + 1);
    vector<vector<int>> rooted_adj(N + 1);
    vector<int> parent(N + 1, 0);
    vector<int> actual_children_count(N + 1, 0);

    for (int i = 0; i < N - 1; ++i) {
        int u_node, v_node; 
        cin >> u_node >> v_node;
        adj[u_node].PB(v_node);
        adj[v_node].PB(u_node);
    }

    dfs_rooting(1, 0, adj, rooted_adj, parent, actual_children_count);

    ll max_total_components = 1; // Case: no removal

    // Subcase 2.1: Path from root (1) to some node v
    // Initial sum from root part for paths starting 1-rc-... is (actual_children_count[1] - 1)
    if (actual_children_count[1] > 0) { // If root has children
         for (int root_child : rooted_adj[1]) {
            dfs_single_path_removal(root_child, 1, (ll)actual_children_count[1] - 1,
                                    rooted_adj, actual_children_count, max_total_components);
        }
    }
    
    // Subcase 2.2: Path u...root...v (u,v != root, LCA(u,v)=root)
    // Requires root to have at least 2 children.
    if (actual_children_count[1] >= 2) {
        vector<ll> branch_scores;
        for (int root_child : rooted_adj[1]) {
            // For path segment from root_child down to some u in its subtree:
            // sum_contrib_from_path_above_u_to_rc is 0 for root_child itself.
            branch_scores.PB(dfs_branch_max_score_calc(root_child, 1, 0, 
                                                       rooted_adj, actual_children_count));
        }
        sort(branch_scores.rbegin(), branch_scores.rend()); // Sort descending

        // We need to pick two distinct branches.
        // This check is implicitly covered by actual_children_count[1] >= 2,
        // as branch_scores will have at least 2 elements.
        if (branch_scores.size() >= 2) { 
            ll current_case_max_score = branch_scores[0] + branch_scores[1] + (actual_children_count[1] - 2);
            max_total_components = max(max_total_components, current_case_max_score);
        }
    }
    
    cout << max_total_components << endl;

    return 0;
}

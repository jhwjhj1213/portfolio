#include "HCTree.hpp"
#include "Helper.hpp"
#include <queue>
#include <iostream>

using namespace std;

void deleteAll(HCNode* node) {
    if (!node) return;
    deleteAll(node->c0);
    deleteAll(node->c1);
    delete node;
}

HCTree::~HCTree() {
    deleteAll(root);
    root = nullptr;
}

void HCTree::build(const vector<int>& freqs) {
    priority_queue<HCNode*, vector<HCNode*>, HCNodePtrComp> pq;

    for (size_t i = 0; i < freqs.size(); ++i) {
        if (freqs[i] > 0) {
            HCNode* newNode = new HCNode(freqs[i], (unsigned char)i);
            leaves[i] = newNode;
            pq.push(newNode);
        }
    }

    if (pq.empty()) {
        root = nullptr;
        return;
    }

    while (pq.size() > 1) {
        HCNode* child0 = pq.top(); pq.pop();
        HCNode* child1 = pq.top(); pq.pop();

        HCNode* parent = new HCNode(child0->count + child1->count, '\0');
        parent->c0 = child0;
        parent->c1 = child1;
        child0->p = parent;
        child1->p = parent;
        pq.push(parent);
    }

    root = pq.top();
}

void HCTree::encode(unsigned char symbol, FancyOutputStream& out) const {
    HCNode* current = leaves[symbol];
    if (!current) {
        cerr << "Error: Symbol not found in the Huffman tree." << endl;
        return;
    }

    vector<int> path;
    while (current->p) {
        path.push_back(current == current->p->c0 ? 0 : 1);
        current = current->p;
    }

    for (auto it = path.rbegin(); it != path.rend(); ++it) {
        out.write_bit(*it);
    }
}

unsigned char HCTree::decode(FancyInputStream& in) const {
    if (!root) {
        cerr << "Error: Huffman tree is empty." << endl;
        return '\0';
    }

    HCNode* current = root;
    while (current->c0 && current->c1) {
        int bit = in.read_bit();
        current = (bit == 0) ? current->c0 : current->c1;
    }

    return current->symbol;
}

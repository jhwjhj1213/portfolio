#include <iostream>
#include <fstream>
#include <vector>
#include "HCTree.hpp"
#include "Helper.hpp"

using namespace std;

int main(int argc, char* argv[]) {
    if (argc != 3) {
        cerr << "Usage: " << argv[0] << " <input_file> <output_file>" << endl;
        return 1;
    }

    const string inputFile = argv[1];
    const string outputFile = argv[2];

    ifstream input(inputFile, ios::binary);
    if (!input.is_open()) {
        cerr << "Error: Could not open input file " << inputFile << endl;
        return 1;
    }

    // Check if input file is empty
    input.seekg(0, ios::end);
    if (input.tellg() == 0) {
        cerr << "Input file is empty. Writing minimal compressed file." << endl;
        FancyOutputStream fancyOut(outputFile.c_str());
        fancyOut.write_int(0); // No non-zero frequencies
        return 0;
    }
    input.seekg(0, ios::beg);

    // Count character frequencies
    vector<int> freq(256, 0);
    char byte;
    while (input.get(byte)) {
        freq[(unsigned char)byte]++;
    }
    input.close();

    // Build Huffman Tree
    HCTree huffmanTree;
    huffmanTree.build(freq);

    // Write compressed data
    FancyOutputStream fancyOut(outputFile.c_str());

    // Write optimized frequency table
    int nonZeroCount = 0;
    for (int f : freq) {
        if (f > 0) nonZeroCount++;
    }
    fancyOut.write_int(nonZeroCount);
    for (size_t i = 0; i < freq.size(); ++i) {
        if (freq[i] > 0) {
            fancyOut.write_byte((unsigned char)i);
            fancyOut.write_int(freq[i]);
        }
    }

    input.open(inputFile, ios::binary);
    if (!input.is_open()) {
        cerr << "Error: Could not reopen input file " << inputFile << endl;
        return 1;
    }

    while (input.get(byte)) {
        huffmanTree.encode((unsigned char)byte, fancyOut);
    }
    input.close();

    return 0;
}

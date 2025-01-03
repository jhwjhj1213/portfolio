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

    FancyInputStream fancyIn(inputFile.c_str());
    if (!fancyIn.good()) {
        cerr << "Error: Could not open input file " << inputFile << endl;
        return 1;
    }

    // Read optimized frequency table
    vector<int> freq(256, 0);
    int nonZeroCount = fancyIn.read_int();
    for (int i = 0; i < nonZeroCount; ++i) {
        unsigned char symbol = fancyIn.read_byte();
        int frequency = fancyIn.read_int();
        freq[symbol] = frequency;
    }

    // Detect empty file
    bool isEmpty = true;
    for (int count : freq) {
        if (count != 0) {
            isEmpty = false;
            break;
        }
    }

    if (isEmpty) {
        cerr << "Compressed file corresponds to an empty input file." << endl;
        ofstream output(outputFile, ios::binary);
        output.close();
        return 0;
    }

    // Build Huffman Tree
    HCTree huffmanTree;
    huffmanTree.build(freq);

    // Decode compressed data
    ofstream output(outputFile, ios::binary);
    if (!output.is_open()) {
        cerr << "Error: Could not open output file " << outputFile << endl;
        return 1;
    }

    int totalDecodedBytes = 0;
    int totalOriginalBytes = 0;
    for (int count : freq) {
        totalOriginalBytes += count;
    }

    while (totalDecodedBytes < totalOriginalBytes) {
        int symbol = huffmanTree.decode(fancyIn);
        output.put(static_cast<char>(symbol));
        totalDecodedBytes++;
    }

    output.close();
    return 0;
}

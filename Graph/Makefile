# Use g++ with C++17 support
CXX = g++
CXXFLAGS ?= -Wall -pedantic -g -O0 -std=c++17
OUTFILES = GraphTest

all: $(OUTFILES)

# Compile the GraphTest executable
GraphTest: GraphTest.cpp Graph.cpp Graph.h
	$(CXX) $(CXXFLAGS) -o GraphTest GraphTest.cpp Graph.cpp

# Profiling support for performance analysis
gprof: GraphTest.cpp Graph.cpp Graph.h
	make clean
	$(CXX) $(CXXFLAGS) -pg -o GraphTest GraphTest.cpp Graph.cpp

# Remove generated files
clean:
	$(RM) $(OUTFILES) *.o gmon.out

#include <iostream>
#include <vector>
#include "library.h"

int main() {
	std::string message = "popi";
	std::vector<int> vettore{1, 2, 3};

	print(message, vettore);

	return 0;
}

#include <iostream>
#include <vector>

void fibonacci(int x, int y, std::vector<int>& v, int n);
void print(std::string message, std::vector<int>& vector);
void call_counter(void);

int main() {
	std::string message = "Fibonacci:";
	std::vector<int> vettore{1, 1};

	fibonacci(1, 1, vettore, 10);
	fibonacci(1, 1, vettore, 10);
	fibonacci(1, 1, vettore, 10);
	fibonacci(1, 1, vettore, 10);
	print(message, vettore);
	return 0;
}

void print(std::string message, std::vector<int>& vector) {
	std::cout << message << std::endl;
	for (int i = 0; i < vector.size(); i++) {
		std::cout << vector[i] << "\t";
	}
	std::cout << std::endl;
}

void fibonacci(int x, int y, std::vector<int>& v, int n) {
	call_counter();
	v.clear();
	v.push_back(x);
	v.push_back(y);
	for (int i = 2; i < n; i++) {
		v.push_back(v[i-1] + v[i-2]);
	}
}

void call_counter(void) {
	static int count = 0;
	count++;
	std::cout << count << std::endl;
}

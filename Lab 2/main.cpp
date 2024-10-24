#include <iostream>
#include "rational.h"

using namespace std;

int main(void) {
    Rational number1 {};
    Rational number2 {1};
    Rational number3 {1, 2};

    Rational popi = number1 + number2;

	return 0;
}

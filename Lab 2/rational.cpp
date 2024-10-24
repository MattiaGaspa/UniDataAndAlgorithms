#include "rational.h"


Rational& Rational::operator=(const Rational& num1) {
    numerator = num1.numerator;
    denominator = num1.denominator;

    return *this;
}

Rational operator+(const Rational& num1, const Rational& num2) {
    const int denominator = num1.getDenominator() * num2.getDenominator();
    const int numerator = num1.getNumerator() * num2.getDenominator() + num2.getNumerator() * num1.getDenominator();

    return Rational{numerator, denominator};
}
Rational operator+(const Rational& num1, const int& num2) {
    const int denominator = num1.getDenominator();
    const int numerator = num1.getNumerator() + num2 * num1.getDenominator();
    
    return Rational {numerator, denominator};
}
Rational operator+(const int& num1, const Rational& num2) {
    return num2 + num1;
}

Rational operator-(const Rational& num1, const Rational& num2) {
    const int denominator = num1.getDenominator() * num2.getDenominator();
    const int numerator = num1.getNumerator() * num2.getDenominator() - num2.getNumerator() * num1.getDenominator();

    return Rational{numerator, denominator};
}

Rational operator*(const Rational& num1, const Rational& num2) {
    const int denominator = num1.getDenominator() * num2.getDenominator();
    const int numerator = num2.getNumerator() * num2.getNumerator();

    return Rational {numerator, denominator};
}

Rational operator/(const Rational& num1, const Rational& num2) {
    const int numerator = num1.getNumerator() * num2.getDenominator();
    const int denominator = num2.getDenominator() * num2.getNumerator();

    return Rational {numerator, denominator};
}

bool operator==(const Rational& num1, const Rational& num2) { // Rifai
    return num1.getDenominator() == num2.getDenominator() &&
        num1.getNumerator() == num2.getNumerator() {
            return true;
        }
        return false;
}
/*
Rational operator>(const Rational& num1, const Rational& num2);
Rational operator<(const Rational& num1, const Rational& num2);
*/

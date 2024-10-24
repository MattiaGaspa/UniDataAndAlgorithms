#ifndef RATIONAL
#define RATIONAL

class Rational {
    public:
        Rational(void) : numerator{0}, denominator{1} {}
        Rational(int n) : numerator{n}, denominator{1} {}
        Rational(int n, int d) : numerator{n}, denominator{d} {}

        int getNumerator(void) const {
            return numerator;
        }
        int getDenominator(void) const {
            return denominator;
        }

        Rational& operator=(const Rational& num1);
        void simple
    private:
        int numerator;
        int denominator;
};

Rational operator+(const Rational& num1, const Rational& num2);
Rational operator+(const Rational& num1, const int& num2);
Rational operator+(const int& num1, const Rational& num2);
Rational operator-(const Rational& num1, const Rational& num2);
Rational operator*(const Rational& num1, const Rational& num2);
Rational operator/(const Rational& num1, const Rational& num2);
bool operator==(const Rational& num1, const Rational& num2);
Rational operator>(const Rational& num1, const Rational& num2);
Rational operator<(const Rational& num1, const Rational& num2);



#endif

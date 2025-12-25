package edu.unl.cc.sucession.business;

/**
 * Autores
 * Joel Tene 
 * Teresa Rivas
 * Axel Lapo
 * Jorge Noboa
 */

public class PrimeNumberWithPowInPairCalculator {
  
    private Integer limit;
    private Integer currentTerm;
    private final StringBuilder printableTerms;

    public Impares(Integer limit) {
        this(0, limit);
    }

    public Impares(Number start, Integer limit) {
        if (start.intValue() < 0) {
            throw new IllegalArgumentException("El numero de inicio debe ser mayor que 0");
        }
        setLimit(limit);
        currentTerm = nextTerm(start).intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Number nextTerm(Number currentTerm) {
        currentTerm = currentTerm.intValue() + 1;
        while (!isPrime(currentTerm.intValue())) {
            currentTerm = currentTerm.intValue() + 1;
        }
        return currentTerm;
    }

    @Override
    public void setLimit(Number limit) {
        if (limit.intValue() <= 0) {
            throw new IllegalArgumentException("El limite debe ser mayor que 0");
        }
        this.limit = limit.intValue();
    }

    @Override
    public Number calculate() {
        double result = 0;
        int counterTerm = 0;
        int exponent = 1;

        currentTerm = this.currentTerm > 0 ? this.currentTerm - 1 : 0;

        while (counterTerm < limit) {
            currentTerm = nextTerm(currentTerm).intValue();
            printableTerms.append(currentTerm)
                    .append("^")
                    .append(exponent)
                    .append(" + ");
            result += Math.pow(currentTerm, exponent);
            counterTerm++;
            exponent += 2;
        }
        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }

}

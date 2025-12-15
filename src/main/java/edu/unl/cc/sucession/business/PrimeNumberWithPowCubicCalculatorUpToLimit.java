package edu.unl.cc.sucession.business;

public class PrimeNumberWithPowCubicCalculatorUpToLimit {

    private Integer limit;
    private Integer currentTerm;
    private StringBuilder printableTerms;

    public PrimeNumberWithPowCubicCalculatorUpToLimit(Number limit) {
        this(1, limit);
    }

    public PrimeNumberWithPowCubicCalculatorUpToLimit(Number start, Number limit) {
        if (start.intValue() < 1) {
            throw new IllegalArgumentException("Start must be greater than 0");
        }
        setLimit(limit);
        this.currentTerm = start.intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    @Override
    public void setLimit(Number limit) {
        if (limit.intValue() < 2) {
            throw new IllegalArgumentException("Limit must be greater than or equal to 2");
        }
        this.limit = limit.intValue();
    }

    // Verifica si un número es primo
    private boolean isPrime(Integer number) {
        if (number < 2) {
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
    public Number calculate() {
        Double result = 0.0;
        currentTerm = 1;

        while (true) {
            // Obtener el siguiente primo
            currentTerm = nextTerm(currentTerm).intValue();

            // El límite se aplica al número primo base
            if (currentTerm > limit) {
                break;
            }

            printableTerms.append(currentTerm)
                    .append("^3");

            result += Math.pow(currentTerm, 3);

            if (currentTerm < limit) {
                printableTerms.append(" + ");
            }
        }
        return result;
    }

    @Override
    public Number nextTerm(Number currentTerm) {
        int number = currentTerm.intValue() + 1;
        while (!isPrime(number)) {
            number++;
        }
        return number;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }
}

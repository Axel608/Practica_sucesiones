package edu.unl.cc.sucession.business;

public class PrimeNumberWithPowPairSqrtUpToLimit {
  private Integer limit;
    private Integer currentTerm;
    private StringBuilder printableTerms;

    public PrimeNumberWithPowPairSqrtUpToLimit (Number limit) {
        this(0, limit);
    }

    public PrimeNumberWithPowPairSqrtUpToLimit (Number start, Number limit) {
        if (start.intValue() < 0) {
            throw new IllegalArgumentException("Start must be greater than 0");
        }
        setLimit(limit);
        currentTerm = nextTerm(start).intValue();
        printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number) {
        if (number < 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }
    @Override
    public Number nextTerm(Number currentTerm) {
        currentTerm = currentTerm.intValue() + 1;
        boolean isPrime = false;
        while (!isPrime) {
            isPrime = isPrime(currentTerm.intValue());
            if (!isPrime) {
                currentTerm =  currentTerm.intValue() + 1;
            }
        }
        return currentTerm;
    }

    @Override
    public void setLimit(Number limit) {
        if (limit.intValue() < 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        this.limit = limit.intValue();
    }

    @Override
    public Number calculate() {
        double result = 0.0;
        int exponent = 2;
        int currentTerm = this.currentTerm > 0 ? this.currentTerm - 1 : 1;
        while (currentTerm < limit) {
            this.printableTerms.append(currentTerm).append("^(1/").append(exponent).append(") + ");
            currentTerm = nextTerm(currentTerm).intValue();
            result += Math.pow(currentTerm, 1.0 / exponent);
            exponent += 2;
        }
        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }
}

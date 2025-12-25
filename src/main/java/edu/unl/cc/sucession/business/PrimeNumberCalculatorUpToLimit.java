package edu.unl.cc.sucession.business;

/**
 * Autores
 * Joel Tene 
 * Teresa Rivas
 * Axel Lapo
 * Jorge Noboa
 */

public class PrimeNumberCalculatorUpToLimit {
   private Integer limit;
    private Integer currentTerm;
    private StringBuilder printableTerms;

    public PrimeNumberCalculatorUpToLimit(Number limit) {
        this(0, limit);
    }

    public PrimeNumberCalculatorUpToLimit(Number start, Number limit) {
        if (start.intValue() < 0){
            throw new IllegalArgumentException("Start must be greater than 0");
        }
        setLimit(limit);
        currentTerm = nextTerm(start).intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number){
        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public Number nextTerm(Number currentTerm) {
        currentTerm = currentTerm.intValue() + 1;
        boolean isPrime = false;
        while (!isPrime){
            isPrime = isPrime(currentTerm.intValue());
            if (!isPrime){
                currentTerm = currentTerm.intValue() + 1;
            }
        }
        return currentTerm;
    }

    @Override
    public void setLimit(Number limit) {
        if (limit.intValue() < 0){
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        this.limit = limit.intValue();
    }

    @Override
    public Number calculate() {
        long result = 0;
        while (currentTerm <= limit){
            this.printableTerms.append(currentTerm).append(" + ");
            result = result + this.currentTerm;
            currentTerm = nextTerm(currentTerm).intValue();
        }
        return result;
    }

    @Override
    public String print() {
        return printableTerms.toString();
    }

}

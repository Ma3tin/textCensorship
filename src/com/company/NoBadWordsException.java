package com.company;

public class NoBadWordsException extends RuntimeException {
    /**
     * exception ktera funguje v momente kdy nejsou zadne spatne slova
     * @param cause pricina
     */

    public NoBadWordsException(Throwable cause) {
        super(cause);
    }
}

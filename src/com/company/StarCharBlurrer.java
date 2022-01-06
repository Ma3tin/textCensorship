package com.company;

public class StarCharBlurrer extends CharBlurrer{
    /**
     * @return vraci hvezdicku jako blurrer
     */
    @Override
    protected String getBlurrChar() {
        return "*";
    }
}

package com.company;

public abstract class CharBlurrer implements IBlurrer{
    /**
     * metoda ktera ze slova udela zablurovane slovo
     * v abstraktni metode getBlurrChar() získám dany znak či typ blurovani(star-starDashed, ale daji se dodelat dalši)
     * @param word slovo ktere je potreba zablurrovat
     * @return vraci zablurrovane slobo
     */
    @Override
    public String blur(String word) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            output.append(getBlurrChar());
        }
        return output.toString();
    }

    abstract protected String getBlurrChar();
}

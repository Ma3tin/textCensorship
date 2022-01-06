package com.company;

public class StarDashBlurrer implements IBlurrer {
    protected StarCharBlurrer blurrer = new StarCharBlurrer();

    /**
     * metoda ktera resi blurrovani hvezdickou na zacatku a na konci a uprostred pomlcky
     * @param word slovo ktere je potreba zablurrovat
     * @return vraci string zablurovany napr. prdel = *---*
     */

    @Override
    public String blur(String word) {
        if (word.length() == 1 || word.length() == 2) blurrer.blur(word);
        StringBuilder output = new StringBuilder("*");
        for (int i = 2; i < word.length(); i++) {
            output.append("-");
        }
        return output.append("*").toString();
    }
}

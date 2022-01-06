package com.company;

import java.util.Arrays;
import java.util.List;

public class ArrayBadWordsProvider implements IBadWordsProvider{
    protected List<String> badWords;

    /**
     * v konstruktoru přenením pole zakazaných slov na list zakazaných slov
     * @param badWords pole zakazaných slov
     */

    public ArrayBadWordsProvider(String[] badWords) {
        this.badWords = Arrays.asList(badWords);
    }

    /**
     * @return metoda returnuje list zakazaných slov
     */

    @Override
    public List<String> getBadWords() {
        return badWords;
    }
}

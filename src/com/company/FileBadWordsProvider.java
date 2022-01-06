package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBadWordsProvider implements IBadWordsProvider{
    protected List<String> badWords;
    protected File input;

    public FileBadWordsProvider(File badWordsFile) {
        this.input = badWordsFile;
        this.badWords = null;
    }

    /**
     * metoda ziska z metody readBadWordsFromFile list zakazaných slov a davá je do listu spatnych slov
     * @return vraci list zakazaných slov
     * @throws NoBadWordsException exception v momente kdy neni file zakazanych slov
     */

    @Override
    public List<String> getBadWords() throws NoBadWordsException {
        if (badWords == null) {
            try {
                badWords = readBadWordsFromFile(input);
            } catch (IOException e) {
                throw new NoBadWordsException(e);
            }
        }
        return badWords;
    }

    /**
     * @param input file spatnych slov
     * @return vraci list zakazanych slov
     * @throws IOException vyhodi chybu v momente kdy není file
     */

    protected List<String> readBadWordsFromFile(File input) throws IOException {
        List<String> badWords = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(input));
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                badWords.add(line);
            }
        } finally {
            br.close();
        }
        return badWords;
    }
}

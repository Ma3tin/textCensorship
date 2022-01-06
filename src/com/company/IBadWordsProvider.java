package com.company;

import java.util.List;

public interface IBadWordsProvider {
    /**
     * Vrací zakazaná slova.
     * @return List zakazanách slov
     * @throws NoBadWordsException Když nastala nějaká chyba se získáním zakazaných slov
     */
    List<String> getBadWords() throws NoBadWordsException;
}

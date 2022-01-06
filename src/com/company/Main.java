package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * Načítání filu s texte který je potřeba za blurrovat
         */
        File file = new File("src/com/company/input.txt");
        try {
            /**
             * volani metody blurFile()
             * 1. argument: předavám file který je potřeba za blurrovat
             * 2. argument: předávaám classu s cestou na file, která se stará o rozebrání filu a prenese ho do listu
             * 3. argument: předávám classu kterou si vybírám zda chci slovo čistě hvězdičky nebo starDash(prdel=*---*)
             */
            blurFile(file, new FileBadWordsProvider(new File("src/com/company/badWords.txt")), new StarDashBlurrer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param badWords list se špatnými slovami
     * @param blurrer  interface který obsahuje metodu blur
     * @return vrací list špatných slov zablurovaných příklad.:prdel=***** nebo *---* zaleží jaky typ blurovaní se používá
     */
    public static List<String> createBlurredWords(List<String> badWords, IBlurrer blurrer) {
        List<String> blurredWords = new ArrayList<>();
        for (String badWord : badWords) {
            /**
             * ve foreach pridavám do listu zablurovaný slova pres interface blurrer a jeho metodu blur a jako parametr predavam spatne slovo
             */
            blurredWords.add(blurrer.blur(badWord));
        }
        return blurredWords;
    }

    /**
     *
     * @param input file s textem, který je potřeba zablurovat
     * @param badWordsProv interface který zařizuje špatné slova a v momentě kdy file chybu vyhazuje vlastní hlášku
     * @param blurrer interface na blurrovani
     * @throws IOException
     */
    public static void blurFile(File input, IBadWordsProvider badWordsProv, IBlurrer blurrer) throws IOException {
        /**
         * vytvaření listu špatných slov
         * vytváření listu zablurrovaných špatných slov
         */
        List<String> badWords = badWordsProv.getBadWords();
        List<String> blurredWords = createBlurredWords(badWords, blurrer);
        /**
         * bufferedReader načíta file a vraci je pres metodu readLine do stringu
         */
        BufferedReader br = new BufferedReader(new FileReader(input));
        try {
            String line = null;
            /**
             * while který iteruje do doby dokud v line nebude null coz se stane kdyz metoda readLine nenajde dalšá řádek
             */
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < badWords.size(); i++) {
                    /**
                     * v celým řádku replacuju špatný slova(díky regexum je poresený zda špatné slovo nezačína na velké písmeno) a nahrazuju je zablurovanými
                     */
                    line = line.replaceAll("(?i)" + badWords.get(i), blurredWords.get(i));
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            /**
             * vyhazuji chybu pokud neni file
             */
            e.printStackTrace();
        } finally {
            /**
             * zavru file
             */
            br.close();
        }
    }
}

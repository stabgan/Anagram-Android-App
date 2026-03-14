/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.anagrams;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;


public class AnagramDictionary {

    HashMap<String,ArrayList<String>> lettersToWord = new HashMap<>();
    HashSet<String> wordSet = new HashSet<>();
    List<String> list = new ArrayList<String>();
    Random random = new Random();



    public String sortLetters(String word){
        char[] temp = word.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordSet.add(word);
            list.add(word);


        }


        for (String word : wordSet) {
            String sortedWord = sortLetters(word);
            if (lettersToWord.containsKey(sortedWord)) {
                lettersToWord.get(sortedWord).add(word);
            } else {
                ArrayList<String> similarWords = new ArrayList<>();
                similarWords.add(word);
                lettersToWord.put(sortedWord, similarWords);
            }
        }
    }


    public boolean isGoodWord(String word, String base) {
        return wordSet.contains(word) && !word.contains(base);
    }

    public List<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : wordSet) {
            if (sortLetters(word).equals(sortLetters(targetWord))) {
                result.add(word);
            }
        }
        return result;
    }

    public List<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i<word.length() ; i++) {
            list.add(Character.toString(word.charAt(i)));
        }
        int l = word.length();

        for (String w : wordSet) {
            if (w.length() == (l + 1) && !w.contains(word)) {
                List<String> temp = new ArrayList<>();
                for(int i = 0 ; i<w.length() ; i++) {
                    temp.add(Character.toString(w.charAt(i)));
                }

                if (temp.containsAll(list)) {
                    result.add(w);
                }
            }
        }

        return result;
    }

    public String pickGoodStarterWord() {

        int i = random.nextInt(wordSet.size());
        return list.get(i);

//

    }
}

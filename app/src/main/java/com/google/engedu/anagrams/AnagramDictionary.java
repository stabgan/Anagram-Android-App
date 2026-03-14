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

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;

    private final HashMap<String, ArrayList<String>> lettersToWord = new HashMap<>();
    private final HashMap<Integer, ArrayList<String>> sizeToWords = new HashMap<>();
    private final HashSet<String> wordSet = new HashSet<>();
    private final List<String> wordList = new ArrayList<>();
    private final Random random = new Random();
    private int wordLength = DEFAULT_WORD_LENGTH;

    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String word = line.trim();
            if (word.isEmpty()) continue;
            wordSet.add(word);
            wordList.add(word);

            // Build the sorted-letters → words map
            String sortedKey = sortLetters(word);
            ArrayList<String> anagrams = lettersToWord.get(sortedKey);
            if (anagrams == null) {
                anagrams = new ArrayList<>();
                lettersToWord.put(sortedKey, anagrams);
            }
            anagrams.add(word);

            // Build the length → words map (for picking good starter words)
            int len = word.length();
            ArrayList<String> wordsOfLength = sizeToWords.get(len);
            if (wordsOfLength == null) {
                wordsOfLength = new ArrayList<>();
                sizeToWords.put(len, wordsOfLength);
            }
            wordsOfLength.add(word);
        }
    }

    public String sortLetters(String word) {
        char[] temp = word.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public boolean isGoodWord(String word, String base) {
        return wordSet.contains(word) && !word.contains(base);
    }

    public List<String> getAnagrams(String targetWord) {
        String sortedTarget = sortLetters(targetWord);
        ArrayList<String> result = lettersToWord.get(sortedTarget);
        if (result != null) {
            return new ArrayList<>(result);
        }
        return new ArrayList<>();
    }

    public List<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            String extendedKey = sortLetters(word + c);
            ArrayList<String> anagrams = lettersToWord.get(extendedKey);
            if (anagrams != null) {
                for (String anagram : anagrams) {
                    if (isGoodWord(anagram, word)) {
                        result.add(anagram);
                    }
                }
            }
        }
        return result;
    }

    public String pickGoodStarterWord() {
        ArrayList<String> candidates = sizeToWords.get(wordLength);
        if (candidates == null || candidates.isEmpty()) {
            return wordList.get(random.nextInt(wordList.size()));
        }

        int startIndex = random.nextInt(candidates.size());
        for (int i = 0; i < candidates.size(); i++) {
            int idx = (startIndex + i) % candidates.size();
            String candidate = candidates.get(idx);
            if (getAnagramsWithOneMoreLetter(candidate).size() >= MIN_NUM_ANAGRAMS) {
                if (wordLength < MAX_WORD_LENGTH) {
                    wordLength++;
                }
                return candidate;
            }
        }
        // Fallback: return a random word from the candidates
        return candidates.get(startIndex);
    }
}

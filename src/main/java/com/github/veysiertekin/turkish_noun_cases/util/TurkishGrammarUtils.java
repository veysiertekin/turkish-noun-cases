package com.github.veysiertekin.turkish_noun_cases.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TurkishGrammarUtils {
    public static final Locale TURKISH_LOCALE = new Locale("tr_TR");

    private static final String VOWELS = "a\u0131eiou\u00F6\u00FC";
    private static final String DEFINITE_ACCUSATIVE_SUFFIXES = "\u0131\u0131iiuu\u00FC\u00FC";

    private static final Pattern ANY_VOWEL_PATTERN = Pattern.compile("[a\\u0131eiou\\u00F6\\u00FC]");
    private static final Pattern BACK_VOWELS_PATTERN = Pattern.compile("[a\\u0131ou]");
    private static final Pattern ASSIMILATION_CHAR_PATTERN = Pattern.compile("[fstk\\u00E7\\u015Fhp]");
    private static final Pattern CIRCUMFLEX_ACCENT_PATTERN = Pattern.compile("[ei][^\\u0131\\u00FCo\\u00F6\\s]*[au]l$|alp$");

    public static String definiteAccusativeCaseAddition(String lowerName) {
        int circumflexAccentVowelIndex = findCircumflexAccentVowelIndex(lowerName);
        String lastVowel = findLastVowel(lowerName);

        int index = VOWELS.indexOf(lastVowel) + circumflexAccentVowelIndex;
        while (index >= DEFINITE_ACCUSATIVE_SUFFIXES.length()) {
            index = index - DEFINITE_ACCUSATIVE_SUFFIXES.length();
        }
        return DEFINITE_ACCUSATIVE_SUFFIXES.charAt(index) + "";
    }

    public static String locativeCaseAddition(String lowerName) {
        int circumflexAccentVowelIndex = findCircumflexAccentVowelIndex(lowerName);
        String lastVowel = findLastVowel(lowerName);

        if (BACK_VOWELS_PATTERN.matcher(lastVowel).matches()) {
            if (circumflexAccentVowelIndex == 2) {
                return "e";
            } else {
                return "a";
            }
        }
        return "e";
    }

    public static String assimilationCharAddition(String lowerName) {
        String lastChar = findLastChar(lowerName);
        if (ASSIMILATION_CHAR_PATTERN.matcher(lastChar).matches()) {
            return "t";
        }
        return "d";
    }

    public static boolean isLastCharIsVowel(String lowerName) {
        String lastVowel = findLastVowel(lowerName);

        String lastCharacter = findLastChar(lowerName);
        return lastVowel.equals(lastCharacter);
    }

    private static int findCircumflexAccentVowelIndex(String name) {
        Matcher matcherOne = CIRCUMFLEX_ACCENT_PATTERN.matcher(name);
        return matcherOne.find() ? 2 : 0;
    }

    private static String findLastVowel(String name) {
        Matcher matcherSecond = ANY_VOWEL_PATTERN.matcher(name);
        String lastVowel = "";
        while (matcherSecond.find()) {
            lastVowel = matcherSecond.group(0);
        }
        return lastVowel;
    }

    private static String findLastChar(String name) {
        return name.charAt(name.length() - 1) + "";
    }
}

package com.github.veysiertekin.turkish_noun_cases.impl;

import com.github.veysiertekin.turkish_noun_cases.TurkishNounCase;

import static com.github.veysiertekin.turkish_noun_cases.util.TurkishGrammarUtils.*;

/**
 * Belirtme hali (-(y)i)
 */
public class DefiniteAccusativeCase implements TurkishNounCase {
    public String combineWithSuffix(String name) {
        String lowerName = name.toLowerCase(TURKISH_LOCALE);
        String addition = definiteAccusativeCaseAddition(lowerName);
        if (isLastCharIsVowel(lowerName)) {
            addition = "y" + addition;
        }
        return name + "'" + addition;
    }
}

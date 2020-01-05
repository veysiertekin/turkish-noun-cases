package com.github.veysiertekin.turkish_noun_cases.impl;

import com.github.veysiertekin.turkish_noun_cases.TurkishNounCase;

import static com.github.veysiertekin.turkish_noun_cases.util.TurkishGrammarUtils.*;

/**
 * Bulunma hali (-de)
 */
public class LocativeCase implements TurkishNounCase {
    public String combineWithSuffix(String name) {
        String lowerName = name.toLowerCase(TURKISH_LOCALE);
        String addition = locativeCaseAddition(lowerName);
        addition = assimilationCharAddition(lowerName) + addition;
        return name + "'" + addition;
    }
}

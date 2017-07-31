package com.github.veysiertekin.turkish_noun_cases.impl;

import com.github.veysiertekin.turkish_noun_cases.TurkishNounCase;

import static com.github.veysiertekin.turkish_noun_cases.util.TurkishGrammarUtils.*;

/**
 * Cikma hali (-den)
 */
public class AblativeCase implements TurkishNounCase {
    private String name;

    public AblativeCase(String name) {
        this.name = name;
    }

    public String combineWithSuffix() {
        String lowerName = name.toLowerCase(TURKISH_LOCALE);
        String addition = locativeCaseAddition(lowerName);
        addition = assimilationCharAddition(lowerName) + addition + "n";
        return name + "'" + addition;
    }
}

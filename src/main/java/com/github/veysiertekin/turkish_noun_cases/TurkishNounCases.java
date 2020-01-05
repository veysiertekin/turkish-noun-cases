package com.github.veysiertekin.turkish_noun_cases;

import com.github.veysiertekin.turkish_noun_cases.impl.*;

/**
 * This enum provides singleton objects for a simple usage
 */
public enum TurkishNounCases {
    ABLATIVE_CASE(new AblativeCase()),
    DATIVE_CASE(new DativeCase()),
    DEFINITE_ACCUSATIVE_CASE(new DefiniteAccusativeCase()),
    GENITIVE_CASE(new GenitiveCase()),
    LOCATIVE_CASE(new LocativeCase());

    private TurkishNounCase caseImpl;

    TurkishNounCases(TurkishNounCase caseImpl) {
        this.caseImpl = caseImpl;
    }

    public String combineWithSuffix(String name) {
        return caseImpl.combineWithSuffix(name);
    }
}

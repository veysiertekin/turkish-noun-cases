package com.github.veysiertekin.turkish_noun_cases;

import com.github.veysiertekin.turkish_noun_cases.annotation.*;
import com.github.veysiertekin.turkish_noun_cases.impl.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TurkishNounCaseTest {
    @GenitiveCaseTest
    void genitiveCase(String name, String expected) throws Exception {
        TurkishNounCase nounCase = new GenitiveCase(name);
        assertEquals(expected, nounCase.combineWithSuffix());
    }

    @DefiniteAccusativeCaseTest
    void definiteAccusativeCase(String name, String expected) throws Exception {
        TurkishNounCase nounCase = new DefiniteAccusativeCase(name);
        assertEquals(expected, nounCase.combineWithSuffix());
    }

    @DativeCaseTest
    void dativeCase(String name, String expected) throws Exception {
        TurkishNounCase nounCase = new DativeCase(name);
        assertEquals(expected, nounCase.combineWithSuffix());
    }

    @LocativeCaseTest
    void locativeCase(String name, String expected) throws Exception {
        TurkishNounCase nounCase = new LocativeCase(name);
        assertEquals(expected, nounCase.combineWithSuffix());
    }

    @AblativeCaseTest
    void ablativeCase(String name, String expected) throws Exception {
        TurkishNounCase nounCase = new AblativeCase(name);
        assertEquals(expected, nounCase.combineWithSuffix());
    }
}

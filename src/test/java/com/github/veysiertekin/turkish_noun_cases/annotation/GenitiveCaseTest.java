package com.github.veysiertekin.turkish_noun_cases.annotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ParameterizedTest
@CsvFileSource(resources = "/genitive-case.csv")
@Retention(RetentionPolicy.RUNTIME)
public @interface GenitiveCaseTest {
}

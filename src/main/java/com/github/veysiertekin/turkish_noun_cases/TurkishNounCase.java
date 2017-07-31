package com.github.veysiertekin.turkish_noun_cases;

/**
 * Turkish Noun Cases
 * <p>
 * Source:
 * https://github.com/sercaneraslan/haller.js/blob/master/haller.js
 * <p>
 * Source:
 * https://en.wikipedia.org/wiki/Turkish_grammar
 * <p>
 * Definite Accusative	belirtme ("clarifying") durumu	        -(y)i	evi
 * Dative	            y\u00F6nelme ("going-towards") durumu	-(y)e	eve
 * Locative	            bulunma ("being-found") durumu	        -de	    evde
 * Ablative	            \u00E7\u0131kma ("going-out") durumu	-den	evden
 * Genitive	            tamlayan ("compounding") eki	        -(n)in	evin
 */
public interface TurkishNounCase {
    String combineWithSuffix();
}

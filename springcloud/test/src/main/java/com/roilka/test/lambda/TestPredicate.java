package com.roilka.test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestPredicate {

	public static void main(String[] args) {
		List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
	    Predicate<String> startsWithJ = (n) -> n.startsWith("J");
	    Predicate<String> fourLetterLong = (n) -> n.length() == 4;
	    
	    languages.stream().filter(startsWithJ.and(fourLetterLong)).forEach((n) -> System.out.println("nName, which starts with 'J' or four letter long is :"+n));
	}
}

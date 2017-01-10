package ch05.ex02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *LocalDate.of(2000, 2, 29)に1年を加算すると何が起きますか. さらに, 1年を4回加算するとどうなりますか.
 *
 *テストはコンソールを目視で確認
 **/

public class AddingYears {

	public static void main(String[] args) {
		LocalDate addingOneYears = LocalDate.of(2000, 2, 29).plusYears(1);
		System.out.println(addingOneYears);

		LocalDate addingFourYears = LocalDate.of(2000, 2, 29).plusYears(4);
		System.out.println(addingFourYears);

	}
}

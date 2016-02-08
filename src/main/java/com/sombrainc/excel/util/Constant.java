package com.sombrainc.excel.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Constant {

	private static final List<String> monthsList = new ArrayList<>();

	static {
		monthsList.add("January");
		monthsList.add("February");
		monthsList.add("March");
		monthsList.add("April");
		monthsList.add("May");
		monthsList.add("June");
		monthsList.add("July");
		monthsList.add("August");
		monthsList.add("September");
		monthsList.add("October");
		monthsList.add("November");
		monthsList.add("December");
	}

	public static final List<String> months = Collections.unmodifiableList(monthsList);

	private static final List<Integer> yearsList = new ArrayList<>();

	static {
		yearsList.add(2014);
		yearsList.add(2015);
	}

	public static final List<Integer> years = Collections.unmodifiableList(yearsList);
}

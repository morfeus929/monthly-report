package com.sombrainc.excel.dto;

import java.util.List;

public class MonthlyReportDTO {

	private String month;
	private int year;
	private List<String> data;

	public MonthlyReportDTO(final String month, final int year, final List<String> data) {
		this.month = month;
		this.year = year;
		this.data = data;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(final String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(final int year) {
		this.year = year;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(final List<String> data) {
		this.data = data;
	}

}

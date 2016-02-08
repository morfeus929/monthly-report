package com.sombrainc.excel.dto;

import java.util.List;

public class MonthlyReportDTO {

	private String month;
	private int year;
	private List<String> data;

	public MonthlyReportDTO(String month, int year, List<String> data) {
		super();
		this.month = month;
		this.year = year;
		this.data = data;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

}

package com.sombrainc.excel.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import com.sombrainc.excel.dto.MonthlyReportDTO;

public class MonthlyReportService {

	private HSSFWorkbook getWorkbook() {
		final ClassLoader classLoader = getClass().getClassLoader();
		HSSFWorkbook workbook = null;
		try {
			final String filePath = classLoader.getResource("file/version1.xls").getFile();
			System.out.println(filePath);
			final FileInputStream file = new FileInputStream(new File(filePath));
			workbook = new HSSFWorkbook(file);
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		}
		return workbook;
	}

	public MonthlyReportDTO getData(final String month, final int year) {
		final List<List<String>> result = new ArrayList<>();
		for (final Row row : getWorkbook().getSheetAt(0)) {
			if (Cell.CELL_TYPE_NUMERIC == row.getCell(0).getCellType()) {
				if (((Double) row.getCell(0).getNumericCellValue()).intValue() == (year) && row.getCell(1).getStringCellValue().equals(month)) {
					final List<String> temp = new ArrayList<>();
					for (int i = 2; i < row.getLastCellNum(); i++) {
						final Cell cell = row.getCell(i);
						switch (cell.getCellType()) {
							case Cell.CELL_TYPE_NUMERIC:
								temp.add(String.valueOf(cell.getNumericCellValue()));
								break;
							case Cell.CELL_TYPE_STRING:
								temp.add(cell.getStringCellValue());
								break;
						}
					}
					result.add(temp);
				}
			}
		}
		return new MonthlyReportDTO(month, year, result);
	}

	public String executeVlookup(String lookupValue, final String range, final int columnIndex, final String rangelookup) {
		final HSSFWorkbook wb = getWorkbook();
		final HSSFSheet sheet = wb.getSheetAt(0);
		final Row row = sheet.getRow(0);
		final Cell cell = row.createCell(7);
		cell.setCellType(Cell.CELL_TYPE_FORMULA);
		final Pattern pattern = Pattern.compile("\\d");
		final Matcher matcher = pattern.matcher(lookupValue);
		if (!matcher.find()) {
			lookupValue = "\"" + lookupValue + "\"";
		}
		final String formula = "VLOOKUP(" + lookupValue + "," + range + "," + columnIndex + "," + rangelookup + ")";
		cell.setCellFormula(formula);
		System.out.println(formula);
		final FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
		final Integer type = evaluator.evaluateFormulaCell(cell);
		return getCellValue(cell, type);
	}

	private static String getCellValue(final Cell cellValue, final Integer type) {
		switch (type == null ? cellValue.getCellType() : type.intValue()) {
			case Cell.CELL_TYPE_BOOLEAN:
				return String.valueOf(cellValue.getBooleanCellValue());
			case Cell.CELL_TYPE_NUMERIC:
				return String.valueOf(cellValue.getNumericCellValue());
			case Cell.CELL_TYPE_STRING:
				return cellValue.getStringCellValue();
			case Cell.CELL_TYPE_BLANK:
				return "<no value>";
			case Cell.CELL_TYPE_ERROR:
				return "<error>";
			default:
				return "<default>";
		}
	}

}

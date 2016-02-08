package com.sombrainc.excel.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.sombrainc.excel.dto.MonthlyReportDTO;

public class MonthlyReportService {

	public MonthlyReportDTO getData(final String month, final int year) {
		final List<String> list = new ArrayList<>();
		final ClassLoader classLoader = getClass().getClassLoader();
		try (FileInputStream file = new FileInputStream(new File(classLoader.getResource("file/version1.xls").getFile()))) {
			final HSSFWorkbook workbook = new HSSFWorkbook(file);
			final HSSFSheet sheet = workbook.getSheetAt(0);
			for (final Row row : sheet) {
				if (row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					if (((Double) row.getCell(0).getNumericCellValue()).intValue() == (year) && row.getCell(1).getStringCellValue().equals(month)) {
						for (int i = 2; i < row.getLastCellNum(); i++) {
							final Cell cell = row.getCell(i);
							switch (cell.getCellType()) {
								case Cell.CELL_TYPE_NUMERIC:
									list.add(String.valueOf(cell.getNumericCellValue()));
									break;
								case Cell.CELL_TYPE_STRING:
									list.add(cell.getStringCellValue());
									break;
							}
						}
					}
				}
			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return new MonthlyReportDTO(month, year, list);
	}
}

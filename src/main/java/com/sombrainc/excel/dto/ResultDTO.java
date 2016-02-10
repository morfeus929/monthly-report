package com.sombrainc.excel.dto;

public class ResultDTO {

	private String formula;
	private String result;

	public ResultDTO(final String formula, final String result) {
		this.formula = formula;
		this.result = result;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(final String formula) {
		this.formula = formula;
	}

	public String getResult() {
		return result;
	}

	public void setResult(final String result) {
		this.result = result;
	}

}

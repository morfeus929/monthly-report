package com.sombrainc.excel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sombrainc.excel.service.MonthlyReportService;
import com.sombrainc.excel.util.Constant;

@Controller
public class MonthlyReportController {

	private final MonthlyReportService service = new MonthlyReportService();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printMain(final ModelMap model) {
		model.addAttribute("monthList", Constant.months);
		model.addAttribute("yearList", Constant.years);
		model.addAttribute("msg", "Monthly Report");
		return "main";
	}

	@RequestMapping(value = "/table", method = RequestMethod.POST)
	public ModelAndView printTable(@RequestParam(value = "month") final String month, @RequestParam(value = "year") final String year) {
		final ModelAndView model = new ModelAndView();
		model.addObject("report", service.getData(month, Integer.parseInt(year)));
		return model;
	}

	@RequestMapping(value = "/vlookup", method = RequestMethod.GET)
	public String printVlookup(final ModelMap model) {
		model.addAttribute("monthList", Constant.months);
		model.addAttribute("yearList", Constant.years);
		model.addAttribute("msg", "Vlookup");
		return "vlookupform";
	}

	@RequestMapping(value = "/vlookup", method = RequestMethod.POST)
	public String runVlookup(@RequestParam(value = "value") final String value, @RequestParam(value = "range") final String range,
			@RequestParam(value = "column") final String column, @RequestParam(value = "rangelookup") final String rangelookup,
			final ModelMap model) {
		model.addAttribute("vlookup", service.executeVlookup(value, range, Integer.parseInt(column), rangelookup));
		model.addAttribute("msg", "Vlookup");
		return "vlookup";
	}
}

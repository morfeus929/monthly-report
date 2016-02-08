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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printMain(ModelMap model) {
		model.addAttribute("monthList", Constant.months);
		model.addAttribute("yearList", Constant.years);
		model.addAttribute("msg", "Monthly Report");
		return "main";
	}

	@RequestMapping(value = "/table", method = RequestMethod.POST)
	public ModelAndView printTable(@RequestParam(value = "month") String month,
			@RequestParam(value = "year") String year) {
		ModelAndView model = new ModelAndView();
		model.addObject("report", new MonthlyReportService().getData(month, Integer.parseInt(year)));
		return model;
	}
}
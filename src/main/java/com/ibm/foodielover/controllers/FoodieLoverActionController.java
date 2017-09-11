package com.ibm.foodielover.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.sql.SQLDataException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.foodielover.common.Constants;
import com.ibm.foodielover.common.JSONWrapper;
import com.ibm.foodielover.entity.Food;
import com.ibm.foodielover.service.FoodieLoverService;


@RestController
@RequestMapping(value = "/rest")
public class FoodieLoverActionController {
	
	@Autowired
	private FoodieLoverService assetService;
	
	
	private static Logger logger = Logger.getLogger(FoodieLoverActionController.class);
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8", value = "/findFood")
	public @ResponseBody JSONWrapper findFood(@RequestBody Map<String, String> map) {
		logger.info("enter findFood method with request mapping /findFood");
		
		JSONWrapper wrapper = new JSONWrapper();
		
		String number = map.get("number");
		String foodName = map.get("foodNm");
		
		//boolean foodExist = assetService.searchFoodService(number);
		
		try {
			List<Food> foodResult = assetService.getFoodByNameService(foodName);
			wrapper.setCode(Constants.CODE_SUCCESS);
			wrapper.setContent(foodResult);
			wrapper.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			wrapper.setCode(Constants.CODE_FAILED);
			wrapper.setSuccess(false);
		}
		
		return wrapper;
	}
	
	@RequestMapping("/index")
	public String index() {
		return "demo";
	}
	
	@RequestMapping("/search")
	public String search() {
		return "This is return search result for detail page.";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "Asset has been updated into database";
	}
	
}

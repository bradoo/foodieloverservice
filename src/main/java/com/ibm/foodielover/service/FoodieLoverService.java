package com.ibm.foodielover.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.foodielover.dao.Impl.FoodieLoverDaoImpl;
import com.ibm.foodielover.entity.Food;


@Service("FoodieLoverService")
public class FoodieLoverService {
	
	@Autowired
	private FoodieLoverDaoImpl foodieLoverDao;
	
	public boolean searchFoodService (String number) {
		boolean isValidate = false;
		
		isValidate = foodieLoverDao.searchFoodDao(number);
					
		return isValidate;
	}
	
	public List<Food> getFoodByNameService(String foodName) throws Exception{
		List<Food> resultList = foodieLoverDao.getFoodByNameDao(foodName);
		return resultList;
	}
	
}
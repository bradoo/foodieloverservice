package com.ibm.foodielover.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ibm.foodielover.entity.Food;

@Component("FoodieLoverDaoImpl")
public class FoodieLoverDaoImpl {
	
	private static Logger logger = Logger.getLogger(FoodieLoverDaoImpl.class);
	
	private static final String search_food_sql = "select * from DEFECTREPORT.FOOD where NUMBER=?";
	
	private static final String get_foodByNm_sql = "select * from DEFECTREPORT.FOOD where lower(name) like ?";
	
	@Autowired
	protected JdbcTemplate foodieloverJdbcTemplate;
	
	public boolean searchFoodDao(String number) {
		boolean isNull = false;
		number = "1";
		
		List<Map<String, Object>> list = foodieloverJdbcTemplate.queryForList(search_food_sql, number);
		
		if (list != null && list.size() > 0) {
			isNull = true;
		}
		return isNull;
	}
	
	public List<Food> getFoodByNameDao(String foodName) throws Exception {
		String param = "%"+ foodName + "%";
		//String param = "pasta";
		
		List<Food> resultList = foodieloverJdbcTemplate.query(get_foodByNm_sql, new Object[]{param.toLowerCase()} , 
				new  RowMapper<Food>(){
					public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
						Food food = new Food();
						food.setFoodId(rs.getString("FOOD_ID"));
						food.setFoodName(rs.getString("NAME"));
						food.setFoodNumber(rs.getString("NUMBER"));
						food.setFoodHeat(rs.getString("HEAT"));
						food.setFoodScore(rs.getString("SCORE"));
						food.setFoodTag(rs.getString("TAG"));
						return food;
					}
		});
		return resultList;
	}
	
}

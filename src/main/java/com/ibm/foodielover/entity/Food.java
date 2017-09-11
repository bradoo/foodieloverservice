package com.ibm.foodielover.entity;

import java.io.Serializable;
import java.util.Date;

public class Food implements Serializable {
	
	private String foodId;
	
	private String foodName;
	
	private String foodNumber;
	
	private String foodHeat;
	
	private String foodScore;
	
	private String foodTag;

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodNumber() {
		return foodNumber;
	}

	public void setFoodNumber(String foodNumber) {
		this.foodNumber = foodNumber;
	}

	public String getFoodHeat() {
		return foodHeat;
	}

	public void setFoodHeat(String foodHeat) {
		this.foodHeat = foodHeat;
	}

	public String getFoodScore() {
		return foodScore;
	}

	public void setFoodScore(String foodScore) {
		this.foodScore = foodScore;
	}

	public String getFoodTag() {
		return foodTag;
	}

	public void setFoodTag(String foodTag) {
		this.foodTag = foodTag;
	}

}
package com.resilience.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class OrderDTO {
    
	    private int id;
	    private String name;
	    private String category;
	    private String color;
	    private double price;
		/**
		 * @param id
		 * @param name
		 * @param category
		 * @param color
		 * @param price
		 */
		public OrderDTO(int id, String name, String category, String color, double price) {
			super();
			this.id = id;
			this.name = name;
			this.category = category;
			this.color = color;
			this.price = price;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
    
    
}

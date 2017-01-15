package com.sda.project.dao;

import java.util.List;

import com.sda.project.model.Item;

public interface ItemDao {


	void saveItem(Item item);
	
	void deleteItemById(int id);

	Item findItemById(int id);
	
	List<Item> findAllItems();
}

package com.sda.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda.project.dao.ItemDao;
import com.sda.project.model.Item;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDao itemDao;

	public void saveItem(Item item) {
		itemDao.saveItem(item);
	}

	public void updateItem(Item item) {
		Item entity = itemDao.findItemById(item.getItemId());
		if(entity!=null){
			entity.setTitle(item.getTitle());
			entity.setBody(item.getBody());
			entity.setPriority(item.getPriority());
			entity.setSeverity(item.getSeverity());
			entity.setOriginalEstimate(item.getOriginalEstimate());
			entity.setRemainingTime(item.getRemainingTime());
			entity.setCompletitionTime(item.getCompletitionTime());
		}
	}

	public void deleteItemById(int id) {
		itemDao.deleteItemById(id);
	}
	
	public Item findItemById(int id) {
		return itemDao.findItemById(id);
	}
	
	public List<Item> findAllItems() {
		return itemDao.findAllItems();
	}
	
	public boolean isItemIdUnique(int id) {
		Item item = findItemById(id);
		return ( item == null);
	}
	
}

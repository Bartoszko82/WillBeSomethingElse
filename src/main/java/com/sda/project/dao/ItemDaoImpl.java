package com.sda.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sda.project.model.Item;

@Repository("itemDao")
public class ItemDaoImpl extends AbstractDao<Integer, Item> implements ItemDao {

	public void saveItem(Item item) {
		persist(item);
	}

	public void deleteItemById(int id) {
		Query query = getSession().createSQLQuery("delete from Item where item_id = :item_id");
		query.setInteger("item_id", id);
		query.executeUpdate();
	}
	
	public Item findItemById(int id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<Item> findAllItems() {
		Criteria criteria = createEntityCriteria();
		return (List<Item>) criteria.list();
	}
}

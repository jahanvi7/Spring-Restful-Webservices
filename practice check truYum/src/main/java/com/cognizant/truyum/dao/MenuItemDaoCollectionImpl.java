package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);

	private static List<MenuItem> menuItemList;
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> fil = new ArrayList<MenuItem>();
		for(MenuItem x : menuItemList)
		{
			Date d = x.getDateOfLaunch();
			Date today = new Date();
			if(d.before(today) || d.equals(today))
			{
				if(x.isActive())
					fil.add(x);
			}
		}
		return fil;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		for(MenuItem item : menuItemList) {
			if(item.equals(menuItem)) {
				item.setName(menuItem.getName());
				item.setPrice(menuItem.getPrice());
				item.setActive(menuItem.isActive());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
				item.setCategory(menuItem.getCategory());
				item.setFreeDelivery(menuItem.isFreeDelivery());
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		for(MenuItem x : menuItemList) {
			if(x.getId()== menuItemId) {
				return x;
			}
		}
		return null;
	}
	
	public MenuItemDaoCollectionImpl()
	{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList = (List<MenuItem>) context.getBean("menuItems");
	}

}

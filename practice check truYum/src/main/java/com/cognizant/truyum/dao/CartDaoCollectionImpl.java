package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
public class CartDaoCollectionImpl implements CartDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoCollectionImpl.class);
	
	public static LinkedHashMap<String, Cart> userCarts;

	public static HashMap<String, Cart> getUserCarts() {
		return userCarts;
	}

	public static void setUserCarts(LinkedHashMap<String, Cart> userCarts) {
		CartDaoCollectionImpl.userCarts = userCarts;
	}

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	@Autowired
	private  MenuItemDao menuItemDao;
	
	@Override
	public void addCartItem(String userId, long menuItemId) {
		LOGGER.info("START");
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if(userCarts.containsKey(userId))
		{
			LOGGER.info("inside if");
			Cart cart = userCarts.get(userId);
			List<MenuItem> menuItemList = cart.getMenuItemList();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			//cart.setTotal(cart.getTotal()+menuItem.getPrice());
			userCarts.put(userId, cart);
		}
		else
		{
			LOGGER.info("inside else");
			LOGGER.info(userId + menuItemId);
			Cart cart = new Cart(new ArrayList<MenuItem>(), 0);
			List<MenuItem> list =  cart.getMenuItemList();
			list.add(menuItem);
			cart.setMenuItemList(list);
			userCarts.put(userId, cart);
		}
		LOGGER.info("End");
	}
	
	
	@Override
	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		LOGGER.info("START");
		List<MenuItem> all = userCarts.get(userId).getMenuItemList();
		if(all.isEmpty()) 
		{
			LOGGER.info("End");
			throw new CartEmptyException();
		}
		else
		{
			float sum = 0.00f;
			for(MenuItem item: all) 
			{
				sum += item.getPrice();
			}
			userCarts.get(userId).setTotal(sum);
		}
		LOGGER.info("End");
		return all;
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) {
		LOGGER.info("START");
		List<MenuItem> list = userCarts.get(userId).getMenuItemList();
		for(MenuItem item : list) {
			if(menuItemId == item.getId())
			{
				list.remove(list.indexOf(item));
				break;
			}
		}
		userCarts.get(userId).setMenuItemList(list); 
		LOGGER.info("End");
		}
	
	public CartDaoCollectionImpl() {
		LOGGER.info("START");
		if(userCarts == null) {
			userCarts = new LinkedHashMap<String, Cart>();
		}
		LOGGER.info("End");
	}

}


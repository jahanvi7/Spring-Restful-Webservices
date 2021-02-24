package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	public CartService getCartService() {
		LOGGER.info("START");
		LOGGER.info("End");
		return cartService;
	}

	public void setCartService(CartService cartService) {
		LOGGER.info("START");
		LOGGER.info("End");
		this.cartService = cartService;
	}
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable String userId, @PathVariable long menuItemId) {
		LOGGER.info("START");
		LOGGER.info("End");
		cartService.addCartItem(userId, menuItemId);
	}
	
	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable String userId) throws CartEmptyException{
		LOGGER.info("START");
		LOGGER.info("End");
		return cartService.getAllCartItems(userId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItems(@PathVariable String userId, @PathVariable long menuItemId) throws CartEmptyException {
		LOGGER.info("START");
		LOGGER.info("End");
		cartService.deleteCartItem(userId, menuItemId);
	}
}


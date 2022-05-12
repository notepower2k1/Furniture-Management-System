package com.thgroup.fms.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.thgroup.fms.entity.CartItem;
import com.thgroup.fms.service.ShoppingCartService;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	//gio hang
	Map<Integer,CartItem> maps = new HashMap<>();
	@Override
	public void add(CartItem item) {
		CartItem cartItem = maps.get(item.getProductId());
		//khong co trong gio hang
		if (cartItem == null) {
			maps.put(item.getProductId(), item);
			
		}
		else {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		}
	}
	@Override
	public void remove(int id) {
		maps.remove(id);
	}
	@Override
	public CartItem update(int proID,int quantity) {
		CartItem cartItem = maps.get(proID);
		cartItem.setQuantity(quantity);
		return cartItem;
	}	
	@Override
	public void Clear() {
		maps.clear();
	}
	@Override
	public Collection<CartItem> getAllItem(){
		return maps.values();
	}
	@Override
	public int getCount() {
		return maps.values().size();
	}
	@Override
	public double getTotal() {
		return maps.values().stream().
				mapToDouble(item -> item.getQuantity() * item.getPrice())
				.sum();
	}
}

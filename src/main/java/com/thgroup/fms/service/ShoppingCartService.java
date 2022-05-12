package com.thgroup.fms.service;



import java.util.Collection;

import com.thgroup.fms.entity.CartItem;

public interface ShoppingCartService {

	void add(CartItem item);
	void remove(int id);
	CartItem update(int proID,int quantity);
	void Clear();
	Collection<CartItem> getAllItem();
	int getCount();
	double getTotal();
}

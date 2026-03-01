package com.cts.jpmcpresonal.service;


import java.util.List;
import java.util.Optional;

import com.cts.jpmcpresonal.model.*;

public interface SuperMarketService {
	List<SuperMarket> getAllItems();
    SuperMarket getItemById(int itemNo);
    SuperMarket addItem(SuperMarket item);
    SuperMarket updateItem(int itemNo, SuperMarket item);
    void deleteItem(int itemNo);
    Optional<Cart> getCartItem(int itemNo);
    Cart addToCart(int itemNo, int quantity);
    List<Cart> getCartItems();
    List<Float> checkout();
    void deleteAllItem();
    
}
package com.cts.jpmcpresonal.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cts.jpmcpresonal.model.Cart;
import com.cts.jpmcpresonal.model.SuperMarket;
import com.cts.jpmcpresonal.service.SuperMarketService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/supermarket")
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class SuperMarketController {
	@Autowired
    public SuperMarketService service;
	
	@GetMapping
	public String Status() {
		return "Application is Successfully running...";
	}
    @GetMapping("/items")
    public List<SuperMarket> getAllItems() {
        return service.getAllItems();
    }

    @PostMapping("/items")
    public SuperMarket addItem(@RequestBody SuperMarket item) {
        return service.addItem(item);
    }

    @PostMapping("/cart/{itemNo}/{quantity}")
    public Cart addToCart(@PathVariable int itemNo, @PathVariable int quantity) {
        return service.addToCart(itemNo, quantity);
    }

    @GetMapping("/cart")
    public List<Cart> getCartItems() {
        return service.getCartItems();
    }
    
    @GetMapping("/cartItem/{itemNo}")
    public Optional<Cart> getCartItem(@PathVariable int itemNo){
    	return service.getCartItem(itemNo);
    }

    @GetMapping("/checkout")
    public List<Float> checkout() {
        return service.checkout();
    }
    
    @DeleteMapping("/cart/remove/{itemNo}")
    public void RemoveItemFromCart(@PathVariable int itemNo) {
    	service.deleteItem(itemNo);
    }
}
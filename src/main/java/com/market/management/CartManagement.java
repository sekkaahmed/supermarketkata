package com.market.management;

import java.util.List;
import java.util.logging.Logger;

import com.market.pojos.Cart;
import com.market.pojos.Item;

public class CartManagement {
    
    private static Logger log=Logger.getLogger(CartManagement.class.getName());
    
     /**
      * Add an itiem to a cart
      * @param cart
      * @param item
      */
    public void addItem(Cart cart,Item item) {
	cart.getListItems().add(item);
    }
    /**
     * Add a list of items to a cart
     * @param cart
     * @param listIstems
     */
    public void addItems(Cart cart,List<Item> listIstems) {
	cart.getListItems().addAll(listIstems);
    }

    /**
     * Remove an item from a cart
     * @param cart
     * @param item
     */
    public void removeItem(Cart cart, Item item) {
	cart.getListItems().remove(item);
    }
    
    /**
     * Clear cart list
     * @param cart
     */
    public void removeAll(Cart cart) {
       cart.getListItems().clear();
    }
    
    /**
     * Show cart item list
     * @param cart
     */
    public void viewCartItem(Cart cart){
	
	if(cart!=null) {
	    log.info("Cart code: "+cart.getCode());	
	    List<Item> listItems=cart.getListItems();
	    if(listItems!=null && !listItems.isEmpty()) {
		
		listItems.stream().forEach(item->log.info(item.toString()));
		
	    }
	}
	
    }
     
}

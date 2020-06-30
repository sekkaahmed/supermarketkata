package com.market.management;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.market.pojos.Cart;
import com.market.pojos.Item;
import com.market.pojos.Offer;

public class CartManagement {
    
    private static Logger log=Logger.getLogger(CartManagement.class.getName());
    
     /**
      * Add an itiem to a cart
      * @param cart
      * @param item
      */
    public boolean addItem(Cart cart,Item item) {
	    return cart.getListItems().add(item);
    }
    /**
     * Add a list of items to a cart
     * @param cart
     * @param listIstems
     */
    public boolean addItems(Cart cart,List<Item> listIstems) {
	   return cart.getListItems().addAll(listIstems);
    }

    /**
     * Remove an item from a cart
     * @param cart
     * @param item
     */
    public boolean removeItem(Cart cart, Item item) {
	    return cart.getListItems().remove(item);
    }
    
    /**
     * Clear cart list
     * @param cart
     */
    public void removeAll(Cart cart) {
       cart.getListItems().clear();
    }
    
    /**
     * Calculate the sum of prices od items
     * @param cart
     * @return
     */
    public BigDecimal  calculateTotalAccount(Cart cart) {
    	BigDecimal totalSum[]= {BigDecimal.ZERO};
    	List<Item> listItem=cart.getListItems();
    	if(null!=listItem && !listItem.isEmpty()) {
    		//Classify the items by code
    		Map<String,List<Item>> mapItems= listItem.stream().collect(Collectors.groupingBy(Item::getCode));
    		
    		if(mapItems!=null && !mapItems.isEmpty()) {
    			
    			mapItems.forEach((k,v)->{
    			BigDecimal size=new BigDecimal(v.size());
    			BigDecimal price=v.get(0).getPrice();
    			Offer offer=v.get(0).getOffer();
    			int offerCountItems=offer.getCountItem();
    			BigDecimal totalOffersSum=BigDecimal.ZERO;
    			BigDecimal totalNotOffersSum=BigDecimal.ZERO;
    			if(offer==null) {
    				totalNotOffersSum=price.multiply(size);
    			}else {
    				
    			 int elemntsInOffer=v.size()/offerCountItems;
    			 int elemntsOffOffer=v.size()%offerCountItems;
    			 BigDecimal totalOffers=offer.getCountItemPrice().multiply(new BigDecimal(elemntsInOffer));
    			 BigDecimal totalInOffers=v.get(0).getPrice().multiply(new BigDecimal(elemntsOffOffer));
    			 totalOffersSum=totalInOffers.add(totalOffers);
    			}
    			totalSum[0]=totalOffersSum.add(totalNotOffersSum);
    			});
    		}
    	}
    	
    	return totalSum[0];
    	
    }
    
    /**
     * Show cart item list
     * @param cart
     */
    public void viewCartItems(Cart cart){
	
	if(cart!=null) {
	    log.info("Cart code: "+cart.getCode());	
	    List<Item> listItems=cart.getListItems();
	    if(listItems!=null && !listItems.isEmpty()) {
		listItems.stream().forEach(item->log.info(item.toString()));
		
	    }
	}
	
    }
     
}

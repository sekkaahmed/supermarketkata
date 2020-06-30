package com.market.test;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.market.management.CartManagement;
import com.market.pojos.Cart;
import com.market.pojos.Item;
import com.market.pojos.Offer;

public class CartManagementTest {

	
	private Cart cart;
	private CartManagement CartManagement;
	
	
 
    @Before
    public void init() {
    	CartManagement=new CartManagement();
    	this.cart=new Cart();
    	Item itemA=new Item("code_a", new BigDecimal(50), new Offer(3,new BigDecimal(130)));
    	Item itemB=new Item("code_b", new BigDecimal(25), new Offer(5,new BigDecimal(100)));
    	Item itemC=new Item("code_c", new BigDecimal(15), null);
    	Item itemD=new Item("code_d", new BigDecimal(80), new Offer(2,new BigDecimal(110)));
    	List<Item> items=Arrays.asList(itemA,itemB,itemC,itemD);
    	this.cart.setCode("card_1");
    	this.cart.setListItems(items);
    	System.out.println("CartManagementTest.init()");
    }
    
    
    @Test
    public void test_add_item_to_cart() {
    	Item item=new Item("code_e", new BigDecimal(19), null);
    	List<Item> items=new ArrayList<Item>(cart.getListItems());
    	assertTrue("The item should be added to the cart list",CartManagement.addItem(cart, item));
    }
    
    @Test
    public void test_remove_item_from_cart() {
    	
    }
}

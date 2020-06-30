package com.market.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import com.market.management.CartManagement;
import com.market.pojos.Cart;
import com.market.pojos.Item;
import com.market.pojos.Offer;

public class CartManagementTest {

	private Cart cart = new Cart();
	private CartManagement cartManagement = new CartManagement();

	@Before
	public void init() {
		Item itemA = new Item("code_a", new BigDecimal(50), new Offer(3, new BigDecimal(130)));
		Item itemB = new Item("code_b", new BigDecimal(25), new Offer(5, new BigDecimal(100)));
		Item itemC = new Item("code_c", new BigDecimal(15), null);
		Item itemD = new Item("code_d", new BigDecimal(80), new Offer(2, new BigDecimal(110)));
		List<Item> items = Arrays.asList(itemA, itemB, itemC, itemD);
		this.cart.setCode("card_1");
		this.cart.setListItems(new ArrayList<Item>(items));
	}

	@Test
	public void test_add_item_to_cart() {
		Item item = new Item("code_e", new BigDecimal(19), null);
		assertTrue("The item should be added to the cart list", cartManagement.addItem(cart, item));
	}

	@Test
	public void test_add_some_items_to_cart() {
		Item itemF = new Item("code_f", new BigDecimal(150), null);
		Item itemG = new Item("code_g", new BigDecimal(200), null);
		List<Item> listIstems = Arrays.asList(itemF, itemG);
		assertTrue("The item should be removed from the cart list", cartManagement.addItems(cart, listIstems));
	}

	@Test
	public void test_remove_item_from_cart() {
		Item item = cart.getListItems().get(0);
		assertTrue("The item should be removed from the cart list", cartManagement.removeItem(cart, item));
	}


	@Test
	public void test_remove_all_items_from_cart() {
		cartManagement.removeAll(cart);
		assertTrue("All item should be removed from the cart list", cart.getListItems().isEmpty());
	}

	@Test
	public void test_show_all_cart_items() {
     	cartManagement.viewCartItems(cart);
		BigDecimal sum = cartManagement.calculateTotalAccount(cart);
		assertNotNull("The sum of price items  should  not be null", sum);

	}

	@Test
	public void test_if_offer_is_applied() {

		Item itemA1 = new Item("code_offer", new BigDecimal(50), new Offer(3, new BigDecimal(130)));
		Item itemA2 = new Item("code_offer", new BigDecimal(50), new Offer(3, new BigDecimal(130)));
		Item itemA3 = new Item("code_offer", new BigDecimal(50), new Offer(3, new BigDecimal(130)));

		cartManagement.addItem(cart, itemA1);
		cartManagement.addItem(cart, itemA2);
		cartManagement.addItem(cart, itemA3);

		// We shoud get 130
		BigDecimal sum = cartManagement.calculateTotalAccount(cart);
		assertEquals(sum, new BigDecimal(130));
		Item itemA4 = new Item("code_offer", new BigDecimal(50), new Offer(3, new BigDecimal(130)));
		cartManagement.addItem(cart, itemA4);
		sum = cartManagement.calculateTotalAccount(cart);
		assertEquals(sum, new BigDecimal(180));
	}

}

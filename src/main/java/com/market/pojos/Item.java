package com.market.pojos;

import java.math.BigDecimal;

public class Item {

    private String code;
    private BigDecimal price;
    private Offer offer;

    public Item(String code, BigDecimal price, Offer offer) {

	this.code = code;
	this.price = price;
	this.offer = offer;

    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public BigDecimal getPrice() {
	return price;
    }

    public void setPrice(BigDecimal price) {
	this.price = price;
    }

    public Offer getOffer() {
	return offer;
    }

    public void setOffer(Offer offer) {
	this.offer = offer;
    }

    @Override
    public String toString() {

	return "Code: " + code + "   Price: " + price + "  Offer_ " + offer;
    }

}

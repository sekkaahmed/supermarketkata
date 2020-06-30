package com.market.pojos;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Offer {

    
    private Integer countItem;
    private BigDecimal countItemPrice;
    
    
    public Offer(Integer countItem,BigDecimal countItemPrice) {
    	
    	this.countItem=countItem;
    	this.countItemPrice=countItemPrice;
    }
    
    
    public Integer getCountItem() {
        return countItem;
    }
    public void setCountItem(Integer countItem) {
        this.countItem = countItem;
    }
    public BigDecimal getCountItemPrice() {
        return countItemPrice;
    }
    public void setCountItemPrice(BigDecimal countItemPrice) {
        this.countItemPrice = countItemPrice;
    }
    
    @Override
    public String toString() {
    	NumberFormat format = NumberFormat.getCurrencyInstance();
        return " CountItem: "+countItem+" CountItemPrice: "+format.format(countItemPrice);
    }
}

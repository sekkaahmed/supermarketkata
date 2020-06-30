package com.market.pojos;

import java.math.BigDecimal;

public class Offer {

    
    private Integer countItem;
    private BigDecimal countItemPrice;
    
    
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
        return "CountItem: "+countItem+"CountItemPrice   :"+countItemPrice;
    }
}

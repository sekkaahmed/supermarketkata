package com.market.pojos;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    
    private String code;
    private List<Item> listItems=new ArrayList<>();
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public List<Item> getListItems() {
        return listItems;
    }
    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }
    
    
    

}

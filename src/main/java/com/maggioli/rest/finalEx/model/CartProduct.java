package com.maggioli.rest.finalEx.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CART_PRODUCT")
@DynamicUpdate
public class CartProduct {
    @EmbeddedId
    CartProductKey id;
    
    private Integer quantity;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

    @JsonIgnore
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}

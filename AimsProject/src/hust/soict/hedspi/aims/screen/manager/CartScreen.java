package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.cart.Cart;

public class CartScreen {
	private static Cart cart;
	public static Cart getCart() {
		return cart;
	}
	public CartScreen(Cart cart) {
		CartScreen.cart = cart;
	}
}

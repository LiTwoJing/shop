package shop.pojo;

import java.util.List;

public class ShopCartL {
	 private List<ShopCart> items;

	    public ShopCartL(List<ShopCart> ShopCart) {
			this.items = ShopCart;
		}

		public List<ShopCart> getItems() {
			return items;
		}

}

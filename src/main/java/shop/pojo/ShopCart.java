package shop.pojo;

import java.util.List;

public class ShopCart {
	 private List<ShopCartitems> items;

	    public ShopCart(List<ShopCartitems> ShopCart) {
			this.items = ShopCart;
		}

		public List<ShopCartitems> getItems() {
			return items;
		}
		
		public int Tototal(){
			int total = 0;
			for(ShopCartitems item :items){
				total += item.getCellphone().getPrice() * item.getAmount();
			}
			return total;
		}
}

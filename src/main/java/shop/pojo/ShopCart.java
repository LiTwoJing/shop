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
		
		public Integer Tototal(){
			Integer total = 0;
			for(ShopCartitems si :items){
				total+= si.getCellphone().getPrice() * si.getAmount();
			}
			return total;
		}
}

package shop.controller.form;

import shop.pojo.Orders;
import shop.pojo.ShopAddress;

public class OrdersForm {
	private Integer shopAddressid;

	public Integer getShopAddressid() {
		return shopAddressid;
	}

	public void setShopAddressid(Integer shopAddressid) {
		this.shopAddressid = shopAddressid;
	}
	
	
	public Orders toOrders (){
		Orders order = new Orders();
		
		ShopAddress shopAddress= new ShopAddress();
		shopAddress.setId(shopAddressid);
		
		order.setShopAddress(shopAddress);
		
		return order;
	}
}

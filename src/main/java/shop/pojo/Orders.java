package shop.pojo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

public class Orders {
	private Integer id;
	private Customer customer;
	private ShopCartitems shopCartitems;
	@NotNull(message="请选择收货地址")
	private ShopAddress shopAddress;
	private Date findtime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getFindtime() {
		return findtime;
	}

	public void setFindtime(Date findtime) {
		this.findtime = findtime;
	}

	public ShopAddress getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(ShopAddress shopAddress) {
		this.shopAddress = shopAddress;
	}

	public ShopCartitems getShopCartitems() {
		return shopCartitems;
	}

	public void setShopCartitems(ShopCartitems shopCartitems) {
		this.shopCartitems = shopCartitems;
	}
	
	

}

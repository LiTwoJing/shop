package shop.service;

import java.util.Date;
import java.util.List;

import shop.pojo.Orders;
import shop.pojo.OrdersItems;
import shop.pojo.ShopAddress;
import shop.pojo.ShopCartitems;

public interface OrderService {

	List<OrdersItems> findAll(Integer userId);

	List<ShopCartitems> findShopCartByUserId(Integer userId);

	List<ShopAddress> findShopAddressByUserId(Integer userId);


	void deleteShopCart(Integer userId);

	void insert(Orders orders, Integer userId, Date date);

}


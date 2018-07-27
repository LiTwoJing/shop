package shop.service;

import java.util.Date;
import java.util.List;

import shop.pojo.Orders;
import shop.pojo.ShopAddress;
import shop.pojo.ShopCartitems;

public interface OrderService {

	List<Orders> findAll(Integer userId, Integer cellphoneId);

	List<ShopCartitems> findShopCartByUserId(Integer userId);

	List<ShopAddress> findShopAddressByUserId(Integer userId);

	void insert(Orders orders,Integer userId, Date date);

	void deleteShopCart(Integer userId);

}


package shop.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import shop.pojo.Orders;
import shop.pojo.OrdersItems;
import shop.pojo.ShopAddress;
import shop.pojo.ShopCartitems;

public interface OrderMapper {

	List<Orders> findAll(Integer userId);

	List<ShopCartitems> findShopCartByUserId(Integer userId);

	List<ShopAddress> findShopAddressByUserId(Integer userId);

	void insert(Orders orders);

	void deleteShopCart(Integer userId);

	void insertOrderitems(OrdersItems ordersItems);
				
}

package shop.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mapper.OrderMapper;
import shop.pojo.Customer;
import shop.pojo.OrderState;
import shop.pojo.Orders;
import shop.pojo.OrdersItems;
import shop.pojo.ShopAddress;
import shop.pojo.ShopCartitems;
import shop.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderMapper orderMapper;
	
	@Autowired
	public OrderServiceImpl(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}


	public List<OrdersItems> findAll(Integer userId) {
		return orderMapper.findAll(userId);
	}


	public List<ShopCartitems> findShopCartByUserId(Integer userId) {
		return orderMapper.findShopCartByUserId(userId);
	}


	public List<ShopAddress> findShopAddressByUserId(Integer userId) {
		return orderMapper.findShopAddressByUserId(userId);
	}

	public void insert(Orders orders,Integer userId, Date date) {
		orders.setFindtime(date);
		Customer customer = new Customer();
		customer.setId(userId);
		orders.setCustomer(customer);
		orders.setState(OrderState.Created);
		orderMapper.insert(orders);
		
		
		
		List<ShopCartitems> sci = orderMapper.findShopCartByUserId(userId);
		for(ShopCartitems shopcartitem:sci){
			OrdersItems ordersItems = new OrdersItems();
			ordersItems.setOrders(orders);
			ordersItems.setCellphone(shopcartitem.getCellphone());
			ordersItems.setAmount(shopcartitem.getAmount());
			orderMapper.insertOrderitems(ordersItems);
		}
		
	}
	
	

	public void deleteShopCart(Integer userId) {
		orderMapper.deleteShopCart(userId);
	}
}

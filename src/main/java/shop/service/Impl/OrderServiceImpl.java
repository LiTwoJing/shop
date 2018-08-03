package shop.service.Impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mapper.OrderMapper;
import shop.pojo.Customer;
import shop.pojo.OrderState;
import shop.pojo.Orders;
import shop.pojo.OrdersItems;
import shop.pojo.ShopAddress;
import shop.pojo.ShopCartitems;
import shop.service.OrderService;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private OrderMapper orderMapper;
	private ObjectMapper objectMapper;
	private AlipayClient alipayClient;
    private String alipayReturnUrl;
    private String alipayNotifyUrl;
	
	
	@Autowired
	public OrderServiceImpl(OrderMapper orderMapper, 
			AlipayClient alipayClient,
            Environment env,
            ObjectMapper objectMapper) {
		this.orderMapper = orderMapper;
		this.alipayClient = alipayClient;
	    this.alipayReturnUrl = env.getProperty("alipay.returnUrl");
	    this.alipayNotifyUrl = env.getProperty("alipay.notifyUrl");
	    this.objectMapper = objectMapper;
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
		logger.debug("插入订单");
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


	public String payForm(Integer userId, Integer id) {
		Orders orders = orderMapper.findOne(userId,id);
		System.out.println(orders);
		if(orders.getState()!=OrderState.Created){
			throw new IllegalStateException("只有Created状态的订单才能发起支付");
		}
		BigDecimal totalAmount = BigDecimal.valueOf(orders.totalCost()).divide(BigDecimal.valueOf(100));// 订单总金额（元）BigDecimal不会损失精度
		logger.info("订单总金额"+totalAmount);
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); // 即将发送给支付宝的请求（电脑网站支付请求）
	       alipayRequest.setReturnUrl(alipayReturnUrl); // 浏览器端完成支付后跳转回商户的地址（同步通知）
	       alipayRequest.setNotifyUrl(alipayNotifyUrl); // 支付宝服务端确认支付成功后通知商户的地址（异步通知）
	        
	       Map<String, Object> bizContent = new HashMap<>(); // biz - business
	        // 填充业务参数
	       bizContent.put("out_trade_no", "" + id + "-" + new Date().getTime()); // 商户订单号，加时间戳是为了避免测试时订单号重复
	       bizContent.put("product_code","FAST_INSTANT_TRADE_PAY"); // 产品码，固定
	       bizContent.put("total_amount",totalAmount); // 订单总金额（元）
	       bizContent.put("subject", "shop手机商城订单支付"); // 订单标题
	       bizContent.put("body", "TODO 显示订单项概要"); // 订单描述
	       
	       // 直接将完整的表单html输出到页面
	       try {
			String bizContentStr = objectMapper.writeValueAsString(bizContent);
			alipayRequest.setBizContent(bizContentStr);
			return alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成支付表单
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

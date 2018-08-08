package shop.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.controller.form.OrdersForm;
import shop.pojo.Orders;
import shop.pojo.OrdersItems;
import shop.pojo.ShopAddress;
import shop.pojo.ShopCart;
import shop.pojo.ShopCartitems;
import shop.service.OrderService;

@Controller
public class ShopOrdersController {
	
	private OrderService orderService;
	
	
	
	@Autowired
	public ShopOrdersController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/order/delit/ready")
	public String findOrder(@AuthenticationPrincipal(expression = "customer.id") Integer userId,Model model,
							@ModelAttribute @Valid OrdersForm ordersForm) {
		findOderByUserId(userId, model);
		return "order-delit";
	}

	private void findOderByUserId(Integer userId, Model model) {
		List<ShopCartitems> sc = orderService.findShopCartByUserId(userId);
		model.addAttribute("shopcarts",new ShopCart(sc));
		List<ShopAddress> sa = orderService.findShopAddressByUserId(userId);
		model.addAttribute("shopAddress",sa);
	}
	
	

	@RequestMapping(method = RequestMethod.GET, value = "/uc/order/")
	public String findAll(@AuthenticationPrincipal(expression = "customer.id") Integer userId,Integer cellphoneId,Model model) {
		List<OrdersItems> oi = orderService.findAll(userId);
		model.addAttribute("OrdersItem",oi);
		return "order-list";
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/order/delit/ready")
	public String create(@AuthenticationPrincipal(expression = "customer.id") Integer userId,
						 @ModelAttribute @Valid OrdersForm ordersForm,BindingResult bindingResult,
						 Model model) {
		if(bindingResult.hasErrors()){
			findOderByUserId(userId, model);
			return "order-delit";
		}
		orderService.insert(ordersForm.toOrders(),userId,new Date());
		orderService.deleteShopCart(userId);
		
		return "redirect:/uc/order/";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/uc/orders/{id}/pay",
					produces = "text/html;charset=UTF-8" // 非常重要，支付宝api响应是html片段（不含编码），必须显式指定
					)
	@ResponseBody
	public String alipay(@AuthenticationPrincipal(expression = "customer.id") Integer userId,
            @PathVariable Integer id){
		return orderService.payForm(userId,id);
	}
	
	 @RequestMapping(method = RequestMethod.GET, value = "/uc/orders/sync-pay-cb")
	   public String payOk(@RequestParam("out_trade_no") String orderNumber,
	                       Model model) {
	       Long orderId = Long.valueOf(orderNumber.split("-")[0]); // 如 3-1533093080374
	       model.addAttribute("orderId", orderId);
	       return "order-pay-ok";
	    }
	
}

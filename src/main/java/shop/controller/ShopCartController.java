package shop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shop.pojo.ShopCartitems;
import shop.pojo.ShopCart;
import shop.service.ShopCartService;

@Controller
public class ShopCartController {
	
	private ShopCartService shopCartService;
	@Autowired
	public ShopCartController(ShopCartService shopCartService) {
		this.shopCartService = shopCartService;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/shopcart/add")
	   public String add(@RequestParam Integer cellphoneId,
	                     @AuthenticationPrincipal(expression = "customer.id") Integer userId) {
		shopCartService.addToCart(userId, cellphoneId, 1);
	    return "redirect:/cellphone/cellphone-list/" + cellphoneId;
	    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/shopcart")
	public String findAll(@AuthenticationPrincipal(expression = "customer.id") Integer userId,Model model) {
		List<ShopCartitems> sc = shopCartService.findAll(userId);
		ShopCart scl = new ShopCart(sc);
		model.addAttribute("shopcarts",scl);
		return "shopcart";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/shopcart/delect")
	public String delete(@RequestParam Integer cellphoneId,
	                     @AuthenticationPrincipal(expression = "customer.id") Integer userId) {
		shopCartService.delete(cellphoneId);
	    return "redirect:/uc/shopcart";
	    }
	
}

package shop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.pojo.ShopCartitems;
import shop.pojo.Cellphone;
import shop.pojo.ShopCart;
import shop.service.CellphoneService;
import shop.service.ShopCartService;

@Controller
public class ShopCartController {
	
	private ShopCartService shopCartService;
	private CellphoneService cellphoneService;
	
	@Autowired
	public ShopCartController(ShopCartService shopCartService, CellphoneService cellphoneService) {
		this.shopCartService = shopCartService;
		this.cellphoneService = cellphoneService;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/shopcart/add")
	@ResponseBody
	public Cellphone add(@RequestParam Integer cellphoneId,
	                  @AuthenticationPrincipal(expression = "customer.id") Integer userId) {
		shopCartService.addToCart(userId, cellphoneId, 1);
	    return cellphoneService.findOne(cellphoneId);
	    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/shopcart")
	public String findAll(@AuthenticationPrincipal(expression = "customer.id") Integer userId,Model model) {
		List<ShopCartitems> sc = shopCartService.findAll(userId);
		model.addAttribute("shopcarts",new ShopCart(sc));
		return "shopcart";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/shopcart/delect")
	public String delete(@RequestParam Integer cellphoneId,
	                     @AuthenticationPrincipal(expression = "customer.id") Integer userId) {
		shopCartService.delete(cellphoneId);
	    return "redirect:/uc/shopcart";
	    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/shopping-cart/item-dec")
	public String deleteOne(@RequestParam Integer cellphoneId,
			@AuthenticationPrincipal(expression = "customer.id") Integer userId) {
		shopCartService.deleteOne(userId,cellphoneId,1);
		return "redirect:/uc/shopcart";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/uc/shopping-cart/item-inc")
	public String insertOne(@RequestParam Integer cellphoneId,
			@AuthenticationPrincipal(expression = "customer.id") Integer userId) {
		shopCartService.insertOne(cellphoneId,1);
		return "redirect:/uc/shopcart";
	}
	
}

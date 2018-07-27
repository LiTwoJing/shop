package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import shop.pojo.ShopAddress;
import shop.service.ShopAddressService;

@Controller
public class ShopAddressController {
	
	private ShopAddressService shopAddressService;
	
	
	@Autowired
	public ShopAddressController(ShopAddressService shopAddressService) {
		this.shopAddressService = shopAddressService;
	}



	@RequestMapping(method = RequestMethod.GET, value = "/uc/shopaddress")
	public String findAll(@AuthenticationPrincipal(expression = "customer.id") Integer userId,Model model,@ModelAttribute ShopAddress shopAddress) {
		List<ShopAddress> sa = shopAddressService.findAll(userId);
		model.addAttribute("shopAddress",sa);
		return "shopaddress-list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/shopaddress/delit")
	public String add(@AuthenticationPrincipal(expression = "customer.id") Integer userId,Model model,@ModelAttribute ShopAddress shopAddress) {
		return "shopaddress-delit";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/shopaddress/delit")
	public String create(@AuthenticationPrincipal(expression = "customer.id") Integer userId,@ModelAttribute ShopAddress shopAddress) {
		shopAddressService.insert(shopAddress,userId);
		return "redirect:/uc/shopaddress";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/shopaddress/delect")
	public String delect(@AuthenticationPrincipal(expression = "customer.id") Integer userId,@ModelAttribute ShopAddress shopAddress) {
		shopAddressService.delect(shopAddress);
		return "redirect:/uc/shopaddress";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/uc/shopaddress/update/{id}")
	public String findOne(@AuthenticationPrincipal(expression = "customer.id") Integer userId,Model model,@PathVariable Integer id) {
		ShopAddress shopAddresss = shopAddressService.findOne(id);
		model.addAttribute("shopAddresss", shopAddresss);
		return "shopaddress-delit";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/uc/shopaddress/update/{id}")
	public String update(@AuthenticationPrincipal(expression = "customer.id") Integer userId,@ModelAttribute ShopAddress shopAddress) {
		shopAddressService.update(shopAddress);
		return "redirect:/uc/shopaddress";
	}
	
	
}

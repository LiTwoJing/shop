package shop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.pojo.Cellphone;
import shop.pojo.Customer;
import shop.service.UserService;


@Controller
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/user/cellphone/")
	public String list(Model model){
		List<Cellphone> ce = userService.findAll();
		model.addAttribute("cellphone", ce);
		return "cellphone-list";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/user/delit")
	public String add(@ModelAttribute Customer customer) {
		
		return "user-delit";
	}
	@RequestMapping(method=RequestMethod.POST,value="/user/delit")
	public String insert(@ModelAttribute @Valid Customer customer,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "user-delit";
		}
		userService.insert(customer);
		return "redirect:/user/cellphone/";
	}
}

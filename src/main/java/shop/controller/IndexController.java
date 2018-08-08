package shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.pojo.Cellphone;
import shop.service.CellphoneService;


@Controller
public class IndexController {
	
	
	private CellphoneService cellphoneService;
	
	@Autowired
	public IndexController(CellphoneService cellphoneService) {
		this.cellphoneService = cellphoneService;
	}


	@RequestMapping(method=RequestMethod.GET,value="/cellphone/")
	public String list(@ModelAttribute Cellphone cellphone,Model model){
		List<Cellphone> ce = cellphoneService.findAll();
		model.addAttribute("ces", ce);
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/cellphone/")
	public String search(@ModelAttribute Cellphone cellphone,Model model){
		System.out.println(cellphone);
		List<Cellphone> ce = cellphoneService.search(cellphone);
		model.addAttribute("ces2", ce);
		return "index";
	}
}

package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.pojo.Cellphone;
import shop.service.CellphoneService;


@Controller
public class CellphoneController {
	
	
	private CellphoneService cellphoneService;
	
	@Autowired
	public CellphoneController(CellphoneService cellphoneService) {
		this.cellphoneService = cellphoneService;
	}


	@RequestMapping(method=RequestMethod.GET,value="/cellphone/")
	public String list(Model model){
		List<Cellphone> ce = cellphoneService.findAll();
		model.addAttribute("cellphone", ce);
		return "cellphone-list";
	}
	
}

package shop.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.pojo.Cellphone;
import shop.service.CellphoneService;

@Controller
public class CellphoneDetailsController {
	private CellphoneService cellphoneService;
	@Autowired
	public CellphoneDetailsController(CellphoneService cellphoneService) {
		this.cellphoneService = cellphoneService;
	}


	@RequestMapping(method=RequestMethod.GET,value="/cellphone/cellphone-list/{id}")
	public String list(@PathVariable Integer id,Model model){
		Cellphone cellphones = cellphoneService.findOne(id);
		model.addAttribute("cellphones", cellphones);
		return "cellphone-list";
	}
}

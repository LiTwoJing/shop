package shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.pojo.Cellphone;
import shop.service.CellphoneService;
import shop.service.IpService;


@Controller
public class IndexController {
	
	
	private CellphoneService cellphoneService;
	private IpService ipService;
	
	
	@Autowired
	public IndexController(CellphoneService cellphoneService,IpService ipService) {
		this.cellphoneService = cellphoneService;
		this.ipService=ipService;
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
	
	@RequestMapping(method=RequestMethod.GET,value="/ip",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String ipToProvince(@RequestParam String ip){
		
		return ipService.ipToProvince(ip);
	}
	
}

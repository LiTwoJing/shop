package shop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mapper.CellphoneMapper;
import shop.pojo.Cellphone;
import shop.service.CellphoneService;
@Service
public class CellphoneServiceImpl implements CellphoneService {
	private CellphoneMapper cellphoneMapper;
	
	
	@Autowired
	public CellphoneServiceImpl(CellphoneMapper cellphoneMapper) {
		this.cellphoneMapper = cellphoneMapper;
	}



	public List<Cellphone> findAll() {
		return cellphoneMapper.findAll();
	}
}

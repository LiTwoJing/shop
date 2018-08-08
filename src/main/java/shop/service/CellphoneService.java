package shop.service;

import java.util.List;

import javax.validation.Valid;

import shop.pojo.Cellphone;

public interface CellphoneService {

	List<Cellphone> findAll();

	List<Cellphone> search(Cellphone cellphone);

	Cellphone findOne(Integer id);

}

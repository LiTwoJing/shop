package shop.mapper;

import java.util.List;

import shop.pojo.Cellphone;

public interface CellphoneMapper {

	List<Cellphone> findAll();

	List<Cellphone> search(Cellphone cellphone);

	Cellphone findOne(Integer id);

}

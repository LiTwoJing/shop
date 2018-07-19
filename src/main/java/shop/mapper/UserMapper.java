package shop.mapper;

import java.util.List;

import shop.pojo.Cellphone;
import shop.pojo.Customer;

public interface UserMapper {

	void insert(Customer customer);

	List<Cellphone> findAll();

	Customer findOneByUsername(String username);
}

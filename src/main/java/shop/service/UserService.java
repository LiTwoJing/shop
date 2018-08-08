package shop.service;

import java.util.List;

import javax.validation.Valid;

import shop.pojo.Cellphone;
import shop.pojo.Customer;

public interface UserService {

	void insert(Customer customer);

	List<Cellphone> findAll();
}

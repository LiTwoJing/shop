package shop.service;

import java.util.List;

import shop.pojo.ShopAddress;

public interface ShopAddressService {

	List<ShopAddress> findAll(Integer userId);

	void insert(ShopAddress shopAddress, Integer userId);

	void delect(ShopAddress shopAddress);

	ShopAddress findOne(Integer id);

	void update(ShopAddress shopAddress);

}

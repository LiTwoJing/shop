package shop.service;

import java.util.List;

import shop.pojo.ShopCartitems;

public interface ShopCartService {

	void addToCart(Integer userId, Integer cellphoneId, int amount);

	List<ShopCartitems> findAll(Integer userId);

	void deleteOne(Integer userId,Integer cellphoneId, int amount);

	void delete(Integer cellphoneId);

	void insertOne(Integer cellphoneId, int amount);
}

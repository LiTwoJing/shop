package shop.service;

import java.util.List;

import shop.pojo.ShopCart;

public interface ShopCartService {

	void addToCart(Integer userId, Integer cellphoneId, int amount);

	List<ShopCart> findAll(Integer userId);
}

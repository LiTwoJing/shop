package shop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mapper.ShopCartMapper;
import shop.pojo.ShopCart;
import shop.service.ShopCartService;
@Service
@Transactional
public class ShopCartServiceImpl implements ShopCartService{
	
	private ShopCartMapper shopCartMapper;
	
	@Autowired
	public ShopCartServiceImpl(ShopCartMapper shopCartMapper) {
		this.shopCartMapper = shopCartMapper;
	}


	public void addToCart(Integer userId, Integer cellphoneId, int amount) {
		Integer sc = shopCartMapper.findUserID(userId);
		System.out.println(sc);
		if(sc==0){
			shopCartMapper.addShopCart(userId,cellphoneId,amount);
		}else{
			Integer fc = shopCartMapper.findCellphoneId(cellphoneId);
			if(fc!=0){
				shopCartMapper.updateShopCart(cellphoneId,amount);
			}else{
				shopCartMapper.addCellphone(userId,cellphoneId,amount);
			}
			
		}
	}


	public List<ShopCart> findAll(Integer userId) {
		
		return shopCartMapper.findAll(userId);
	}

	
}

package shop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mapper.ShopAddressMapper;
import shop.pojo.ShopAddress;
import shop.service.ShopAddressService;

@Service
public class ShopAddressServiceImpl implements ShopAddressService{
	
	private ShopAddressMapper shopAddressMapper;
	
	@Autowired
	public ShopAddressServiceImpl(ShopAddressMapper shopAddressMapper) {
		this.shopAddressMapper = shopAddressMapper;
	}


	public List<ShopAddress> findAll(Integer userId) {
		return shopAddressMapper.findAll(userId);
	}


	public void insert(ShopAddress shopAddress, Integer userId) {
		System.out.println("我"+shopAddress.getCellphonenum());
		shopAddressMapper.insert(shopAddress,userId);
	}


	public void delect(ShopAddress shopAddress) {
		shopAddressMapper.delect(shopAddress);
	}


	public ShopAddress findOne(Integer id) {
		return shopAddressMapper.findOne(id);
	}


	public void update(ShopAddress shopAddress) {
		shopAddressMapper.update(shopAddress);
	}
	
}

package shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.pojo.ShopAddress;

public interface ShopAddressMapper {

	List<ShopAddress> findAll(Integer userId);

	void insert(@Param("shopAddress") ShopAddress shopAddress,
					@Param("userId") Integer userId);

	void delect(ShopAddress shopAddress);

	ShopAddress findOne(Integer id);

	void update(ShopAddress shopAddress);
}

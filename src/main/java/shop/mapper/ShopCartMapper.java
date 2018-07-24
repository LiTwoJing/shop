package shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.pojo.ShopCartitems;

public interface ShopCartMapper {

	Integer findUserID(Integer userId);

	void addShopCart(@Param("userId") Integer userId,
					 @Param("cellphoneId") Integer cellphoneId,
					 @Param("amount")int amount);

	void updateShopCart(@Param("cellphoneId") Integer cellphoneId,@Param("amount") int amount);

	Integer findCellphoneId(Integer cellphoneId);

	void addCellphone(@Param("userId") Integer userId,
					  @Param("cellphoneId") Integer cellphoneId,
					  @Param("amount") int amount);

	List<ShopCartitems> findAll(Integer userId);

	void delete(Integer cellphoneId);

	void updateAmount(Integer cellphoneId);

	Integer findAmount(Integer cellphoneId);
}

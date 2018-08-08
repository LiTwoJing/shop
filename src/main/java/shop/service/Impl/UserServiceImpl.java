package shop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import shop.mapper.UserMapper;
import shop.pojo.Cellphone;
import shop.pojo.Customer;
import shop.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	private UserMapper userMapepr;
	private PasswordEncoder passwordEncoder;
	@Autowired
	public UserServiceImpl(UserMapper userMapepr, PasswordEncoder passwordEncoder) {
		this.userMapepr = userMapepr;
		this.passwordEncoder = passwordEncoder;
	}

	public void insert(Customer customer) {
		String p = passwordEncoder.encode(customer.getPassword());
		customer.setPassword(p);
		userMapepr.insert(customer);
	}
	

	public List<Cellphone> findAll() {
		return userMapepr.findAll();
	}

}

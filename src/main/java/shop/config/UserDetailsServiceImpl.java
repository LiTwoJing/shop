package shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shop.mapper.UserMapper;
import shop.pojo.Customer;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private UserMapper userMapper;
	@Autowired
	public UserDetailsServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Customer customer = userMapper.findOneByUsername(username);
		
		if(customer == null){
			throw new UsernameNotFoundException("用户名不存在"+username);
		}
		
		return new UserDetailsImpl(customer);
	}

}

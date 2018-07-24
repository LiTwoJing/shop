package shop.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import shop.pojo.Customer;

public class UserDetailsImpl extends User{
	
	private Customer customer;

	public UserDetailsImpl(Customer customer) {
		super(customer.getUsername(),customer.getPassword(), true, true, true, true, 
				Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}
}

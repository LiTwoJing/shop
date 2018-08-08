package shop.pojo;

public class ShopAddress {
	private Integer id;
	private Customer customer;
	private String username;
	private String cellphonenum;
	private String detailaddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCellphonenum() {
		return cellphonenum;
	}

	public void setCellphonenum(String cellphonenum) {
		this.cellphonenum = cellphonenum;
	}

	public String getDetailaddress() {
		return detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

}

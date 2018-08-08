package shop.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cellphone {
	 private Integer id;
	 @Size(min=2,max=20,message="2~20")
	 private String cellphone;
	 @Size(min=2,max=20,message="2~20")
	 private String brand;
	 @Size(min=2,max=20,message="2~20")
	 private String model;
	 @Size(min=2,max=20,message="2~20")
	 private String os;
	 @Size(min=2,max=20,message="2~20")
	 private String cpuBrand;
	 @NotNull(message="必填")
	 private Integer ram;
	 @NotNull(message="必填")
	 private Integer storage;
	 @Size(min=2,max=20,message="2~20")
	 private String color;
	 private String description;
	 private Integer price;
	 private String cpucorenumber;
	 
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getCpuBrand() {
		return cpuBrand;
	}
	public void setCpuBrand(String cpuBrand) {
		this.cpuBrand = cpuBrand;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	public Integer getStorage() {
		return storage;
	}
	public void setStorage(Integer storage) {
		this.storage = storage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getCpucorenumber() {
		return cpucorenumber;
	}
	public void setCpucorenumber(String cpucorenumber) {
		this.cpucorenumber = cpucorenumber;
	}
	 
	 
}

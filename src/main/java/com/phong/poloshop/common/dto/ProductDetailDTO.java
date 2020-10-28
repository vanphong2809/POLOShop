package com.phong.poloshop.common.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDetailDTO implements Serializable{
	private static final long serialVersionUID = -4186228668922923702L;
//	ProductEntity product;
//	List<ProductSizeEntity> productSizes;
	private int productId;
	private boolean status;
	
	public ProductDetailDTO() {
		super();
	}

	public ProductDetailDTO(int productId, boolean status) {
		super();
		this.productId = productId;
		this.status = status;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

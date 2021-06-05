package com.phong.poloshop.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PRODUCT", schema = "dbo", catalog = "POLO")
public class ProductEntity implements Serializable{
	private static final long serialVersionUID = -214220888034079709L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductId", nullable = false)
	private int productId;
	@Column(name = "ProductName", nullable = false)
	private String productName;
	@Column(name="Content")
	private String content;
	@Column(name = "ContentDetail")
	private String contentDetail;
	@Column(name = "Image")
	private String image;
	@Column(name="[View]")
	private int view;
	@Column(name="BuyItem")
	private int buyItem;
	@Column(name="Quantity")
	private int quantity;
	@Column(name="CreatedAt")
	private Date createdAt;
	@Column(name="UpdatedAt")
	private Date updatedAt;
	@Column(name="Promotion")
	private int promotion;
	@Column(name = "Status")
	private int status;
	@Column(name = "Price")
	private int price;
	@ManyToOne
	@JoinColumn(name = "CatalogId")
	private CatalogEntity catalog;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<ProductColorEntity> productColors=new HashSet<ProductColorEntity>(0);
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	
	private Set<ImageEntity> images=new HashSet<ImageEntity>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<ProductSizeEntity> productSizes=new HashSet<ProductSizeEntity>();
	
//	@ManyToMany( cascade = CascadeType.ALL, targetEntity = SizeEntity.class)
//    @JoinTable(name = "PRODUCT_SIZE",
//        joinColumns = @JoinColumn(name = "productId"),
//        inverseJoinColumns = @JoinColumn(name = "sizeId"))
//	@Fetch(FetchMode.SELECT)
//    private Set<SizeEntity> size=new HashSet<SizeEntity>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<PriceEntity> prices=new HashSet<PriceEntity>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<PromotionEntity> promotions=new HashSet<PromotionEntity>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<OrderDetailEntity> orderDetails=new HashSet<OrderDetailEntity>();
	
	public ProductEntity() {
		super();
	}

	public ProductEntity(int productId, String productName, String content, String contentDetail, String image,
			int view, int buyItem, int quantity, Date createdAt, Date updatedAt, int promotion, int status, int price,
			CatalogEntity catalog) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.content = content;
		this.contentDetail = contentDetail;
		this.image = image;
		this.view = view;
		this.buyItem = buyItem;
		this.quantity = quantity;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.promotion = promotion;
		this.status = status;
		this.price = price;
		this.catalog = catalog;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentDetail() {
		return contentDetail;
	}

	public void setContentDetail(String contentDetail) {
		this.contentDetail = contentDetail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getBuyItem() {
		return buyItem;
	}

	public void setBuyItem(int buyItem) {
		this.buyItem = buyItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getPromotion() {
		return promotion;
	}

	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public CatalogEntity getCatalog() {
		return catalog;
	}

	public void setCatalog(CatalogEntity catalog) {
		this.catalog = catalog;
	}
	
	public Set<ProductColorEntity> getProductColors() {
		return productColors;
	}

	public void setProductColors(Set<ProductColorEntity> productColors) {
		this.productColors = productColors;
	}
	
	public Set<ImageEntity> getImages() {
		return images;
	}

	public void setImages(Set<ImageEntity> images) {
		this.images = images;
	}
	
	public Set<ProductSizeEntity> getProductSizes() {
		return productSizes;
	}

	public void setProductSizes(Set<ProductSizeEntity> productSizes) {
		this.productSizes = productSizes;
	}
//	public Set<SizeEntity> getSize() {
//		return size;
//	}
//
//	public void setSize(Set<SizeEntity> size) {
//		this.size = size;
//	}
	
	public Set<PriceEntity> getPrices() {
		return prices;
	}


	public void setPrices(Set<PriceEntity> prices) {
		this.prices = prices;
	}

	public Set<PromotionEntity> getPromotions() {
		return promotions;
	}

	public void setPromotions(Set<PromotionEntity> promotions) {
		this.promotions = promotions;
	}

	public Set<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}

}

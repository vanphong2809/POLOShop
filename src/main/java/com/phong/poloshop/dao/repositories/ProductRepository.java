package com.phong.poloshop.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phong.poloshop.dao.entities.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	@Query(value = "select top 8 * from PRODUCT where PRODUCT.Quantity>0 order by Buyitem desc", nativeQuery = true)
	List<ProductEntity> getHotProducts();

	@Query(value = "select top 8 * from PRODUCT where PRODUCT.Quantity>0 order by CreatedAt desc", nativeQuery = true)
	List<ProductEntity> getNewProducts();

	@Query(value = "select * from PRODUCT where Promotion > 0", nativeQuery = true)
	List<ProductEntity> getPromotionProducts();

	@Query(value = "select top 8 * from PRODUCT where PRODUCT.CatalogId =:catalogId", nativeQuery = true)
	List<ProductEntity> getProductsByCatalog(@Param("catalogId") Integer catalogId);

	@Query(value = "select top 8 * from PRODUCT  order by Buyitem desc", nativeQuery = true)
	List<ProductEntity> getBestSellerProducts();

	@Query(value = "select * from PRODUCT p join PRODUCT_SIZE"
	+ " ps on p.productId=ps.productId and p.status=ps.status"
	+ " join SIZE s on s.sizeId=ps.sizeId and s.status=ps.status"
	+ " join PRICE pr on p.ProductId=pr.ProductId"
	+ " where p.productId=:id and ps.status=1", nativeQuery = true)
	ProductEntity getProductById(@Param("id") int id);

	@Query(value = "select * from Product p join Catalog c"
			+ " on p.CatalogId=c.CatalogId where freetext(p.ProductName, :queryString)"
			+ " or freetext(c.catalogName, :queryString)", nativeQuery = true)
	List<ProductEntity> search(@Param("queryString") String queryString);
}

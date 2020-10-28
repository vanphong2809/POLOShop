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

	@Query(value = "select * from PRODUCT where PRODUCT.CatalogId =:catalogId", nativeQuery = true)
	List<ProductEntity> getProductsByCatalog(@Param("catalogId") int catalogId);

	@Query(value = "select top 8 * from PRODUCT  order by Buyitem desc", nativeQuery = true)
	List<ProductEntity> getBestSellerProducts();

//	@Query(value = "select p from SizeEntity as s join s.product as p "
//			+ "where p.productId=:id and s.status=1")
//	@Query(value = "select * from Product p, Product_Size ps, Size s"
//			+ " where  ps.status =true AND p.ProductId=:id", nativeQuery = true)
//	@Query(value = "select p.ProductId, p.ProductName, p.Content, p.ContentDetail,"
//			+ " p.[Image], p.[View], p.BuyItem, p.Quantity, p.CreatedAt, p.UpdatedAt,"
//			+ " p.[Status],p.CatalogId, p.Promotion, s.SizeId, s.SizeName, s.Description from Product p,"
//			+ " Product_Size ps, Size s"
//			+ " where p.productId=:id and ps.[Status] = 1", nativeQuery = true)
//	@Query(value = "select * from PRODUCT p left join PRODUCT_SIZE"
//			+ " ps on p.productId=ps.productId and p.status=ps.status"
//			+ " left join SIZE s on s.sizeId=ps.sizeId and s.status=ps.status"
//			+ " where p.productId=:id and ps.status=1", nativeQuery = true)
//@Query(value = "SELECT PRODUCT.* FROM PRODUCT " + 
//		"JOIN (SELECT PRODUCT_SIZE.* FROM PRODUCT_SIZE " + 
//		"JOIN SIZE ON PRODUCT_SIZE.SizeId = SIZE.SizeId " + 
//		"WHERE PRODUCT_SIZE.ProductId =:id  AND PRODUCT_SIZE.Status = 'True' " + 
//		")AS tb ON tb.ProductId =  PRODUCT.ProductId " + 
//		"WHERE PRODUCT.Status = 1 AND PRODUCT.ProductId =:id ", nativeQuery = true)
//	@Query(value = "SELECT * FROM PRODUCT" + " JOIN PRODUCT_SIZE ON PRODUCT.ProductId = PRODUCT_SIZE.ProductId "
//			+ "JOIN SIZE ON PRODUCT_SIZE.SizeId = SIZE.SizeId "
//			+ " WHERE PRODUCT.Status = 1 AND PRODUCT_SIZE.Status = 'True' AND PRODUCT.ProductId =:id", nativeQuery = true)
//	@Query(value = "select p"
//			+ " from ProductEntity p join p.productSizes ps"
//			+ " where p.productId=:id and ps.status=1")
	@Query(value = "select * from PRODUCT p left join PRODUCT_SIZE"
	+ " ps on p.productId=ps.productId and p.status=ps.status"
	+ " left join SIZE s on s.sizeId=ps.sizeId and s.status=ps.status"
	+ " join PRICE pr on p.ProductId=pr.ProductId"
	+ " where p.productId=:id and ps.status=1", nativeQuery = true)
	ProductEntity getProductById(@Param("id") int id);
//	@Query(value = "select * from Product p join Catalog c on p.CatalogId=c.CatalogId" 
//			+ " where dbo.non_unicode_convert(p.ProductName) like case " 
//			+ " when dbo.non_unicode_convert(:queryString)='' then '%'"
//			+ " else '%' + dbo.non_unicode_convert(:queryString)+'%' end"
//			+ " or dbo.non_unicode_convert(c.CatalogName) like case" 
//			+ "	when dbo.non_unicode_convert(:queryString)='' then '%' else '%'+dbo.non_unicode_convert(:queryString)+'%' end", nativeQuery = true)
	@Query(value = "select * from Product p join Catalog c"
			+ " on p.CatalogId=c.CatalogId where freetext(p.ProductName, :queryString)"
			+ " or freetext(c.catalogName, :queryString)", nativeQuery = true)
	List<ProductEntity> search(@Param("queryString") String queryString);
}

package com.vthinkdynamic.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vthinkdynamic.product.entity.Product;
@Service
public interface ProductService {

	String addProduct(Product product);

	List<Product> listAllProduct();

	List<Product> ProductCategoryList(String category);

	Product ProductById(Integer id);

	String updateProduct(Product product);

	String deleteProductById(Integer id);

}

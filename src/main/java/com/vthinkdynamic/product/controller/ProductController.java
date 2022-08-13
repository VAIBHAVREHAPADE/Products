package com.vthinkdynamic.product.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vthinkdynamic.product.entity.Product;
import com.vthinkdynamic.product.service.ProductService;


@RestController
@RequestMapping("/v1")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;

@PostMapping("/addProduct")
 ResponseEntity<Product> addProduct(@RequestBody Product product){
	String Status = productService.addProduct(product);
	logger.info("Product Added Status is " + Status);
	return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
@GetMapping("/productList")
List<Product> ProductList()
{
	return productService.listAllProduct();
}

@GetMapping("/productList/{category}")
List<Product> ProductCategoryList(@PathVariable String category)
{
	return productService.ProductCategoryList(category);

}
@GetMapping("/product/{id}")
Product ProductById(@PathVariable Integer id)
{
	return productService.ProductById(id);

}
@PutMapping("/productUpdate")
String updateProduct(@RequestBody Product product)
{
	return productService.updateProduct(product);
}

@DeleteMapping("/product/{id}")
String deleteProductById(@PathVariable Integer id)
{
	return productService.deleteProductById(id);

}




}
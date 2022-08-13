package com.vthinkdynamic.product.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vthinkdynamic.product.entity.Product;
import com.vthinkdynamic.product.service.ProductService;
@Service
public class ProductServiceimpl implements ProductService {

	List<Product> products = new ArrayList<>();

	@Override
	public String addProduct(Product product) {
		products.add(product);
		return "Successful";
	}

	@Override
	public List<Product> listAllProduct() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public List<Product> ProductCategoryList(String category) {
		// TODO Auto-generated method stub
		return products.stream().filter(product -> product.getCategory().getName().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}

	@Override
	public Product ProductById(Integer id) {
		// TODO Auto-generated method stub
		return products.stream().filter(product -> product.getId() == id).findAny().get();
	}

	@Override
	public String updateProduct(Product product) {
		for (Product prod : products)
			if (prod.getId() == prod.getId()) {
				prod.setName(product.getName());
				prod.setCategory(product.getCategory());
				prod.setDiscount(product.getDiscount());
				prod.setPrice(product.getPrice());
				prod.setDiscountDescription(product.getDiscountDescription());
				return "Product Updated Successfully..";	
			}

		return "Product Updation Failed";
	}

	@Override
	public String deleteProductById(Integer id) {
          for(Product product : products) {
        	  if(product.getId()==id) {
        		  products.remove(product);
        		  return "Product remove successfully";
        	  }
        	  }
		return "Remove failed";
	}

}

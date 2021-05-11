package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ProductNotFoundException;
import com.model.Product;
import com.repository.ProductRepository;

@Service

public class ProductService {
List<Product> le;
	
	@Autowired(required = true)
	ProductRepository productrepo;
	
	public Product createProduct(Product p) {
		// TODO Auto-generated method stub
		Product p1=productrepo.save(p);
		
		return p1;
	}
	
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		le=new ArrayList(); 
		le=productrepo.findAll();
		return le;
	}
	public Product getProductById(int product_id)throws Exception {
		// TODO Auto-generated method stub
		
		Supplier<Exception> s2=()-> new ProductNotFoundException ("Product is not present in the database");
		Product p1 = productrepo.findById(product_id).orElseThrow(s2);
		return p1;
	}
	public List<Product> addProduct(List<Product> ls) {
		// TODO Auto-generated method stub
		le = new ArrayList<>();
		le = productrepo.saveAll(ls);
		return le;
	}
	public Product updateProduct(Product p)throws Exception {
		// TODO Auto-generated method stub
		int id = p.getProduct_id();
		Supplier<Exception> s1 = ()->new ProductNotFoundException("Product id is not present in the database");
		
		Product p1=productrepo.findById(id).orElseThrow(s1);
		p1.setProduct_status(p.getProduct_status());
	
		productrepo.save(p1);
		return p1;	
		}
	
	public Product deleteProduct(int product_id ) {
		Product c1=productrepo.findById(product_id).orElse(null);
		           productrepo.deleteById(product_id);
				return c1;	
		
	}

    public String deleteProductById(int product_id) {
		// TODO Auto-generated method stub
		Product c1 = productrepo.findById(product_id).orElse(null);
		productrepo.deleteById(product_id);
		return "Deleted";
	}
    public List<Product> findingByStatusSorted(String product_status) {
		// TODO Auto-generated method stub
		
		List<Product> le=productrepo.findByStatusSorted(product_status);
		productrepo.saveAll(le);
		return le;
	}

	
	

}

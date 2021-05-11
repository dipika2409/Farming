package com;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
@Validated
public class ProductController {

	@Autowired
	ProductService pservice;
	
	
	@GetMapping(path="/getProduct")
	public ResponseEntity<List<Product>> getProduct()
	{
         List<Product> le=pservice.getProduct();
		
		ResponseEntity re=new ResponseEntity<List<Product>>(le,HttpStatus.OK);
		return re;
		
	}
	@GetMapping(path="/getProducts/{product_id}")
	public ResponseEntity<Product> getProductById(@PathVariable int product_id)throws Exception
	{
		Product e1=pservice.getProductById(product_id);
		
		ResponseEntity re=new ResponseEntity<Product>(e1,HttpStatus.OK);
		return re;
	}
	@PostMapping(path="/addProduct")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product p)
	{
		Product p1=pservice.createProduct(p);
		
		ResponseEntity re=new ResponseEntity<Product>(p1,HttpStatus.OK);
		return re;
	}
	@PostMapping(path="/addProducts")
	public ResponseEntity<List<Product>> addProducts(@Valid @RequestBody List<Product> ls)
	{
		
		List<Product> le=pservice.addProduct(ls);
		ResponseEntity re=new ResponseEntity<List<Product>>(le,HttpStatus.OK);
		return re;
		
	}
	@PutMapping(path="/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product p)throws Exception
	{
		Product p1=pservice.updateProduct(p);
		ResponseEntity re =new ResponseEntity<Product>(p1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteProduct")
	public ResponseEntity<Product> deleteProduct(@RequestBody int product_id)
	{
		Product c1=pservice.deleteProduct(product_id);
		ResponseEntity re=new ResponseEntity<Product>(c1,HttpStatus.OK);
		
		return re;
		
	}	
	
	@DeleteMapping(path="/deleteProducts/{product_id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int product_id)
	{
		pservice.deleteProductById(product_id);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
		
	}

}

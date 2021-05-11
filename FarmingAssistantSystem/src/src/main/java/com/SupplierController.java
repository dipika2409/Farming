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
import com.model.Supplier1;
import com.service.ProductService;
import com.service.SupplierService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/api")
@Validated
public class SupplierController {

	@Autowired
	SupplierService sservice;
	@Autowired
	ProductService pservice;
	
	//get supplier details
	@GetMapping(path="/getSupplier")
	public ResponseEntity<List<Supplier1>> getSuppliers()
	{
        List<Supplier1> le=(List<Supplier1>) sservice.getSuppliers();
		
		ResponseEntity re=new ResponseEntity<List<Supplier1>>(le,HttpStatus.OK);
		return re;
		
	}
	
	//get product details in supplier
	@GetMapping(path="/getProductBySupplier")
	public ResponseEntity<List<Product>> getProduct()
	{
        List<Product> le=pservice.getProduct();
		
		ResponseEntity re=new ResponseEntity<List<Product>>(le,HttpStatus.OK);
		return re;
		
	}
	

	  @PostMapping(path="/addSupplier") 
	  public ResponseEntity<Supplier1> addSupplier(@Valid @RequestBody Supplier1 e) 
	  { 
	  
	  Supplier1 e1=sservice.createSupplier(e);
	  
	  ResponseEntity re=new ResponseEntity<Supplier1>(e1,HttpStatus.OK); 
	  return re;
	  }
	  
	  @PostMapping(path="/addSuppliers") 
	  public ResponseEntity<List<Supplier1>>  addSuppliers(@Valid @RequestBody List<Supplier1> ls) 
	  {
		  
		List<Supplier1> le=sservice.addSuppliers(ls);
	  
        ResponseEntity re=new ResponseEntity<List<Supplier1>>(le,HttpStatus.OK);
	    return re;
	    
	  }
	  
	  @PutMapping(path="/updateSupplier")
	  public ResponseEntity<Supplier1>  updateSupplier(@RequestBody Supplier1 e) throws Exception { 
		  Supplier1 e1=sservice.updateSupplier(e);
	  
	  ResponseEntity re=new ResponseEntity<Supplier1>(e1,HttpStatus.OK); return re;
	  }
	  
	  @DeleteMapping(path="/deleteSupplier") 
	  public ResponseEntity<Supplier1> deleteSupplier(@RequestBody int id) { 
		  Supplier1 e1=sservice.deleteSupplier(id);
	  ResponseEntity re=new ResponseEntity<Supplier1>(e1,HttpStatus.OK);
	  return re; }
	  
	  @DeleteMapping(path="/delete/{supplier_id}") 
	  public ResponseEntity<String> deleteSupplierById(@PathVariable int supplier_id) { 
		  sservice.deleteSupplierById(supplier_id);
	  
	  ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK); return
	  re; }
	 
	  
}

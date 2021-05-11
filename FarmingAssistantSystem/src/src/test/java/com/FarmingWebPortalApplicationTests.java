package com;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import com.model.Advertise;
import com.model.Complaint;
import com.model.Farmer;
import com.model.Notification;
import com.model.Product;
import com.model.Supplier1;
import com.repository.AdminRepository;
import com.repository.AdvertiseRepository;
import com.repository.ComplaintRepository;
import com.repository.FarmerRepository;
import com.repository.NotificationRepository;
import com.repository.ProductRepository;
import com.repository.SupplierRepository;
import com.service.AdminService;
import com.service.AdvertiseService;
import com.service.ComplaintService;
import com.service.FarmerService;
import com.service.NotificationService;
import com.service.ProductService;
import com.service.SupplierService;

@SpringBootTest
class FarmerAssistantApplicationTests {
	@InjectMocks
    private ComplaintService cservice;
	@InjectMocks 
	private FarmerService fservice;
	@InjectMocks 
	private SupplierService sservice;
	@InjectMocks
	private NotificationService nservice;
    @InjectMocks
    private ProductService pservice;
    @InjectMocks
	private AdvertiseService aservice;
    
    @Mock
    private ComplaintRepository crepo;
    @Mock
    private FarmerRepository frepo;
    @Mock
    private SupplierRepository srepo;
    @Mock
    private NotificationRepository nrepo;
	@Mock
	private ProductRepository prepo;
	@Mock
	private AdvertiseRepository arepo;
    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testCreateComplaint(){

 

        Complaint ticket = new Complaint();
        ticket.setComplaint_id(9);
        ticket.setComplaint_text("Quality is poor");
        ticket.setComplaint_status("In-progress");
        crepo.save(ticket);
        when(crepo.save(ticket)).thenReturn(ticket);
        Complaint c1=cservice.createComplaint(ticket);
        assertNotNull(c1);
        assertEquals("In-progress",c1.getComplaint_status());
            
    }
	
	
	
	

	@Test
	public void testGetComplaintById() throws Exception{
	     Complaint ticket = new Complaint();
		ticket.setComplaint_id(9);
		ticket.setComplaint_text("Quality is poor ");
		ticket.setComplaint_status("In-progress");
		Optional<Complaint> ticket1=Optional.ofNullable(ticket);
	   when(crepo.findById(9)).thenReturn(ticket1);
	   Complaint c1=cservice.getComById(9);
	   assertNotNull(c1);
       assertEquals(9,c1.getComplaint_id());
           
	   
	   
	}

	
	@Test
	public void testdeleteCompById(){
		Complaint ticket=new Complaint();
		ticket.setComplaint_id(10);
		ticket.setComplaint_text("Quality is poor");
		ticket.setComplaint_status("In-progress");
		
		Optional<Complaint> ticket1=Optional.ofNullable(ticket);
	    when(crepo.findById(10)).thenReturn(ticket1);
	    Complaint c1=cservice.deleteComp(10);
	    assertNotNull(c1);
	    assertEquals(10,c1.getComplaint_id());

	}
	
	@Test
	public void testUpdateComplaint() throws Exception{
		Complaint ticket = new Complaint();
		ticket.setComplaint_id(10);
		ticket.setComplaint_text("Quality is poor");
		ticket.setComplaint_status("In-progress");
		Optional<Complaint> ticket1=Optional.ofNullable(ticket);
	    when(crepo.findById(10)).thenReturn(ticket1);
	    Complaint c1=cservice.updateComp(ticket);
	    assertNotNull(c1);
	    assertEquals("In-progress",c1.getComplaint_status());	
		
	}
	
	 @Test
	    public void testAddFarmer() {

	        Farmer ticket = new Farmer();
	        ticket.setFarmer_id(1);
	        ticket.setFirst_name("Milind");
	        ticket.setLast_name("Gavali");
	        ticket.setGender("Male");
	        ticket.setContact_number("934638273");
	        frepo.save(ticket);
	        when(frepo.save(ticket)).thenReturn(ticket);
	        Farmer f1=fservice.addFarmer(ticket);
	        assertNotNull(f1);
	        assertEquals("Milind",f1.getFirst_name());
	            
	    }
	 
	     @Test
		public void testGetFarmerById() throws Exception{
	    	   Farmer ticket = new Farmer();
	    	   ticket.setFarmer_id(1);
		        ticket.setFirst_name("Milind");
		        ticket.setLast_name("Gavali");
		        ticket.setGender("Male");
		        ticket.setContact_number("934638273");
			Optional<Farmer> ticket1=Optional.ofNullable(ticket);
		   when(frepo.findById(1)).thenReturn(ticket1);
		   Farmer f1=fservice.getFarmerById(1);
		   assertNotNull(f1);
	       assertEquals(1,f1.getFarmer_id());
	           
		   	   
		}

	 	@Test
	 	public void testdeleteFarmerById(){
		    	   Farmer ticket = new Farmer();
		    	   ticket.setFarmer_id(1);
			        ticket.setFirst_name("Milind");
			        ticket.setLast_name("Gavali");
			        ticket.setGender("Male");
			        ticket.setContact_number("934638273");
	 		
	 		Optional<Farmer> ticket1=Optional.ofNullable(ticket);
	 	    when(frepo.findById(1)).thenReturn(ticket1);
	 	   Farmer f1=fservice.deleteFarmer(1);
	 	    assertNotNull(f1);
	 	    assertEquals(1,f1.getFarmer_id());

	 	}
	 	
	 	
	 	@Test
	    public void testAddSupplier(){

	        Supplier1 s = new Supplier1();
	        s.setSupplier_id(1);
	        s.setName("Yogesh");
	        s.setMobile_no("78486427181");
	        s.setEmail("sawant@gmail.com");
	        srepo.save(s);
	        when(srepo.save(s)).thenReturn(s);
	        Supplier1 s1=sservice.createSupplier(s);
	        assertNotNull(s1);
	        assertEquals("Yogesh",s1.getName());         
	    }
		
	 	@Test
	 	public void testdeleteFSupplierById(){
	 		Supplier1 s = new Supplier1();
	        s.setSupplier_id(1);
	        s.setName("Yogesh");
	        s.setMobile_no("78486427181");
	        s.setEmail("sawant@gmail.com");
	       
	 		Optional<Supplier1> ticket1=Optional.ofNullable(s);
	 	    when(srepo.findById(1)).thenReturn(ticket1);
	 	   Supplier1 s1=sservice.deleteSupplier(1);
	 	    assertNotNull(s1);
	 	    assertEquals(1,s1.getSupplier_id());

	 	}
		
	 	@Test
	 	public void testUpdateSupplier() throws Exception{
	 		Supplier1 s = new Supplier1();
	        s.setSupplier_id(1);
	        s.setName("Yogesh");
	        s.setMobile_no("78486427181");
	        s.setEmail("sawant@gmail.com");
	       
	 		Optional<Supplier1> sup=Optional.ofNullable(s);
	 	    when(srepo.findById(1)).thenReturn(sup);
	 	   Supplier1 s1=sservice.updateSupplier(s);
	 	    assertNotNull(s1);
	 	    assertEquals("sawant@gmail.com",s.getEmail());	
	 	}
	
		@Test
	    public void testCreateNotification(){

	
	 		Notification n = new Notification();
	        n.setNotification_id(1);
	        n.setNotification_name("Urgent Required");
	        nrepo.save(n);
	        when(nrepo.save(n)).thenReturn(n);
	        Notification n1=nservice.createNotification(n);
	        assertNotNull(n1);
	        assertEquals("Urgent Required",n1.getNotification_name());
	            
	    }
		
		
		
		

		@Test
		public void testGetNotification() throws Exception{
			Notification n = new Notification();
	        n.setNotification_id(1);
	        n.setNotification_name("Urgent Required");
			Optional<Notification> n1=Optional.ofNullable(n);
		   when(nrepo.findById(1)).thenReturn(n1);
		   Notification c1=nservice.getNotiById(1);
		   assertNotNull(c1);
	       assertEquals(1,c1.getNotification_id());
	           
		   
		   
		}

		
		@Test
		public void testdeleteNotificationById(){
			Notification n = new Notification();
	        n.setNotification_id(1);
	        n.setNotification_name("Urgent Required");
			Optional<Notification> n1=Optional.ofNullable(n);
		   when(nrepo.findById(1)).thenReturn(n1);
		   Notification n2=nservice.deleteNoti(1);
		    assertNotNull(n2);
		    assertEquals(1,n2.getNotification_id());

		}
		
		@Test
		public void testUpdateNotification() throws Exception{
			Notification n = new Notification();
	        n.setNotification_id(1);
	        n.setNotification_name("Urgent Required");
			Optional<Notification> n1=Optional.ofNullable(n);
		   when(nrepo.findById(1)).thenReturn(n1);
		   Notification n2=nservice.updateNoti(n);
		    assertNotNull(n2);
		    assertEquals("Urgent Required",n2.getNotification_name());	
			
		}
		 @Test
		    public void testCreateProduct(){

	            Product product = new Product();
			    product.setProduct_id(9);
			    product.setProduct_name("Rice");
			    product.setPrice(3000);
			    product.setQuantity(10);
			    product.setProduct_status("Available");
			    prepo.save(product);
		        when(prepo.save(product)).thenReturn(product);
		        Product p1=pservice.createProduct(product);
		        assertNotNull(p1);
		        assertEquals("Available",p1.getProduct_status());
		            
		    }
		  @Test
			public void testGetProdById() throws Exception{
			    Product product = new Product();
			    product.setProduct_id(9);
			    product.setProduct_name("Rice");
			    product.setPrice(3000);
			    product.setQuantity(10);
			    product.setProduct_status("Available");
				Optional<Product>  product1=Optional.ofNullable( product);
			   when(prepo.findById(9)).thenReturn( product1);
			   Product p1=pservice.getProductById(9);
			   assertNotNull(p1);
		       assertEquals(9,p1.getProduct_id());
		           
			   
			   
			}

			
			@Test
			public void testdeleteProductById(){
				Product product=new Product();
				product.setProduct_id(10);
				product.setProduct_name("Quality is poor");
				product.setPrice(3000);
			    product.setQuantity(10);
			    product.setProduct_status("Available");
				
				Optional<Product> product1=Optional.ofNullable(product);
			    when(prepo.findById(10)).thenReturn(product1);
			    Product p1=pservice.deleteProduct(10);
			    assertNotNull(p1);
			    assertEquals(10,p1.getProduct_id());

			}
			
			@Test
			public void testUpdateProduct() throws Exception{
				Product product = new Product();
				product.setProduct_id(10);
				product.setProduct_name("Quality is poor");
				product.setPrice(3000);
			    product.setQuantity(10);
			    product.setProduct_status("Available");
				Optional<Product> product1=Optional.ofNullable(product);
			    when(prepo.findById(10)).thenReturn(product1);
			    Product p1=pservice.updateProduct(product);
			    assertNotNull(p1);
			    assertEquals("Available",p1.getProduct_status());
				
				
			}
			
			

			
			  @Test 
			  public void testGetProductById() throws Exception {
				  Product product = new Product();
				  product.setProduct_id(9);
				  product.setProduct_name("Quality is poor");
				  product.setPrice(3000);
				  product.setQuantity(10);
				  product.setProduct_status("Available"); 
				 Optional<Product> product1=Optional.ofNullable(product);
			     when(prepo.findById(9)).thenReturn(product1);
			     Product c1=pservice.getProductById(9);
			     assertNotNull(c1);
				 assertEquals(9,c1.getProduct_id());
			  }
			  //advertise
			  @Test
			    public void testCreateAdvertise(){

				  Advertise adv = new Advertise();
				  adv.setAdv_id(9);
				  adv.setAdv_title("Want Product");
				  adv.setAdv_description("Want Rice Product");
				  arepo.save(adv);
			      when(arepo.save(adv)).thenReturn(adv);
			      Advertise c1=aservice.createAdvertise(adv);
			      assertNotNull(c1);
			      assertEquals(9,c1.getAdv_id());
			            
			    }
			  @Test
				public void testGetAdvById() throws Exception{
				  Advertise adv = new Advertise();
				  adv.setAdv_id(9);
				  adv.setAdv_title("Want Product");
				  adv.setAdv_description("Want Rice Product");
				  Optional<Advertise>  adv1=Optional.ofNullable( adv);
				  when(arepo.findById(9)).thenReturn(adv1);
				  Advertise c1=aservice.getAdvById(9);
				  assertNotNull(c1);
			      assertEquals(9,c1.getAdv_id());
			           
				   
				   
				}

				
				@Test
				public void testdeleteAdvertiseById(){
					Advertise adv=new Advertise();
					adv.setAdv_id(10);
					adv.setAdv_title("Want Product");
					adv.setAdv_description("Want Rice Product");
				    Optional<Advertise> adv1=Optional.ofNullable(adv);
				    when(arepo.findById(10)).thenReturn(adv1);
				    Advertise p1=aservice.deleteAdv(10);
				    assertNotNull(p1);
				    assertEquals(10,p1.getAdv_id());

				}
				
				@Test
				public void testUpdateAdvertise() throws Exception{
					Advertise adv = new Advertise();
					adv.setAdv_id(10);
					adv.setAdv_title("Want Product");
					adv.setAdv_description("Want Rice Product");
					Optional<Advertise> adv1=Optional.ofNullable(adv);
				    when(arepo.findById(10)).thenReturn(adv1);
				    Advertise c1=aservice.updateAdv(adv);
				    assertNotNull(c1);
				    assertEquals(10,c1.getAdv_id());
					
					
				}
				
				

				
				  @Test 
				  public void testGetAdvertiseById() throws Exception {
					 Advertise adv = new Advertise();
					 adv.setAdv_id(9);
					 adv.setAdv_title("Want Product");
					 adv.setAdv_description("Want Rice Product");
					 Optional<Advertise> adv1=Optional.ofNullable(adv);
				     when(arepo.findById(9)).thenReturn(adv1);
				     Advertise c1=aservice.getAdvById(9);
				     assertNotNull(c1);
					 assertEquals(9,c1.getAdv_id());
				  }
			  
		 

		

		
		
		
}

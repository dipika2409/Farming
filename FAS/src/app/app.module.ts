import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateComplaintComponent } from './create-complaint/create-complaint.component';
import { CompserviceService } from './service/compservice.service';
import { ComplaintListComponent } from './complaint-list/complaint-list.component';
import { UpdateComplaintComponent } from './update-complaint/update-complaint.component';
import { CreateFarmerComponent } from './farmer/create-farmer/create-farmer.component';
import { FarmerListComponent } from './farmer/farmer-list/farmer-list.component';
import { UpdateFarmerComponent } from './farmer/update-farmer/update-farmer.component';
import { CreateAdvertiseComponent } from './advertise/create-advertise/create-advertise.component';
import { AdvertiseListComponent } from './advertise/advertise-list/advertise-list.component';
import { UpdateAdvertiseComponent } from './advertise/update-advertise/update-advertise.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatToolbarModule} from '@angular/material/toolbar';

import{ MatFormFieldModule } from '@angular/material/form-field';

import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FarmerCComponent } from './farmer/farmer-c/farmer-c.component';
import { ComplaintfComponent } from './complaint/complaintf/complaintf.component';
import { CreateProductComponent } from './product/create-product/create-product.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { UpdateProductComponent } from './product/update-product/update-product.component';
import { SupplierHomeComponent } from './supplier/supplier-home/supplier-home.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { SupplierListComponent } from './supplier/supplier-list/supplier-list.component';
import { CreateSupplierComponent } from './supplier/create-supplier/create-supplier.component';
import { UpdateSupplierComponent } from './supplier/update-supplier/update-supplier.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { HomeComponent } from './home/home.component';
import { FarmerLoginComponent } from './farmer-login/farmer-login.component';
import { SupplierLoginComponent } from './supplier/supplier-login/supplier-login.component';
import { FarmercomplaintlistComponent } from './farmer/farmercomplaintlist/farmercomplaintlist.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactUsComponent } from './contact-us/contact-us.component';








@NgModule({
  declarations: [
    AppComponent,
    CreateComplaintComponent,
    ComplaintListComponent,
    UpdateComplaintComponent,
    CreateFarmerComponent,
    FarmerListComponent,
    UpdateFarmerComponent,
    CreateAdvertiseComponent,
    AdvertiseListComponent,
    UpdateAdvertiseComponent,
    FarmerCComponent,
    ComplaintfComponent,
    CreateProductComponent,
    ProductListComponent,
    UpdateProductComponent,
    SupplierHomeComponent,
    AdminHomeComponent,
    SupplierListComponent,
    CreateSupplierComponent,
    UpdateSupplierComponent,
    AdminLoginComponent,
    HomeComponent,
    FarmerLoginComponent,
    SupplierLoginComponent,
    FarmercomplaintlistComponent,
    AboutusComponent,
    ContactUsComponent

    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,

    MatToolbarModule,

    MatFormFieldModule,

    MatInputModule,
    ReactiveFormsModule
  ],
  providers: [CompserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdvertiseListComponent } from './advertise/advertise-list/advertise-list.component';
import { CreateAdvertiseComponent } from './advertise/create-advertise/create-advertise.component';
import { UpdateAdvertiseComponent } from './advertise/update-advertise/update-advertise.component';
import { ComplaintListComponent } from './complaint-list/complaint-list.component';
import { ComplaintfComponent } from './complaint/complaintf/complaintf.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { CreateComplaintComponent } from './create-complaint/create-complaint.component';
import { FarmerLoginComponent } from './farmer-login/farmer-login.component';
import { CreateFarmerComponent } from './farmer/create-farmer/create-farmer.component';
import { FarmerCComponent } from './farmer/farmer-c/farmer-c.component';
import { FarmerListComponent } from './farmer/farmer-list/farmer-list.component';
import { FarmercomplaintlistComponent } from './farmer/farmercomplaintlist/farmercomplaintlist.component';
import { UpdateFarmerComponent } from './farmer/update-farmer/update-farmer.component';
import { HomeComponent } from './home/home.component';
import { CreateProductComponent } from './product/create-product/create-product.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { UpdateProductComponent } from './product/update-product/update-product.component';
import { CreateSupplierComponent } from './supplier/create-supplier/create-supplier.component';
import { SupplierHomeComponent } from './supplier/supplier-home/supplier-home.component';
import { SupplierListComponent } from './supplier/supplier-list/supplier-list.component';
import { SupplierLoginComponent } from './supplier/supplier-login/supplier-login.component';
import { UpdateSupplierComponent } from './supplier/update-supplier/update-supplier.component';
import { UpdateComplaintComponent } from './update-complaint/update-complaint.component';

const routes: Routes = [
  { path: '', redirectTo: 'complaint', pathMatch: 'full' },
  { path: 'add', component: CreateComplaintComponent },
  { path: 'complaints', component: ComplaintListComponent },
  { path: 'update/:id', component: UpdateComplaintComponent },
  { path: 'addF', component: CreateFarmerComponent },
  { path: 'farmers', component: FarmerListComponent },
  { path: 'updates/:idF', component: UpdateFarmerComponent },
  { path: 'addA', component: CreateAdvertiseComponent },
  { path: 'view/advertises', component: AdvertiseListComponent },
  { path: 'updatead/:id_adv', component: UpdateAdvertiseComponent },
  { path: 'complaintHome', component:ComplaintfComponent },
  { path: 'add/product', component: CreateProductComponent },
  { path: 'products', component: ProductListComponent },
  { path: 'update/product/:id_prod', component: UpdateProductComponent },
  { path: 'farmerHome', component:FarmerCComponent },
  { path: 'supplierHome', component:SupplierHomeComponent },
  { path: 'adminHome', component:AdminHomeComponent },
  { path: 'suppliers', component:SupplierListComponent },
  { path: 'add/supplier', component:CreateSupplierComponent },
  { path: 'update/supplier/:id_supp', component:UpdateSupplierComponent},
  { path: 'admin/login', component:AdminLoginComponent},
  { path: 'farmer/login', component:FarmerLoginComponent},
  { path: 'supplier/login', component:SupplierLoginComponent},
  { path: 'farmer/complaint', component:FarmercomplaintlistComponent},
  { path: 'aboutus', component:AboutusComponent},
  { path: 'home', component:HomeComponent},
  { path: 'contactus', component:ContactUsComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

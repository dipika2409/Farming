import { Injectable } from '@angular/core';
import { Complaint } from '../complaint';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Farmer } from '../farmer';
import { Advertise } from '../advertise';

@Injectable({
  providedIn: 'root'
})
export class CompserviceService {

  complaint!: Complaint;


  constructor(private httpClient: HttpClient) { }

  private baseUrl = "http://localhost:9090/api/";

  public createComplaint(complaint: Complaint): Observable<Complaint> {
    return this.httpClient.post<Complaint>(`${this.baseUrl}addComplaint`, complaint);
  }

  public getComplaints(): Observable<Complaint[]> {
    return this.httpClient.get<Complaint[]>("http://localhost:9090/api/getComplaint");
  }

  public getComplaintById(complaint_id: number): Observable<Complaint> {
    return this.httpClient.get<Complaint>("http://localhost:9090/api/getComplaints/" + complaint_id);
  }

  public deleteComplaint(complaint_id: number): Observable<Complaint> {
    return this.httpClient.delete<Complaint>(`${this.baseUrl}deleteComplaints/` + complaint_id);
  }


  public updateComplaint(complaint: Complaint): Observable<Complaint> {
    return this.httpClient.put<Complaint>(`${this.baseUrl}updateComplaint/`, complaint);
  }

  public createFarmer(farmer: Farmer): Observable<Farmer> {
    return this.httpClient.post<Farmer>(`${this.baseUrl}addFarmer/`, farmer);
  }


  public getFarmers(): Observable<Farmer[]> {
    return this.httpClient.get<Farmer[]>("http://localhost:9090/api/getFarmers");
  }

  public getFarmerById(farmer_id: number): Observable<Farmer> {
    return this.httpClient.get<Farmer>("http://localhost:9090/api/getFarmerById/" + farmer_id);
  }

  public deleteFarmer(farmer_id: number): Observable<Farmer> {
    return this.httpClient.delete<Farmer>(`${this.baseUrl}deleteFarmerById/` + farmer_id);
  }
  public updateFarmer(farmer: Farmer): Observable<Farmer> {
    return this.httpClient.put<Farmer>(`${this.baseUrl}updateFarmer/`, farmer);
  }


  public createAdvertise(advertise: Advertise): Observable<Advertise> {
    return this.httpClient.post<Advertise>(`${this.baseUrl}addAdvertise/`, advertise);
  }


  public getAdvertises(): Observable<Advertise[]> {
    return this.httpClient.get<Advertise[]>("http://localhost:9090/api/getAdvertise");
  }

  public getAdvertiseById(adv_id: number): Observable<Advertise> {
    return this.httpClient.get<Advertise>("http://localhost:9090/api/getAdvertises/" + adv_id);
  }

  public deleteAdvertise(adv_id: number): Observable<Advertise> {
    return this.httpClient.delete<Advertise>(`${this.baseUrl}deleteAdvertisement/` + adv_id);
  }
  public updateAdvertise(advertise: Advertise): Observable<Advertise> {
    return this.httpClient.put<Advertise>(`${this.baseUrl}updateAdvertise/`, advertise);
  }



  // getAuthType(): string {
  //   if (this.storage.get("auth_type") !== null) {
  //     return this.storage.get("auth_type");
  //   }
  //  return "admin";
  // }
}

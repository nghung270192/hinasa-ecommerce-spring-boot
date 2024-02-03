import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface Product {
  id: string;
  name: string;
  description: string;
  price: number;
  imgUrl: string;
  quantityTotal: number;
  quantitySold: number;
}

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl = 'http://localhost:8080/api/v1/products';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiUrl}/all`);
  }

  getProductById(productId: string): Observable<Product> {
    return this.http.get<Product>(`${this.apiUrl}/${productId}`);
  }

  addToCart(productId: string, quantity: number): Observable<any> {
    const userId = localStorage.getItem('user_id');

    const headers = new HttpHeaders({
      Authorization: 'Bearer ' + localStorage.getItem('access_token'),
      "Access-Control-Allow-Origin": "*"
    });

    return this.http.post<number>(`http://localhost:8080/api/v1/cart/${userId}/${productId}/${quantity}`, {}, {headers});
  }
}

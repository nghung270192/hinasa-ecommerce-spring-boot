import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export interface CartItem {
  imgUrl: any;
  productId: string;
  productName: string;
  quantity: number;
  price: number;
  subTotal: number;
}

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private baseApiUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {
  }

  updateCartItemCount(count: number) {
    console.log('Updated cart item count:', count);
  }

  getCartItemsCount(userId: string): Observable<number> {
    const apiUrl = `${this.baseApiUrl}/cart/${userId}`;
    return this.http.get<number>(apiUrl);
  }

  getCartItems(userId: string): Observable<CartItem[]> {
    const apiUrl = `${this.baseApiUrl}/cart/${userId}`;
    return this.http.get<CartItem[]>(apiUrl);
  }

  removeCartItem(userId: string, productId: string): Observable<CartItem[]> {
    const apiUrl = `${this.baseApiUrl}/cart/${userId}/${productId}`;
    return this.http.delete<CartItem[]>(apiUrl);
  }
}

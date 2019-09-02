import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { User } from '../model/user';
import {Observable} from 'rxjs';

import {map} from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  API_URL: string = "/fsd/";

  constructor(private httpService: HttpClient) { }

  public  getUserList(): Observable<User[]> {
    return this.httpService.get<User[]>(this.API_URL+ 'users').pipe(
      map(data => 
       data.map(data => 
        new User().deserialize(data)))
    );
    }
  
    public createUser(user:User)
    {
      console.log("creating user"+user);

      return this.httpService.post(`${this.API_URL + 'user'}`,user);
    }
  
    public updateUser(user:User)
    {
      return this.httpService.put(`${this.API_URL + 'updateUser'}`,user);
    }
    
    getUser(userId):Observable<User> {
      return this.httpService.get<User>(`${this.API_URL + 'user'}/${userId}`);
    }
}

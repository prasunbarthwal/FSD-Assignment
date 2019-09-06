import { Injectable } from '@angular/core';
import { Task } from '../model/task';
import { HttpClient } from "@angular/common/http";
import {Observable} from 'rxjs';

import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

 
  API_URL: string = "/fsd/";

  constructor(private httpService: HttpClient) { }

  public  getTaskList(projectId): Observable<Task[]> {
    return this.httpService.get<Task[]>(`${this.API_URL + 'tasks'}/${projectId}`).pipe(
      map(data => 
       data.map(data => 
        new Task().deserialize(data)))
    );
    }
}

import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Task } from '../model/task';
import {Observable} from 'rxjs';

import {map} from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class TaskService {

  API_URL: string = "/fsd/";


  constructor(private httpService: HttpClient) { }

 public  getTaskList(): Observable<Task[]> {
  return this.httpService.get<Task[]>(this.API_URL+ 'tasks').pipe(
    map(data => 
     data.map(data => 
      new Task().deserialize(data)))
  );
  }


  getTask(taskId):Observable<Task> {
    return this.httpService.get<Task>(`${this.API_URL + 'task'}/${taskId}`)
  }

  public createTask(task:Task)
  {
    return this.httpService.post(`${this.API_URL + 'task'}`,task);
  }

  public updateTask(task:Task)
  {
    return this.httpService.put(`${this.API_URL + 'updateTask'}`,task);
  }
  public endTask(taskId,task:Task)
  {
    console
    return this.httpService.put(`${this.API_URL + 'endTask'}/${taskId}`, task);
  }
}

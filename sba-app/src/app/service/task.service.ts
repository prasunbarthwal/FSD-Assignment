import { Injectable } from '@angular/core';
import { Task } from '../model/task';
import { ParentTask } from '../model/parent-task';

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

    public  getParentList(): Observable<ParentTask[]> {
      return this.httpService.get<ParentTask[]>(this.API_URL+ 'parents').pipe(
        map(data => 
         data.map(data => 
          new ParentTask().deserialize(data)))
      );
         }
    
    public createTask(task:Task)
    {
      return this.httpService.post(`${this.API_URL + 'task'}`,task);
    }

    getTask(taskId):Observable<Task> {
      return this.httpService.get<Task>(`${this.API_URL + 'task'}/${taskId}`)
    }

    public endTask(taskId,task:Task)
    {      
      return this.httpService.put(`${this.API_URL + 'endTask'}/${taskId}`, task);
    }
    public updateTask(task:Task)
    {
      return this.httpService.put(`${this.API_URL + 'updateTask'}`,task);
    }
}

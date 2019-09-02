import { Injectable } from '@angular/core';
import { Project } from '../model/project';
import { HttpClient } from "@angular/common/http";
import {Observable} from 'rxjs';

import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  API_URL: string = "/fsd/";

  constructor(private httpService: HttpClient) { }

  public  getProjectList(): Observable<Project[]> {
    return this.httpService.get<Project[]>(this.API_URL+ 'projects').pipe(
      map(data => 
       data.map(data => 
        new Project().deserialize(data)))
    );
    }
  
    public createProject(project:Project)
    {
      return this.httpService.post(`${this.API_URL + 'project'}`,project);
    }
  
    public updateProject(project:Project)
    {
      return this.httpService.put(`${this.API_URL + 'updateProject'}`,project);
    }
    
    getProject(projectId):Observable<Project> {
      return this.httpService.get<Project>(`${this.API_URL + 'project'}/${projectId}`);
    }
}

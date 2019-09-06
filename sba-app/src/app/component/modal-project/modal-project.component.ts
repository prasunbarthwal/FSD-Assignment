import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../../service/project.service';
import {Project} from '../../model/project';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormBuilder, FormGroup,FormControl } from  '@angular/forms';
import { Subscription } from 'rxjs';
import { TaskService } from '../../service/task.service';
import {Task} from '../../model/task';

@Component({
  selector: 'app-modal-project',
  templateUrl: './modal-project.component.html',
  styleUrls: ['./modal-project.component.css']
})
export class ModalProjectComponent implements OnInit {

  constructor(private taskService: TaskService,private formBuilder: FormBuilder,private projectService: ProjectService,private dialogRef: MatDialogRef<ModalProjectComponent>) { }
  projects: Project[]=[];
 // tasks:Task[]=[];
  form: FormGroup;
  private httpSubscription: Subscription;


 // private dialogRef: MatDialogRef<ModalComponent>;


  ngOnInit() {
    //alert(2);
  this.httpSubscription =  this.projectService.getProjectList().subscribe(projectList =>
      this.projects = projectList);
      this.form  =  this.formBuilder.group({
        index: [{value: null, disabled:true}],
        projectId:[{value:''}],
     //   show:[{value: false, disabled:true}],
        projectName: ['']
     //   tasks: this.formBuilder.array([  ])
      
  
    });
  }

  ngOnDestroy() {
    this.httpSubscription.unsubscribe();
  }

  selectProject(project:Project, i) {
      
    this.form.setValue({
      index: i,
      projectId:project.projectId,
      projectName: project.projectName
      
        });
        
this.save();
        
  }

  close()
  {
    console.log("inside project modal close");
    this.dialogRef.close();

  }

  save()
  {     console.log("inside project modal save");

    this.dialogRef.close(this.form.value);

  }

}

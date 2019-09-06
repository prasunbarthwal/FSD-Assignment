import { Component, OnInit } from '@angular/core';
import { ModalProjectComponent } from '../modal-project/modal-project.component';
import {Router} from "@angular/router";
import {NgForm,FormBuilder, FormGroup, Validators,FormControl } from  '@angular/forms';
import { MatDialog,MatDialogConfig } from '@angular/material';
import { TaskService } from '../../service/task.service';
import { ProjectService } from '../../service/project.service';

import {Task} from '../../model/task';
import {Project} from '../../model/project';



@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  tasks: Task[]=[];
  

  // modalRef: MatDialogRef<ModalComponent>;
 
 
   taskForm: FormGroup;
   isSubmitted  =  false;
   showActions: boolean = false;  
   order:boolean = false;
   isDesc:boolean = false;
 
 
 
 
   constructor(private taskService: TaskService,private router: Router, private formBuilder: FormBuilder ,
     private dialog: MatDialog) { }
 
   ngOnInit() {
   
    
     console.log("init task component");
      this.taskForm  =  this.formBuilder.group({
        index: [{value: null, disabled:true}],
        projectId:[''],
     //   show:[{value: false, disabled:true}],
     projectName: ['', Validators.required]
    
  
    });
   
  
    }
    get formControls() { return this.taskForm.controls; }

    searchProject()
    {
      //this.modalRef = this.dialog.open(ModalComponent,{hasBackdrop:false , width:"100",height:"50"});
      const dialogConfig = new MatDialogConfig();
       
        dialogConfig.disableClose = true;
        //dialogConfig.autoFocus = true;

       // this.dialog.open(ModalComponent, dialogConfig);
        const dialogRef = this.dialog.open(ModalProjectComponent, dialogConfig);
        

        dialogRef.afterClosed().subscribe(
          data => 
        
          this.taskForm.patchValue({
            
            projectId:data.projectId,
            projectName: data.projectName

              })
              
      ); 
      dialogRef.afterClosed()   
     // alert (this.taskForm.projectId);
      this.taskService.getTaskList(1).subscribe(taskList =>
      this.tasks = taskList);
      alert(this.tasks[0]);
        
      
    }

}




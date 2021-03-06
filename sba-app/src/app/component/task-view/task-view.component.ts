import { Component, OnInit } from '@angular/core';
import {Task} from '../../model/task';
import {Router} from "@angular/router";
import {NgForm,FormBuilder, FormGroup, Validators,FormControl } from  '@angular/forms';
import { MatDialog,MatDialogConfig } from '@angular/material';
import { TaskService } from '../../service/task.service';
import { ModalComponent } from '../modal/modal.component';
import { ModalParentTaskComponent } from '../modal-parent-task/modal-parent-task.component';

import { ModalProjectComponent } from '../modal-project/modal-project.component';


@Component({
  selector: 'app-task-view',
  templateUrl: './task-view.component.html',
  styleUrls: ['./task-view.component.css']
})
export class TaskViewComponent implements OnInit {
  addTaskForm: FormGroup;
  isSubmitted  =  false;
  checkPolicy = false;


  constructor(private taskService: TaskService, private router: Router, private formBuilder: FormBuilder ,
    private dialog: MatDialog) { }
  ngOnInit() {   this.addTaskForm  =  this.formBuilder.group({
    projectId:[''],
    userId:[''],
    parentTaskId:[''],

    userName:[''],
    task:['',Validators.required],
    parentTask:[''],
    isParent:[false],

 //   show:[{value: false, disabled:true}],
 projectName: ['', Validators.required],
 priority: [''],
    startDate: [''],
    endDate:['']

});

const currentDate = new Date().toISOString().substring(0,10);
const futureDate = new Date((new Date()).getTime() + (60*60*24*1000)).toISOString().substring(0,10);

this.addTaskForm.patchValue(
{
  startDate:currentDate,
  endDate:futureDate
})

}
get formControls() { return this.addTaskForm.controls; }

onSubmit() {
  this.isSubmitted = true;
  if(this.addTaskForm.invalid){
    return;
  }
  this.taskService.createTask(this.addTaskForm.value)
    .subscribe( data => {
      this.router.navigate(['view-task']);

    });

  }

onClear() {
  this.addTaskForm.reset();
  }

  searchUser()
  {
    //this.modalRef = this.dialog.open(ModalComponent,{hasBackdrop:false , width:"100",height:"50"});
    const dialogConfig = new MatDialogConfig();

      dialogConfig.disableClose = true;
      //dialogConfig.autoFocus = true;

     // this.dialog.open(ModalComponent, dialogConfig);
      const dialogRef = this.dialog.open(ModalComponent, dialogConfig);

      dialogRef.afterClosed().subscribe(
        data => 
        this.addTaskForm.patchValue({
          
          userId:data.userId,
          userName: data.firstName +" "+ data.lastName
            })
    );    

  }
  searchParentTask()
  {
    //this.modalRef = this.dialog.open(ModalComponent,{hasBackdrop:false , width:"100",height:"50"});
    const dialogConfig = new MatDialogConfig();

      dialogConfig.disableClose = true;
      //dialogConfig.autoFocus = true;

     // this.dialog.open(ModalComponent, dialogConfig);
      const dialogRef = this.dialog.open(ModalParentTaskComponent, dialogConfig);

      dialogRef.afterClosed().subscribe(
        data => 
        this.addTaskForm.patchValue({
          
          parentTaskId:data.parentTaskId,
          parentTask: data.parentTask
            })
    );    

  }

  
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
      
        this.addTaskForm.patchValue({
          
          projectId:data.projectId,
          projectName: data.projectName

            })
            
    ); 
         
    
  }
  disableFields()
  {
    if(this.formControls.isParent.value)
    {
      this.formControls.startDate.disable();
      this.formControls.endDate.disable();
      this.formControls.priority.disable();
      this.checkPolicy=true;
     

    }
    else
  {
    this.formControls.startDate.enable();
      this.formControls.endDate.enable();
      this.formControls.priority.enable();

      this.checkPolicy=false;


  }
}












}

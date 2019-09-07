import { Component, OnInit,ViewChild } from '@angular/core';
import { TaskService } from '../../service/task.service';
import {Router} from "@angular/router";
import {NgForm,FormBuilder, FormGroup, Validators } from  '@angular/forms';
import { ModalComponent } from '../modal/modal.component';
import { ModalParentTaskComponent } from '../modal-parent-task/modal-parent-task.component';
import { MatDialog,MatDialogConfig } from '@angular/material';

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {

  constructor(private taskService: TaskService, private router: Router, private formBuilder: FormBuilder ,private dialog: MatDialog) { }
  isSubmitted  =  false;
  myform: FormGroup;

  ngOnInit() {
    console.log("inside init edit");
    this.myform  =  this.formBuilder.group({
      projectId:[''],
      taskId:[''],

      userId:[''],
      parentTaskId:[''],
  
      userName:[''],
      task:[''],
      parentTask:[''],
      isParent:[],
  
   projectName: ['', Validators.required],
   priority: [''],
      startDate: [''],
      endDate:['']
  
  });
  let taskId = window.localStorage.getItem("taskId");
    if(!taskId) {
      this.router.navigate(['view-task']);
      return;
    }
    this.taskService.getTask(taskId)
    .subscribe( data => {
      this.myform.setValue(data);
    });
  
  }

  onSubmit() {
    this.isSubmitted = true;
    if(this.myform.invalid){
      return;
    }
    this.taskService.updateTask(this.myform.value)
      .subscribe( data => {
        this.router.navigate(['view-task']);

      //  this.router.navigate(['list-user']);
      });

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
        this.myform.patchValue({
          
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
        this.myform.patchValue({
          
          parentTaskId:data.parentTaskId,
          parentTask: data.parentTask
            })
    );    

  }
  get formControls() { return this.myform.controls; }
 
  cancel ()
  {
    this.router.navigate(['view-task']);

  }

}

import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../../service/project.service';
import {Project} from '../../model/project';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormBuilder, FormGroup,FormControl } from  '@angular/forms';
import { Subscription } from 'rxjs';
import { TaskService } from '../../service/task.service';
import {ParentTask} from '../../model/parent-task';

@Component({
  selector: 'app-modal-parent-task',
  templateUrl: './modal-parent-task.component.html',
  styleUrls: ['./modal-parent-task.component.css']
})
export class ModalParentTaskComponent implements OnInit {

  constructor(private taskService: TaskService,private formBuilder: FormBuilder,private dialogRef: MatDialogRef<ModalParentTaskComponent>) { }
  tasks: ParentTask[]=[];
 // tasks:Task[]=[];
  form: FormGroup;
  private httpSubscription: Subscription;


 // private dialogRef: MatDialogRef<ModalComponent>;


  ngOnInit() {
    //alert(2);
  this.httpSubscription =  this.taskService.getParentList().subscribe(taskList =>
      this.tasks = taskList);
      this.form  =  this.formBuilder.group({
        index: [{value: null, disabled:true}],
        parentTaskId:[{value:''}],
        parentTask: ['']
      
  
    });
  }

  ngOnDestroy() {
    this.httpSubscription.unsubscribe();
  }

  selectParentTask(parentTask:ParentTask, i) {
      
    this.form.setValue({
      index: i,
      parentTaskId:parentTask.parentTaskId,
      parentTask: parentTask.parentTask
      
        });
        
this.save();
        
  }

  close()
  {
    this.dialogRef.close();

  }

  save()
  {     

    this.dialogRef.close(this.form.value);

  }


}

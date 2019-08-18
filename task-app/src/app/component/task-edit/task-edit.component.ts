import { Component, OnInit,ViewChild } from '@angular/core';
import { TaskService } from '../../service/task.service';
import {Router} from "@angular/router";
import {NgForm,FormBuilder, FormGroup, Validators } from  '@angular/forms';


@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {

  constructor(private taskService: TaskService, private router: Router, private formBuilder: FormBuilder ) { }
  //@ViewChild('editForm') editForm: NgForm;
  myform: FormGroup;
  isSubmitted  =  false;
  get formControls() { return this.myform.controls; }
  ngOnInit() {
    this.myform  =  this.formBuilder.group({
      id:[''],
      task: ['', Validators.required],
      parentTask: [''],
      priority: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['']

  });
    let taskId = window.localStorage.getItem("taskId");
    if(!taskId) {
      alert("Invalid action.")
      this.router.navigate(['tasks']);
      return;
    }
    this.taskService.getTask(taskId)
    .subscribe( data => {
     // console.log('edit successfull');
      this.myform.setValue(data);
    });
  }

  onSubmit() {
    console.log(this.myform .value);
    this.isSubmitted = true;
    if(this.myform.invalid){
      return;
    }
    this.taskService.updateTask(this.myform.value)
      .subscribe( data => {
        this.router.navigate(['tasks']);

      //  this.router.navigate(['list-user']);
      });

    }
  onCancel() {
    this.router.navigate(['tasks']);
    }

}

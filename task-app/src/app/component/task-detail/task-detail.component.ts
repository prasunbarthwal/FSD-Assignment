import {Component, OnInit,ViewChild } from '@angular/core';
import {Task} from '../../model/task';
import {NgForm,FormBuilder, FormGroup, Validators } from  '@angular/forms';

import { TaskService } from '../../service/task.service';
import {Router} from "@angular/router";



@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.css']
})
export class TaskDetailComponent implements OnInit {
  task: Task;
  constructor(private taskService: TaskService, private router: Router, private formBuilder: FormBuilder ) { }

  ngOnInit() {
    this.myform  =  this.formBuilder.group({
      task: ['', Validators.required],
      parentTask: [''],
      priority: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['']

  });
  }
//@ViewChild('myform') myform: NgForm;
myform: FormGroup;
isSubmitted  =  false;
get formControls() { return this.myform.controls; }


  onSubmit() {
    this.isSubmitted = true;
    if(this.myform.invalid){
      return;
    }
    this.taskService.createTask(this.myform.value)
      .subscribe( data => {
        this.router.navigate(['tasks']);

      //  this.router.navigate(['list-user']);
      });

    }
    onClear() {
      this.myform.reset();
      }

}

import { Component, OnInit,ViewChild } from '@angular/core';
import {Task} from '../../model/task';
import { NgForm } from '@angular/forms';
import { TaskService } from '../../service/task.service';
import {Router} from "@angular/router";



@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.css']
})
export class TaskDetailComponent implements OnInit {
  task: Task;
  constructor(private taskService: TaskService,private router: Router) { }

  ngOnInit() {
  }
	@ViewChild('myform') myform: NgForm;

  onSubmit(form: NgForm) {
    console.log("Course Name is : "+form.controls['task'].value );

    this.taskService.createTask(this.myform.value)
      .subscribe( data => {
        this.router.navigate(['tasks']);

      //  this.router.navigate(['list-user']);
      });

  // this.task.task=form.controls['task'].value;
  //  this.task.priority=form.controls['priority'].value;

    //this.task.endDate=form.controls['endDate'].value;

  //  this.task.startDate=form.controls['startDate'].value;

  //  this.task.parent.parentTask=form.controls['parentTask'].value;

  // this.taskService.createTask(this.task).subscribe((res)=>{
 //     console.log("Created Task");
//});
    }
    onClear() {
      // Now that we have access to the form via the 'ViewChild', we can access the form and clear it.
      this.myform.reset();
      }

}

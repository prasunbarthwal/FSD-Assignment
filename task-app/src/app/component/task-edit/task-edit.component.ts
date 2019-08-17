import { Component, OnInit,ViewChild } from '@angular/core';
import { TaskService } from '../../service/task.service';
import {Router} from "@angular/router";
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {

  constructor(private taskService: TaskService,private router: Router) { }
  @ViewChild('editForm') editForm: NgForm;

  ngOnInit() {
    let taskId = window.localStorage.getItem("taskId");
    if(!taskId) {
      alert("Invalid action.")
      this.router.navigate(['tasks']);
      return;
    }
    this.taskService.getTask(taskId)
    .subscribe( data => {
     // console.log('edit successfull');
      this.editForm.setValue(data);
    });
  }

  onCancel() {
    this.router.navigate(['tasks']);
    }

}

import { Component, OnInit } from '@angular/core';
import {Task} from '../../model/task';
//import { TASKS } from '../../mock-task';
import { TaskService } from '../../service/task.service';
import {Router} from "@angular/router";



@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
  public searchText : string;
  public taskSearch : string;

  
  tasks: Task [] = [];
  constructor(private taskService: TaskService, private router: Router) { }

  ngOnInit() {
    console.log("1");
    this.taskService.getTaskList().subscribe(tasks =>
    
      this.tasks = tasks);
      console.log(this.tasks);
      }

      editTask(task: Task): void {
        window.localStorage.removeItem("taskId");
        window.localStorage.setItem("taskId", task.id.toString());
        this.router.navigate(['task-edit']);
      };

      endTask(task: Task): void {
        console.log("inside end task");

        console.log(task.id.toString())
       

        this.taskService.endTask(task.id.toString(),task)
        .subscribe( data => {
          this.reloadComponent();
        //  this.router.navigate(['tasks']);
        //this.router.navigate(['tasks']);
      });
    }

    reloadComponent() {
      this.router.routeReuseStrategy.shouldReuseRoute = () => false;
      this.router.onSameUrlNavigation = 'reload';
      this.router.navigate(['/tasks']);
  }
}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TasksComponent} from './component/tasks/tasks.component';
import {TaskDetailComponent} from './component/task-detail/task-detail.component';
import {TaskEditComponent} from './component/task-edit/task-edit.component';




const routes: Routes = [  {path: 'tasks' , component: TasksComponent},
{path: 'addTask' , component: TaskDetailComponent},
{path: 'task-edit' , component: TaskEditComponent},
{ path: '',  redirectTo: '/tasks', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

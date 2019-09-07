import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './component/user/user.component';
import { ProjectComponent } from './component/project/project.component';
import { TaskComponent } from './component/task/task.component';
import { TaskViewComponent } from './component/task-view/task-view.component';
import { TaskEditComponent } from './component/task-edit/task-edit.component';



const routes: Routes = [  
{path: 'add-project' , component: ProjectComponent},
//{path: 'add-task' , component: TaskDetailComponent},
{path: 'add-user' , component: UserComponent},
{path: 'view-task' , component: TaskComponent},
{path: 'add-task' , component: TaskViewComponent},
{path: 'edit-task' , component: TaskEditComponent},

{ path: '',  redirectTo: '/add-project', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

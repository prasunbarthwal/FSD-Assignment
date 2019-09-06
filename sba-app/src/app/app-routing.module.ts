import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './component/user/user.component';
import { ProjectComponent } from './component/project/project.component';
import { TaskComponent } from './component/task/task.component';



const routes: Routes = [  
{path: 'add-project' , component: ProjectComponent},
//{path: 'add-task' , component: TaskDetailComponent},
{path: 'add-user' , component: UserComponent},
{path: 'view-task' , component: TaskComponent}
//{ path: '',  redirectTo: '/tasks', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

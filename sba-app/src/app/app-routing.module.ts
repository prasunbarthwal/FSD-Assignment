import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './component/user/user.component';

const routes: Routes = [  
//{path: 'add-project' , component: TasksComponent},
//{path: 'add-task' , component: TaskDetailComponent},
{path: 'add-user' , component: UserComponent}
//{path: 'view-task' , component: TaskEditComponent},
//{ path: '',  redirectTo: '/tasks', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

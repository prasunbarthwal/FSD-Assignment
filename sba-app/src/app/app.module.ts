import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms'; // <-- NgModel lives here
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './material.module';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { UserComponent } from './component/user/user.component';
import {UserFilterPipe} from './filter/userFilter.pipe';
import {OrderByPipe} from './filter/orderBy.pipe';
import { ProjectComponent } from './component/project/project.component';
import { ModalComponent } from './component/modal/modal.component';
import { TaskComponent } from './component/task/task.component';
import { TaskViewComponent } from './component/task-view/task-view.component';
import { ModalProjectComponent } from './component/modal-project/modal-project.component';
import { ModalParentTaskComponent } from './component/modal-parent-task/modal-parent-task.component';
import { TaskEditComponent } from './component/task-edit/task-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    UserComponent,
    UserFilterPipe,
    OrderByPipe,
    ProjectComponent,
    ModalComponent,
    TaskComponent,
    TaskViewComponent,
    ModalProjectComponent,
    ModalParentTaskComponent,
    TaskEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MaterialModule
  ],
  entryComponents: [ModalComponent,ModalProjectComponent,ModalParentTaskComponent]
,
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

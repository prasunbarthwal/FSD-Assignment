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
import { ProjectComponent } from './component/project/project.component';
import { ModalComponent } from './component/modal/modal.component';
import { TaskComponent } from './component/task/task.component';
import { TaskViewComponent } from './component/task-view/task-view.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    UserComponent,
    UserFilterPipe,
    ProjectComponent,
    ModalComponent,
    TaskComponent,
    TaskViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MaterialModule
  ],
  entryComponents: [ModalComponent]
,
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

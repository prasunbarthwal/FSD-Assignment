import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms'; // <-- NgModel lives here
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TasksComponent } from './component/tasks/tasks.component';
import { TaskDetailComponent } from './component/task-detail/task-detail.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { MaterialModule } from './material.module';
import { FilterPipe} from './filter.pipe';
import {TaskFilterPipe} from './taskFilter.pipe';
import {ParentFilterPipe} from './parentFilter.pipe';
import {StartDateFilterPipe} from './startDateFilter.pipe';
import {EndDateFilterPipe} from './endDateFilter.pipe';
import { TaskEditComponent } from './component/task-edit/task-edit.component';

//import { MatDatepickerModule, MatNativeDateModule,  MatFormFieldModule,  MatInputModule } from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    TaskDetailComponent,
    HeaderComponent,
    FooterComponent,
    FilterPipe,
    TaskFilterPipe,
    ParentFilterPipe,
    StartDateFilterPipe,
    EndDateFilterPipe,
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
  providers: [],

  bootstrap: [AppComponent]
})
export class AppModule { }

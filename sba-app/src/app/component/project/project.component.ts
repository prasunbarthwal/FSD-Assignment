import { Component, OnInit } from '@angular/core';
import {Project} from '../../model/project';
import {Router} from "@angular/router";
import {NgForm,FormBuilder, FormGroup, Validators,FormControl } from  '@angular/forms';
import { MatDialog,MatDialogConfig } from '@angular/material';
import { ProjectService } from '../../service/project.service';
import { ModalComponent } from '../modal/modal.component';


@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  projects: Project[]=[];
 // modalRef: MatDialogRef<ModalComponent>;


  projectForm: FormGroup;
  isSubmitted  =  false;
  showActions: boolean = false;  
  order:boolean = false;
  isDesc:boolean = false;




  constructor(private projectService: ProjectService, private router: Router, private formBuilder: FormBuilder ,
    private dialog: MatDialog) { }

  ngOnInit() {

    this.projectService.getProjectList().subscribe(projectList =>
     this.projects = projectList);
     this.projectForm  =  this.formBuilder.group({
       index: [{value: null, disabled:true}],
       projectId:[{value:''}],
       userId:[{value:''}],
       setDate:[{value:''}],
    //   show:[{value: false, disabled:true}],
    projectName: ['', Validators.required],
    priority: ['', Validators.required],
       manager: [{value:'', disabled:true}, Validators.required],
       startDate: [{value:'', disabled:true}],
       endDate:[{value:'', disabled:true}]
 
   });
  
 
   }
   get formControls() { return this.projectForm.controls; }

   reloadComponent() {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = 'reload';
    this.router.navigate(['/add-project']);
}

enableDate()
{
  if(this.formControls.setDate.value)
  {
    const currentDate = new Date().toISOString().substring(0,10);
    const futureDate = new Date((new Date()).getTime() + (60*60*24*1000)).toISOString().substring(0,10);
    this.formControls.startDate.enable();
    this.formControls.endDate.enable();
    this.projectForm.patchValue(
    {
      startDate:currentDate,
      endDate:futureDate
    })

  }
  else{
    this.formControls.startDate.disable();
    this.formControls.endDate.disable();
    this.projectForm.patchValue(
      {
        startDate:'',
        endDate:''
      })


  }

}
  onClear() {
    this.projectForm.reset();
    }

    searchUser()
    {
      //this.modalRef = this.dialog.open(ModalComponent,{hasBackdrop:false , width:"100",height:"50"});
      const dialogConfig = new MatDialogConfig();

        dialogConfig.disableClose = true;
        //dialogConfig.autoFocus = true;

        this.dialog.open(ModalComponent, dialogConfig);
        const dialogRef = this.dialog.open(ModalComponent, dialogConfig);
        dialogRef.afterClosed().subscribe(
          data => 
          this.projectForm.patchValue({
            
            userId:data.userId,
            manager: data.firstName +" "+ data.lastName
              })
      );    

    }

}

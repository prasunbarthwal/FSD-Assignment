import { Component, OnInit } from '@angular/core';
import {Project} from '../../model/project';
import {Router} from "@angular/router";
import {NgForm,FormBuilder, FormGroup, Validators,FormControl } from  '@angular/forms';
import { MatDialog,MatDialogConfig } from '@angular/material';
import { ProjectService } from '../../service/project.service';
import { ModalComponent } from '../modal/modal.component';
import { CompareDate } from '../../helper/compare-date.validator';



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
       projectId:[''],
       userId:[{value:''}],
       setDate:[{value:''}],
    //   show:[{value: false, disabled:true}],
    projectName: ['', Validators.required],
    priority: ['', Validators.required],
       manager: [{value:''}],
       startDate: [{value:'', disabled:true}],
       endDate:[{value:'', disabled:true}]
 
   });
  
 
   }
   get formControls() { return this.projectForm.controls; }

   
  onUpdateSubmit(userForm)
  {
    console.log('inside update 1');

    this.isSubmitted = true;
    if(this.projectForm.invalid){
      return;
    }
    this.projectService.updateProject(this.projectForm.value)
    .subscribe( data => {
    // this.router.navigate(['add-user']);
 this.reloadComponent();
   });
   this.projectForm.reset() // reset form to empty

  }

  onAddSubmit(projectForm) {
    console.log('inside create 5'+this.projectForm.value);
    console.log(this.formControls.projectName.value);
    console.log(this.formControls.userId.value);
    console.log(this.formControls.manager.value);


    this.isSubmitted = true;
    if(this.projectForm.invalid){
      console.log('inside invalid'+this.projectForm.value);

      return;
    }
  let index = projectForm.getRawValue().index
  console.log('inside create 2'+index);

  if(index != null) {
    console.log('inside update');
    this.projects[index] = projectForm.value;
    this.onUpdateSubmit(projectForm)

  } else {
   // this.users.push(userForm.value)
   console.log('inside create 3'+this.projectForm.value);

   this.projectService.createProject(this.projectForm.value)
   .subscribe( data => {
   // this.router.navigate(['add-user']);
this.reloadComponent();
  });
  }
  this.projectForm.reset() // reset form to empty
  }

 

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

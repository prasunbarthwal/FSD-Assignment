import { Component, OnInit } from '@angular/core';
import {Project} from '../../model/project';
import {Router} from "@angular/router";
import {NgForm,FormBuilder, FormGroup, Validators,FormControl } from  '@angular/forms';
import { MatDialog,MatDialogConfig } from '@angular/material';
import { ProjectService } from '../../service/project.service';
import { ModalComponent } from '../modal/modal.component';
import { MustMatch } from '../../helper/MustMatch.validator';



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
  isDesc:boolean = true;
  column:string; 
  direction: number;



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
       manager: ['',Validators.required],
       startDate: [{value:'', disabled:true}],
       endDate:[{value:'', disabled:true}]
      }, {
        validator: MustMatch('startDate', 'endDate')
      });
 
   }
   get formControls() { return this.projectForm.controls; }

   
  onUpdateSubmit(userForm)
  {

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
  
    this.isSubmitted = true;
    if(this.projectForm.invalid){

      return;
    }
  let index = projectForm.getRawValue().index

  if(index != null) {
    this.projects[index] = projectForm.value;
    this.onUpdateSubmit(projectForm)

  } else {
   // this.users.push(userForm.value)

   this.projectService.createProject(this.projectForm.value)
   .subscribe( data => {
   // this.router.navigate(['add-user']);
this.reloadComponent();
  });
  }
  this.projectForm.reset() // reset form to empty
  }


  
  editProject(project:Project, i) {
    this.projectForm.patchValue({
      index: i,
      projectId:project.projectId,
      startDate:project.startDate,
      endDate: project.endDate,
      manager: project.manager,
      projectName:project.projectName,
      userId:project.userId,
      priority:project.priority


        })
        this.showActions=true;
  }
 

   reloadComponent() {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = 'reload';
    this.router.navigate(['/add-project']);
}

sort(property){
  this.isDesc = !this.isDesc; //change the direction    
  this.column = property;
  this.direction = this.isDesc ? 1 : -1;
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

       // this.dialog.open(ModalComponent, dialogConfig);
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

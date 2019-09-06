import { Component, OnInit } from '@angular/core';
import {User} from '../../model/user';
import {Router} from "@angular/router";
import {NgForm,FormBuilder, FormGroup, Validators,FormControl } from  '@angular/forms';
import { UserService } from '../../service/user.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
  
})
export class UserComponent implements OnInit {

  users: User[]=[];

  userForm: FormGroup;
  isSubmitted  =  false;
  showActions: boolean = false;  
  order:boolean = false;
  isDesc:boolean = true;
  column:string;

  direction: number;
  // Change sort function to this: 
  sort(property){
      this.isDesc = !this.isDesc; //change the direction    
      this.column = property;
      this.direction = this.isDesc ? 1 : -1;
  }


  constructor(private userService: UserService, private router: Router, private formBuilder: FormBuilder ) { }

  ngOnInit() {
   // this.users=[];
   
   this.userService.getUserList().subscribe(userList =>
    this.users = userList);
    this.userForm  =  this.formBuilder.group({
      index: [{value: null, disabled:true}],
      userId:[''],
   //   show:[{value: false, disabled:true}],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      empId: ['', [Validators.required, Validators.min(1),Validators.pattern('[0-9]*')]]

  });


  }
  get formControls() { return this.userForm.controls; }

  onUpdateSubmit(userForm)
  {
    this.isSubmitted = true;
    if(this.userForm.invalid){
      return;
    }
    this.userService.updateUser(this.userForm.value)
    .subscribe( data => {
    // this.router.navigate(['add-user']);
 this.reloadComponent();
   });
   this.userForm.reset() // reset form to empty

  }

  onAddSubmit(userForm) {
    this.isSubmitted = true;
    if(this.userForm.invalid){
      return;
    }
  let index = userForm.getRawValue().index
  if(index != null) {
    console.log('inside update');
    this.users[index] = userForm.value;
    this.onUpdateSubmit(userForm)

  } else {
   // this.users.push(userForm.value)
       console.log("creating user 1"+this.userForm.value)
   this.userService.createUser(this.userForm.value)
   .subscribe( data => {
   // this.router.navigate(['add-user']);
this.reloadComponent();
  });
  }
  this.userForm.reset() // reset form to empty
  }

  editUser(user:User, i) {
    this.userForm.setValue({
      index: i,
      userId:user.userId,
      firstName: user.firstName,
      lastName: user.lastName,
      empId:user.empId
        })
        this.showActions=true;
  }

  reloadComponent() {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = 'reload';
    this.router.navigate(['/add-user']);
}
  onClear() {
    this.userForm.reset();
    }

    sortEmpId(){
      this.isDesc = !this.isDesc; //change the direction    
      //this.column = property;
     // let direction = this.isDesc ? 1 : -1;
    this.users.sort((obj1, obj2) => {
    // Ascending: first age less than the previous
    return (this.isDesc) ? obj1.empId - obj2.empId : obj2.empId - obj1.empId;
  });

  }

  sortFName(){
    this.isDesc = !this.isDesc; //change the direction    
    //this.column = property;
   // let direction = this.isDesc ? 1 : -1;
  this.users.sort((obj1, obj2) => {
  // Ascending: first age less than the previous
  //return (this.isDesc) ? obj1.firstName > obj2.firstName : obj2.firstName > obj1.firstName;
  return (this.isDesc)? obj1.firstName .localeCompare(obj2.firstName):obj2.firstName.localeCompare(obj1.firstName );
});
  }
sortLName(){
  this.isDesc = !this.isDesc; //change the direction    
  //this.column = property;
 // let direction = this.isDesc ? 1 : -1;
this.users.sort((obj1, obj2) => {
// Ascending: first age less than the previous
//return (this.isDesc) ? obj1.firstName > obj2.firstName : obj2.firstName > obj1.firstName;
return (this.isDesc)? obj1.lastName .localeCompare(obj2.lastName):obj2.lastName.localeCompare(obj1.lastName );

});

}
 
}

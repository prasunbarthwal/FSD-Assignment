import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';
import {User} from '../../model/user';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormBuilder, FormGroup,FormControl } from  '@angular/forms';


@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private userService: UserService,private dialogRef: MatDialogRef<ModalComponent>) { }
  users: User[]=[];
  form: FormGroup;

 // private dialogRef: MatDialogRef<ModalComponent>;


  ngOnInit() {
    this.userService.getUserList().subscribe(userList =>
      this.users = userList);
      this.form  =  this.formBuilder.group({
        index: [{value: null, disabled:true}],
        userId:[{value:''}],
     //   show:[{value: false, disabled:true}],
        firstName: [''],
        lastName: [''],
       
  
    });


  }

  selectUser(user:User, i) {
    console.log("inside select user");

    this.form.setValue({
      index: i,
      userId:user.userId,
      firstName: user.firstName,
      lastName: user.lastName,
        })
this.save();
        
  }

  close()
  {
    console.log("inside modal close");
    this.dialogRef.close();

  }

  save()
  {     console.log("inside modal save");

    this.dialogRef.close(this.form.value);

  }

}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators, FormGroup } from '@angular/forms';
import { UserService } from 'src/app/shared/service/user.service';
import { LoginAuthService } from 'src/app/shared/service/login-auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  
  reactiveForm:any=FormGroup;
  userFile:any=File;

  public loginuser:any={};
  public currentStatus:any;
  constructor(private fb:FormBuilder,private userService:UserService) {

    this.loginuser=JSON.parse(localStorage.getItem('currentUser'));
    this.reactiveForm=this.fb.group({
      name: new FormControl('', [Validators.required, Validators.compose([Validators.pattern('[a-zA-z ]*'), Validators.minLength(3)])]),
      username: new FormControl('', [Validators.required, Validators.compose([Validators.pattern('[a-zA-z ]*[0-9+ ]*'), Validators.minLength(3)])]),
      password: new FormControl('', [Validators.required, Validators.compose([Validators.pattern('[a-zA-z ]*[0-9+ ]*'), Validators.minLength(8)])])
    });
  
   }

   saveForm(submitForm:FormGroup){
    if(submitForm.valid){
      const user=submitForm.value;
      const formData= new FormData();
      formData.append('user',JSON.stringify(user));
      formData.append('file',this.userFile);
      this.userService.register(formData).subscribe((response)=>{
        console.log(response);
      });
      console.log(submitForm.value);
      this.reactiveForm.reset();
    }else{
      this.validateFormFields(submitForm);
    }
  }
   
   validateFormFields(submitForm:FormGroup){
    Object.keys(submitForm.controls).forEach(field=>{
      const control=submitForm.get(field);
      if(control instanceof FormControl){
        control.markAsTouched({onlySelf: true});
      }else if(control instanceof FormGroup){
        this.validateFormFields(control);
      }
    })
  }
   onSelectFile(event){
     this.userFile=event.target.files[0];
   }

  ngOnInit() {
  }

}

import {Deserializable} from './deserializable.model';


export class User implements Deserializable{
    userId:number;
    firstName: string;
    lastName: string;
    empId:number;

    
    deserialize(input: any): this {
        // alert(input.parentTask);
          Object.assign(this, input);
         
          return this;
       }

     }
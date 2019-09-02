import {Deserializable} from './deserializable.model';
import { User } from './user';


export class Project implements Deserializable{

    projectId:number;
    projectName: string;
    startDate:Date;
    endDate:Date;
    totalTask:number;
    completedTask:number;
    priority:number;
    manager:string;
    userId:number;
    index:number;
    setDate:boolean;
   // user:User;

    
    deserialize(input: any): this {
        // alert(input.parentTask);
          Object.assign(this, input);
         // this.user =  new User().deserialize(input.parentTask);

          return this;
       }

     }
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
    user:User;

    
    deserialize(input: any): this {
        // alert(input.parentTask);
          Object.assign(this, input);
         
          return this;
       }

     }
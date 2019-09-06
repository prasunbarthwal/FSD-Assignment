import {Deserializable} from './deserializable.model';


export class Task implements Deserializable{
    taskId:number;
    projectId:number;
    projectName: string;
    task: string;
    isParent:boolean;
    starDate:Date;
    endDate:Date;
    priority:number;
    parentTask:string ;
    parentTaskId:number;
    userId:number;
    userName:string; 


    
    deserialize(input: any): this {
        // alert(input.parentTask);
          Object.assign(this, input);
         
          return this;
       }

     }
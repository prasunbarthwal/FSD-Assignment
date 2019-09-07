import {Deserializable} from './deserializable.model';


export class ParentTask implements Deserializable{
    parentTaskId:number;
    parentTask:number;
   


    
    deserialize(input: any): this {
        // alert(input.parentTask);
          Object.assign(this, input);
         
          return this;
       }

     }
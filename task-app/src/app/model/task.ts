
import {ParentTask} from "./parent-task";
import {Deserializable} from './deserializable.model';

export class Task implements Deserializable {
    id:number;
    task: string;
    priority:number;
    parent:ParentTask;
    startDate:Date;
    endDate:Date;

    deserialize(input: any): this {
     // alert(input.parentTask);
    //  alert(input.Task);
       Object.assign(this, input);
      // this.parent = input.parentTask.map(item => new ParentTask().deserialize(item));
      this.parent =  new ParentTask().deserialize(input.parentTask);
       return this;
    }
  }
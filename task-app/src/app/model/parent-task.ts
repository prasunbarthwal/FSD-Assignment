
import {Deserializable} from './deserializable.model';

export class ParentTask implements Deserializable {

  parentTask:string;
  deserialize(input: any): this {
    return Object.assign(this, input);
  }
    
    
    
  }
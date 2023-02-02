import { Movies } from "./Movies";
import { Screen } from "./Screen";

export class Show{
    constructor(public id:number,public startTime:Date,public movie:Movies,public screen:Screen,public bookedSeats:number[]){}

}
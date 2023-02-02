import { City } from "./City";
import { Screen } from "./Screen";


export class Multiplex{
    constructor(public id:number,public name:string,public address:string,public city:City,public noOfScreens:number,public screens:Screen[]){}
}
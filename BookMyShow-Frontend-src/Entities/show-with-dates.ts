import { MultiplexShows } from "./MultiplexShows";


export class ShowWithDates {
    constructor(public date:Date,public results:MultiplexShows[]){}
}

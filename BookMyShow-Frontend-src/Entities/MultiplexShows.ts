import { Multiplex } from "./Multiplex";
import { Show } from "./Show";

export class MultiplexShows{
    constructor(public multiplex:Multiplex,public shows:Show[]){}
}
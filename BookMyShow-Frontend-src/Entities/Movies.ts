export class Movies{
    constructor(
        public id:number,
        public title:string,
        public genre:string,
        public language:string,
        public format:string,
        public rating:number,
        public duration:number,
        public dateOfRelease:any=new Date(),
        public about:string,
        public cast:string,
        public  crew:string,
        public image:string,
        public backgroundImage:string,
        public reviews:any[] ){}
    }
import { Component, OnInit } from '@angular/core';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { Movies } from 'src/Entities/Movies';
import { MoviesApiService } from 'src/services/movies-api.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-home-main-content',
  templateUrl: './home-main-content.component.html',
  styleUrls: ['./home-main-content.component.css']
})
export class HomeMainContentComponent implements OnInit {

  constructor(private _movieClient:MoviesApiService) { }
  nextImg:any
  counter=0;
  counts=[
    "https://images.news18.com/ibnlive/uploads/2022/03/rrr-ticket-costliest-1-3-164820521016x9.jpg",
    "https://www.hollywoodreporter.com/wp-content/uploads/2022/11/2011_0010_v0420.1075_altered_v2.jpg?w=1296",
    "https://wallpaperaccess.com/full/2765727.jpg",
    "https://wallpaperaccess.com/full/13453.jpg",
    "https://cdn.wallpapersafari.com/28/75/7F1XA2.jpg",
    'https://images3.alphacoders.com/239/239087.jpg'
  ];
  movies?:Array<Movies>=[]
  dropdownList:any = [];
  selectedItems:any = [];
  dropdownSettings:IDropdownSettings = {};



  ngOnInit(): void {
    setInterval(()=>{
      this.increment(this.counts)
    },3000);
    this.fetchMoviesFromServer()
    this.dropdownList = [
      { item_id: "ACTION", item_text: 'Action' },
      { item_id: "FICTION", item_text: 'Fiction' },
      { item_id: "DRAMA", item_text: 'Drama' },
      {item_id:"ROMANTIC",item_text:"Romantic"},
      {item_id:"HORROR",item_text:"Horror"},
      {item_id:"THRILLER",item_text:"Thriller"},
      {item_id:"COMEDY",item_text:"Comedy"}
    ];


    this.selectedItems = [
    ];
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: false,
      enableCheckAll:false,
    };
  }

  increment(counts:Array<String>){
     var key:any
     if(this.counter<counts.length){
        setInterval(()=>{
            this.nextImg=counts[this.counter];
        },1500)
        this.counter=this.counter+1; 
      }
      else{ 
        setInterval(()=>{
          this.nextImg=counts[this.counter];
          },1500)
        this.counter=0
      }
  }  
      // for(key in counts){
      //   key=this.counter
      //     setInterval(()=>{
      //       this.nextImg=counts[key];
      //     },2000)
      //     this.counter=this.counter+1;        
      //   console.log(counts[key],this.counter);
      //   break;
      // } 


      
  fetchMoviesFromServer(){
    this._movieClient.findAllMovies().subscribe(
      data=>this.movies=data,
      error=>console.error(error.error.message)
    )
  }

  onItemSelect(item: any) {
    console.log(item);
    let filterList:any=[]
    for(let element of this.selectedItems ){
      filterList.push(element.item_id)
    }
    this._movieClient.findMovies(filterList).subscribe(data=>(console.log(data),this.movies=data),error=>Swal.fire({
      title: "",
      text: error.error.message,
      icon: "warning",
    }))
  }
  onSelectAll(items: any) {
    console.log(items);
  }

  }


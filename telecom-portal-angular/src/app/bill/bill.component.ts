import { Component, OnInit } from '@angular/core';
import { BillService } from '../bill.service';
import { UserService } from '../user.service';
import User from '../models/User';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {

  bill:number;
  plan1:number;
  plan2:number;
  plan3:number;
  user:User;
  billService:BillService;
  userService:UserService;

  constructor(bservice: BillService, uservice:UserService) { 
    this.billService = bservice;
    this.userService = uservice;
    this.bill = 0;
    this.plan1 = 0;
    this.plan2 = 0;
    this.plan3 = 0;
    this.user = {userID:0, firstName:"daw", lastName:"wadadw", email:"Chung@gmail.com", password:"adwda"};

  }

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe(result => {
      this.user = result[0];
      console.log(this.user);

      this.billService.getBill(this.user).subscribe(result => {
        this.bill = result;
        console.log(result);
      })
      this.billService.getABill(this.user, 1).subscribe(result => {
        this.plan1 = result;
      })
      this.billService.getABill(this.user, 2).subscribe(result => {
        this.plan2 = result;
      })
      this.billService.getABill(this.user, 3).subscribe(result => {
        this.plan3 = result;
      })
   })
   
  }

}

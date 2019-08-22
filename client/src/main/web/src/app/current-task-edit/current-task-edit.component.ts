import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {CurrentTaskService} from "../shared/task/current-task.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-current-task-edit',
  templateUrl: './current-task-edit.component.html',
  styleUrls: ['./current-task-edit.component.css']
})
export class CurrentTaskEditComponent implements OnInit {
  currentTask: any;
  sub:Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private currentTaskService: CurrentTaskService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.currentTaskService.get(id).subscribe((task: any) => {
          if (task) {
            this.currentTask = task;
            this.currentTask.href = task._links.self.href;
          } else {
            console.log(`Task with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/current-task-list']);
  }

  save(form: NgForm) {
    this.currentTaskService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.currentTaskService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}


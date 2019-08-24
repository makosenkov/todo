import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {CurrentTaskService} from "../shared/task/current-task.service";
import {NgForm} from "@angular/forms";
import {CurrentTask} from "../currentTask";
import {ThemePalette} from "@angular/material";

export interface Chips {
  name: string;
  color: ThemePalette;
}

@Component({
  selector: 'app-current-task-edit',
  templateUrl: './current-task-edit.component.html',
  styleUrls: ['./current-task-edit.component.css']
})
export class CurrentTaskEditComponent implements OnInit {
  currentTask: CurrentTask = new CurrentTask;
  submitted = false;
  sub:Subscription;
  availableChips: Chips[] = [
    {name: 'Chill', color: 'primary'},
    {name: 'Normal', color: 'accent'},
    {name: 'Important', color: 'warn'}
  ];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private currentTaskService: CurrentTaskService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.currentTaskService.getCurrentTask(id).subscribe((task: any) => {
          if (task) {
            this.currentTask = task;
          } else {
            console.log(`Task with id '${id}' not found, returning to main page`);
            this.gotoList();
          }
        });
      }
    });
  }

  gotoList() {
    this.router.navigate(['/main']);
  }

  newCurrentTask(): void {
    this.submitted = false;
    this.currentTask = new CurrentTask();
  }

  save() {
    this.currentTaskService.createCurrentTask(this.currentTask)
      .subscribe(data => console.log(data), error => console.log(error));
    this.currentTask = new CurrentTask();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
    this.gotoList();
  }

  delete() {
    this.currentTaskService.deleteCurrentTask(this.currentTask.id)
      .subscribe(data => console.log(data), error => console.log(error));
    this.gotoList();
  }

}


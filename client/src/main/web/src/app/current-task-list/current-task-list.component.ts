import {Component, OnInit} from '@angular/core';
import {CurrentTaskService} from "../shared/task/current-task.service";
import {Observable} from "rxjs";
import {CurrentTask} from "../currentTask";

@Component({
  selector: 'app-current-task-list',
  templateUrl: './current-task-list.component.html',
  styleUrls: ['./current-task-list.component.css']
})
export class CurrentTaskListComponent implements OnInit {
  tasks: Observable<CurrentTask[]>;

  constructor(private taskService: CurrentTaskService) {
  }

  ngOnInit() {
    this.reloadData();
  }

  ngAfterViewInit() {
    this.reloadData();
  }

  reloadData() {
    this.tasks = this.taskService.getCurrentTasksList();
  }

  deleteTask(id: number) {
    this.taskService.deleteCurrentTask(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

}

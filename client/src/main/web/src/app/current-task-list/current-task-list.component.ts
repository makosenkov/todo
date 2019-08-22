import {Component, OnInit} from '@angular/core';
import {CurrentTaskService} from "../shared/task/current-task.service";

@Component({
  selector: 'app-current-task-list',
  templateUrl: './current-task-list.component.html',
  styleUrls: ['./current-task-list.component.css']
})
export class CurrentTaskListComponent implements OnInit {
  tasks: Array<any>;

  constructor(private taskService: CurrentTaskService) {
  }

  ngOnInit() {
    this.taskService.getAll().subscribe(data => {
      this.tasks = data;
    })
  }

}

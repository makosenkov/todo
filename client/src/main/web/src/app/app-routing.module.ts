import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CurrentTaskListComponent} from "./current-task-list/current-task-list.component";
import {CurrentTaskEditComponent} from "./current-task-edit/current-task-edit.component";


const routes: Routes = [
  { path: '', redirectTo: '/current-task-list', pathMatch: 'full' },
  {
    path: 'current-task-list',
    component: CurrentTaskListComponent
  },
  {
    path: 'current-task-add',
    component: CurrentTaskEditComponent
  },
  {
    path: 'current-task-edit/:id',
    component: CurrentTaskEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

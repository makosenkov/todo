import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CurrentTaskEditComponent} from "./current-task-edit/current-task-edit.component";
import {MainComponent} from "./main/main.component";
import {NoteEditComponent} from "./note-edit/note-edit.component";


const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  {
    path: 'main',
    component: MainComponent
  },
  {
    path: 'note-add',
    component: NoteEditComponent
  },
  {
    path: 'note-edit/:id',
    component: NoteEditComponent
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

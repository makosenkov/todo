import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CurrentTaskListComponent } from './current-task-list/current-task-list.component';
import {HttpClientModule} from "@angular/common/http";
import {
  MatButtonModule,
  MatCardModule,
  MatChipsModule, MatIcon,
  MatInputModule,
  MatListModule,
  MatToolbarModule,
  MatIconModule
} from '@angular/material';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule} from "@angular/forms";
import { CurrentTaskEditComponent } from './current-task-edit/current-task-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    CurrentTaskListComponent,
    CurrentTaskEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatChipsModule,
    MatIconModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

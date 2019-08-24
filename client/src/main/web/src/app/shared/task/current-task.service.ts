import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CurrentTaskService {
  public API = '//localhost:8080';
  public CURRENT_TASK_API = this.API + '/current-tasks';

  constructor(private http: HttpClient) {
  }

  getCurrentTask(id: number): Observable<Object> {
    return this.http.get(`${this.CURRENT_TASK_API}/${id}`);
  }

  createCurrentTask(currentTask: Object): Observable<Object> {
    return this.http.post(`${this.CURRENT_TASK_API}`, currentTask);
  }

  updateCurrentTask(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.CURRENT_TASK_API}/${id}`, value);
  }

  deleteCurrentTask(id: number) {
    return this.http.delete(`${this.CURRENT_TASK_API}/${id}`, { responseType: 'text' });
  }

  getCurrentTasksList(): Observable<any> {
    return this.http.get(`${this.CURRENT_TASK_API}`);
  }
}

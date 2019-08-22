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

  getAll(): Observable<any> {
    return this.http.get(this.CURRENT_TASK_API);
  }

  get(id: string) {
    return this.http.get(this.CURRENT_TASK_API + '/' + id);
  }

  save(currentTask: any): Observable<any> {
    let result: Observable<Object>;
    if (currentTask['href']) {
      result = this.http.put(currentTask.href, currentTask);
    } else {
      result = this.http.post(this.CURRENT_TASK_API, currentTask);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}

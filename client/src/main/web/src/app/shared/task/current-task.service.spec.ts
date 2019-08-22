import { TestBed } from '@angular/core/testing';

import { CurrentTaskService } from './current-task.service';

describe('CurrentTaskService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CurrentTaskService = TestBed.get(CurrentTaskService);
    expect(service).toBeTruthy();
  });
});

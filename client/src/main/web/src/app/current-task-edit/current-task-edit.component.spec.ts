import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrentTaskEditComponent } from './current-task-edit.component';

describe('CurrentTaskEditComponent', () => {
  let component: CurrentTaskEditComponent;
  let fixture: ComponentFixture<CurrentTaskEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CurrentTaskEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CurrentTaskEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalParentTaskComponent } from './modal-parent-task.component';

describe('ModalParentTaskComponent', () => {
  let component: ModalParentTaskComponent;
  let fixture: ComponentFixture<ModalParentTaskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalParentTaskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalParentTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

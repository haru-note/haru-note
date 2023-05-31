create table goal (
                      goal_id bigint not null auto_increment,
                      completed BOOLEAN DEFAULT false comment '목표 완료 여부',
                      deleted BOOLEAN DEFAULT false comment '삭제 여부',
                      end_at datetime(6) comment '목표 완료 일시',
                      shared BOOLEAN DEFAULT false comment '공유 여부',
                      start_at datetime(6) comment '목표 시작 일시',
                      title varchar(255) not null comment '제목',
                      type varchar(20) not null comment '목표 타입 (CORNELL_NOTE, FOUR_LINE_DIARY, MANDALART, PLAN_NOTE, TIL, YWT)',
                      user_id bigint not null comment '유저 ID',
                      created_at datetime(6) not null comment '생성일시',
                      created_by varchar(255) comment '생성자',
                      updated_at datetime(6) not null comment '수정일시',
                      updated_by varchar(255) comment '수정자',
                      primary key (goal_id)
) comment='마이 노트 목표' engine=InnoDB



alter table goal modify column updated_at  datetime(6) not null comment '수정일시'
alter table goal modify column end_at  datetime(6) comment '목표 완료 일시'
alter table goal modify column start_at  datetime(6) comment '목표 시작 일시'
alter table goal modify column type  enum ('CORNELL_NOTE','FOUR_LINE_DIARY','MANDALART','PLAN_NOTE','TIL','YWT') not null comment '목표 타입'


alter table goal add created_at datetime(6) not null comment '생성일시';



-- column drop
alter table goal drop column created_at;

alter table goal drop column created_by;

alter table goal drop column updated_at;

alter table goal drop column updated_by;

alter table goal drop column type;


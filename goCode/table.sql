create table TB_TPS_TK_003
(
    TCKT_NO varchar(10)                          not null comment '티켓번호',
    BIZ_CD  varchar(10)                          not null comment '프로젝트코드',
    MISN_ID varchar(15)                          not null comment '할일아이디',
    RLS_ID  varchar(15)                          not null comment '릴리즈아이디',
    TASK_CD varchar(10)                          not null comment '업무코드',
    REG_DT  datetime default current_timestamp() not null comment '등록일시',
    RGTR_ID varchar(10)                          not null comment '등록자아이디',
    primary key (TCKT_NO, BIZ_CD, MISN_ID, RLS_ID, TASK_CD)
)
    comment '프로젝트티켓매핑기본';
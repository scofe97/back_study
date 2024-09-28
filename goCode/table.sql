create table TB_TPS_WK_02A
(
    COMPN_CD            varchar(8)                           not null comment '콤포넌트코드',
    COMPN_VSRN          int                                  not null comment '콤포넌트버전',
    MERGE_TRGT_BRNCH_CD varchar(10)                          not null comment '병합대상브랜치코드',
    TASK_AUTHRT_USE_YN  char     default 'N'                 not null comment '업무권한사용여부',
    TASK_AUTHRT_CD      varchar(10)                          null comment '업무권한코드',
    PRCR_ID             varchar(10)                          null comment '처리자아이디',
    REG_DT              datetime default current_timestamp() not null comment '등록일시',
    RGTR_ID             varchar(10)                          not null comment '등록자아이디',
    primary key (COMPN_CD, COMPN_VSRN)
)
    comment '코드병합콤포넌트상세'
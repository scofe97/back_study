create table TB_TPS_WK_022
(
    COMPN_SN           int                                    not null comment '콤포넌트일련번호',
    STEP_NM            varchar(50)                            not null comment '단계명',
    TASK_AUTHRT_USE_YN char       default 'N'                 not null comment '업무권한사용여부',
    TASK_AUTHRT_CD     varchar(10)                            null comment '업무권한코드',
    APRVR_ID           varchar(10)                            null comment '결재자아이디',
    APRVR_REL_CD       varchar(6) default 'MU'                not null comment '결재자관계코드',
    REG_DT             datetime   default current_timestamp() not null comment '등록일시',
    RGTR_ID            varchar(10)                            not null comment '등록자아이디',
    MDFCN_DT           datetime   default current_timestamp() not null comment '수정일시',
    MDFR_ID            varchar(10)                            not null comment '수정자아이디',
    PRIMARY KEY (COMPN_SN)
)
    comment '결재사전정보상세';
create table TB_TPS_CM_052
(
    WRKFLW_EXCN_NO     varchar(12)                          not null comment '워크플로실행번호',
    WRKFLW_INPT_NO     int                                  not null comment '워크플로입력번호',
    PPLN_NO            varchar(6)                           null comment '파이프라인번호',
    PPLN_VSRN          int                                  null comment '파이프라인버전',
    INOUT_SE           varchar(6)                           not null comment '내외구분',
    BIZ_NO             varchar(50)                          null comment '프로젝트번호',
    TASK_AUTHRT_USE_YN char     default 'N'                 not null comment '업무권한사용여부',
    TASK_AUTHRT_CD     varchar(10)                          null comment '업무권한코드',
    PRCR_ID            varchar(10)                          null comment '처리자아이디',
    STTS_CD            varchar(6)                           null comment '상태코드',
    REG_DT             datetime default current_timestamp() not null comment '등록일시',
    RGTR_ID            varchar(10)                          not null comment '등록자아이디',
    MDFCN_DT           datetime default current_timestamp() not null comment '수정일시',
    MDFR_ID            varchar(10)                          not null comment '수정자아이디',
    primary key (WRKFLW_EXCN_NO, WRKFLW_INPT_NO)
)
    comment '파이프라인매핑정보';
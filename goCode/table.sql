create table TB_TPS_WK_020
(
    COMPN_SN   int                                  not null comment '콤포넌트일련번호'
        primary key,
    COMPN_NM   varchar(50)                          not null comment '콤포넌트명',
    COMPN_TYPE varchar(10)                          not null comment '콤포넌트유형',
    USE_YN     char                                 null comment '사용여부',
    DEL_YN     char                                 null comment '삭제여부',
    REG_DT     datetime default current_timestamp() not null comment '등록일시',
    RGTR_ID    varchar(10)                          not null comment '등록자아이디',
    MDFCN_DT   datetime default current_timestamp() not null comment '수정일시',
    MDFR_ID    varchar(10)                          not null comment '수정자아이디'
)
    comment '콤포넌트기본';
create table TB_TPS_WK_027
(
    COMPN_SN       int                                  not null comment '콤포넌트일련번호'
        primary key,
    CERT_MTHD_CD   varchar(10)                          null comment '인증방법코드',
    URL            varchar(200)                         null comment 'URL',
    BSC_CERT_ID    varchar(100)                         null comment '기본인증아이디',
    BSC_CERT_SGNL  varchar(128)                         null comment '기본인증부호',
    TKN_VL         varchar(300)                         null comment '토큰값',
    TKN_SCS_SE_VL  varchar(70)                          null comment '토큰성공구분값',
    TKN_FAIL_SE_VL varchar(70)                          null comment '토큰실패구분값',
    ESNTL_PRGRS_YN char     default 'Y'                 not null comment '필수진행여부',
    REG_DT         datetime default current_timestamp() not null comment '등록일시',
    RGTR_ID        varchar(10)                          not null comment '등록자아이디',
    MDFCN_DT       datetime default current_timestamp() not null comment '수정일시',
    MDFR_ID        varchar(10)                          not null comment '수정자아이디'
)
    comment '인터페이스사전정보설정';
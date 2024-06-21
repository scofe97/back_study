create table TB_TPS_TK_005
(
    TCKT_NO  varchar(10)                          not null comment '티켓번호',
    REPO_SN  int                                  not null comment '저장소순번',
    INOUT_SE varchar(6)                           not null comment '내외구분',
    BIZ_NO   varchar(50)                          null comment '프로젝트번호',
    PPLN_NO  varchar(6)                           null comment '파이프라인번호',
    REG_DT   datetime default current_timestamp() not null comment '등록일시',
    RGTR_ID  varchar(10)                          not null comment '등록자아이디',
    primary key (TCKT_NO, REPO_SN)
)
    comment '티켓레포정보';
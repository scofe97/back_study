create table TB_TPS_TK_002
(
    TCKT_NO       varchar(10)                          not null comment '티켓번호',
    REG_DT        datetime default current_timestamp() not null comment '등록일시',
    CRLTN_RSVT_DT varchar(14)                          null comment '''YYYYMMDDHHMISS'' 14자리 화면에서 입력',
    RGTR_ID       varchar(10)                          not null comment '등록자아이디',
    primary key (TCKT_NO, REG_DT)
)
    comment '티켓베포예약일시변경이력'
create table TB_TPS_BB_002
(
    BBS_SE                int                                  not null comment '게시판일련번호',
    PST_SE                int                                  not null comment '게시글일련번호',
    TASK_CD               varchar(10)                          null comment '업무코드용',
    PST_TTL               varchar(100)                         not null comment '게시글제목',
    PST_CN                mediumtext                           not null comment '게시물내용',
    ATCH_FILE_GROUP_NO    varchar(10)                          null comment '첨부파일그룹번호',
    UPEND_FIXING_YN       char     default 'N'                 not null comment '상단고정여부',
    UPEND_FIXING_BGNG_YMD varchar(8)                           null comment '상단고정시작일자',
    UPEND_FIXING_END_YMD  varchar(8)                           null comment '상단고정종료일자',
    MAIN_NTC_YN           char     default 'N'                 not null comment '공지사항 유형 사용 시 입력',
    MAIN_NTC_BGNG_YMD     varchar(8)                           null comment '메인공지시작일자',
    MAIN_NTC_END_YMD      varchar(8)                           null comment '메인공지종료일자',
    DEL_YN                char     default 'N'                 not null comment '삭제여부',
    REG_DT                datetime default current_timestamp() not null comment '등록일시',
    RGTR_ID               varchar(10)                          not null comment '등록자아이디',
    MDFCN_DT              datetime default current_timestamp() not null comment '수정일시',
    MDFR_ID               varchar(10)                          not null comment '수정자아이디',
    primary key (BBS_SE, PST_SE)
)
    comment '공지사항게시판';
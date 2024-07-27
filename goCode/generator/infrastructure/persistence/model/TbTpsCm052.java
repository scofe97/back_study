package org.okestro.tps.api.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbTpsCm052 {
    private String wrkflwExcnNo;      // 워크플로실행번호
    private Integer wrkflwInptNo;      // 워크플로입력번호
    private String pplnNo;      // 파이프라인번호
    private Integer pplnVsrn;      // 파이프라인버전
    private String inoutSe;      // 내외구분
    private String bizNo;      // 프로젝트번호
    private String taskAuthrtUseYn;      // 업무권한사용여부
    private String taskAuthrtCd;      // 업무권한코드
    private String prcrId;      // 처리자아이디
    private String sttsCd;      // 상태코드
    private LocalDateTime regDt;      // 등록일시
    private String rgtrId;      // 등록자아이디
    private LocalDateTime mdfcnDt;      // 수정일시
    private String mdfrId;      // 수정자아이디
}
package org.okestro.tps.api.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbTpsWk022 {
    private Integer compnSn;      // 콤포넌트일련번호
    private String stepNm;      // 단계명
    private String taskAuthrtUseYn;      // 업무권한사용여부
    private String taskAuthrtCd;      // 업무권한코드
    private String aprvrId;      // 결재자아이디
    private String aprvrRelCd;      // 결재자관계코드
    private LocalDateTime regDt;      // 등록일시
    private String rgtrId;      // 등록자아이디
    private LocalDateTime mdfcnDt;      // 수정일시
    private String mdfrId;      // 수정자아이디
}
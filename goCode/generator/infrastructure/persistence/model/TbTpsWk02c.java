package org.okestro.tps.api.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TbTpsWk02c {
    private String compnCd;      // 콤포넌트코드
    private Integer compnVsrn;      // 콤포넌트버전
    private String mergeTrgtBrnchCd;      // 병합대상브랜치코드
    private String taskAuthrtUseYn;      // 업무권한사용여부
    private String taskAuthrtCd;      // 업무권한코드
    private String prcrId;      // 처리자아이디
    private LocalDateTime regDt;      // 등록일시
    private String rgtrId;      // 등록자아이디
}
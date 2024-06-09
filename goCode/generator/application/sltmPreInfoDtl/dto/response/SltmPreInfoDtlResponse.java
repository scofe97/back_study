package org.okestro.tps.api.application.sltmPreInfoDtl.dto.response;

import lombok.Builder;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk022;

@Builder
public record SltmPreInfoDtlResponse(
        @Schema(description = "콤포넌트일련번호")
        Integer compnSn,
    
        @Schema(description = "단계명")
        String stepNm,
    
        @Schema(description = "업무권한사용여부")
        String taskAuthrtUseYn,
    
        @Schema(description = "업무권한코드")
        String taskAuthrtCd,
    
        @Schema(description = "결재자아이디")
        String aprvrId,
    
        @Schema(description = "결재자관계코드")
        String aprvrRelCd,
    
        @Schema(description = "등록일시")
        LocalDateTime regDt,
    
        @Schema(description = "등록자아이디")
        String rgtrId,
    
        @Schema(description = "수정일시")
        LocalDateTime mdfcnDt,
    
        @Schema(description = "수정자아이디")
        String mdfrId
    
) {
    public static SltmPreInfoDtlResponse from(TbTpsWk022 sltmPreInfoDtl) {
        return SltmPreInfoDtlResponse.builder()
            .compnSn(sltmPreInfoDtl.getCompnSn())
            .stepNm(sltmPreInfoDtl.getStepNm())
            .taskAuthrtUseYn(sltmPreInfoDtl.getTaskAuthrtUseYn())
            .taskAuthrtCd(sltmPreInfoDtl.getTaskAuthrtCd())
            .aprvrId(sltmPreInfoDtl.getAprvrId())
            .aprvrRelCd(sltmPreInfoDtl.getAprvrRelCd())
            .regDt(sltmPreInfoDtl.getRegDt())
            .rgtrId(sltmPreInfoDtl.getRgtrId())
            .mdfcnDt(sltmPreInfoDtl.getMdfcnDt())
            .mdfrId(sltmPreInfoDtl.getMdfrId())
            .build();
    }
}
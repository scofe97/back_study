package org.okestro.tps.api.application.sltmCompnDtl.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsWk022;

import java.time.LocalDateTime;

@Builder
public record SltmCompnDtlResponse(
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
    public static SltmCompnDtlResponse from(TbTpsWk022 sltmCompnDtl) {
        return SltmCompnDtlResponse.builder()
            .compnSn(sltmCompnDtl.getCompnSn())
            .stepNm(sltmCompnDtl.getStepNm())
            .taskAuthrtUseYn(sltmCompnDtl.getTaskAuthrtUseYn())
            .taskAuthrtCd(sltmCompnDtl.getTaskAuthrtCd())
            .aprvrId(sltmCompnDtl.getAprvrId())
            .aprvrRelCd(sltmCompnDtl.getAprvrRelCd())
            .regDt(sltmCompnDtl.getRegDt())
            .rgtrId(sltmCompnDtl.getRgtrId())
            .mdfcnDt(sltmCompnDtl.getMdfcnDt())
            .mdfrId(sltmCompnDtl.getMdfrId())
            .build();
    }
}
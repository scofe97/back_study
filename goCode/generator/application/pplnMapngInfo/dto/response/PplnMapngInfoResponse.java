package org.okestro.tps.api.application.pplnMapngInfo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsCm052;

import java.time.LocalDateTime;

@Builder
public record PplnMapngInfoResponse(
        @Schema(description = "워크플로실행번호")
        String wrkflwExcnNo,
    
        @Schema(description = "워크플로입력번호")
        Integer wrkflwInptNo,
    
        @Schema(description = "파이프라인번호")
        String pplnNo,
    
        @Schema(description = "파이프라인버전")
        Integer pplnVsrn,
    
        @Schema(description = "내외구분")
        String inoutSe,
    
        @Schema(description = "프로젝트번호")
        String bizNo,
    
        @Schema(description = "업무권한사용여부")
        String taskAuthrtUseYn,
    
        @Schema(description = "업무권한코드")
        String taskAuthrtCd,
    
        @Schema(description = "처리자아이디")
        String prcrId,
    
        @Schema(description = "상태코드")
        String sttsCd,
    
        @Schema(description = "등록일시")
        LocalDateTime regDt,
    
        @Schema(description = "등록자아이디")
        String rgtrId,
    
        @Schema(description = "수정일시")
        LocalDateTime mdfcnDt,
    
        @Schema(description = "수정자아이디")
        String mdfrId
    
) {
    public static PplnMapngInfoResponse from(TbTpsCm052 tbTpsCm052) {
        return PplnMapngInfoResponse.builder()
            .wrkflwExcnNo(tbTpsCm052.getWrkflwExcnNo())
            .wrkflwInptNo(tbTpsCm052.getWrkflwInptNo())
            .pplnNo(tbTpsCm052.getPplnNo())
            .pplnVsrn(tbTpsCm052.getPplnVsrn())
            .inoutSe(tbTpsCm052.getInoutSe())
            .bizNo(tbTpsCm052.getBizNo())
            .taskAuthrtUseYn(tbTpsCm052.getTaskAuthrtUseYn())
            .taskAuthrtCd(tbTpsCm052.getTaskAuthrtCd())
            .prcrId(tbTpsCm052.getPrcrId())
            .sttsCd(tbTpsCm052.getSttsCd())
            .regDt(tbTpsCm052.getRegDt())
            .rgtrId(tbTpsCm052.getRgtrId())
            .mdfcnDt(tbTpsCm052.getMdfcnDt())
            .mdfrId(tbTpsCm052.getMdfrId())
            .build();
    }
}
package org.okestro.tps.api.application.pplnMapngInfo.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsCm052;

import java.time.LocalDateTime;

public record PplnMapngInfoUpdateRequest(
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
        
) {
    public TbTpsCm052 toModel(String userId) {
        return TbTpsCm052.builder()
                .wrkflwExcnNo(this.wrkflwExcnNo)
                .wrkflwInptNo(this.wrkflwInptNo)
                .pplnNo(this.pplnNo)
                .pplnVsrn(this.pplnVsrn)
                .inoutSe(this.inoutSe)
                .bizNo(this.bizNo)
                .taskAuthrtUseYn(this.taskAuthrtUseYn)
                .taskAuthrtCd(this.taskAuthrtCd)
                .prcrId(this.prcrId)
                .sttsCd(this.sttsCd)
                .mdfrId(userId)
                .build();
    }
}
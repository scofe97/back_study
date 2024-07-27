package org.okestro.tps.api.application.pplnMapngInfo.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.okestro.tps.api.infrastructure.persistence.model.TbTpsCm052;

@Builder
public record PplnMapngInfoSelectRequest(
        @Schema(description = "워크플로실행번호")
        @NotBlank(message = "{field.notBlank}")
        String wrkflwExcnNo,
        
        @Schema(description = "워크플로입력번호")
        @NotBlank(message = "{field.notBlank}")
        Integer wrkflwInptNo
        
) {
    public static PplnMapngInfoSelectRequest from(
        String wrkflwExcnNo,
        Integer wrkflwInptNo
    ) {
        return PplnMapngInfoSelectRequest.builder()
                .wrkflwExcnNo(wrkflwExcnNo)
                .wrkflwInptNo(wrkflwInptNo)
                .build();
    }

    public TbTpsCm052 toModel() {
        return TbTpsCm052.builder()
                .wrkflwExcnNo(this.wrkflwExcnNo)
                .wrkflwInptNo(this.wrkflwInptNo)
                .build();
    }
}

package lv.proofit.insurance.premiums.helper.domain;

import lombok.*;
import lv.proofit.insurance.premiums.helper.enums.RiskType;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Generated
public class PolicySubObject {
    private String title;
    private BigDecimal cost;
    private RiskType risk;
}

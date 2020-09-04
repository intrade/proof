package lv.proofit.insurance.premiums.helper.domain;

import lombok.*;
import lv.proofit.insurance.premiums.helper.enums.PolicyStatus;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Generated
public class Policy {
    private String number;
    private PolicyStatus status;
    private Collection<PolicyObject> policyObjects;
}

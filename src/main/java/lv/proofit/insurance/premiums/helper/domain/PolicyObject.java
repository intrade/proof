package lv.proofit.insurance.premiums.helper.domain;

import lombok.*;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Generated
public class PolicyObject {
    private String title;
    private Collection<PolicySubObject> policySubObjects;
}

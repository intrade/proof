package lv.proofit.insurance.premiums;

import lv.proofit.insurance.premiums.helper.domain.Policy;
import lv.proofit.insurance.premiums.helper.domain.PolicyObject;
import lv.proofit.insurance.premiums.helper.domain.PolicySubObject;
import lv.proofit.insurance.premiums.helper.enums.RiskType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class DefaultPremiumCalculatorTest {
    private DefaultPremiumCalculator premiumCalculator = new DefaultPremiumCalculator();

    @Test
    public void premiumCalculationTest(){
        assertThat(premiumCalculator.calculate(createPolicyNormal()).doubleValue()).isEqualTo(2.28);
    }

    @Test
    public void testCalOnBorderValue(){
        assertThat(premiumCalculator.calculate(createPolicyBorder()).doubleValue()).isEqualTo(2.15);
    }

    @Test
    public void testCalOnBorder2Value(){
        assertThat(premiumCalculator.calculate(createPolicyBorderPlusOne()).doubleValue()).isEqualTo(3.15);
    }

    @Test
    public void testCalOnHiValue(){
        assertThat(premiumCalculator.calculate(createPolicyHi()).doubleValue()).isEqualTo(17.13);
    }

    private Collection<PolicyObject> policyObjectsNormal(){
        List<PolicyObject> policyObjects = new ArrayList<>();
        PolicyObject po1 = PolicyObject.builder()
                .title("House")
                .policySubObjects(subObjectsNormal())
                .build();
        policyObjects.add(po1);
        return policyObjects;
    }
    private Collection<PolicyObject> policyObjectsBorder(){
        List<PolicyObject> policyObjects = new ArrayList<>();
        PolicyObject po1 = PolicyObject.builder()
                .title("House")
                .policySubObjects(subObjectsBorder())
                .build();
        policyObjects.add(po1);
        return policyObjects;
    }
    private Collection<PolicyObject> policyObjectsBorderPlusOne(){
        List<PolicyObject> policyObjects = new ArrayList<>();
        PolicyObject po1 = PolicyObject.builder()
                .title("House")
                .policySubObjects(subObjectsBorderPlusOne())
                .build();
        policyObjects.add(po1);
        return policyObjects;
    }
    private Collection<PolicyObject> policyObjectsHi(){
        List<PolicyObject> policyObjects = new ArrayList<>();
        PolicyObject po1 = PolicyObject.builder()
                .title("House")
                .policySubObjects(subObjectsHi())
                .build();
        policyObjects.add(po1);
        return policyObjects;
    }

    private Collection<PolicySubObject> subObjectsNormal() {
        List<PolicySubObject> subObjects = new ArrayList<>();
        PolicySubObject ps1 = PolicySubObject.builder()
                .title("TV")
                .risk(RiskType.FIRE)
                .cost(BigDecimal.valueOf(33.33))
                .build();
        PolicySubObject ps2 = PolicySubObject.builder()
                .title("TV")
                .risk(RiskType.FIRE)
                .cost(BigDecimal.valueOf(26.70))
                .build();
        PolicySubObject ps3 = PolicySubObject.builder()
                .title("TV")
                .risk(RiskType.FIRE)
                .cost(BigDecimal.valueOf(39.97))
                .build();
        PolicySubObject ps4 = PolicySubObject.builder()
                .title("PC")
                .risk(RiskType.THEFT)
                .cost(BigDecimal.valueOf(8.00))
                .build();
        subObjects.add(ps1);
        subObjects.add(ps2);
        subObjects.add(ps3);
        subObjects.add(ps4);
        return subObjects;
    }
    private Collection<PolicySubObject> subObjectsBorder() {
        List<PolicySubObject> subObjects = new ArrayList<>();
        PolicySubObject ps1 = PolicySubObject.builder()
                .title("TV")
                .risk(RiskType.FIRE)
                .cost(BigDecimal.valueOf(100.00))
                .build();
        PolicySubObject ps2 = PolicySubObject.builder()
                .title("PC")
                .risk(RiskType.THEFT)
                .cost(BigDecimal.valueOf(15.00))
                .build();
        subObjects.add(ps1);
        subObjects.add(ps2);
        return subObjects;
    }
    private Collection<PolicySubObject> subObjectsBorderPlusOne() {
        List<PolicySubObject> subObjects = new ArrayList<>();
        PolicySubObject ps1 = PolicySubObject.builder()
                .title("TV")
                .risk(RiskType.FIRE)
                .cost(BigDecimal.valueOf(100.01))
                .build();
        PolicySubObject ps2 = PolicySubObject.builder()
                .title("PC")
                .risk(RiskType.THEFT)
                .cost(BigDecimal.valueOf(15.00))
                .build();
        subObjects.add(ps1);
        subObjects.add(ps2);
        return subObjects;
    }
    private Collection<PolicySubObject> subObjectsHi() {
        List<PolicySubObject> subObjects = new ArrayList<>();
        PolicySubObject ps1 = PolicySubObject.builder()
                .title("TV")
                .risk(RiskType.FIRE)
                .cost(BigDecimal.valueOf(100.0))
                .build();
        PolicySubObject ps2 = PolicySubObject.builder()
                .title("TV")
                .risk(RiskType.FIRE)
                .cost(BigDecimal.valueOf(250.0))
                .build();
        PolicySubObject ps3 = PolicySubObject.builder()
                .title("TV")
                .risk(RiskType.FIRE)
                .cost(BigDecimal.valueOf(150.0))
                .build();
        PolicySubObject ps4 = PolicySubObject.builder()
                .title("PC")
                .risk(RiskType.THEFT)
                .cost(BigDecimal.valueOf(102.51))
                .build();
        subObjects.add(ps1);
        subObjects.add(ps2);
        subObjects.add(ps3);
        subObjects.add(ps4);
        return subObjects;
    }

    private Policy createPolicyNormal(){
        return Policy.builder()
                .number("AA11")
                .policyObjects(policyObjectsNormal())
                .build();
    }
    private Policy createPolicyBorder() {
        return Policy.builder()
                .number("AA11")
                .policyObjects(policyObjectsBorder())
                .build();
    }
    private Policy createPolicyBorderPlusOne() {
        return Policy.builder()
                .number("AA11")
                .policyObjects(policyObjectsBorderPlusOne())
                .build();
    }
    private Policy createPolicyHi(){
        return Policy.builder()
                .number("AA11")
                .policyObjects(policyObjectsHi())
                .build();
    }

}
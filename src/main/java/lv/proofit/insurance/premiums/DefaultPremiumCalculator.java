package lv.proofit.insurance.premiums;

import lv.proofit.insurance.premiums.helper.domain.Policy;
import lv.proofit.insurance.premiums.helper.domain.PolicySubObject;
import lv.proofit.insurance.premiums.helper.enums.RiskType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class DefaultPremiumCalculator implements PremiumCalculator {
    private Properties props;

    public DefaultPremiumCalculator() {
        this.props = new Properties();
        props.put("fire", 0.014);
        props.put("fireExt", 0.024);
        props.put("theft", 0.11);
        props.put("theftExt", 0.05);
    }

    @Override
    public BigDecimal calculate(Policy policy) {
        BigDecimal fireSum, theftSum;

        List<PolicySubObject> fireObjects = new LinkedList<>();
        List<PolicySubObject> theftObjects = new LinkedList<>();

        policy.getPolicyObjects()
                .stream()
                .map(o -> o.getPolicySubObjects())
                .forEach(so -> so.stream()
                        .forEach(s -> {
                            if (s.getRisk().equals(RiskType.FIRE)) {
                                fireObjects.add(s);
                            } else {
                                theftObjects.add(s);
                            }
                        }));
        fireSum = fireObjects.stream().map(so -> so.getCost()).reduce(BigDecimal::add).get();
        theftSum = theftObjects.stream().map(so -> so.getCost()).reduce(BigDecimal::add).get();

        return applyCoeficient(fireSum, theftSum);
    }

    private BigDecimal applyCoeficient(BigDecimal fireSum, BigDecimal theftSum) {
        BigDecimal result;
        double coeficient;
        if (fireSum.compareTo(BigDecimal.valueOf(100.00))>0){
            coeficient = (Double) props.get("fireExt");
        } else {
            coeficient = (Double) props.get("fire");
        }
        result = fireSum.multiply(BigDecimal.valueOf(coeficient));
        if (theftSum.compareTo(BigDecimal.valueOf(15.00))>=0){
            coeficient = (Double) props.get("theftExt");
        } else {
            coeficient = (Double) props.get("theft");
        }
        return result.add(theftSum.multiply(BigDecimal.valueOf(coeficient))).setScale(2, RoundingMode.HALF_UP);
    }

}

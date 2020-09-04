package lv.proofit.insurance.premiums;

import lv.proofit.insurance.premiums.helper.domain.Policy;

import java.math.BigDecimal;

public interface PremiumCalculator {
    BigDecimal calculate(Policy policy);
}

package tv.codely.checkout;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tv.codely.checkout.TieredPricing.*;

public class TieredPricingShould {

    @Test
	void calculate_total_value_for_first_pricing_range() {
        var pricing = new TieredPricing();
        var subscription = IntStream.rangeClosed(FIRST_RANGE_LOWER_LIMIT, FIRST_RANGE_UPPER_LIMIT).findAny().getAsInt();
        assertEquals(FIRST_RANGE_UNIT_PRICE * subscription, pricing.calculateTotalPrice(subscription));
	}

    @Test
    void calculate_total_value_for_3_subscription() {
        var pricing = new TieredPricing();
        assertEquals(717, pricing.calculateTotalPrice(3));
    }

    @Test
    void calculate_total_value_for_4_subscription() {
        var pricing = new TieredPricing();
        assertEquals(956, pricing.calculateTotalPrice(4));
    }
}

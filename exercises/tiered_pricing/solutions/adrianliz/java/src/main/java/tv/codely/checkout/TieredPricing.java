package tv.codely.checkout;

import java.util.List;

public class TieredPricing {

    private final List<SubscriptionTier> subscriptionTiers;

    public TieredPricing(final SubscriptionTiers subscriptionTiers) {
        this.subscriptionTiers = subscriptionTiers.tiers();
    }

    public TieredPricing(final List<SubscriptionTier> subscriptionTiers) {
        this(new SubscriptionTiers(subscriptionTiers));
    }

    public double getTotalPrice(int subscriptions) {
        return subscriptionTiers.stream()
            .filter(subscriptionTier -> subscriptionTier.isInRange(subscriptions))
            .findFirst()
            .map(subscriptionTier -> subscriptionTier.getTotalPrice(subscriptions))
            .orElse(0D);
    }

    public double getBasePrice(int subscriptions) {
        return subscriptionTiers.stream()
            .filter(subscriptionTier -> subscriptionTier.isInRange(subscriptions))
            .findFirst()
            .map(SubscriptionTier::unitPrice)
            .orElse(0D);
    }
}

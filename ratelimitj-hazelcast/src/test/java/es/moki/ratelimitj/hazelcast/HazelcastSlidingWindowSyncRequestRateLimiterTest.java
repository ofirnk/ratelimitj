package es.moki.ratelimitj.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import es.moki.ratelimitj.core.limiter.request.RequestLimitRule;
import es.moki.ratelimitj.core.limiter.request.RequestRateLimiter;
import es.moki.ratelimitj.core.time.TimeSupplier;
import es.moki.ratelimitj.test.limiter.request.AbstractSyncRequestRateLimiterTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;


public class HazelcastSlidingWindowSyncRequestRateLimiterTest extends AbstractSyncRequestRateLimiterTest {

    private static HazelcastInstance hz;

    @BeforeAll
    public static void before() {
        hz = Hazelcast.newHazelcastInstance();
    }

    @AfterAll
    public static void after() {
        hz.shutdown();
    }

    @Override
    protected RequestRateLimiter getRateLimiter(Set<RequestLimitRule> rules, TimeSupplier timeSupplier) {
        return new HazelcastSlidingWindowRequestRateLimiter(hz, rules, timeSupplier);
    }

    @Override
    @Test
    @Disabled
    public void shouldResetLimit() {

    }

}

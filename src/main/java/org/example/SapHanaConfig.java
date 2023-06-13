package org.example;

import io.airlift.configuration.Config;
import io.airlift.units.Duration;
import io.airlift.units.MaxDuration;
import io.airlift.units.MinDuration;

import javax.validation.constraints.NotNull;
import java.util.concurrent.TimeUnit;

public class SapHanaConfig {
    private Duration timeout = Duration.succinctDuration(10, TimeUnit.SECONDS);

    @NotNull
    @MaxDuration("10m")
    @MinDuration("1ms")
    public Duration getTimeout()
    {
        return timeout;
    }

    @Config("timeout")
    public SapHanaConfig setTimeout(Duration timeout)
    {
        this.timeout = timeout;
        return this;
    }
}

package com.redlimerl.sleepbackground.config;

import org.mcsr.speedrunapi.config.api.SpeedrunConfigStorage;
import org.mcsr.speedrunapi.config.api.annotations.Config;

@SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
public abstract class ConfigValue implements SpeedrunConfigStorage {

    @Config.Name("sleepbackground.config.enable")
    private boolean enabled = true;

    public final boolean isEnabled() {
        return this.enabled;
    }
}

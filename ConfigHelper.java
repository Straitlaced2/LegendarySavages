package straitlaced.legendarysavages.server.config;

import net.minecraftforge.fml.config.ModConfig;

/**
 * This bakes the config values to normal fields
 *
 * @author Cadiboo
 * It can be merged into the main LegendarySavagesConfig class, but is separate because of personal preference and to keep the code organised
 */

public class ConfigHelper {

    // We store a reference to the ModConfigs here to be able to change the values in them from our code
    // (For example from a config GUI)
    private static ModConfig clientConfig;
    private static ModConfig serverConfig;

    public static void bakeClient(final ModConfig config) {
        clientConfig = config;

        LegendarySavagesConfig.clientBoolean = ConfigHolder.CLIENT.clientBoolean.get();
        LegendarySavagesConfig.clientStringList = ConfigHolder.CLIENT.clientStringList.get();
        LegendarySavagesConfig.clientDyeColorEnum = ConfigHolder.CLIENT.clientDyeColorEnum.get();

        LegendarySavagesConfig.modelTranslucency = ConfigHolder.CLIENT.modelTranslucency.get();
        LegendarySavagesConfig.modelScale = ConfigHolder.CLIENT.modelScale.get();

    }

    public static void bakeServer(final ModConfig config) {
        serverConfig = config;

        LegendarySavagesConfig.serverBoolean = ConfigHolder.SERVER.serverBoolean.get();
        LegendarySavagesConfig.serverStringList = ConfigHolder.SERVER.serverStringList.get();
        LegendarySavagesConfig.serverEnumDyeColor = ConfigHolder.SERVER.serverEnumDyeColor.get();

        LegendarySavagesConfig.electricFurnaceEnergySmeltCostPerTick = ConfigHolder.SERVER.electricFurnaceEnergySmeltCostPerTick.get();
        LegendarySavagesConfig.heatCollectorTransferAmountPerTick = ConfigHolder.SERVER.heatCollectorTransferAmountPerTick.get();
    }

    /**
     * Helper method to set a value on a config and then save the config.
     *
     * @param modConfig The ModConfig to change and save
     * @param path      The name/path of the config entry
     * @param newValue  The new value of the config entry
     */
    public static void setValueAndSave(final ModConfig modConfig, final String path, final Object newValue) {
        modConfig.getConfigData().set(path, newValue);
        modConfig.save();
    }
}

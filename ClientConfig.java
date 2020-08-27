package straitlaced.legendarysavages.server.config;

import straitlaced.legendarysavages.LegendarySavages;
import net.minecraft.item.DyeColor;
import net.minecraftforge.common.ForgeConfigSpec;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ClientConfig {

    final ForgeConfigSpec.BooleanValue clientBoolean;
    final ForgeConfigSpec.ConfigValue<List<String>> clientStringList;
    final ForgeConfigSpec.EnumValue<DyeColor> clientDyeColorEnum;

    final ForgeConfigSpec.BooleanValue modelTranslucency;
    final ForgeConfigSpec.DoubleValue modelScale;

    final ForgeConfigSpec.BooleanValue clientReceiveRendezvousMessages;



    ClientConfig(@Nonnull final ForgeConfigSpec.Builder builder) {
        builder.push("general");
        clientBoolean = builder
                .comment("An example boolean in the client config")
                .translation(LegendarySavages.MODID + ".config.clientBoolean")
                .define("clientBoolean", true);
        clientStringList = builder
                .comment("An example list of Strings in the client config")
                .translation(LegendarySavages.MODID + ".config.clientStringList")
                .define("clientStringList", new ArrayList<>());
        clientDyeColorEnum = builder
                .comment("An example DyeColor enum in the client config")
                .translation(LegendarySavages.MODID + ".config.clientDyeColorEnum")
                .defineEnum("clientDyeColorEnum", DyeColor.WHITE);

        modelTranslucency = builder
                .comment("If the model should be rendered translucent")
                .translation(LegendarySavages.MODID + ".config.modelTranslucency")
                .define("modelTranslucency", true);
        modelScale = builder
                .comment("The scale to render the model at")
                .translation(LegendarySavages.MODID + ".config.modelScale")
                .defineInRange("modelScale", 0.0625, 0.0001, 100);
        clientReceiveRendezvousMessages = builder
                .comment("Receive rendezvous messages")
                .define("clientReceiveRendezvousMessages", true);
        builder.pop();
    }
}

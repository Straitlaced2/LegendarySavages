package straitlaced.legendarysavages;

import straitlaced.legendarysavages.client.renders.ModRenderRegistry;

import straitlaced.legendarysavages.server.advancements.criterion.*;
import straitlaced.legendarysavages.server.config.ConfigHolder;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LegendarySavages.MODID)
public class LegendarySavages
{
    // Directly reference a log4j logger.
    public static LegendarySavages instance;

    public static final String MODID = "legendarysavages";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    //public static final IProxy PROXY = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public LegendarySavages() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener((FMLCommonSetupEvent event) -> {
            ModTriggers.TAME_LEGEND_AHRI = (TameLegendAhriTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendAhriTrigger());
            ModTriggers.TAME_LEGEND_AKALI = (TameLegendAkaliTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendAkaliTrigger());
            ModTriggers.TAME_LEGEND_AMUMU = (TameLegendAmumuTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendAmumuTrigger());
            ModTriggers.TAME_LEGEND_ANIVIA = (TameLegendAniviaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendAniviaTrigger());
            ModTriggers.TAME_LEGEND_ANNIE = (TameLegendAnnieTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendAnnieTrigger());
            ModTriggers.TAME_LEGEND_ASHE = (TameLegendAsheTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendAsheTrigger());
            ModTriggers.TAME_LEGEND_AYUREX = (TameLegendAyurexTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendAyurexTrigger());
            ModTriggers.TAME_LEGEND_CAITLYN = (TameLegendCaitlynTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendCaitlynTrigger());
            ModTriggers.TAME_LEGEND_CAMILLE = (TameLegendCamilleTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendCamilleTrigger());
            ModTriggers.TAME_LEGEND_CASSIOPEIA = (TameLegendCassiopeiaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendCassiopeiaTrigger());
            ModTriggers.TAME_LEGEND_DIANA = (TameLegendDianaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendDianaTrigger());
            ModTriggers.TAME_LEGEND_ELISE = (TameLegendEliseTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendEliseTrigger());
            ModTriggers.TAME_LEGEND_EVELYNN = (TameLegendEvelynnTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendEvelynnTrigger());
            ModTriggers.TAME_LEGEND_FIORA = (TameLegendFioraTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendFioraTrigger());
            ModTriggers.TAME_LEGEND_FIZZ = (TameLegendFizzTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendFizzTrigger());
            ModTriggers.TAME_LEGEND_GNAR = (TameLegendGnarTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendGnarTrigger());
            ModTriggers.TAME_LEGEND_ILLAOI = (TameLegendIllaoiTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendIllaoiTrigger());
            ModTriggers.TAME_LEGEND_JANNA = (TameLegendJannaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendJannaTrigger());
            ModTriggers.TAME_LEGEND_JINX = (TameLegendJinxTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendJinxTrigger());
            ModTriggers.TAME_LEGEND_KAI_SA = (TameLegendKaiSaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendKaiSaTrigger());
            ModTriggers.TAME_LEGEND_KARMA = (TameLegendKarmaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendKarmaTrigger());
            ModTriggers.TAME_LEGEND_KATARINA = (TameLegendKatarinaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendKatarinaTrigger());
            ModTriggers.TAME_LEGEND_KINDRED = (TameLegendKindredTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendKindredTrigger());
            ModTriggers.TAME_LEGEND_LE_BLANC = (TameLegendLeBlancTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendLeBlancTrigger());
            ModTriggers.TAME_LEGEND_LEONA = (TameLegendLeonaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendLeonaTrigger());
            ModTriggers.TAME_LEGEND_LISSANDRA = (TameLegendLissandraTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendLissandraTrigger());
            ModTriggers.TAME_LEGEND_LULU = (TameLegendLuluTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendLuluTrigger());
            ModTriggers.TAME_LEGEND_LUX = (TameLegendLuxTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendLuxTrigger());
            ModTriggers.TAME_LEGEND_MISS_FORTUNE = (TameLegendMissFortuneTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendMissFortuneTrigger());
            ModTriggers.TAME_LEGEND_MORGANA = (TameLegendMorganaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendMorganaTrigger());
            ModTriggers.TAME_LEGEND_NEEKO = (TameLegendNeekoTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendNeekoTrigger());
            ModTriggers.TAME_LEGEND_NIDALEE = (TameLegendNidaleeTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendNidaleeTrigger());
            ModTriggers.TAME_LEGEND_ORIANNA = (TameLegendOriannaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendOriannaTrigger());
            ModTriggers.TAME_LEGEND_POPPY = (TameLegendPoppyTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendPoppyTrigger());
            ModTriggers.TAME_LEGEND_QIYANA = (TameLegendQiyanaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendQiyanaTrigger());
            ModTriggers.TAME_LEGEND_QUINN = (TameLegendQuinnTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendQuinnTrigger());
            ModTriggers.TAME_LEGEND_RAMMUS = (TameLegendRammusTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendRammusTrigger());
            ModTriggers.TAME_LEGEND_RIVEN = (TameLegendRivenTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendRivenTrigger());
            ModTriggers.TAME_LEGEND_SEJUANI = (TameLegendSejuaniTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendSejuaniTrigger());
            ModTriggers.TAME_LEGEND_SHYVANA = (TameLegendShyvanaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendShyvanaTrigger());
            ModTriggers.TAME_LEGEND_SIVIR = (TameLegendSivirTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendSivirTrigger());
            ModTriggers.TAME_LEGEND_SONA = (TameLegendSonaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendSonaTrigger());
            ModTriggers.TAME_LEGEND_SORAKA= (TameLegendSorakaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendSorakaTrigger());
            ModTriggers.TAME_LEGEND_SYNDRA = (TameLegendSyndraTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendSyndraTrigger());
            ModTriggers.TAME_LEGEND_TALIYAH = (TameLegendTaliyahTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendTaliyahTrigger());
            ModTriggers.TAME_LEGEND_TEEMO = (TameLegendTeemoTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendTeemoTrigger());
            ModTriggers.TAME_LEGEND_TRISTANA = (TameLegendTristanaTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendTristanaTrigger());
            ModTriggers.TAME_LEGEND_VAYNE = (TameLegendVayneTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendVayneTrigger());
            ModTriggers.TAME_LEGEND_VI = (TameLegendViTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendViTrigger());
            ModTriggers.TAME_LEGEND_XAYAH = (TameLegendXayahTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendXayahTrigger());
            ModTriggers.TAME_LEGEND_YUUMI = (TameLegendYuumiTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendYuumiTrigger());
            ModTriggers.TAME_LEGEND_ZAC = (TameLegendZacTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendZacTrigger());
            ModTriggers.TAME_LEGEND_ZOE = (TameLegendZoeTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendZoeTrigger());
            ModTriggers.TAME_LEGEND_ZYRA = (TameLegendZyraTrigger) ModEventSubscriber.registerAdvancementTrigger(new TameLegendZyraTrigger());


            //Feature.register("ore", new OreFeature(OreFeatureConfig::deserialize));
            //ModFeatures.hardOre = (Registry.<Feature<?>>register(Registry.FEATURE, "hardore", new HardOreFeature(OreFeatureConfig::deserialize, BlockProperties.ORE_DENSITY)));
        });


        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        // Register Configs
        modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, ConfigHolder.SERVER_SPEC);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        //Method method = ReflectionHelper.findMethod(CriteriaTriggers.class, "register", "func_192118_a", ICriterionTrigger.class);



        //Create biome features here, call it in FMLCommonSetupEvent, but use DeferredWorkQueue, since biome features are not thread safe.
        //SnowyTundraBiome.createDecoratedFeature()
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        // register entity models here
        ModRenderRegistry.registryEntityRenderers();
        LOGGER.info("clientRegisteries method registered.");

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("legendarysavages", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    /*

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {



        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }






    }
*/

}


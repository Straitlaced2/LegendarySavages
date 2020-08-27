package straitlaced.legendarysavages;

import com.google.common.base.Preconditions;
import net.minecraft.entity.EntityClassification;
import net.minecraftforge.eventbus.api.EventPriority;
import straitlaced.legendarysavages.client.sound.LSSoundRegistry;
import straitlaced.legendarysavages.server.config.ConfigHelper;
import straitlaced.legendarysavages.server.config.ConfigHolder;
import straitlaced.legendarysavages.server.entity.monster.EntityDeadKingPoro;
import straitlaced.legendarysavages.server.init.ModBlocks;
import straitlaced.legendarysavages.server.init.ModEntities;
import straitlaced.legendarysavages.server.init.ModItemGroups;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static straitlaced.legendarysavages.LegendarySavages.MODID;
import static straitlaced.legendarysavages.client.sound.LSSoundRegistry.*;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

    private static final Logger LOGGER = LogManager.getLogger(MODID + " Mod Event Subscriber");
    private static final List<IForgeRegistryEntry<?>> otherItems = new ArrayList<IForgeRegistryEntry<?>>();
    private static Method CriterionRegister;


    @SuppressWarnings("unchecked")
    public static <T extends ICriterionInstance> ICriterionTrigger<T> registerAdvancementTrigger(ICriterionTrigger<T> trigger) {
        if(CriterionRegister == null) {
            CriterionRegister = ObfuscationReflectionHelper.findMethod(CriteriaTriggers.class, "register", ICriterionTrigger.class);
            CriterionRegister.setAccessible(true);
        }
        try {
            trigger = (ICriterionTrigger<T>) CriterionRegister.invoke(null, trigger);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            System.out.println("Failed to register trigger " + trigger.getId() + "!");
            e.printStackTrace();
        }
        return trigger;
    }

    public static <K extends IForgeRegistryEntry<K>> void registerOther(K object, ResourceLocation registryname) {
        otherItems.add(object.setRegistryName(registryname));
    }

    @SubscribeEvent
    public static void registerFeature(@Nonnull final RegistryEvent.Register<Feature<?>> event) {
        for(IForgeRegistryEntry<?> e : otherItems) {
            if(e instanceof Feature<?>)
                event.getRegistry().register((Feature<?>)e);
        }
    }

    @SubscribeEvent
    public static void onRegisterItems(@Nonnull RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        event.getRegistry().registerAll( // do not register spawn eggs here
                setup(new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)), "example_item")
        );

        // Automatically register BlockItems for all our Blocks
        // (We need to go over the entire registry so that we include any potential Registry Overrides)
        ForgeRegistries.BLOCKS.getValues().stream()
                // Filter out blocks that aren't from our mod
                .filter(block -> Objects.requireNonNull(block.getRegistryName()).getNamespace().equals(MODID))
                // You can do extra filtering here if you don't want some blocks to have an BlockItem automatically registered for them
                // Register the BlockItem for the block
                .forEach(block -> {
                    // Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
                    final Item.Properties properties = new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP);
                    // Create the new BlockItem with the block and it's properties
                    final BlockItem blockItem = new BlockItem(block, properties);
                    // Setup the new BlockItem with the block's registry name and register it
                    registry.register(setup(blockItem, block.getRegistryName()));
                });
        LOGGER.debug("Registered Items");

        ModEntities.registerEntitySpawnEggs(event);
    }



    @SubscribeEvent
    public static void onRegisterBlocks(@Nonnull RegistryEvent.Register<Block> event) {

        event.getRegistry().registerAll(
                //setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)), "example_ore")
                // Register all your blocks inside this registerAll call
                //ModBlocks.ORE_NICKEL = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 5.6f).sound(SoundType.STONE).harvestLevel(2)).setRegistryName(location("ore_nickel"))
                setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 5.6F).sound(SoundType.STONE).harvestLevel(2)), "ore_nickel")
        );


        /*
        event.getRegistry().registerAll(
                // This block has the ROCK material, meaning it needs at least a wooden pickaxe to break it. It is very similar to Iron Ore
                //setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)), "example_ore"),
                // This block has the IRON material, meaning it needs at least a stone pickaxe to break it. It is very similar to the Iron Block
                //setup(new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)), "example_block")
                /*
                // This block has the MISCELLANEOUS material. It is very similar to the Redstone Torch
                setup(new MiniModelBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(1.5F).lightValue(13).doesNotBlockMovement()), "mini_model"),
                // This block has the ROCK material, meaning it needs at least a wooden pickaxe to break it. It is very similar to the Furnace
                setup(new HeatCollectorBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5F).lightValue(13)), "heat_collector"),
                setup(new ElectricFurnaceBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5F)), "electric_furnace"),
                setup(new ModFurnaceBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5F).lightValue(13)), "mod_furnace")


        );
 */
        LOGGER.debug("Registered Blocks");

    }

    /**
     * This method will be called by Forge when it is time for the mod to register its TileEntityType.
     * This method will always be called after the Block and Item registry methods.
     */
    @SubscribeEvent
    public static void onRegisterTileEntityTypes(@Nonnull final RegistryEvent.Register<TileEntityType<?>> event) {
        // Register your TileEntityTypes here if you have them
        event.getRegistry().registerAll(
                // We don't have a datafixer for our TileEntity, so we pass null into build
                /*
                setup(TileEntityType.Builder.create(MiniModelTileEntity::new, ModBlocks.MINI_MODEL).build(null), "mini_model"),
                setup(TileEntityType.Builder.create(HeatCollectorTileEntity::new, ModBlocks.HEAT_COLLECTOR).build(null), "heat_collector"),
                setup(TileEntityType.Builder.create(ElectricFurnaceTileEntity::new, ModBlocks.ELECTRIC_FURNACE).build(null), "electric_furnace"),
                setup(TileEntityType.Builder.create(ModFurnaceTileEntity::new, ModBlocks.MOD_FURNACE).build(null), "mod_furnace")

                 */
        );
        LOGGER.debug("Registered TileEntityTypes");
    }

    /**
     * This method will be called by Forge when it is time for the mod to register its ContainerTypes.
     * This method will always be called after the Block and Item registry methods.
     */
    @SubscribeEvent
    public static void onRegisterContainerTypes(@Nonnull final RegistryEvent.Register<ContainerType<?>> event) {
        // Register your ContainerTypes here if you have them
        event.getRegistry().registerAll(
                /*
                setup(IForgeContainerType.create(HeatCollectorContainer::new), "heat_collector"),
                setup(IForgeContainerType.create(ElectricFurnaceContainer::new), "electric_furnace"),
                setup(IForgeContainerType.create(ModFurnaceContainer::new), "mod_furnace")

                 */
        );
        LOGGER.debug("Registered ContainerTypes");
    }

    @SubscribeEvent
    public static void onRegisterEntityEntry(@Nonnull final RegistryEvent.Register<EntityType<?>> event) {


        event.getRegistry().registerAll(

                ModEntities.CHAMPION_AATROX,
                ModEntities.CHAMPION_ALISTAR,
                ModEntities.CHAMPION_APHELIOS,
                ModEntities.CHAMPION_AURELION_SOL,
                ModEntities.CHAMPION_AZIR,
                ModEntities.CHAMPION_BARD,
                ModEntities.CHAMPION_BLITZCRANK,
                ModEntities.CHAMPION_BRAUM,
                ModEntities.CHAMPION_CHO_GATH,
                ModEntities.CHAMPION_CORKI,
                ModEntities.CHAMPION_CYRO_BRAND,
                ModEntities.CHAMPION_DARIUS,
                ModEntities.CHAMPION_DRAVEN,
                ModEntities.CHAMPION_DR_MUNDO,
                ModEntities.CHAMPION_EKKO,
                ModEntities.CHAMPION_EZREAL,
                ModEntities.CHAMPION_FIDDLESTICKS,
                ModEntities.CHAMPION_GALIO,
                ModEntities.CHAMPION_GANGPLANK,
                ModEntities.CHAMPION_GAREN,
                ModEntities.CHAMPION_GRAGAS,
                ModEntities.CHAMPION_GRAVES,
                ModEntities.CHAMPION_HECARIM,
                ModEntities.CHAMPION_HEIMERDINGER,
                ModEntities.CHAMPION_IVERN,
                ModEntities.CHAMPION_JARVAN_IV,
                ModEntities.CHAMPION_JAX,
                ModEntities.CHAMPION_JAYCE,
                ModEntities.CHAMPION_JHIN,
                ModEntities.CHAMPION_KALISTA,
                ModEntities.CHAMPION_KARTHUS,
                ModEntities.CHAMPION_KASSADIN,
                ModEntities.CHAMPION_KAYN,
                ModEntities.CHAMPION_KENNEN,
                ModEntities.CHAMPION_KHA_ZIX,
                ModEntities.CHAMPION_KLED,
                ModEntities.CHAMPION_KOG_MAW,
                ModEntities.CHAMPION_LEE_SIN,
                ModEntities.CHAMPION_LUCIAN,
                ModEntities.CHAMPION_MALPHITE,
                ModEntities.CHAMPION_MALZAHAR,
                ModEntities.CHAMPION_MAOKAI,
                ModEntities.CHAMPION_MASTER_YI,
                ModEntities.CHAMPION_MORDEKAISER,
                ModEntities.CHAMPION_NASUS,
                ModEntities.CHAMPION_NAUTILUS,
                ModEntities.CHAMPION_NOCTURNE,
                ModEntities.CHAMPION_NUNU,
                ModEntities.CHAMPION_OLAF,
                ModEntities.CHAMPION_ORNN,
                ModEntities.CHAMPION_PANTHEON,
                ModEntities.CHAMPION_PYKE,
                ModEntities.CHAMPION_RAKAN,
                ModEntities.CHAMPION_REK_SAI,
                ModEntities.CHAMPION_RENEKTON,
                ModEntities.CHAMPION_RENGAR,
                ModEntities.CHAMPION_RUMBLE,
                ModEntities.CHAMPION_RYZE,
                ModEntities.CHAMPION_SETT,
                ModEntities.CHAMPION_SHACO,
                ModEntities.CHAMPION_SHEN,
                ModEntities.CHAMPION_SINGED,
                ModEntities.CHAMPION_SION,
                ModEntities.CHAMPION_SKARNER,
                ModEntities.CHAMPION_SWAIN,
                ModEntities.CHAMPION_SYLAS,
                ModEntities.CHAMPION_TAHM_KENCH,
                ModEntities.CHAMPION_TALON,
                ModEntities.CHAMPION_TARIC,
                ModEntities.CHAMPION_THRESH,
                ModEntities.CHAMPION_TRUNDLE,
                ModEntities.CHAMPION_TRYNDAMERE,
                ModEntities.CHAMPION_TWISTED_FATE,
                ModEntities.CHAMPION_TWITCH,
                ModEntities.CHAMPION_UDYR,
                ModEntities.CHAMPION_URGOT,
                ModEntities.CHAMPION_VARUS,
                ModEntities.CHAMPION_VEIGAR,
                ModEntities.CHAMPION_VEL_KOZ,
                ModEntities.CHAMPION_VIKTOR,
                ModEntities.CHAMPION_VLADIMIR,
                ModEntities.CHAMPION_VOLIBEAR,
                ModEntities.CHAMPION_WARWICK,
                ModEntities.CHAMPION_WUKONG,
                ModEntities.CHAMPION_XERATH,
                ModEntities.CHAMPION_XIN_ZHAO,
                ModEntities.CHAMPION_YASUO,
                ModEntities.CHAMPION_YORICK,
                ModEntities.CHAMPION_ZED,
                ModEntities.CHAMPION_ZIGGS,
                ModEntities.CHAMPION_ZILEAN,

                ModEntities.BATTLE_BUNNY_JANNA,
                ModEntities.BATTLE_BUNNY_RIVEN,

                ModEntities.KING_PORO,
                ModEntities.DEAD_KING_PORO,

                ModEntities.LEGEND_AHRI,
                ModEntities.LEGEND_AKALI,
                ModEntities.LEGEND_AMUMU,
                ModEntities.LEGEND_ANIVIA,
                ModEntities.LEGEND_ANNIE,
                ModEntities.LEGEND_ASHE,
                ModEntities.LEGEND_AYUREX,
                ModEntities.LEGEND_CAITLYN,
                ModEntities.LEGEND_CAMILLE,
                ModEntities.LEGEND_CASSIOPEIA,
                ModEntities.LEGEND_DIANA,
                ModEntities.LEGEND_ELISE,
                ModEntities.LEGEND_EVELYNN,
                ModEntities.LEGEND_FIORA,
                ModEntities.LEGEND_FIZZ,
                ModEntities.LEGEND_GNAR,
                ModEntities.LEGEND_ILLAOI,
                ModEntities.LEGEND_IRELIA,
                ModEntities.LEGEND_JANNA,
                ModEntities.LEGEND_JINX,
                ModEntities.LEGEND_KAI_SA,
                ModEntities.LEGEND_KARMA,
                ModEntities.LEGEND_KATARINA,
                ModEntities.LEGEND_KINDRED,
                ModEntities.LEGEND_LEONA,
                ModEntities.LEGEND_LE_BLANC,
                ModEntities.LEGEND_LISSANDRA,
                ModEntities.LEGEND_LULU,
                ModEntities.LEGEND_LUX,
                ModEntities.LEGEND_MISS_FORTUNE,
                ModEntities.LEGEND_MORGANA,
                ModEntities.LEGEND_NEEKO,
                ModEntities.LEGEND_NIDALEE,
                ModEntities.LEGEND_ORIANNA,
                ModEntities.LEGEND_POPPY,
                ModEntities.LEGEND_QIYANA,
                ModEntities.LEGEND_QUINN,
                ModEntities.LEGEND_RAMMUS,
                ModEntities.LEGEND_RIVEN,
                ModEntities.LEGEND_SEJUANI,
                ModEntities.LEGEND_SHYVANA,
                ModEntities.LEGEND_SIVIR,
                ModEntities.LEGEND_SONA,
                ModEntities.LEGEND_SORAKA,
                ModEntities.LEGEND_SYNDRA,
                ModEntities.LEGEND_TALIYAH,
                ModEntities.LEGEND_TEEMO,
                ModEntities.LEGEND_TRISTANA,
                ModEntities.LEGEND_VAYNE,
                ModEntities.LEGEND_VI,
                ModEntities.LEGEND_XAYAH,
                ModEntities.LEGEND_YUUMI,
                ModEntities.LEGEND_ZAC,
                ModEntities.LEGEND_ZOE,
                ModEntities.LEGEND_ZYRA,

                ModEntities.YETI_BESTIA_GLACIES,
                ModEntities.YETI_SASQUATCH,

                ModEntities.MAGMA_BRAND,

                ModEntities.DIVINE_KAYLE,
                ModEntities.GUARDIAN_NAMI,

                ModEntities.LEGENDARY_AATROX,
                ModEntities.LEGENDARY_ALISTAR,
                ModEntities.LEGENDARY_APHELIOS,
                ModEntities.LEGENDARY_AURELION_SOL,
                ModEntities.LEGENDARY_AZIR,
                ModEntities.LEGENDARY_BARD,
                ModEntities.LEGENDARY_BLITZCRANK,
                ModEntities.LEGENDARY_BRAUM,

                ModEntities.LEGENDARY_CHO_GATH,
                ModEntities.LEGENDARY_CORKI,
                ModEntities.LEGENDARY_CYRO_BRAND,
                ModEntities.LEGENDARY_DARIUS,
                ModEntities.LEGENDARY_DRAVEN,
                ModEntities.LEGENDARY_DR_MUNDO,
                ModEntities.LEGENDARY_EKKO,
                ModEntities.LEGENDARY_EZREAL,
                ModEntities.LEGENDARY_FIDDLESTICKS,
                ModEntities.LEGENDARY_GALIO,
                ModEntities.LEGENDARY_GANGPLANK,
                ModEntities.LEGENDARY_GAREN,
                ModEntities.LEGENDARY_GRAGAS,
                ModEntities.LEGENDARY_GRAVES,
                ModEntities.LEGENDARY_HECARIM,
                ModEntities.LEGENDARY_HEIMERDINGER,
                ModEntities.LEGENDARY_IVERN,
                ModEntities.LEGENDARY_JARVAN_IV,
                ModEntities.LEGENDARY_JAX,
                ModEntities.LEGENDARY_JAYCE,
                ModEntities.LEGENDARY_JHIN,
                ModEntities.LEGENDARY_KALISTA,
                ModEntities.LEGENDARY_KARTHUS,
                ModEntities.LEGENDARY_KASSADIN,
                ModEntities.LEGENDARY_KAYN,
                ModEntities.LEGENDARY_KENNEN,
                ModEntities.LEGENDARY_KHA_ZIX,
                ModEntities.LEGENDARY_KLED,
                ModEntities.LEGENDARY_KOG_MAW,
                ModEntities.LEGENDARY_LEE_SIN,
                ModEntities.LEGENDARY_LUCIAN,
                ModEntities.LEGENDARY_MALPHITE,
                ModEntities.LEGENDARY_MALZAHAR,
                ModEntities.LEGENDARY_MAOKAI,
                ModEntities.LEGENDARY_MASTER_YI,
                ModEntities.LEGENDARY_MORDEKAISER,
                ModEntities.LEGENDARY_NASUS,
                ModEntities.LEGENDARY_NAUTILUS,
                ModEntities.LEGENDARY_NOCTURNE,
                ModEntities.LEGENDARY_NUNU,
                ModEntities.LEGENDARY_OLAF,
                ModEntities.LEGENDARY_ORNN,
                ModEntities.LEGENDARY_PANTHEON,
                ModEntities.LEGENDARY_PYKE,
                ModEntities.LEGENDARY_RAKAN,
                ModEntities.LEGENDARY_REK_SAI,
                ModEntities.LEGENDARY_RENEKTON,
                ModEntities.LEGENDARY_RENGAR,
                ModEntities.LEGENDARY_RUMBLE,
                ModEntities.LEGENDARY_RYZE,
                ModEntities.LEGENDARY_SETT,
                ModEntities.LEGENDARY_SHACO,
                ModEntities.LEGENDARY_SHEN,
                ModEntities.LEGENDARY_SINGED,
                ModEntities.LEGENDARY_SION,
                ModEntities.LEGENDARY_SKARNER,
                ModEntities.LEGENDARY_SWAIN,
                ModEntities.LEGENDARY_SYLAS,
                ModEntities.LEGENDARY_TAHM_KENCH,
                ModEntities.LEGENDARY_TALON,
                ModEntities.LEGENDARY_TARIC,
                ModEntities.LEGENDARY_THRESH,
                ModEntities.LEGENDARY_TRUNDLE,
                ModEntities.LEGENDARY_TRYNDAMERE,
                ModEntities.LEGENDARY_TWISTED_FATE,
                ModEntities.LEGENDARY_TWITCH,
                ModEntities.LEGENDARY_UDYR,
                ModEntities.LEGENDARY_URGOT,
                ModEntities.LEGENDARY_VARUS,
                ModEntities.LEGENDARY_VEIGAR,
                ModEntities.LEGENDARY_VEL_KOZ,
                ModEntities.LEGENDARY_VIKTOR,
                ModEntities.LEGENDARY_VLADIMIR,
                ModEntities.LEGENDARY_VOLIBEAR,
                ModEntities.LEGENDARY_WARWICK,
                ModEntities.LEGENDARY_WILLUMP,
                ModEntities.LEGENDARY_WUKONG,
                ModEntities.LEGENDARY_XERATH,
                ModEntities.LEGENDARY_XIN_ZHAO,
                ModEntities.LEGENDARY_YASUO,
                ModEntities.LEGENDARY_YORICK,
                ModEntities.LEGENDARY_ZED,
                ModEntities.LEGENDARY_ZIGGS,
                ModEntities.LEGENDARY_ZILEAN
                );
        LOGGER.debug("Registered Entities");

        /*
        ModEntities.registerEntityWorldSpawns();

        Method method = ObfuscationReflectionHelper.findMethod(CriteriaTriggers.class, "register", ICriterionTrigger.class);
        method.setAccessible(true);
        try
        {
            method.invoke(straitlaced.legendarysavages.server.advancements.criterion.TameLegendXayahTrigger.class);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            e.printStackTrace();
        }

         */

    }






    @SubscribeEvent
    public static void registerSoundEvents(@Nonnull final RegistryEvent.Register<SoundEvent> event) {
        LegendarySavages.LOGGER.info("In ModEventSubscriber.registerSoundEvents");
        event.getRegistry().registerAll(

                BRAND_STORM,
                CHAMPION_LIVING,
                CHAMPION_HURT,
                CHAMPION_DEATH,
                LEGEND_CUDDLE,
                LEGEND_HUNGRY,
                LEGEND_LIVING,
                LEGEND_HURT,
                LEGEND_DEATH,
                ZAC_LIVING,
                ZAC_HURT,
                ZAC_DEATH,
                LEGENDARY_LIVING,
                LEGENDARY_HURT,
                LEGENDARY_DEATH,
                BESTIA_ANGRY,
                BESTIA_LIVING,
                BESTIA_HURT,
                BESTIA_DEATH,
                SASQUATCH_ANGRY,
                SASQUATCH_LIVING,
                SASQUATCH_HURT,
                SASQUATCH_DEATH,
                WARWICK_BARK,
                WARWICK_HOWL,
                WILLUMP_ANGRY,
                WILLUMP_LIVING,
                WILLUMP_HURT,
                WILLUMP_DEATH,
                CYBORG_LIVING,
                CYBORG_HURT,
                CYBORG_DEATH,
                POLTERGEIST_LIVING,
                POLTERGEIST_HURT,
                POLTERGEIST_DEATH,
                REAPER_ANGRY,
                REAPER_LIVING,
                REAPER_HURT,
                REAPER_DEATH,
                DEVIL_LIVING,
                DEVIL_HURT,
                DEVIL_DEATH,
                JAX_LIVING,
                JAX_HURT,
                JAX_DEATH,
                CREATURE_ATTACK,
                CREATURE_LIVING,
                CREATURE_HURT,
                CREATURE_DEATH
        );
        LegendarySavages.LOGGER.info("In LSSoundRegistry.RegistrationHandler Complete");
    }

    /**
     * This method will be called by Forge when a config changes.
     */
    @SubscribeEvent
    public static void onModConfigEvent(@Nonnull final ModConfig.ModConfigEvent event) {
        final ModConfig config = event.getConfig();
        // Rebake the configs when they change
        if (config.getSpec() == ConfigHolder.CLIENT_SPEC) {
            ConfigHelper.bakeClient(config);
            LOGGER.debug("Baked client config");
        } else if (config.getSpec() == ConfigHolder.SERVER_SPEC) {
            ConfigHelper.bakeServer(config);
            LOGGER.debug("Baked server config");
        }
    }

    /**
     * Performs setup on a registry entry
     *
     * @param name The path of the entry's name. Used to make a name who's domain is our mod's modid
     */
    @Nonnull
    private static <T extends IForgeRegistryEntry<T>> T setup(@Nonnull final T entry, @Nonnull final String name) {
        Preconditions.checkNotNull(name, "Name to assign to entry cannot be null!");
        return setup(entry, new ResourceLocation(MODID, name));
    }

    /**
     * Performs setup on a registry entry
     *
     * @param registryName The full registry name of the entry
     */
    @Nonnull
    private static <T extends IForgeRegistryEntry<T>> T setup(@Nonnull final T entry, @Nonnull final ResourceLocation registryName) {
        Preconditions.checkNotNull(entry, "Entry cannot be null!");
        Preconditions.checkNotNull(registryName, "Registry name to assign to entry cannot be null!");
        entry.setRegistryName(registryName);
        return entry;
    }

    @Nonnull
    private static ResourceLocation location(@Nonnull String name) {
        return new ResourceLocation(MODID, name);
    }
}

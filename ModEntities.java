package straitlaced.legendarysavages.server.init;

import straitlaced.legendarysavages.LegendarySavages;
import straitlaced.legendarysavages.server.entity.monster.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

import javax.annotation.Nonnull;


import java.awt.*;
import java.util.ArrayList;

import static straitlaced.legendarysavages.LegendarySavages.MODID;

public class ModEntities {


    public static final EntityType<EntityChampionAatrox> CHAMPION_AATROX = (EntityType<EntityChampionAatrox>) EntityType.Builder
            .<EntityChampionAatrox>create(EntityChampionAatrox::new, EntityClassification.MONSTER)
            .size(0.8f, 2.3f)
            .setCustomClientFactory((EntityChampionAatrox::new))
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(32)
            .setUpdateInterval(1)
            .build(LegendarySavages.MODID + ":champion_aatrox")
            .setRegistryName(location("champion_aatrox"));

    public static final EntityType<EntityChampionAlistar> CHAMPION_ALISTAR = (EntityType<EntityChampionAlistar>) EntityType.Builder
            .<EntityChampionAlistar>create(EntityChampionAlistar::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionAlistar::new))
            .build(LegendarySavages.MODID + ":champion_alistar")
            .setRegistryName(location("champion_alistar"));
    public static final EntityType<EntityChampionAphelios> CHAMPION_APHELIOS = (EntityType<EntityChampionAphelios>) EntityType.Builder
            .<EntityChampionAphelios>create(EntityChampionAphelios::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionAphelios::new))
            .build(LegendarySavages.MODID + ":champion_aphelios")
            .setRegistryName(location("champion_aphelios"));
    public static final EntityType<EntityChampionAurelionSol> CHAMPION_AURELION_SOL = (EntityType<EntityChampionAurelionSol>) EntityType.Builder
            .<EntityChampionAurelionSol>create(EntityChampionAurelionSol::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionAurelionSol::new))
            .build(LegendarySavages.MODID + ":champion_aurelion_sol")
            .setRegistryName(location("champion_aurelion_sol"));
    public static final EntityType<EntityChampionAzir> CHAMPION_AZIR = (EntityType<EntityChampionAzir>) EntityType.Builder
            .<EntityChampionAzir>create(EntityChampionAzir::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionAzir::new))
            .build(LegendarySavages.MODID + ":champion_azir")
            .setRegistryName(location("champion_azir"));
    public static final EntityType<EntityChampionBard> CHAMPION_BARD = (EntityType<EntityChampionBard>) EntityType.Builder
            .<EntityChampionBard>create(EntityChampionBard::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionBard::new))
            .build(LegendarySavages.MODID + ":champion_bard")
            .setRegistryName(location("champion_bard"));
    public static final EntityType<EntityChampionBlitzcrank> CHAMPION_BLITZCRANK = (EntityType<EntityChampionBlitzcrank>) EntityType.Builder
            .<EntityChampionBlitzcrank>create(EntityChampionBlitzcrank::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionBlitzcrank::new))
            .build(LegendarySavages.MODID + ":champion_blitzcrank")
            .setRegistryName(location("champion_blitzcrank"));
    public static final EntityType<EntityChampionBraum> CHAMPION_BRAUM = (EntityType<EntityChampionBraum>) EntityType.Builder
            .<EntityChampionBraum>create(EntityChampionBraum::new, EntityClassification.MONSTER)
            .setCustomClientFactory(EntityChampionBraum::new)
            .build(LegendarySavages.MODID + ":champion_braum")
            .setRegistryName(location("champion_braum"));
    public static final EntityType<EntityChampionChoGath> CHAMPION_CHO_GATH = (EntityType<EntityChampionChoGath>) EntityType.Builder
            .<EntityChampionChoGath>create(EntityChampionChoGath::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionChoGath::new))
            .build(LegendarySavages.MODID + ":champion_cho_gath")
            .setRegistryName(location("champion_cho_gath"));
    public static final EntityType<EntityChampionCorki> CHAMPION_CORKI = (EntityType<EntityChampionCorki>) EntityType.Builder
            .<EntityChampionCorki>create(EntityChampionCorki::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionCorki::new))
            .build(LegendarySavages.MODID + ":champion_corki")
            .setRegistryName(location("champion_corki"));
    public static final EntityType<EntityChampionCyroBrand> CHAMPION_CYRO_BRAND = (EntityType<EntityChampionCyroBrand>) EntityType.Builder
            .<EntityChampionCyroBrand>create(EntityChampionCyroBrand::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionCyroBrand::new))
            .build(LegendarySavages.MODID + ":champion_cyro_brand")
            .setRegistryName(location("champion_cyro_brand"));
    public static final EntityType<EntityChampionDarius> CHAMPION_DARIUS = (EntityType<EntityChampionDarius>) EntityType.Builder
            .<EntityChampionDarius>create(EntityChampionDarius::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionDarius::new))
            .build(LegendarySavages.MODID + ":champion_darius")
            .setRegistryName(location("champion_darius"));
    public static final EntityType<EntityChampionDraven> CHAMPION_DRAVEN = (EntityType<EntityChampionDraven>) EntityType.Builder
            .<EntityChampionDraven>create(EntityChampionDraven::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionDraven::new))
            .build(LegendarySavages.MODID + ":champion_draven")
            .setRegistryName(location("champion_draven"));
    public static final EntityType<EntityChampionDrMundo> CHAMPION_DR_MUNDO = (EntityType<EntityChampionDrMundo>) EntityType.Builder
            .<EntityChampionDrMundo>create(EntityChampionDrMundo::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionDrMundo::new))
            .build(LegendarySavages.MODID + ":champion_dr_mundo")
            .setRegistryName(location("champion_dr_mundo"));
    public static final EntityType<EntityChampionEkko> CHAMPION_EKKO = (EntityType<EntityChampionEkko>) EntityType.Builder
            .<EntityChampionEkko>create(EntityChampionEkko::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionEkko::new))
            .build(LegendarySavages.MODID + ":champion_ekko")
            .setRegistryName(location("champion_ekko"));
    public static final EntityType<EntityChampionEzreal> CHAMPION_EZREAL = (EntityType<EntityChampionEzreal>) EntityType.Builder
            .<EntityChampionEzreal>create(EntityChampionEzreal::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionEzreal::new))
            .build(LegendarySavages.MODID + ":champion_ezreal")
            .setRegistryName(location("champion_ezreal"));
    public static final EntityType<EntityChampionFiddlesticks> CHAMPION_FIDDLESTICKS = (EntityType<EntityChampionFiddlesticks>) EntityType.Builder
            .<EntityChampionFiddlesticks>create(EntityChampionFiddlesticks::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionFiddlesticks::new))
            .build(LegendarySavages.MODID + ":champion_fiddlesticks")
            .setRegistryName(location("champion_fiddlesticks"));
    public static final EntityType<EntityChampionGalio> CHAMPION_GALIO = (EntityType<EntityChampionGalio>) EntityType.Builder
            .<EntityChampionGalio>create(EntityChampionGalio::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionGalio::new))
            .build(LegendarySavages.MODID + ":champion_galio")
            .setRegistryName(location("champion_galio"));
    public static final EntityType<EntityChampionGangplank> CHAMPION_GANGPLANK = (EntityType<EntityChampionGangplank>) EntityType.Builder
            .<EntityChampionGangplank>create(EntityChampionGangplank::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionGangplank::new))
            .build(LegendarySavages.MODID + ":champion_gangplank")
            .setRegistryName(location("champion_gangplank"));
    public static final EntityType<EntityChampionGaren> CHAMPION_GAREN = (EntityType<EntityChampionGaren>) EntityType.Builder
            .<EntityChampionGaren>create(EntityChampionGaren::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionGaren::new))
            .build(LegendarySavages.MODID + ":champion_garen")
            .setRegistryName(location("champion_garen"));
    public static final EntityType<EntityChampionGragas> CHAMPION_GRAGAS = (EntityType<EntityChampionGragas>) EntityType.Builder
            .<EntityChampionGragas>create(EntityChampionGragas::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionGragas::new))
            .build(LegendarySavages.MODID + ":champion_gragas")
            .setRegistryName(location("champion_gragas"));
    public static final EntityType<EntityChampionGraves> CHAMPION_GRAVES = (EntityType<EntityChampionGraves>) EntityType.Builder
            .<EntityChampionGraves>create(EntityChampionGraves::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionGraves::new))
            .build(LegendarySavages.MODID + ":champion_graves")
            .setRegistryName(location("champion_graves"));
    public static final EntityType<EntityChampionHecarim> CHAMPION_HECARIM = (EntityType<EntityChampionHecarim>) EntityType.Builder
            .<EntityChampionHecarim>create(EntityChampionHecarim::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionHecarim::new))
            .build(LegendarySavages.MODID + ":champion_hecarim")
            .setRegistryName(location("champion_hecarim"));
    public static final EntityType<EntityChampionHeimerdinger> CHAMPION_HEIMERDINGER = (EntityType<EntityChampionHeimerdinger>) EntityType.Builder
            .<EntityChampionHeimerdinger>create(EntityChampionHeimerdinger::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionHeimerdinger::new))
            .build(LegendarySavages.MODID + ":champion_heimerdinger")
            .setRegistryName(location("champion_heimerdinger"));
    public static final EntityType<EntityChampionIvern> CHAMPION_IVERN = (EntityType<EntityChampionIvern>) EntityType.Builder
            .<EntityChampionIvern>create(EntityChampionIvern::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionIvern::new))
            .build(LegendarySavages.MODID + ":champion_ivern")
            .setRegistryName(location("champion_ivern"));
    public static final EntityType<EntityChampionJarvanIV> CHAMPION_JARVAN_IV = (EntityType<EntityChampionJarvanIV>) EntityType.Builder
            .<EntityChampionJarvanIV>create(EntityChampionJarvanIV::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionJarvanIV::new))
            .build(LegendarySavages.MODID + ":champion_jarvan_iv")
            .setRegistryName(location("champion_jarvan_iv"));
    public static final EntityType<EntityChampionJax> CHAMPION_JAX = (EntityType<EntityChampionJax>) EntityType.Builder
            .<EntityChampionJax>create(EntityChampionJax::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionJax::new))
            .build(LegendarySavages.MODID + ":champion_jax")
            .setRegistryName(location("champion_jax"));
    public static final EntityType<EntityChampionJayce> CHAMPION_JAYCE = (EntityType<EntityChampionJayce>) EntityType.Builder
            .<EntityChampionJayce>create(EntityChampionJayce::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionJayce::new))
            .build(LegendarySavages.MODID + ":champion_jayce")
            .setRegistryName(location("champion_jayce"));
    public static final EntityType<EntityChampionJhin> CHAMPION_JHIN = (EntityType<EntityChampionJhin>) EntityType.Builder
            .<EntityChampionJhin>create(EntityChampionJhin::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionJhin::new))
            .build(LegendarySavages.MODID + ":champion_jhin")
            .setRegistryName(location("champion_jhin"));
    public static final EntityType<EntityChampionKalista> CHAMPION_KALISTA = (EntityType<EntityChampionKalista>) EntityType.Builder
            .<EntityChampionKalista>create(EntityChampionKalista::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionKalista::new))
            .build(LegendarySavages.MODID + ":champion_kalista")
            .setRegistryName(location("champion_kalista"));
    public static final EntityType<EntityChampionKarthus> CHAMPION_KARTHUS = (EntityType<EntityChampionKarthus>) EntityType.Builder
            .<EntityChampionKarthus>create(EntityChampionKarthus::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionKarthus::new))
            .build(LegendarySavages.MODID + ":champion_karthus")
            .setRegistryName(location("champion_karthus"));
    public static final EntityType<EntityChampionKassadin> CHAMPION_KASSADIN = (EntityType<EntityChampionKassadin>) EntityType.Builder
            .<EntityChampionKassadin>create(EntityChampionKassadin::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionKassadin::new))
            .build(LegendarySavages.MODID + ":champion_kassadin")
            .setRegistryName(location("champion_kassadin"));
    public static final EntityType<EntityChampionKayn> CHAMPION_KAYN = (EntityType<EntityChampionKayn>) EntityType.Builder
            .<EntityChampionKayn>create(EntityChampionKayn::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionKayn::new))
            .build(LegendarySavages.MODID + ":champion_kayn")
            .setRegistryName(location("champion_kayn"));
    public static final EntityType<EntityChampionKennen> CHAMPION_KENNEN = (EntityType<EntityChampionKennen>) EntityType.Builder
            .<EntityChampionKennen>create(EntityChampionKennen::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionKennen::new))
            .build(LegendarySavages.MODID + ":champion_kennen")
            .setRegistryName(location("champion_kennen"));
    public static final EntityType<EntityChampionKhaZix> CHAMPION_KHA_ZIX = (EntityType<EntityChampionKhaZix>) EntityType.Builder
            .<EntityChampionKhaZix>create(EntityChampionKhaZix::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionKhaZix::new))
            .build(LegendarySavages.MODID + ":champion_kha_zix")
            .setRegistryName(location("champion_kha_zix"));
    public static final EntityType<EntityChampionKled> CHAMPION_KLED = (EntityType<EntityChampionKled>) EntityType.Builder
            .<EntityChampionKled>create(EntityChampionKled::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionKled::new))
            .build(LegendarySavages.MODID + ":champion_kled")
            .setRegistryName(location("champion_kled"));
    public static final EntityType<EntityChampionKogMaw> CHAMPION_KOG_MAW = (EntityType<EntityChampionKogMaw>) EntityType.Builder
            .<EntityChampionKogMaw>create(EntityChampionKogMaw::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionKogMaw::new))
            .build(LegendarySavages.MODID + ":champion_kog_maw")
            .setRegistryName(location("champion_kog_maw"));
    public static final EntityType<EntityChampionLeeSin> CHAMPION_LEE_SIN = (EntityType<EntityChampionLeeSin>) EntityType.Builder
            .<EntityChampionLeeSin>create(EntityChampionLeeSin::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionLeeSin::new))
            .build(LegendarySavages.MODID + ":champion_lee_sin")
            .setRegistryName(location("champion_lee_sin"));
    public static final EntityType<EntityChampionLucian> CHAMPION_LUCIAN = (EntityType<EntityChampionLucian>) EntityType.Builder
            .<EntityChampionLucian>create(EntityChampionLucian::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionLucian::new))
            .build(LegendarySavages.MODID + ":champion_lucian")
            .setRegistryName(location("champion_lucian"));
    public static final EntityType<EntityChampionMalphite> CHAMPION_MALPHITE = (EntityType<EntityChampionMalphite>) EntityType.Builder
            .<EntityChampionMalphite>create(EntityChampionMalphite::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionMalphite::new))
            .build(LegendarySavages.MODID + ":champion_malphite")
            .setRegistryName(location("champion_malphite"));
    public static final EntityType<EntityChampionMalzahar> CHAMPION_MALZAHAR = (EntityType<EntityChampionMalzahar>) EntityType.Builder
            .<EntityChampionMalzahar>create(EntityChampionMalzahar::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionMalzahar::new))
            .build(LegendarySavages.MODID + ":champion_malzahar")
            .setRegistryName(location("champion_malzahar"));
    public static final EntityType<EntityChampionMaokai> CHAMPION_MAOKAI = (EntityType<EntityChampionMaokai>) EntityType.Builder
            .<EntityChampionMaokai>create(EntityChampionMaokai::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionMaokai::new))
            .build(LegendarySavages.MODID + ":champion_maokai")
            .setRegistryName(location("champion_maokai"));
    public static final EntityType<EntityChampionMasterYi> CHAMPION_MASTER_YI = (EntityType<EntityChampionMasterYi>) EntityType.Builder
            .<EntityChampionMasterYi>create(EntityChampionMasterYi::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionMasterYi::new))
            .build(LegendarySavages.MODID + ":champion_master_yi")
            .setRegistryName(location("champion_master_yi"));
    public static final EntityType<EntityChampionMordekaiser> CHAMPION_MORDEKAISER = (EntityType<EntityChampionMordekaiser>) EntityType.Builder
            .<EntityChampionMordekaiser>create(EntityChampionMordekaiser::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionMordekaiser::new))
            .build(LegendarySavages.MODID + ":champion_mordekaiser")
            .setRegistryName(location("champion_mordekaiser"));
    public static final EntityType<EntityChampionNasus> CHAMPION_NASUS = (EntityType<EntityChampionNasus>) EntityType.Builder
            .<EntityChampionNasus>create(EntityChampionNasus::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionNasus::new))
            .build(LegendarySavages.MODID + ":champion_nasus")
            .setRegistryName(location("champion_nasus"));
    public static final EntityType<EntityChampionNautilus> CHAMPION_NAUTILUS = (EntityType<EntityChampionNautilus>) EntityType.Builder
            .<EntityChampionNautilus>create(EntityChampionNautilus::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionNautilus::new))
            .build(LegendarySavages.MODID + ":champion_nautilus")
            .setRegistryName(location("champion_nautilus"));
    public static final EntityType<EntityChampionNocturne> CHAMPION_NOCTURNE = (EntityType<EntityChampionNocturne>) EntityType.Builder
            .<EntityChampionNocturne>create(EntityChampionNocturne::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionNocturne::new))
            .build(LegendarySavages.MODID + ":champion_nocturne")
            .setRegistryName(location("champion_nocturne"));
    public static final EntityType<EntityChampionNunu> CHAMPION_NUNU = (EntityType<EntityChampionNunu>) EntityType.Builder
            .<EntityChampionNunu>create(EntityChampionNunu::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionNunu::new))
            .build(LegendarySavages.MODID + ":champion_nunu")
            .setRegistryName(location("champion_nunu"));
    public static final EntityType<EntityChampionOlaf> CHAMPION_OLAF = (EntityType<EntityChampionOlaf>) EntityType.Builder
            .<EntityChampionOlaf>create(EntityChampionOlaf::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionOlaf::new))
            .build(LegendarySavages.MODID + ":champion_olaf")
            .setRegistryName(location("champion_olaf"));
    public static final EntityType<EntityChampionOrnn> CHAMPION_ORNN = (EntityType<EntityChampionOrnn>) EntityType.Builder
            .<EntityChampionOrnn>create(EntityChampionOrnn::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionOrnn::new))
            .build(LegendarySavages.MODID + ":champion_ornn")
            .setRegistryName(location("champion_ornn"));
    public static final EntityType<EntityChampionPantheon> CHAMPION_PANTHEON = (EntityType<EntityChampionPantheon>) EntityType.Builder
            .<EntityChampionPantheon>create(EntityChampionPantheon::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionPantheon::new))
            .build(LegendarySavages.MODID + ":champion_pantheon")
            .setRegistryName(location("champion_pantheon"));
    public static final EntityType<EntityChampionPyke> CHAMPION_PYKE = (EntityType<EntityChampionPyke>) EntityType.Builder
            .<EntityChampionPyke>create(EntityChampionPyke::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionPyke::new))
            .build(LegendarySavages.MODID + ":champion_pyke")
            .setRegistryName(location("champion_pyke"));
    public static final EntityType<EntityChampionRakan> CHAMPION_RAKAN = (EntityType<EntityChampionRakan>) EntityType.Builder
            .<EntityChampionRakan>create(EntityChampionRakan::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionRakan::new))
            .build(LegendarySavages.MODID + ":champion_rakan")
            .setRegistryName(location("champion_rakan"));
    public static final EntityType<EntityChampionRekSai> CHAMPION_REK_SAI = (EntityType<EntityChampionRekSai>) EntityType.Builder
            .<EntityChampionRekSai>create(EntityChampionRekSai::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionRekSai::new))
            .build(LegendarySavages.MODID + ":champion_rek_sai")
            .setRegistryName(location("champion_rek_sai"));
    public static final EntityType<EntityChampionRenekton> CHAMPION_RENEKTON = (EntityType<EntityChampionRenekton>) EntityType.Builder
            .<EntityChampionRenekton>create(EntityChampionRenekton::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionRenekton::new))
            .build(LegendarySavages.MODID + ":champion_renekton")
            .setRegistryName(location("champion_renekton"));
    public static final EntityType<EntityChampionRengar> CHAMPION_RENGAR = (EntityType<EntityChampionRengar>) EntityType.Builder
            .<EntityChampionRengar>create(EntityChampionRengar::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionRengar::new))
            .build(LegendarySavages.MODID + ":champion_rengar")
            .setRegistryName(location("champion_rengar"));
    public static final EntityType<EntityChampionRumble> CHAMPION_RUMBLE = (EntityType<EntityChampionRumble>) EntityType.Builder
            .<EntityChampionRumble>create(EntityChampionRumble::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionRumble::new))
            .build(LegendarySavages.MODID + ":champion_rumble")
            .setRegistryName(location("champion_rumble"));
    public static final EntityType<EntityChampionRyze> CHAMPION_RYZE = (EntityType<EntityChampionRyze>) EntityType.Builder
            .<EntityChampionRyze>create(EntityChampionRyze::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionRyze::new))
            .build(LegendarySavages.MODID + ":champion_ryze")
            .setRegistryName(location("champion_ryze"));
    public static final EntityType<EntityChampionSett> CHAMPION_SETT = (EntityType<EntityChampionSett>) EntityType.Builder
            .<EntityChampionSett>create(EntityChampionSett::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionSett::new))
            .build(LegendarySavages.MODID + ":champion_sett")
            .setRegistryName(location("champion_sett"));
    public static final EntityType<EntityChampionShaco> CHAMPION_SHACO = (EntityType<EntityChampionShaco>) EntityType.Builder
            .<EntityChampionShaco>create(EntityChampionShaco::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionShaco::new))
            .build(LegendarySavages.MODID + ":champion_shaco")
            .setRegistryName(location("champion_shaco"));
    public static final EntityType<EntityChampionShen> CHAMPION_SHEN = (EntityType<EntityChampionShen>) EntityType.Builder
            .<EntityChampionShen>create(EntityChampionShen::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionShen::new))
            .build(LegendarySavages.MODID + ":champion_shen")
            .setRegistryName(location("champion_shen"));
    public static final EntityType<EntityChampionSinged> CHAMPION_SINGED = (EntityType<EntityChampionSinged>) EntityType.Builder
            .<EntityChampionSinged>create(EntityChampionSinged::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionSinged::new))
            .build(LegendarySavages.MODID + ":champion_singed")
            .setRegistryName(location("champion_singed"));
    public static final EntityType<EntityChampionSion> CHAMPION_SION = (EntityType<EntityChampionSion>) EntityType.Builder
            .<EntityChampionSion>create(EntityChampionSion::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionSion::new))
            .build(LegendarySavages.MODID + ":champion_sion")
            .setRegistryName(location("champion_sion"));
    public static final EntityType<EntityChampionSkarner> CHAMPION_SKARNER = (EntityType<EntityChampionSkarner>) EntityType.Builder
            .<EntityChampionSkarner>create(EntityChampionSkarner::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionSkarner::new))
            .build(LegendarySavages.MODID + ":champion_skarner")
            .setRegistryName(location("champion_skarner"));
    public static final EntityType<EntityChampionSwain> CHAMPION_SWAIN = (EntityType<EntityChampionSwain>) EntityType.Builder
            .<EntityChampionSwain>create(EntityChampionSwain::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionSwain::new))
            .build(LegendarySavages.MODID + ":champion_swain")
            .setRegistryName(location("champion_swain"));
    public static final EntityType<EntityChampionSylas> CHAMPION_SYLAS = (EntityType<EntityChampionSylas>) EntityType.Builder
            .<EntityChampionSylas>create(EntityChampionSylas::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionSylas::new))
            .build(LegendarySavages.MODID + ":champion_sylas")
            .setRegistryName(location("champion_sylas"));
    public static final EntityType<EntityChampionTahmKench> CHAMPION_TAHM_KENCH = (EntityType<EntityChampionTahmKench>) EntityType.Builder
            .<EntityChampionTahmKench>create(EntityChampionTahmKench::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionTahmKench::new))
            .build(LegendarySavages.MODID + ":champion_tahm_kench")
            .setRegistryName(location("champion_tahm_kench"));
    public static final EntityType<EntityChampionTalon> CHAMPION_TALON = (EntityType<EntityChampionTalon>) EntityType.Builder
            .<EntityChampionTalon>create(EntityChampionTalon::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionTalon::new))
            .build(LegendarySavages.MODID + ":champion_talon")
            .setRegistryName(location("champion_talon"));
    public static final EntityType<EntityChampionTaric> CHAMPION_TARIC = (EntityType<EntityChampionTaric>) EntityType.Builder
            .<EntityChampionTaric>create(EntityChampionTaric::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionTaric::new))
            .build(LegendarySavages.MODID + ":champion_taric")
            .setRegistryName(location("champion_taric"));
    public static final EntityType<EntityChampionThresh> CHAMPION_THRESH = (EntityType<EntityChampionThresh>) EntityType.Builder
            .<EntityChampionThresh>create(EntityChampionThresh::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionThresh::new))
            .build(LegendarySavages.MODID + ":champion_thresh")
            .setRegistryName(location("champion_thresh"));
    public static final EntityType<EntityChampionTrundle> CHAMPION_TRUNDLE = (EntityType<EntityChampionTrundle>) EntityType.Builder
            .<EntityChampionTrundle>create(EntityChampionTrundle::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionTrundle::new))
            .build(LegendarySavages.MODID + ":champion_trundle")
            .setRegistryName(location("champion_trundle"));
    public static final EntityType<EntityChampionTryndamere> CHAMPION_TRYNDAMERE = (EntityType<EntityChampionTryndamere>) EntityType.Builder
            .<EntityChampionTryndamere>create(EntityChampionTryndamere::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionTryndamere::new))
            .build(LegendarySavages.MODID + ":champion_tryndamere")
            .setRegistryName(location("champion_tryndamere"));
    public static final EntityType<EntityChampionTwistedFate> CHAMPION_TWISTED_FATE = (EntityType<EntityChampionTwistedFate>) EntityType.Builder
            .<EntityChampionTwistedFate>create(EntityChampionTwistedFate::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionTwistedFate::new))
            .build(LegendarySavages.MODID + ":champion_twisted_fate")
            .setRegistryName(location("champion_twisted_fate"));
    public static final EntityType<EntityChampionTwitch> CHAMPION_TWITCH = (EntityType<EntityChampionTwitch>) EntityType.Builder
            .<EntityChampionTwitch>create(EntityChampionTwitch::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionTwitch::new))
            .build(LegendarySavages.MODID + ":champion_twitch")
            .setRegistryName(location("champion_twitch"));
    public static final EntityType<EntityChampionUdyr> CHAMPION_UDYR = (EntityType<EntityChampionUdyr>) EntityType.Builder
            .<EntityChampionUdyr>create(EntityChampionUdyr::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionUdyr::new))
            .build(LegendarySavages.MODID + ":champion_udyr")
            .setRegistryName(location("champion_udyr"));
    public static final EntityType<EntityChampionUrgot> CHAMPION_URGOT = (EntityType<EntityChampionUrgot>) EntityType.Builder
            .<EntityChampionUrgot>create(EntityChampionUrgot::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionUrgot::new))
            .build(LegendarySavages.MODID + ":champion_urgot")
            .setRegistryName(location("champion_urgot"));
    public static final EntityType<EntityChampionVarus> CHAMPION_VARUS = (EntityType<EntityChampionVarus>) EntityType.Builder
            .<EntityChampionVarus>create(EntityChampionVarus::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionVarus::new))
            .build(LegendarySavages.MODID + ":champion_varus")
            .setRegistryName(location("champion_varus"));
    public static final EntityType<EntityChampionVeigar> CHAMPION_VEIGAR = (EntityType<EntityChampionVeigar>) EntityType.Builder
            .<EntityChampionVeigar>create(EntityChampionVeigar::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionVeigar::new))
            .build(LegendarySavages.MODID + ":champion_veigar")
            .setRegistryName(location("champion_veigar"));
    public static final EntityType<EntityChampionVelKoz> CHAMPION_VEL_KOZ = (EntityType<EntityChampionVelKoz>) EntityType.Builder
            .<EntityChampionVelKoz>create(EntityChampionVelKoz::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionVelKoz::new))
            .build(LegendarySavages.MODID + ":champion_vel_koz")
            .setRegistryName(location("champion_vel_koz"));
    public static final EntityType<EntityChampionViktor> CHAMPION_VIKTOR = (EntityType<EntityChampionViktor>) EntityType.Builder
            .<EntityChampionViktor>create(EntityChampionViktor::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionViktor::new))
            .build(LegendarySavages.MODID + ":champion_viktor")
            .setRegistryName(location("champion_viktor"));
    public static final EntityType<EntityChampionVladimir> CHAMPION_VLADIMIR = (EntityType<EntityChampionVladimir>) EntityType.Builder
            .<EntityChampionVladimir>create(EntityChampionVladimir::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionVladimir::new))
            .build(LegendarySavages.MODID + ":champion_vladimir")
            .setRegistryName(location("champion_vladimir"));
    public static final EntityType<EntityChampionVolibear> CHAMPION_VOLIBEAR = (EntityType<EntityChampionVolibear>) EntityType.Builder
            .<EntityChampionVolibear>create(EntityChampionVolibear::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionVolibear::new))
            .build(LegendarySavages.MODID + ":champion_volibear")
            .setRegistryName(location("champion_volibear"));
    public static final EntityType<EntityChampionWarwick> CHAMPION_WARWICK = (EntityType<EntityChampionWarwick>) EntityType.Builder
            .<EntityChampionWarwick>create(EntityChampionWarwick::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionWarwick::new))
            .build(LegendarySavages.MODID + ":champion_warwick")
            .setRegistryName(location("champion_warwick"));

    public static final EntityType<EntityChampionWukong> CHAMPION_WUKONG = (EntityType<EntityChampionWukong>) EntityType.Builder
            .<EntityChampionWukong>create(EntityChampionWukong::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionWukong::new))
            .build(LegendarySavages.MODID + ":champion_wukong")
            .setRegistryName(location("champion_wukong"));
    public static final EntityType<EntityChampionXerath> CHAMPION_XERATH = (EntityType<EntityChampionXerath>) EntityType.Builder
            .<EntityChampionXerath>create(EntityChampionXerath::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionXerath::new))
            .build(LegendarySavages.MODID + ":champion_xerath")
            .setRegistryName(location("champion_xerath"));
    public static final EntityType<EntityChampionXinZhao> CHAMPION_XIN_ZHAO = (EntityType<EntityChampionXinZhao>) EntityType.Builder
            .<EntityChampionXinZhao>create(EntityChampionXinZhao::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionXinZhao::new))
            .build(LegendarySavages.MODID + ":champion_xin_zhao")
            .setRegistryName(location("champion_xin_zhao"));
    public static final EntityType<EntityChampionYasuo> CHAMPION_YASUO = (EntityType<EntityChampionYasuo>) EntityType.Builder
            .<EntityChampionYasuo>create(EntityChampionYasuo::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionYasuo::new))
            .build(LegendarySavages.MODID + ":champion_yasuo")
            .setRegistryName(location("champion_yasuo"));
    public static final EntityType<EntityChampionYorick> CHAMPION_YORICK = (EntityType<EntityChampionYorick>) EntityType.Builder
            .<EntityChampionYorick>create(EntityChampionYorick::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionYorick::new))
            .build(LegendarySavages.MODID + ":champion_yorick")
            .setRegistryName(location("champion_yorick"));
    public static final EntityType<EntityChampionZed> CHAMPION_ZED = (EntityType<EntityChampionZed>) EntityType.Builder
            .<EntityChampionZed>create(EntityChampionZed::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionZed::new))
            .build(LegendarySavages.MODID + ":champion_zed")
            .setRegistryName(location("champion_zed"));
    public static final EntityType<EntityChampionZiggs> CHAMPION_ZIGGS = (EntityType<EntityChampionZiggs>) EntityType.Builder
            .<EntityChampionZiggs>create(EntityChampionZiggs::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionZiggs::new))
            .build(LegendarySavages.MODID + ":champion_ziggs")
            .setRegistryName(location("champion_ziggs"));
    public static final EntityType<EntityChampionZilean> CHAMPION_ZILEAN = (EntityType<EntityChampionZilean>) EntityType.Builder
            .<EntityChampionZilean>create(EntityChampionZilean::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityChampionZilean::new))
            .build(LegendarySavages.MODID + ":champion_zilean")
            .setRegistryName(location("champion_zilean"));


    public static final EntityType<EntityDeadKingPoro> DEAD_KING_PORO= (EntityType<EntityDeadKingPoro>) EntityType.Builder
            .<EntityDeadKingPoro>create(EntityDeadKingPoro::new, EntityClassification.MISC)
            .setCustomClientFactory((EntityDeadKingPoro::new))
            .build(LegendarySavages.MODID + ":dead_king_poro")
            .setRegistryName(location("dead_king_poro"));
    public static final EntityType<EntityKingPoro> KING_PORO = (EntityType<EntityKingPoro>) EntityType.Builder
            .<EntityKingPoro>create(EntityKingPoro::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityKingPoro::new))
            .build(LegendarySavages.MODID + ":king_poro")
            .setRegistryName(location("king_poro"));
    public static final EntityType<EntityBattleBunnyJanna> BATTLE_BUNNY_JANNA =(EntityType<EntityBattleBunnyJanna>) EntityType.Builder
            .<EntityBattleBunnyJanna> create(EntityBattleBunnyJanna::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityBattleBunnyJanna::new))
            .build(LegendarySavages.MODID + ":battle_bunny_janna")
            .setRegistryName(location("battle_bunny_janna"));

    public static final EntityType<EntityBattleBunnyRiven> BATTLE_BUNNY_RIVEN = (EntityType<EntityBattleBunnyRiven>) EntityType.Builder
            .<EntityBattleBunnyRiven>create(EntityBattleBunnyRiven::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityBattleBunnyRiven::new))
            .build(LegendarySavages.MODID + ":battle_bunny_riven")
            .setRegistryName(location("battle_bunny_riven"));


    public static final EntityType<EntityLegendAhri> LEGEND_AHRI = (EntityType<EntityLegendAhri>) EntityType.Builder
            .<EntityLegendAhri> create(EntityLegendAhri::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendAhri::new))
            .build(LegendarySavages.MODID + ":legend_ahri")
            .setRegistryName(location("legend_ahri"));

    public static final EntityType<EntityLegendAkali> LEGEND_AKALI = (EntityType<EntityLegendAkali>) EntityType.Builder
            .<EntityLegendAkali>create(EntityLegendAkali::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendAkali::new))
            .build(LegendarySavages.MODID + ":legend_akali")
            .setRegistryName(location("legend_akali"));

    public static final EntityType<EntityLegendAmumu> LEGEND_AMUMU =(EntityType<EntityLegendAmumu>) EntityType.Builder
            .<EntityLegendAmumu>create(EntityLegendAmumu::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendAmumu::new))
            .build(LegendarySavages.MODID + ":legend_amumu")
            .setRegistryName(location("legend_amumu"));
    public static final EntityType<EntityLegendAnivia> LEGEND_ANIVIA = (EntityType<EntityLegendAnivia>) EntityType.Builder
            .<EntityLegendAnivia>create(EntityLegendAnivia::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendAnivia::new))
            .build(LegendarySavages.MODID + ":legend_anivia")
            .setRegistryName(location("legend_anivia"));

    public static final EntityType<EntityLegendAnnie> LEGEND_ANNIE = (EntityType<EntityLegendAnnie>) EntityType.Builder
            .<EntityLegendAnnie>create(EntityLegendAnnie::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendAnnie::new))
            .build(LegendarySavages.MODID + ":legend_annie")
            .setRegistryName(location("legend_annie"));

    public static final EntityType<EntityLegendAshe> LEGEND_ASHE =(EntityType<EntityLegendAshe>) EntityType.Builder
            .<EntityLegendAshe>create(EntityLegendAshe::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendAshe::new))
            .build(LegendarySavages.MODID + ":legend_ashe")
            .setRegistryName(location("legend_ashe"));

    public static final EntityType<EntityLegendAyurex> LEGEND_AYUREX = (EntityType<EntityLegendAyurex>) EntityType.Builder
            .<EntityLegendAyurex>create(EntityLegendAyurex::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendAyurex::new))
            .build(LegendarySavages.MODID + ":legend_ayurex")
            .setRegistryName(location("legend_ayurex"));

    public static final EntityType<EntityLegendCaitlyn> LEGEND_CAITLYN = (EntityType<EntityLegendCaitlyn>) EntityType.Builder
            .<EntityLegendCaitlyn>create(EntityLegendCaitlyn::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendCaitlyn::new))
            .build(LegendarySavages.MODID + ":legend_caitlyn")
            .setRegistryName(location("legend_caitlyn"));
    public static final EntityType<EntityLegendCamille> LEGEND_CAMILLE = (EntityType<EntityLegendCamille>) EntityType.Builder
            .<EntityLegendCamille>create(EntityLegendCamille::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendCamille::new))
            .build(LegendarySavages.MODID + ":legend_camille")
            .setRegistryName(location("legend_camille"));
    public static final EntityType<EntityLegendCassiopeia> LEGEND_CASSIOPEIA = (EntityType<EntityLegendCassiopeia>) EntityType.Builder
            .<EntityLegendCassiopeia>create(EntityLegendCassiopeia::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendCassiopeia::new))
            .build(LegendarySavages.MODID + ":legend_cassiopeia")
            .setRegistryName(location("legend_cassiopeia"));
    public static final EntityType<EntityLegendDiana> LEGEND_DIANA = (EntityType<EntityLegendDiana>) EntityType.Builder
            .<EntityLegendDiana>create(EntityLegendDiana::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendDiana::new))
            .build(LegendarySavages.MODID + ":legend_diana")
            .setRegistryName(location("legend_diana"));
    public static final EntityType<EntityLegendElise> LEGEND_ELISE = (EntityType<EntityLegendElise>) EntityType.Builder
            .<EntityLegendElise>create(EntityLegendElise::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendElise::new))
            .build(LegendarySavages.MODID + ":legend_elise")
            .setRegistryName(location("legend_elise"));
    public static final EntityType<EntityLegendEvelynn> LEGEND_EVELYNN = (EntityType<EntityLegendEvelynn>) EntityType.Builder
            .<EntityLegendEvelynn>create(EntityLegendEvelynn::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendEvelynn::new))
            .build(LegendarySavages.MODID + ":legend_evelynn")
            .setRegistryName(location("legend_evelynn"));
    public static final EntityType<EntityLegendFiora> LEGEND_FIORA = (EntityType<EntityLegendFiora>) EntityType.Builder
            .<EntityLegendFiora>create(EntityLegendFiora::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendFiora::new))
            .build(LegendarySavages.MODID + ":legend_fiora")
            .setRegistryName(location("legend_fiora"));
    public static final EntityType<EntityLegendFizz> LEGEND_FIZZ = (EntityType<EntityLegendFizz>) EntityType.Builder
            .<EntityLegendFizz>create(EntityLegendFizz::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendFizz::new))
            .build(LegendarySavages.MODID + ":legend_fizz")
            .setRegistryName(location("legend_fizz"));
    public static final EntityType<EntityLegendGnar> LEGEND_GNAR = (EntityType<EntityLegendGnar>) EntityType.Builder
            .<EntityLegendGnar>create(EntityLegendGnar::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendGnar::new))
            .build(LegendarySavages.MODID + ":legend_gnar")
            .setRegistryName(location("legend_gnar"));
    public static final EntityType<EntityLegendIllaoi> LEGEND_ILLAOI = (EntityType<EntityLegendIllaoi>) EntityType.Builder
            .<EntityLegendIllaoi>create(EntityLegendIllaoi::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendIllaoi::new))
            .build(LegendarySavages.MODID + ":legend_illaoi")
            .setRegistryName(location("legend_illaoi"));
    public static final EntityType<EntityLegendIrelia> LEGEND_IRELIA = (EntityType<EntityLegendIrelia>) EntityType.Builder
            .<EntityLegendIrelia>create(EntityLegendIrelia::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendIrelia::new))
            .build(LegendarySavages.MODID + ":legend_irelia")
            .setRegistryName(location("legend_irelia"));
    public static final EntityType<EntityLegendJanna> LEGEND_JANNA = (EntityType<EntityLegendJanna>) EntityType.Builder
            .<EntityLegendJanna>create(EntityLegendJanna::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendJanna::new))
            .build(LegendarySavages.MODID + ":legend_janna")
            .setRegistryName(location("legend_janna"));
    public static final EntityType<EntityLegendJinx> LEGEND_JINX = (EntityType<EntityLegendJinx>) EntityType.Builder
            .<EntityLegendJinx>create(EntityLegendJinx::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendJinx::new))
            .build(LegendarySavages.MODID + ":legend_jinx")
            .setRegistryName(location("legend_jinx"));
    public static final EntityType<EntityLegendKaiSa> LEGEND_KAI_SA = (EntityType<EntityLegendKaiSa>) EntityType.Builder
            .<EntityLegendKaiSa>create(EntityLegendKaiSa::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendKaiSa::new))
            .build(LegendarySavages.MODID + ":legend_kai_sa")
            .setRegistryName(location("legend_kai_sa"));
    public static final EntityType<EntityLegendKarma> LEGEND_KARMA = (EntityType<EntityLegendKarma>) EntityType.Builder
            .<EntityLegendKarma>create(EntityLegendKarma::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendKarma::new))
            .build(LegendarySavages.MODID + ":legend_karma")
            .setRegistryName(location("legend_karma"));
    public static final EntityType<EntityLegendKatarina> LEGEND_KATARINA = (EntityType<EntityLegendKatarina>) EntityType.Builder
            .<EntityLegendKatarina>create(EntityLegendKatarina::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendKatarina::new))
            .build(LegendarySavages.MODID + ":legend_katarina")
            .setRegistryName(location("legend_katarina"));
    public static final EntityType<EntityLegendKindred> LEGEND_KINDRED = (EntityType<EntityLegendKindred>) EntityType.Builder
            .<EntityLegendKindred>create(EntityLegendKindred::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendKindred::new))
            .build(LegendarySavages.MODID + ":legend_kindred")
            .setRegistryName(location("legend_kindred"));
    public static final EntityType<EntityLegendLeona> LEGEND_LEONA = (EntityType<EntityLegendLeona>) EntityType.Builder
            .<EntityLegendLeona>create(EntityLegendLeona::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendLeona::new))
            .build(LegendarySavages.MODID + ":legend_leona")
            .setRegistryName(location("legend_leona"));
    public static final EntityType<EntityLegendLeBlanc> LEGEND_LE_BLANC = (EntityType<EntityLegendLeBlanc>) EntityType.Builder
            .<EntityLegendLeBlanc>create(EntityLegendLeBlanc::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendLeBlanc::new))
            .build(LegendarySavages.MODID + ":legend_le_blanc")
            .setRegistryName(location("legend_le_blanc"));
    public static final EntityType<EntityLegendLissandra> LEGEND_LISSANDRA = (EntityType<EntityLegendLissandra>) EntityType.Builder
            .<EntityLegendLissandra>create(EntityLegendLissandra::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendLissandra::new))
            .build(LegendarySavages.MODID + ":legend_lissandra")
            .setRegistryName(location("legend_lissandra"));
    public static final EntityType<EntityLegendLulu> LEGEND_LULU = (EntityType<EntityLegendLulu>) EntityType.Builder
            .<EntityLegendLulu>create(EntityLegendLulu::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendLulu::new))
            .build(LegendarySavages.MODID + ":legend_lulu")
            .setRegistryName(location("legend_lulu"));
    public static final EntityType<EntityLegendLux> LEGEND_LUX = (EntityType<EntityLegendLux>) EntityType.Builder
            .<EntityLegendLux>create(EntityLegendLux::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendLux::new))
            .build(LegendarySavages.MODID + ":legend_lux")
            .setRegistryName(location("legend_lux"));
    public static final EntityType<EntityLegendMissFortune> LEGEND_MISS_FORTUNE = (EntityType<EntityLegendMissFortune>) EntityType.Builder
            .<EntityLegendMissFortune>create(EntityLegendMissFortune::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendMissFortune::new))
            .build(LegendarySavages.MODID + ":legend_miss_fortune")
            .setRegistryName(location("legend_miss_fortune"));
    public static final EntityType<EntityLegendMorgana> LEGEND_MORGANA = (EntityType<EntityLegendMorgana>) EntityType.Builder
            .<EntityLegendMorgana>create(EntityLegendMorgana::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendMorgana::new))
            .build(LegendarySavages.MODID + ":legend_morgana")
            .setRegistryName(location("legend_morgana"));
    public static final EntityType<EntityLegendNeeko> LEGEND_NEEKO = (EntityType<EntityLegendNeeko>) EntityType.Builder
            .<EntityLegendNeeko>create(EntityLegendNeeko::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendNeeko::new))
            .build(LegendarySavages.MODID + ":legend_neeko")
            .setRegistryName(location("legend_neeko"));
    public static final EntityType<EntityLegendNidalee> LEGEND_NIDALEE = (EntityType<EntityLegendNidalee>) EntityType.Builder
            .<EntityLegendNidalee>create(EntityLegendNidalee::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendNidalee::new))
            .build(LegendarySavages.MODID + ":legend_nidalee")
            .setRegistryName(location("legend_nidalee"));
    public static final EntityType<EntityLegendOrianna> LEGEND_ORIANNA = (EntityType<EntityLegendOrianna>) EntityType.Builder
            .<EntityLegendOrianna>create(EntityLegendOrianna::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendOrianna::new))
            .build(LegendarySavages.MODID + ":legend_orianna")
            .setRegistryName(location("legend_orianna"));
    public static final EntityType<EntityLegendPoppy> LEGEND_POPPY = (EntityType<EntityLegendPoppy>) EntityType.Builder
            .<EntityLegendPoppy>create(EntityLegendPoppy::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendPoppy::new))
            .build(LegendarySavages.MODID + ":legend_poppy")
            .setRegistryName(location("legend_poppy"));
    public static final EntityType<EntityLegendQiyana> LEGEND_QIYANA = (EntityType<EntityLegendQiyana>) EntityType.Builder
            .<EntityLegendQiyana>create(EntityLegendQiyana::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendQiyana::new))
            .build(LegendarySavages.MODID + ":legend_qiyana")
            .setRegistryName(location("legend_qiyana"));
    public static final EntityType<EntityLegendQuinn> LEGEND_QUINN = (EntityType<EntityLegendQuinn>) EntityType.Builder
            .<EntityLegendQuinn>create(EntityLegendQuinn::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendQuinn::new))
            .build(LegendarySavages.MODID + ":legend_quinn")
            .setRegistryName(location("legend_quinn"));
    public static final EntityType<EntityLegendRammus> LEGEND_RAMMUS = (EntityType<EntityLegendRammus>) EntityType.Builder
            .<EntityLegendRammus>create(EntityLegendRammus::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendRammus::new))
            .build(LegendarySavages.MODID + ":legend_rammus")
            .setRegistryName(location("legend_rammus"));
    public static final EntityType<EntityLegendRiven> LEGEND_RIVEN = (EntityType<EntityLegendRiven>) EntityType.Builder
            .<EntityLegendRiven>create(EntityLegendRiven::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendRiven::new))
            .build(LegendarySavages.MODID + ":legend_riven")
            .setRegistryName(location("legend_riven"));
    public static final EntityType<EntityLegendSejuani> LEGEND_SEJUANI = (EntityType<EntityLegendSejuani>) EntityType.Builder
            .<EntityLegendSejuani>create(EntityLegendSejuani::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendSejuani::new))
            .build(LegendarySavages.MODID + ":legend_sejuani").setRegistryName(location("legend_sejuani"));
    public static final EntityType<EntityLegendShyvana> LEGEND_SHYVANA = (EntityType<EntityLegendShyvana>) EntityType.Builder
            .<EntityLegendShyvana>create(EntityLegendShyvana::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendShyvana::new))
            .build(LegendarySavages.MODID + ":legend_shyvana")
            .setRegistryName(location("legend_shyvana"));
    public static final EntityType<EntityLegendSivir> LEGEND_SIVIR = (EntityType<EntityLegendSivir>) EntityType.Builder
            .<EntityLegendSivir>create(EntityLegendSivir::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendSivir::new))
            .build(LegendarySavages.MODID + ":legend_sivir")
            .setRegistryName(location("legend_sivir"));
    public static final EntityType<EntityLegendSona> LEGEND_SONA = (EntityType<EntityLegendSona>) EntityType.Builder
            .<EntityLegendSona>create(EntityLegendSona::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendSona::new))
            .build(LegendarySavages.MODID + ":legend_sona")
            .setRegistryName(location("legend_sona"));
    public static final EntityType<EntityLegendSoraka> LEGEND_SORAKA = (EntityType<EntityLegendSoraka>) EntityType.Builder
            .<EntityLegendSoraka>create(EntityLegendSoraka::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendSoraka::new))
            .build(LegendarySavages.MODID + ":legend_soraka")
            .setRegistryName(location("legend_soraka"));
    public static final EntityType<EntityLegendSyndra> LEGEND_SYNDRA = (EntityType<EntityLegendSyndra>) EntityType.Builder
            .<EntityLegendSyndra>create(EntityLegendSyndra::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendSyndra::new))
            .build(LegendarySavages.MODID + ":legend_syndra")
            .setRegistryName(location("legend_syndra"));
    public static final EntityType<EntityLegendTaliyah> LEGEND_TALIYAH = (EntityType<EntityLegendTaliyah>) EntityType.Builder
            .<EntityLegendTaliyah>create(EntityLegendTaliyah::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendTaliyah::new))
            .build(LegendarySavages.MODID + ":legend_taliyah")
            .setRegistryName(location("legend_taliyah"));
    public static final EntityType<EntityLegendTeemo> LEGEND_TEEMO = (EntityType<EntityLegendTeemo>) EntityType.Builder
            .<EntityLegendTeemo>create(EntityLegendTeemo::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendTeemo::new))
            .build(LegendarySavages.MODID + ":legend_teemo")
            .setRegistryName(location("legend_teemo"));
    public static final EntityType<EntityLegendTristana> LEGEND_TRISTANA = (EntityType<EntityLegendTristana>) EntityType.Builder
            .<EntityLegendTristana>create(EntityLegendTristana::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendTristana::new))
            .build(LegendarySavages.MODID + ":legend_tristana")
            .setRegistryName(location("legend_tristana"));
    public static final EntityType<EntityLegendVayne> LEGEND_VAYNE = (EntityType<EntityLegendVayne>) EntityType.Builder
            .<EntityLegendVayne>create(EntityLegendVayne::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendVayne::new))
            .build(LegendarySavages.MODID + ":legend_vayne")
            .setRegistryName(location("legend_vayne"));
    public static final EntityType<EntityLegendVi> LEGEND_VI = (EntityType<EntityLegendVi>) EntityType.Builder
            .<EntityLegendVi>create(EntityLegendVi::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendVi::new))
            .build(LegendarySavages.MODID + ":legend_vi")
            .setRegistryName(location("legend_vi"));
    public static final EntityType<EntityLegendXayah> LEGEND_XAYAH = (EntityType<EntityLegendXayah>) EntityType.Builder
            .<EntityLegendXayah>create(EntityLegendXayah::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendXayah::new))
            .build(LegendarySavages.MODID + ":legend_xayah")
            .setRegistryName(location("legend_xayah"));
    public static final EntityType<EntityLegendYuumi> LEGEND_YUUMI = (EntityType<EntityLegendYuumi>) EntityType.Builder
            .<EntityLegendYuumi>create(EntityLegendYuumi::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendYuumi::new))
            .build(LegendarySavages.MODID + ":legend_yuumi")
            .setRegistryName(location("legend_yuumi"));
    public static final EntityType<EntityLegendZac> LEGEND_ZAC = (EntityType<EntityLegendZac>) EntityType.Builder
            .<EntityLegendZac>create(EntityLegendZac::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendZac::new))
            .build(LegendarySavages.MODID + ":legend_zac")
            .setRegistryName(location("legend_zac"));
    public static final EntityType<EntityLegendZoe> LEGEND_ZOE = (EntityType<EntityLegendZoe>) EntityType.Builder
            .<EntityLegendZoe>create(EntityLegendZoe::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendZoe::new))
            .build(LegendarySavages.MODID + ":legend_zoe")
            .setRegistryName(location("legend_zoe"));
    public static final EntityType<EntityLegendZyra> LEGEND_ZYRA = (EntityType<EntityLegendZyra>) EntityType.Builder
            .<EntityLegendZyra>create(EntityLegendZyra::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendZyra::new))
            .build(LegendarySavages.MODID + ":legend_zyra")
            .setRegistryName(location("legend_zyra"));

    public static final EntityType<EntityYetiBestiaGlacies> YETI_BESTIA_GLACIES = (EntityType<EntityYetiBestiaGlacies>) EntityType.Builder
            .<EntityYetiBestiaGlacies>create(EntityYetiBestiaGlacies::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityYetiBestiaGlacies::new))
            .build(LegendarySavages.MODID + ":yeti_bestia_glacies")
            .setRegistryName(location("yeti_bestia_glacies"));
    public static final EntityType<EntityYetiSasquatch> YETI_SASQUATCH = (EntityType<EntityYetiSasquatch>) EntityType.Builder
            .<EntityYetiSasquatch>create(EntityYetiSasquatch::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityYetiSasquatch::new))
            .build(LegendarySavages.MODID + ":yeti_sasquatch")
            .setRegistryName(location("yeti_sasquatch"));

    public static final EntityType<EntityDivineKayle> DIVINE_KAYLE = (EntityType<EntityDivineKayle>) EntityType.Builder
            .<EntityDivineKayle>create(EntityDivineKayle::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityDivineKayle::new))
            .build(LegendarySavages.MODID + ":divine_kayle")
            .setRegistryName(location("divine_kayle"));
    public static final EntityType<EntityGuardianNami> GUARDIAN_NAMI = (EntityType<EntityGuardianNami>) EntityType.Builder
            .<EntityGuardianNami>create(EntityGuardianNami::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityGuardianNami::new))
            .build(LegendarySavages.MODID + ":guardian_nami")
            .setRegistryName(location("guardian_nami"));

    public static final EntityType<EntityLegendaryAatrox> LEGENDARY_AATROX = (EntityType<EntityLegendaryAatrox>) EntityType.Builder
            .<EntityLegendaryAatrox>create(EntityLegendaryAatrox::new, EntityClassification.MONSTER)
            .size(0.8f, 2.3f)
            .setCustomClientFactory((EntityLegendaryAatrox::new))
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(32)
            .setUpdateInterval(1)
            .build(LegendarySavages.MODID + ":legendary_aatrox")
            .setRegistryName(location("legendary_aatrox"));
    public static final EntityType<EntityLegendaryAlistar> LEGENDARY_ALISTAR = (EntityType<EntityLegendaryAlistar>) EntityType.Builder
            .<EntityLegendaryAlistar>create(EntityLegendaryAlistar::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryAlistar::new))
            .build(LegendarySavages.MODID + ":legendary_alistar")
            .setRegistryName(location("legendary_alistar"));
    public static final EntityType<EntityLegendaryAphelios> LEGENDARY_APHELIOS = (EntityType<EntityLegendaryAphelios>) EntityType.Builder
            .<EntityLegendaryAphelios>create(EntityLegendaryAphelios::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryAphelios::new))
            .build(LegendarySavages.MODID + ":legendary_aphelios")
            .setRegistryName(location("legendary_aphelios"));
    public static final EntityType<EntityLegendaryAurelionSol> LEGENDARY_AURELION_SOL = (EntityType<EntityLegendaryAurelionSol>) EntityType.Builder
            .<EntityLegendaryAurelionSol>create(EntityLegendaryAurelionSol::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryAurelionSol::new))
            .build(LegendarySavages.MODID + ":legendary_aurelion_sol")
            .setRegistryName(location("legendary_aurelion_sol"));
    public static final EntityType<EntityLegendaryAzir> LEGENDARY_AZIR = (EntityType<EntityLegendaryAzir>) EntityType.Builder
            .<EntityLegendaryAzir>create(EntityLegendaryAzir::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryAzir::new))
            .build(LegendarySavages.MODID + ":legendary_azir")
            .setRegistryName(location("legendary_azir"));
    public static final EntityType<EntityLegendaryBard> LEGENDARY_BARD = (EntityType<EntityLegendaryBard>) EntityType.Builder
            .<EntityLegendaryBard>create(EntityLegendaryBard::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryBard::new))
            .build(LegendarySavages.MODID + ":legendary_bard")
            .setRegistryName(location("legendary_bard"));
    public static final EntityType<EntityLegendaryBlitzcrank> LEGENDARY_BLITZCRANK = (EntityType<EntityLegendaryBlitzcrank>) EntityType.Builder
            .<EntityLegendaryBlitzcrank>create(EntityLegendaryBlitzcrank::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryBlitzcrank::new))
            .build(LegendarySavages.MODID + ":legendary_blitzcrank")
            .setRegistryName(location("legendary_blitzcrank"));
    public static final EntityType<EntityLegendaryBraum> LEGENDARY_BRAUM = (EntityType<EntityLegendaryBraum>) EntityType.Builder
            .<EntityLegendaryBraum>create(EntityLegendaryBraum::new, EntityClassification.MONSTER)
            .setCustomClientFactory(EntityLegendaryBraum::new)
            .build(LegendarySavages.MODID + ":legendary_braum")
            .setRegistryName(location("legendary_braum"));
    public static final EntityType<EntityLegendaryChoGath> LEGENDARY_CHO_GATH = (EntityType<EntityLegendaryChoGath>) EntityType.Builder
            .<EntityLegendaryChoGath>create(EntityLegendaryChoGath::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryChoGath::new))
            .build(LegendarySavages.MODID + ":legendary_cho_gath")
            .setRegistryName(location("legendary_cho_gath"));
    public static final EntityType<EntityLegendaryCorki> LEGENDARY_CORKI = (EntityType<EntityLegendaryCorki>) EntityType.Builder
            .<EntityLegendaryCorki>create(EntityLegendaryCorki::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryCorki::new))
            .build(LegendarySavages.MODID + ":legendary_corki")
            .setRegistryName(location("legendary_corki"));
    public static final EntityType<EntityLegendaryCyroBrand> LEGENDARY_CYRO_BRAND = (EntityType<EntityLegendaryCyroBrand>) EntityType.Builder
            .<EntityLegendaryCyroBrand>create(EntityLegendaryCyroBrand::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryCyroBrand::new))
            .build(LegendarySavages.MODID + ":legendary_cyro_brand")
            .setRegistryName(location("legendary_cyro_brand"));
    public static final EntityType<EntityLegendaryDarius> LEGENDARY_DARIUS = (EntityType<EntityLegendaryDarius>) EntityType.Builder
            .<EntityLegendaryDarius>create(EntityLegendaryDarius::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryDarius::new))
            .build(LegendarySavages.MODID + ":legendary_darius")
            .setRegistryName(location("legendary_darius"));
    public static final EntityType<EntityLegendaryDraven> LEGENDARY_DRAVEN = (EntityType<EntityLegendaryDraven>) EntityType.Builder
            .<EntityLegendaryDraven>create(EntityLegendaryDraven::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryDraven::new))
            .build(LegendarySavages.MODID + ":legendary_draven")
            .setRegistryName(location("legendary_draven"));
    public static final EntityType<EntityLegendaryDrMundo> LEGENDARY_DR_MUNDO = (EntityType<EntityLegendaryDrMundo>) EntityType.Builder
            .<EntityLegendaryDrMundo>create(EntityLegendaryDrMundo::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryDrMundo::new))
            .build(LegendarySavages.MODID + ":legendary_dr_mundo")
            .setRegistryName(location("legendary_dr_mundo"));
    public static final EntityType<EntityLegendaryEkko> LEGENDARY_EKKO = (EntityType<EntityLegendaryEkko>) EntityType.Builder
            .<EntityLegendaryEkko>create(EntityLegendaryEkko::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryEkko::new))
            .build(LegendarySavages.MODID + ":legendary_ekko")
            .setRegistryName(location("legendary_ekko"));
    public static final EntityType<EntityLegendaryEzreal> LEGENDARY_EZREAL = (EntityType<EntityLegendaryEzreal>) EntityType.Builder
            .<EntityLegendaryEzreal>create(EntityLegendaryEzreal::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryEzreal::new))
            .build(LegendarySavages.MODID + ":legendary_ezreal")
            .setRegistryName(location("legendary_ezreal"));
    public static final EntityType<EntityLegendaryFiddlesticks> LEGENDARY_FIDDLESTICKS = (EntityType<EntityLegendaryFiddlesticks>) EntityType.Builder
            .<EntityLegendaryFiddlesticks>create(EntityLegendaryFiddlesticks::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryFiddlesticks::new))
            .build(LegendarySavages.MODID + ":legendary_fiddlesticks")
            .setRegistryName(location("legendary_fiddlesticks"));
    public static final EntityType<EntityLegendaryGalio> LEGENDARY_GALIO = (EntityType<EntityLegendaryGalio>) EntityType.Builder
            .<EntityLegendaryGalio>create(EntityLegendaryGalio::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryGalio::new))
            .build(LegendarySavages.MODID + ":legendary_galio")
            .setRegistryName(location("legendary_galio"));
    public static final EntityType<EntityLegendaryGangplank> LEGENDARY_GANGPLANK = (EntityType<EntityLegendaryGangplank>) EntityType.Builder
            .<EntityLegendaryGangplank>create(EntityLegendaryGangplank::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryGangplank::new))
            .build(LegendarySavages.MODID + ":legendary_gangplank")
            .setRegistryName(location("legendary_gangplank"));
    public static final EntityType<EntityLegendaryGaren> LEGENDARY_GAREN = (EntityType<EntityLegendaryGaren>) EntityType.Builder
            .<EntityLegendaryGaren>create(EntityLegendaryGaren::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryGaren::new))
            .build(LegendarySavages.MODID + ":legendary_garen")
            .setRegistryName(location("legendary_garen"));
    public static final EntityType<EntityLegendaryGragas> LEGENDARY_GRAGAS = (EntityType<EntityLegendaryGragas>) EntityType.Builder
            .<EntityLegendaryGragas>create(EntityLegendaryGragas::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryGragas::new))
            .build(LegendarySavages.MODID + ":legendary_gragas")
            .setRegistryName(location("legendary_gragas"));
    public static final EntityType<EntityLegendaryGraves> LEGENDARY_GRAVES = (EntityType<EntityLegendaryGraves>) EntityType.Builder
            .<EntityLegendaryGraves>create(EntityLegendaryGraves::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryGraves::new))
            .build(LegendarySavages.MODID + ":legendary_graves")
            .setRegistryName(location("legendary_graves"));
    public static final EntityType<EntityLegendaryHecarim> LEGENDARY_HECARIM = (EntityType<EntityLegendaryHecarim>) EntityType.Builder
            .<EntityLegendaryHecarim>create(EntityLegendaryHecarim::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryHecarim::new))
            .build(LegendarySavages.MODID + ":legendary_hecarim")
            .setRegistryName(location("legendary_hecarim"));
    public static final EntityType<EntityLegendaryHeimerdinger> LEGENDARY_HEIMERDINGER = (EntityType<EntityLegendaryHeimerdinger>) EntityType.Builder
            .<EntityLegendaryHeimerdinger>create(EntityLegendaryHeimerdinger::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryHeimerdinger::new))
            .build(LegendarySavages.MODID + ":legendary_heimerdinger")
            .setRegistryName(location("legendary_heimerdinger"));
    public static final EntityType<EntityLegendaryIvern> LEGENDARY_IVERN = (EntityType<EntityLegendaryIvern>) EntityType.Builder
            .<EntityLegendaryIvern>create(EntityLegendaryIvern::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryIvern::new))
            .build(LegendarySavages.MODID + ":legendary_ivern")
            .setRegistryName(location("legendary_ivern"));
    public static final EntityType<EntityLegendaryJarvanIV> LEGENDARY_JARVAN_IV = (EntityType<EntityLegendaryJarvanIV>) EntityType.Builder
            .<EntityLegendaryJarvanIV>create(EntityLegendaryJarvanIV::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryJarvanIV::new))
            .build(LegendarySavages.MODID + ":legendary_jarvan_iv")
            .setRegistryName(location("legendary_jarvan_iv"));
    public static final EntityType<EntityLegendaryJax> LEGENDARY_JAX = (EntityType<EntityLegendaryJax>) EntityType.Builder
            .<EntityLegendaryJax>create(EntityLegendaryJax::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryJax::new))
            .build(LegendarySavages.MODID + ":legendary_jax")
            .setRegistryName(location("legendary_jax"));
    public static final EntityType<EntityLegendaryJayce> LEGENDARY_JAYCE = (EntityType<EntityLegendaryJayce>) EntityType.Builder
            .<EntityLegendaryJayce>create(EntityLegendaryJayce::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryJayce::new))
            .build(LegendarySavages.MODID + ":legendary_jayce")
            .setRegistryName(location("legendary_jayce"));
    public static final EntityType<EntityLegendaryJhin> LEGENDARY_JHIN = (EntityType<EntityLegendaryJhin>) EntityType.Builder
            .<EntityLegendaryJhin>create(EntityLegendaryJhin::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryJhin::new))
            .build(LegendarySavages.MODID + ":legendary_jhin")
            .setRegistryName(location("legendary_jhin"));
    public static final EntityType<EntityLegendaryKalista> LEGENDARY_KALISTA = (EntityType<EntityLegendaryKalista>) EntityType.Builder
            .<EntityLegendaryKalista>create(EntityLegendaryKalista::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryKalista::new))
            .build(LegendarySavages.MODID + ":legendary_kalista")
            .setRegistryName(location("legendary_kalista"));
    public static final EntityType<EntityLegendaryKarthus> LEGENDARY_KARTHUS = (EntityType<EntityLegendaryKarthus>) EntityType.Builder
            .<EntityLegendaryKarthus>create(EntityLegendaryKarthus::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryKarthus::new))
            .build(LegendarySavages.MODID + ":legendary_karthus")
            .setRegistryName(location("legendary_karthus"));
    public static final EntityType<EntityLegendaryKassadin> LEGENDARY_KASSADIN = (EntityType<EntityLegendaryKassadin>) EntityType.Builder
            .<EntityLegendaryKassadin>create(EntityLegendaryKassadin::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryKassadin::new))
            .build(LegendarySavages.MODID + ":legendary_kassadin")
            .setRegistryName(location("legendary_kassadin"));
    public static final EntityType<EntityLegendaryKayn> LEGENDARY_KAYN = (EntityType<EntityLegendaryKayn>) EntityType.Builder
            .<EntityLegendaryKayn>create(EntityLegendaryKayn::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryKayn::new))
            .build(LegendarySavages.MODID + ":legendary_kayn")
            .setRegistryName(location("legendary_kayn"));
    public static final EntityType<EntityLegendaryKennen> LEGENDARY_KENNEN = (EntityType<EntityLegendaryKennen>) EntityType.Builder
            .<EntityLegendaryKennen>create(EntityLegendaryKennen::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryKennen::new))
            .build(LegendarySavages.MODID + ":legendary_kennen")
            .setRegistryName(location("legendary_kennen"));
    public static final EntityType<EntityLegendaryKhaZix> LEGENDARY_KHA_ZIX = (EntityType<EntityLegendaryKhaZix>) EntityType.Builder
            .<EntityLegendaryKhaZix>create(EntityLegendaryKhaZix::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryKhaZix::new))
            .build(LegendarySavages.MODID + ":legendary_kha_zix")
            .setRegistryName(location("legendary_kha_zix"));
    public static final EntityType<EntityLegendaryKled> LEGENDARY_KLED = (EntityType<EntityLegendaryKled>) EntityType.Builder
            .<EntityLegendaryKled>create(EntityLegendaryKled::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryKled::new))
            .build(LegendarySavages.MODID + ":legendary_kled")
            .setRegistryName(location("legendary_kled"));
    public static final EntityType<EntityLegendaryKogMaw> LEGENDARY_KOG_MAW = (EntityType<EntityLegendaryKogMaw>) EntityType.Builder
            .<EntityLegendaryKogMaw>create(EntityLegendaryKogMaw::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryKogMaw::new))
            .build(LegendarySavages.MODID + ":legendary_kog_maw")
            .setRegistryName(location("legendary_kog_maw"));
    public static final EntityType<EntityLegendaryLeeSin> LEGENDARY_LEE_SIN = (EntityType<EntityLegendaryLeeSin>) EntityType.Builder
            .<EntityLegendaryLeeSin>create(EntityLegendaryLeeSin::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryLeeSin::new))
            .build(LegendarySavages.MODID + ":legendary_lee_sin")
            .setRegistryName(location("legendary_lee_sin"));
    public static final EntityType<EntityLegendaryLucian> LEGENDARY_LUCIAN = (EntityType<EntityLegendaryLucian>) EntityType.Builder
            .<EntityLegendaryLucian>create(EntityLegendaryLucian::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryLucian::new))
            .build(LegendarySavages.MODID + ":legendary_lucian")
            .setRegistryName(location("legendary_lucian"));
    public static final EntityType<EntityLegendaryMalphite> LEGENDARY_MALPHITE = (EntityType<EntityLegendaryMalphite>) EntityType.Builder
            .<EntityLegendaryMalphite>create(EntityLegendaryMalphite::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryMalphite::new))
            .build(LegendarySavages.MODID + ":legendary_malphite")
            .setRegistryName(location("legendary_malphite"));
    public static final EntityType<EntityLegendaryMalzahar> LEGENDARY_MALZAHAR = (EntityType<EntityLegendaryMalzahar>) EntityType.Builder
            .<EntityLegendaryMalzahar>create(EntityLegendaryMalzahar::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryMalzahar::new))
            .build(LegendarySavages.MODID + ":legendary_malzahar")
            .setRegistryName(location("legendary_malzahar"));
    public static final EntityType<EntityLegendaryMaokai> LEGENDARY_MAOKAI = (EntityType<EntityLegendaryMaokai>) EntityType.Builder
            .<EntityLegendaryMaokai>create(EntityLegendaryMaokai::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryMaokai::new))
            .build(LegendarySavages.MODID + ":legendary_maokai")
            .setRegistryName(location("legendary_maokai"));
    public static final EntityType<EntityLegendaryMasterYi> LEGENDARY_MASTER_YI = (EntityType<EntityLegendaryMasterYi>) EntityType.Builder
            .<EntityLegendaryMasterYi>create(EntityLegendaryMasterYi::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryMasterYi::new))
            .build(LegendarySavages.MODID + ":legendary_master_yi")
            .setRegistryName(location("legendary_master_yi"));
    public static final EntityType<EntityLegendaryMordekaiser> LEGENDARY_MORDEKAISER = (EntityType<EntityLegendaryMordekaiser>) EntityType.Builder
            .<EntityLegendaryMordekaiser>create(EntityLegendaryMordekaiser::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryMordekaiser::new))
            .build(LegendarySavages.MODID + ":legendary_mordekaiser")
            .setRegistryName(location("legendary_mordekaiser"));
    public static final EntityType<EntityLegendaryNasus> LEGENDARY_NASUS = (EntityType<EntityLegendaryNasus>) EntityType.Builder
            .<EntityLegendaryNasus>create(EntityLegendaryNasus::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryNasus::new))
            .build(LegendarySavages.MODID + ":legendary_nasus")
            .setRegistryName(location("legendary_nasus"));
    public static final EntityType<EntityLegendaryNautilus> LEGENDARY_NAUTILUS = (EntityType<EntityLegendaryNautilus>) EntityType.Builder
            .<EntityLegendaryNautilus>create(EntityLegendaryNautilus::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryNautilus::new))
            .build(LegendarySavages.MODID + ":legendary_nautilus")
            .setRegistryName(location("legendary_nautilus"));
    public static final EntityType<EntityLegendaryNocturne> LEGENDARY_NOCTURNE = (EntityType<EntityLegendaryNocturne>) EntityType.Builder
            .<EntityLegendaryNocturne>create(EntityLegendaryNocturne::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryNocturne::new))
            .build(LegendarySavages.MODID + ":legendary_nocturne")
            .setRegistryName(location("legendary_nocturne"));
    public static final EntityType<EntityLegendaryNunu> LEGENDARY_NUNU = (EntityType<EntityLegendaryNunu>) EntityType.Builder
            .<EntityLegendaryNunu>create(EntityLegendaryNunu::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryNunu::new))
            .build(LegendarySavages.MODID + ":legendary_nunu")
            .setRegistryName(location("legendary_nunu"));
    public static final EntityType<EntityLegendaryOlaf> LEGENDARY_OLAF = (EntityType<EntityLegendaryOlaf>) EntityType.Builder
            .<EntityLegendaryOlaf>create(EntityLegendaryOlaf::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryOlaf::new))
            .build(LegendarySavages.MODID + ":legendary_olaf")
            .setRegistryName(location("legendary_olaf"));
    public static final EntityType<EntityLegendaryOrnn> LEGENDARY_ORNN = (EntityType<EntityLegendaryOrnn>) EntityType.Builder
            .<EntityLegendaryOrnn>create(EntityLegendaryOrnn::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryOrnn::new))
            .build(LegendarySavages.MODID + ":legendary_ornn")
            .setRegistryName(location("legendary_ornn"));
    public static final EntityType<EntityLegendaryPantheon> LEGENDARY_PANTHEON = (EntityType<EntityLegendaryPantheon>) EntityType.Builder
            .<EntityLegendaryPantheon>create(EntityLegendaryPantheon::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryPantheon::new))
            .build(LegendarySavages.MODID + ":legendary_pantheon")
            .setRegistryName(location("legendary_pantheon"));
    public static final EntityType<EntityLegendaryPyke> LEGENDARY_PYKE = (EntityType<EntityLegendaryPyke>) EntityType.Builder
            .<EntityLegendaryPyke>create(EntityLegendaryPyke::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryPyke::new))
            .build(LegendarySavages.MODID + ":legendary_pyke")
            .setRegistryName(location("legendary_pyke"));
    public static final EntityType<EntityLegendaryRakan> LEGENDARY_RAKAN = (EntityType<EntityLegendaryRakan>) EntityType.Builder
            .<EntityLegendaryRakan>create(EntityLegendaryRakan::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryRakan::new))
            .build(LegendarySavages.MODID + ":legendary_rakan")
            .setRegistryName(location("legendary_rakan"));
    public static final EntityType<EntityLegendaryRekSai> LEGENDARY_REK_SAI = (EntityType<EntityLegendaryRekSai>) EntityType.Builder
            .<EntityLegendaryRekSai>create(EntityLegendaryRekSai::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryRekSai::new))
            .build(LegendarySavages.MODID + ":legendary_rek_sai")
            .setRegistryName(location("legendary_rek_sai"));
    public static final EntityType<EntityLegendaryRenekton> LEGENDARY_RENEKTON = (EntityType<EntityLegendaryRenekton>) EntityType.Builder
            .<EntityLegendaryRenekton>create(EntityLegendaryRenekton::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryRenekton::new))
            .build(LegendarySavages.MODID + ":legendary_renekton")
            .setRegistryName(location("legendary_renekton"));
    public static final EntityType<EntityLegendaryRengar> LEGENDARY_RENGAR = (EntityType<EntityLegendaryRengar>) EntityType.Builder
            .<EntityLegendaryRengar>create(EntityLegendaryRengar::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryRengar::new))
            .build(LegendarySavages.MODID + ":legendary_rengar")
            .setRegistryName(location("legendary_rengar"));
    public static final EntityType<EntityLegendaryRumble> LEGENDARY_RUMBLE = (EntityType<EntityLegendaryRumble>) EntityType.Builder
            .<EntityLegendaryRumble>create(EntityLegendaryRumble::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryRumble::new))
            .build(LegendarySavages.MODID + ":legendary_rumble")
            .setRegistryName(location("legendary_rumble"));
    public static final EntityType<EntityLegendaryRyze> LEGENDARY_RYZE = (EntityType<EntityLegendaryRyze>) EntityType.Builder
            .<EntityLegendaryRyze>create(EntityLegendaryRyze::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryRyze::new))
            .build(LegendarySavages.MODID + ":legendary_ryze")
            .setRegistryName(location("legendary_ryze"));
    public static final EntityType<EntityLegendarySett> LEGENDARY_SETT = (EntityType<EntityLegendarySett>) EntityType.Builder
            .<EntityLegendarySett>create(EntityLegendarySett::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendarySett::new))
            .build(LegendarySavages.MODID + ":legendary_sett")
            .setRegistryName(location("legendary_sett"));
    public static final EntityType<EntityLegendaryShaco> LEGENDARY_SHACO = (EntityType<EntityLegendaryShaco>) EntityType.Builder
            .<EntityLegendaryShaco>create(EntityLegendaryShaco::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryShaco::new))
            .build(LegendarySavages.MODID + ":legendary_shaco")
            .setRegistryName(location("legendary_shaco"));
    public static final EntityType<EntityLegendaryShen> LEGENDARY_SHEN = (EntityType<EntityLegendaryShen>) EntityType.Builder
            .<EntityLegendaryShen>create(EntityLegendaryShen::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryShen::new))
            .build(LegendarySavages.MODID + ":legendary_shen")
            .setRegistryName(location("legendary_shen"));
    public static final EntityType<EntityLegendarySinged> LEGENDARY_SINGED = (EntityType<EntityLegendarySinged>) EntityType.Builder
            .<EntityLegendarySinged>create(EntityLegendarySinged::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendarySinged::new))
            .build(LegendarySavages.MODID + ":legendary_singed")
            .setRegistryName(location("legendary_singed"));
    public static final EntityType<EntityLegendarySion> LEGENDARY_SION = (EntityType<EntityLegendarySion>) EntityType.Builder
            .<EntityLegendarySion>create(EntityLegendarySion::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendarySion::new))
            .build(LegendarySavages.MODID + ":legendary_sion")
            .setRegistryName(location("legendary_sion"));
    public static final EntityType<EntityLegendarySkarner> LEGENDARY_SKARNER = (EntityType<EntityLegendarySkarner>) EntityType.Builder
            .<EntityLegendarySkarner>create(EntityLegendarySkarner::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendarySkarner::new))
            .build(LegendarySavages.MODID + ":legendary_skarner")
            .setRegistryName(location("legendary_skarner"));
    public static final EntityType<EntityLegendarySwain> LEGENDARY_SWAIN = (EntityType<EntityLegendarySwain>) EntityType.Builder
            .<EntityLegendarySwain>create(EntityLegendarySwain::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendarySwain::new))
            .build(LegendarySavages.MODID + ":legendary_swain")
            .setRegistryName(location("legendary_swain"));
    public static final EntityType<EntityLegendarySylas> LEGENDARY_SYLAS = (EntityType<EntityLegendarySylas>) EntityType.Builder
            .<EntityLegendarySylas>create(EntityLegendarySylas::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendarySylas::new))
            .build(LegendarySavages.MODID + ":legendary_sylas")
            .setRegistryName(location("legendary_sylas"));
    public static final EntityType<EntityLegendaryTahmKench> LEGENDARY_TAHM_KENCH = (EntityType<EntityLegendaryTahmKench>) EntityType.Builder
            .<EntityLegendaryTahmKench>create(EntityLegendaryTahmKench::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryTahmKench::new))
            .build(LegendarySavages.MODID + ":legendary_tahm_kench")
            .setRegistryName(location("legendary_tahm_kench"));
    public static final EntityType<EntityLegendaryTalon> LEGENDARY_TALON = (EntityType<EntityLegendaryTalon>) EntityType.Builder
            .<EntityLegendaryTalon>create(EntityLegendaryTalon::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryTalon::new))
            .build(LegendarySavages.MODID + ":legendary_talon")
            .setRegistryName(location("legendary_talon"));
    public static final EntityType<EntityLegendaryTaric> LEGENDARY_TARIC = (EntityType<EntityLegendaryTaric>) EntityType.Builder
            .<EntityLegendaryTaric>create(EntityLegendaryTaric::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryTaric::new))
            .build(LegendarySavages.MODID + ":legendary_taric")
            .setRegistryName(location("legendary_taric"));
    public static final EntityType<EntityLegendaryThresh> LEGENDARY_THRESH = (EntityType<EntityLegendaryThresh>) EntityType.Builder
            .<EntityLegendaryThresh>create(EntityLegendaryThresh::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryThresh::new))
            .build(LegendarySavages.MODID + ":legendary_thresh")
            .setRegistryName(location("legendary_thresh"));
    public static final EntityType<EntityLegendaryTrundle> LEGENDARY_TRUNDLE = (EntityType<EntityLegendaryTrundle>) EntityType.Builder
            .<EntityLegendaryTrundle>create(EntityLegendaryTrundle::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryTrundle::new))
            .build(LegendarySavages.MODID + ":legendary_trundle")
            .setRegistryName(location("legendary_trundle"));
    public static final EntityType<EntityLegendaryTryndamere> LEGENDARY_TRYNDAMERE = (EntityType<EntityLegendaryTryndamere>) EntityType.Builder
            .<EntityLegendaryTryndamere>create(EntityLegendaryTryndamere::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryTryndamere::new))
            .build(LegendarySavages.MODID + ":legendary_tryndamere")
            .setRegistryName(location("legendary_tryndamere"));
    public static final EntityType<EntityLegendaryTwistedFate> LEGENDARY_TWISTED_FATE = (EntityType<EntityLegendaryTwistedFate>) EntityType.Builder
            .<EntityLegendaryTwistedFate>create(EntityLegendaryTwistedFate::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryTwistedFate::new))
            .build(LegendarySavages.MODID + ":legendary_twisted_fate")
            .setRegistryName(location("legendary_twisted_fate"));
    public static final EntityType<EntityLegendaryTwitch> LEGENDARY_TWITCH = (EntityType<EntityLegendaryTwitch>) EntityType.Builder
            .<EntityLegendaryTwitch>create(EntityLegendaryTwitch::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryTwitch::new))
            .build(LegendarySavages.MODID + ":legendary_twitch")
            .setRegistryName(location("legendary_twitch"));
    public static final EntityType<EntityLegendaryUdyr> LEGENDARY_UDYR = (EntityType<EntityLegendaryUdyr>) EntityType.Builder
            .<EntityLegendaryUdyr>create(EntityLegendaryUdyr::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryUdyr::new))
            .build(LegendarySavages.MODID + ":legendary_udyr")
            .setRegistryName(location("legendary_udyr"));
    public static final EntityType<EntityLegendaryUrgot> LEGENDARY_URGOT = (EntityType<EntityLegendaryUrgot>) EntityType.Builder
            .<EntityLegendaryUrgot>create(EntityLegendaryUrgot::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryUrgot::new))
            .build(LegendarySavages.MODID + ":legendary_urgot")
            .setRegistryName(location("legendary_urgot"));
    public static final EntityType<EntityLegendaryVarus> LEGENDARY_VARUS = (EntityType<EntityLegendaryVarus>) EntityType.Builder
            .<EntityLegendaryVarus>create(EntityLegendaryVarus::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryVarus::new))
            .build(LegendarySavages.MODID + ":legendary_varus")
            .setRegistryName(location("legendary_varus"));
    public static final EntityType<EntityLegendaryVeigar> LEGENDARY_VEIGAR = (EntityType<EntityLegendaryVeigar>) EntityType.Builder
            .<EntityLegendaryVeigar>create(EntityLegendaryVeigar::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryVeigar::new))
            .build(LegendarySavages.MODID + ":legendary_veigar")
            .setRegistryName(location("legendary_veigar"));
    public static final EntityType<EntityLegendaryVelKoz> LEGENDARY_VEL_KOZ = (EntityType<EntityLegendaryVelKoz>) EntityType.Builder
            .<EntityLegendaryVelKoz>create(EntityLegendaryVelKoz::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryVelKoz::new))
            .build(LegendarySavages.MODID + ":legendary_vel_koz")
            .setRegistryName(location("legendary_vel_koz"));
    public static final EntityType<EntityLegendaryViktor> LEGENDARY_VIKTOR = (EntityType<EntityLegendaryViktor>) EntityType.Builder
            .<EntityLegendaryViktor>create(EntityLegendaryViktor::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryViktor::new))
            .build(LegendarySavages.MODID + ":legendary_viktor")
            .setRegistryName(location("legendary_viktor"));
    public static final EntityType<EntityLegendaryVladimir> LEGENDARY_VLADIMIR = (EntityType<EntityLegendaryVladimir>) EntityType.Builder
            .<EntityLegendaryVladimir>create(EntityLegendaryVladimir::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryVladimir::new))
            .build(LegendarySavages.MODID + ":legendary_vladimir")
            .setRegistryName(location("legendary_vladimir"));
    public static final EntityType<EntityLegendaryVolibear> LEGENDARY_VOLIBEAR = (EntityType<EntityLegendaryVolibear>) EntityType.Builder
            .<EntityLegendaryVolibear>create(EntityLegendaryVolibear::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryVolibear::new))
            .build(LegendarySavages.MODID + ":legendary_volibear")
            .setRegistryName(location("legendary_volibear"));
    public static final EntityType<EntityLegendaryWarwick> LEGENDARY_WARWICK = (EntityType<EntityLegendaryWarwick>) EntityType.Builder
            .<EntityLegendaryWarwick>create(EntityLegendaryWarwick::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryWarwick::new))
            .build(LegendarySavages.MODID + ":legendary_warwick")
            .setRegistryName(location("legendary_warwick"));
    public static final EntityType<EntityLegendaryWillump> LEGENDARY_WILLUMP = (EntityType<EntityLegendaryWillump>) EntityType.Builder
            .<EntityLegendaryWillump>create(EntityLegendaryWillump::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryWillump::new))
            .build(LegendarySavages.MODID + ":legendary_willump")
            .setRegistryName(location("legendary_willump"));
    public static final EntityType<EntityLegendaryWukong> LEGENDARY_WUKONG = (EntityType<EntityLegendaryWukong>) EntityType.Builder
            .<EntityLegendaryWukong>create(EntityLegendaryWukong::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryWukong::new))
            .build(LegendarySavages.MODID + ":legendary_wukong")
            .setRegistryName(location("legendary_wukong"));
    public static final EntityType<EntityLegendaryXerath> LEGENDARY_XERATH = (EntityType<EntityLegendaryXerath>) EntityType.Builder
            .<EntityLegendaryXerath>create(EntityLegendaryXerath::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryXerath::new))
            .build(LegendarySavages.MODID + ":legendary_xerath")
            .setRegistryName(location("legendary_xerath"));
    public static final EntityType<EntityLegendaryXinZhao> LEGENDARY_XIN_ZHAO = (EntityType<EntityLegendaryXinZhao>) EntityType.Builder
            .<EntityLegendaryXinZhao>create(EntityLegendaryXinZhao::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryXinZhao::new))
            .build(LegendarySavages.MODID + ":legendary_xin_zhao")
            .setRegistryName(location("legendary_xin_zhao"));
    public static final EntityType<EntityLegendaryYasuo> LEGENDARY_YASUO = (EntityType<EntityLegendaryYasuo>) EntityType.Builder
            .<EntityLegendaryYasuo>create(EntityLegendaryYasuo::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryYasuo::new))
            .build(LegendarySavages.MODID + ":legendary_yasuo")
            .setRegistryName(location("legendary_yasuo"));
    public static final EntityType<EntityLegendaryYorick> LEGENDARY_YORICK = (EntityType<EntityLegendaryYorick>) EntityType.Builder
            .<EntityLegendaryYorick>create(EntityLegendaryYorick::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryYorick::new))
            .build(LegendarySavages.MODID + ":legendary_yorick")
            .setRegistryName(location("legendary_yorick"));
    public static final EntityType<EntityLegendaryZed> LEGENDARY_ZED = (EntityType<EntityLegendaryZed>) EntityType.Builder
            .<EntityLegendaryZed>create(EntityLegendaryZed::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryZed::new))
            .build(LegendarySavages.MODID + ":legendary_zed")
            .setRegistryName(location("legendary_zed"));
    public static final EntityType<EntityLegendaryZiggs> LEGENDARY_ZIGGS = (EntityType<EntityLegendaryZiggs>) EntityType.Builder
            .<EntityLegendaryZiggs>create(EntityLegendaryZiggs::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryZiggs::new))
            .build(LegendarySavages.MODID + ":legendary_ziggs")
            .setRegistryName(location("legendary_ziggs"));
    public static final EntityType<EntityLegendaryZilean> LEGENDARY_ZILEAN = (EntityType<EntityLegendaryZilean>) EntityType.Builder
            .<EntityLegendaryZilean>create(EntityLegendaryZilean::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityLegendaryZilean::new))
            .build(LegendarySavages.MODID + ":legendary_zilean")
            .setRegistryName(location("legendary_zilean"));
    public static final EntityType<EntityMagmaBrand> MAGMA_BRAND = (EntityType<EntityMagmaBrand>) EntityType.Builder
            .<EntityMagmaBrand>create(EntityMagmaBrand::new, EntityClassification.MONSTER)
            .setCustomClientFactory((EntityMagmaBrand::new))
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(128)
            .setUpdateInterval(1)
            .build(LegendarySavages.MODID + ":magma_brand")
            .setRegistryName(location("magma_brand"));

    public static void registerEntityWorldSpawns() {
        registryEntityWorldSpawn(LEGEND_XAYAH, Biomes.SNOWY_MOUNTAINS, Biomes.SNOWY_TUNDRA, Biomes.SNOWY_TAIGA_MOUNTAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA_HILLS);
    }

    public static void registryEntityWorldSpawn(EntityType<?> entity, @Nonnull Biome... biomes) {
        for(Biome biome : biomes) {
            if (biome != null) {
                biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, 10, 1, 4));// weight, min, max
            }
        }
    }

    public static void registerEntitySpawnEggs(@Nonnull final RegistryEvent.Register<Item> event) {
        int kingMainColor = new Color(51, 51, 255).getRGB();
        int kingSubColor = new Color(156, 7, 18).getRGB();
        int legendMainColor = new Color(255, 102, 255).getRGB();
        int legendSubColor = new Color(156, 7, 18).getRGB();
        int divineMainColor = new Color(177, 163, 18).getRGB();
        int divineSubColor = new Color(156, 7, 18).getRGB();
        int guardianMainColor = new Color(255, 102, 255).getRGB();
        int guardianSubColor = new Color(156, 7, 18).getRGB();
        int yetiMainColor = new Color(166, 166, 166).getRGB();
        int yetiSubColor = new Color(186, 122, 76).getRGB();
        int legendaryMainColor = new Color(255, 204, 0).getRGB();
        int legendarySubColor = new Color(156, 7, 18).getRGB();
        int championMainColor = new Color(51, 204, 204).getRGB();
        int championSubColor = new Color(156, 7, 18).getRGB();
        int bunnyMainColor = new Color(204, 255, 255).getRGB();
        int bunnySubColor = new Color(156, 7, 18).getRGB();
        int magmaMainColor = new Color(0, 0, 0).getRGB();
        int magmaSubColor = new Color(156, 7, 18).getRGB();

        event.getRegistry().registerAll(
                registerEntitySpawnEggs(MAGMA_BRAND, magmaMainColor, magmaSubColor, "magma_brand"),
                registerEntitySpawnEggs(CHAMPION_AATROX, championMainColor, championSubColor, "champion_aatrox"),
                registerEntitySpawnEggs(CHAMPION_ALISTAR, championMainColor, championSubColor, "champion_alistar"),
                registerEntitySpawnEggs(CHAMPION_APHELIOS, championMainColor, championSubColor, "champion_aphelios"),
                registerEntitySpawnEggs(CHAMPION_AURELION_SOL, championMainColor, championSubColor,  "champion_aurelion_sol"),
                registerEntitySpawnEggs(CHAMPION_AZIR, championMainColor, championSubColor,  "champion_azir"),
                registerEntitySpawnEggs(CHAMPION_BARD, championMainColor, championSubColor, "champion_bard"),
                registerEntitySpawnEggs(CHAMPION_BLITZCRANK, championMainColor, championSubColor,  "champion_blitzcrank"),
                registerEntitySpawnEggs(CHAMPION_BRAUM, championMainColor, championSubColor, "champion_braum"),
                registerEntitySpawnEggs(CHAMPION_CHO_GATH, championMainColor, championSubColor,  "champion_cho_gath"),
                registerEntitySpawnEggs(CHAMPION_CORKI, championMainColor, championSubColor,   "champion_corki"),
                registerEntitySpawnEggs(CHAMPION_CYRO_BRAND, championMainColor, championSubColor,  "champion_cyro_brand"),
                registerEntitySpawnEggs(CHAMPION_DARIUS, championMainColor, championSubColor,  "champion_darius"),
                registerEntitySpawnEggs(CHAMPION_DRAVEN, championMainColor, championSubColor,  "champion_draven"),
                registerEntitySpawnEggs(CHAMPION_DR_MUNDO, championMainColor, championSubColor,   "champion_dr_mundo"),
                registerEntitySpawnEggs(CHAMPION_EKKO, championMainColor, championSubColor,   "champion_ekko"),
                registerEntitySpawnEggs(CHAMPION_EZREAL, championMainColor, championSubColor,   "champion_ezreal"),
                registerEntitySpawnEggs(CHAMPION_FIDDLESTICKS, championMainColor, championSubColor,   "champion_fiddlesticks"),
                registerEntitySpawnEggs(CHAMPION_GALIO, championMainColor, championSubColor,   "champion_galio"),
                registerEntitySpawnEggs(CHAMPION_GANGPLANK, championMainColor, championSubColor,   "champion_gangplank"),
                registerEntitySpawnEggs(CHAMPION_GAREN, championMainColor, championSubColor,  "champion_garen"),
                registerEntitySpawnEggs(CHAMPION_GRAGAS, championMainColor, championSubColor,   "champion_gragas"),
                registerEntitySpawnEggs(CHAMPION_GRAVES, championMainColor, championSubColor,   "champion_graves"),
                registerEntitySpawnEggs(CHAMPION_HECARIM, championMainColor, championSubColor,  "champion_hecarim"),
                registerEntitySpawnEggs(CHAMPION_HEIMERDINGER, championMainColor, championSubColor,  "champion_heimerdinger"),
                registerEntitySpawnEggs(CHAMPION_IVERN, championMainColor, championSubColor,  "champion_ivern"),
                registerEntitySpawnEggs(CHAMPION_JARVAN_IV, championMainColor, championSubColor,   "champion_jarvan_iv"),
                registerEntitySpawnEggs(CHAMPION_JAX, championMainColor, championSubColor,  "champion_jax"),
                registerEntitySpawnEggs(CHAMPION_JAYCE, championMainColor, championSubColor,  "champion_jayce"),
                registerEntitySpawnEggs(CHAMPION_JHIN, championMainColor, championSubColor,   "champion_jhin"),
                registerEntitySpawnEggs(CHAMPION_KALISTA, championMainColor, championSubColor,   "champion_kalista"),
                registerEntitySpawnEggs(CHAMPION_KARTHUS, championMainColor, championSubColor,  "champion_karthus"),
                registerEntitySpawnEggs(CHAMPION_KASSADIN, championMainColor, championSubColor,   "champion_kassadin"),
                registerEntitySpawnEggs(CHAMPION_KAYN, championMainColor, championSubColor,  "champion_kayn"),
                registerEntitySpawnEggs(CHAMPION_KENNEN, championMainColor, championSubColor,   "champion_kennen"),
                registerEntitySpawnEggs(CHAMPION_KHA_ZIX, championMainColor, championSubColor,  "champion_kha_zix"),
                registerEntitySpawnEggs(CHAMPION_KLED, championMainColor, championSubColor,  "champion_kled"),
                registerEntitySpawnEggs(CHAMPION_KOG_MAW, championMainColor, championSubColor,  "champion_kog_maw"),
                registerEntitySpawnEggs(CHAMPION_LEE_SIN, championMainColor, championSubColor,  "champion_lee_sin"),
                registerEntitySpawnEggs(CHAMPION_LUCIAN, championMainColor, championSubColor,  "champion_lucian"),
                registerEntitySpawnEggs(CHAMPION_MALPHITE, championMainColor, championSubColor, "champion_malphite"),
                registerEntitySpawnEggs(CHAMPION_MALZAHAR, championMainColor, championSubColor,  "champion_malzahar"),
                registerEntitySpawnEggs(CHAMPION_MAOKAI, championMainColor, championSubColor,  "champion_maokai"),
                registerEntitySpawnEggs(CHAMPION_MASTER_YI, championMainColor, championSubColor,  "champion_master_yi"),
                registerEntitySpawnEggs(CHAMPION_MORDEKAISER, championMainColor, championSubColor,  "champion_mordekaiser"),
                registerEntitySpawnEggs(CHAMPION_NASUS, championMainColor, championSubColor,  "champion_nasus"),
                registerEntitySpawnEggs(CHAMPION_NAUTILUS, championMainColor, championSubColor,  "champion_nautilus"),
                registerEntitySpawnEggs(CHAMPION_NOCTURNE, championMainColor, championSubColor,  "champion_nocturne"),
                registerEntitySpawnEggs(CHAMPION_NUNU, championMainColor, championSubColor, "champion_nunu"),
                registerEntitySpawnEggs(CHAMPION_OLAF, championMainColor, championSubColor, "champion_olaf"),
                registerEntitySpawnEggs(CHAMPION_ORNN, championMainColor, championSubColor,  "champion_ornn"),
                registerEntitySpawnEggs(CHAMPION_PANTHEON, championMainColor, championSubColor,  "champion_pantheon"),
                registerEntitySpawnEggs(CHAMPION_PYKE, championMainColor, championSubColor, "champion_pyke"),
                registerEntitySpawnEggs(CHAMPION_RAKAN, championMainColor, championSubColor, "champion_rakan"),
                registerEntitySpawnEggs(CHAMPION_REK_SAI, championMainColor, championSubColor,  "champion_rek_sai"),
                registerEntitySpawnEggs(CHAMPION_RENEKTON, championMainColor, championSubColor,  "champion_renekton"),
                registerEntitySpawnEggs(CHAMPION_RENGAR, championMainColor, championSubColor,  "champion_rengar"),
                registerEntitySpawnEggs(CHAMPION_RUMBLE, championMainColor, championSubColor, "champion_rumble"),
                registerEntitySpawnEggs(CHAMPION_RYZE, championMainColor, championSubColor, "champion_ryze"),
                registerEntitySpawnEggs(CHAMPION_SETT, championMainColor, championSubColor, "champion_sett"),
                registerEntitySpawnEggs(CHAMPION_SHACO, championMainColor, championSubColor,  "champion_shaco"),
                registerEntitySpawnEggs(CHAMPION_SHEN, championMainColor, championSubColor, "champion_shen"),
                registerEntitySpawnEggs(CHAMPION_SINGED, championMainColor, championSubColor, "champion_singed"),
                registerEntitySpawnEggs(CHAMPION_SION, championMainColor, championSubColor,  "champion_sion"),
                registerEntitySpawnEggs(CHAMPION_SKARNER, championMainColor, championSubColor,  "champion_skarner"),
                registerEntitySpawnEggs(CHAMPION_SWAIN, championMainColor, championSubColor,  "champion_swain"),
                registerEntitySpawnEggs(CHAMPION_SYLAS, championMainColor, championSubColor, "champion_sylas"),
                registerEntitySpawnEggs(CHAMPION_TAHM_KENCH, championMainColor, championSubColor,  "champion_tahm_kench"),
                registerEntitySpawnEggs(CHAMPION_TALON, championMainColor, championSubColor,  "champion_talon"),
                registerEntitySpawnEggs(CHAMPION_TARIC, championMainColor, championSubColor,  "champion_taric"),
                registerEntitySpawnEggs(CHAMPION_THRESH, championMainColor, championSubColor,  "champion_thresh"),
                registerEntitySpawnEggs(CHAMPION_TRUNDLE, championMainColor, championSubColor,  "champion_trundle"),
                registerEntitySpawnEggs(CHAMPION_TRYNDAMERE, championMainColor, championSubColor,  "champion_tryndamere"),
                registerEntitySpawnEggs(CHAMPION_TWISTED_FATE, championMainColor, championSubColor,  "champion_twisted_fate"),
                registerEntitySpawnEggs(CHAMPION_TWITCH, championMainColor, championSubColor, "champion_twitch"),
                registerEntitySpawnEggs(CHAMPION_UDYR, championMainColor, championSubColor, "champion_udyr"),
                registerEntitySpawnEggs(CHAMPION_URGOT, championMainColor, championSubColor,  "champion_urgot"),
                registerEntitySpawnEggs(CHAMPION_VARUS, championMainColor, championSubColor, "champion_varus"),
                registerEntitySpawnEggs(CHAMPION_VEIGAR, championMainColor, championSubColor,  "champion_veigar"),
                registerEntitySpawnEggs(CHAMPION_VEL_KOZ, championMainColor, championSubColor,   "champion_vel_koz"),
                registerEntitySpawnEggs(CHAMPION_VIKTOR, championMainColor, championSubColor,  "champion_viktor"),
                registerEntitySpawnEggs(CHAMPION_VLADIMIR, championMainColor, championSubColor,  "champion_vladimir"),
                registerEntitySpawnEggs(CHAMPION_VOLIBEAR, championMainColor, championSubColor,  "champion_volibear"),
                registerEntitySpawnEggs(CHAMPION_WARWICK, championMainColor, championSubColor,  "champion_warwick"),
                registerEntitySpawnEggs(CHAMPION_WUKONG, championMainColor, championSubColor,  "champion_wukong"),
                registerEntitySpawnEggs(CHAMPION_XERATH, championMainColor, championSubColor,   "champion_xerath"),
                registerEntitySpawnEggs(CHAMPION_XIN_ZHAO, championMainColor, championSubColor,   "champion_xin_zhao"),
                registerEntitySpawnEggs(CHAMPION_YASUO, championMainColor, championSubColor,   "champion_yasuo"),
                registerEntitySpawnEggs(CHAMPION_YORICK, championMainColor, championSubColor,  "champion_yorick"),
                registerEntitySpawnEggs(CHAMPION_ZED, championMainColor, championSubColor,   "champion_zed"),
                registerEntitySpawnEggs(CHAMPION_ZIGGS, championMainColor, championSubColor,   "champion_ziggs"),
                registerEntitySpawnEggs(CHAMPION_ZILEAN, championMainColor, championSubColor,   "champion_zilean"),
                registerEntitySpawnEggs(KING_PORO, kingMainColor, kingSubColor, "king_poro"),
                registerEntitySpawnEggs(LEGEND_AHRI, legendMainColor, legendSubColor, "legend_ahri"),
                registerEntitySpawnEggs(LEGEND_AKALI, legendMainColor, legendSubColor, "legend_akali"),
                registerEntitySpawnEggs(LEGEND_AMUMU, legendMainColor, legendSubColor,"legend_amumu"),
                registerEntitySpawnEggs(LEGEND_ANIVIA, legendMainColor, legendSubColor, "legend_anivia"),
                registerEntitySpawnEggs(LEGEND_ANNIE, legendMainColor, legendSubColor, "legend_annie"),
                registerEntitySpawnEggs(LEGEND_ASHE, legendMainColor, legendSubColor, "legend_ashe"),
                registerEntitySpawnEggs(LEGEND_AYUREX, legendMainColor, legendSubColor, "legend_ayurex"),
                registerEntitySpawnEggs(LEGEND_CAITLYN, legendMainColor, legendSubColor, "legend_caitlyn"),
                registerEntitySpawnEggs(LEGEND_CAMILLE, legendMainColor, legendSubColor, "legend_camille"),
                registerEntitySpawnEggs(LEGEND_CASSIOPEIA, legendMainColor, legendSubColor,  "legend_cassiopeia"),
                registerEntitySpawnEggs(LEGEND_DIANA, legendMainColor, legendSubColor, "legend_diana"),
                registerEntitySpawnEggs(LEGEND_ELISE, legendMainColor, legendSubColor, "legend_elise"),
                registerEntitySpawnEggs(LEGEND_EVELYNN, legendMainColor, legendSubColor,  "legend_evelynn"),
                registerEntitySpawnEggs(LEGEND_FIORA, legendMainColor, legendSubColor, "legend_fiora"),
                registerEntitySpawnEggs(LEGEND_FIZZ, legendMainColor, legendSubColor,  "legend_fizz"),
                registerEntitySpawnEggs(LEGEND_GNAR, legendMainColor, legendSubColor,  "legend_gnar"),
                registerEntitySpawnEggs(LEGEND_ILLAOI, legendMainColor, legendSubColor,  "legend_illaoi"),
                registerEntitySpawnEggs(LEGEND_IRELIA, legendMainColor, legendSubColor,  "legend_irelia"),
                registerEntitySpawnEggs(LEGEND_JANNA, legendMainColor, legendSubColor,  "legend_janna"),
                registerEntitySpawnEggs(LEGEND_JINX, legendMainColor, legendSubColor,  "legend_jinx"),
                registerEntitySpawnEggs(LEGEND_KAI_SA, legendMainColor, legendSubColor,  "legend_kai_sa"),
                registerEntitySpawnEggs(LEGEND_KARMA, legendMainColor, legendSubColor,  "legend_karma"),
                registerEntitySpawnEggs(LEGEND_KATARINA, legendMainColor, legendSubColor,  "legend_katarina"),
                registerEntitySpawnEggs(LEGEND_KINDRED, legendMainColor, legendSubColor,  "legend_kindred"),
                registerEntitySpawnEggs(LEGEND_LE_BLANC, legendMainColor, legendSubColor,  "legend_le_blanc"),
                registerEntitySpawnEggs(LEGEND_LEONA, legendMainColor, legendSubColor,  "legend_leona"),
                registerEntitySpawnEggs(LEGEND_LISSANDRA, legendMainColor, legendSubColor,  "legend_lissandra"),
                registerEntitySpawnEggs(LEGEND_LULU, legendMainColor, legendSubColor,  "legend_lulu"),
                registerEntitySpawnEggs(LEGEND_LUX, legendMainColor, legendSubColor,  "legend_lux"),
                registerEntitySpawnEggs(LEGEND_MISS_FORTUNE, legendMainColor, legendSubColor, "legend_miss_fortune"),
                registerEntitySpawnEggs(LEGEND_MORGANA, legendMainColor, legendSubColor,  "legend_morgana"),
                registerEntitySpawnEggs(LEGEND_NEEKO, legendMainColor, legendSubColor,  "legend_neeko"),
                registerEntitySpawnEggs(LEGEND_NIDALEE, legendMainColor, legendSubColor,  "legend_nidalee"),
                registerEntitySpawnEggs(LEGEND_ORIANNA, legendMainColor, legendSubColor,  "legend_orianna"),
                registerEntitySpawnEggs(LEGEND_POPPY, legendMainColor, legendSubColor,  "legend_poppy"),
                registerEntitySpawnEggs(LEGEND_QIYANA, legendMainColor, legendSubColor,  "legend_qiyana"),
                registerEntitySpawnEggs(LEGEND_QUINN, legendMainColor, legendSubColor,  "legend_quinn"),
                registerEntitySpawnEggs(LEGEND_RAMMUS, legendMainColor, legendSubColor,  "legend_rammus"),
                registerEntitySpawnEggs(LEGEND_RIVEN, legendMainColor, legendSubColor,  "legend_riven"),
                registerEntitySpawnEggs(LEGEND_SEJUANI, legendMainColor, legendSubColor,  "legend_sejuani"),
                registerEntitySpawnEggs(LEGEND_SHYVANA, legendMainColor, legendSubColor,  "legend_shyvana"),
                registerEntitySpawnEggs(LEGEND_SIVIR, legendMainColor, legendSubColor,  "legend_sivir"),
                registerEntitySpawnEggs(LEGEND_SONA, legendMainColor, legendSubColor,  "legend_sona"),
                registerEntitySpawnEggs(LEGEND_SORAKA, legendMainColor, legendSubColor,  "legend_soraka"),
                registerEntitySpawnEggs(LEGEND_SYNDRA, legendMainColor, legendSubColor,  "legend_syndra"),
                registerEntitySpawnEggs(LEGEND_TALIYAH, legendMainColor, legendSubColor,  "legend_taliyah"),
                registerEntitySpawnEggs(LEGEND_TEEMO, legendMainColor, legendSubColor,  "legend_teemo"),
                registerEntitySpawnEggs(LEGEND_TRISTANA, legendMainColor, legendSubColor,  "legend_tristana"),
                registerEntitySpawnEggs(LEGEND_VAYNE, legendMainColor, legendSubColor,  "legend_vayne"),
                registerEntitySpawnEggs(LEGEND_VI, legendMainColor, legendSubColor,  "legend_vi"),
                registerEntitySpawnEggs(LEGEND_XAYAH, legendMainColor, legendSubColor, "legend_xayah"),
                registerEntitySpawnEggs(LEGEND_YUUMI, legendMainColor, legendSubColor,  "legend_yuumi"),
                registerEntitySpawnEggs(LEGEND_ZAC, legendMainColor, legendSubColor,  "legend_zac"),
                registerEntitySpawnEggs(LEGEND_ZOE, legendMainColor, legendSubColor,  "legend_zoe"),
                registerEntitySpawnEggs(LEGEND_ZYRA, legendMainColor, legendSubColor,  "legend_zyra"),
                registerEntitySpawnEggs(YETI_BESTIA_GLACIES, yetiMainColor, yetiSubColor,  "yeti_bestia_glacies"),
                registerEntitySpawnEggs(YETI_SASQUATCH, yetiMainColor, yetiSubColor,  "yeti_sasquatch"),
                registerEntitySpawnEggs(DIVINE_KAYLE, divineMainColor, divineSubColor,  "divine_kayle"),
                registerEntitySpawnEggs(GUARDIAN_NAMI, guardianMainColor, guardianSubColor,  "guardian_nami"),
                registerEntitySpawnEggs(LEGENDARY_AATROX, legendaryMainColor, legendarySubColor, "legendary_aatrox"),
                registerEntitySpawnEggs(LEGENDARY_ALISTAR, legendaryMainColor, legendarySubColor, "legendary_alistar"),
                registerEntitySpawnEggs(LEGENDARY_APHELIOS, legendaryMainColor, legendarySubColor, "legendary_aphelios"),
                registerEntitySpawnEggs(LEGENDARY_AURELION_SOL, legendaryMainColor, legendarySubColor,  "legendary_aurelion_sol"),
                registerEntitySpawnEggs(LEGENDARY_AZIR, legendaryMainColor, legendarySubColor,  "legendary_azir"),
                registerEntitySpawnEggs(LEGENDARY_BARD, legendaryMainColor, legendarySubColor, "legendary_bard"),
                registerEntitySpawnEggs(LEGENDARY_BLITZCRANK, legendaryMainColor, legendarySubColor,  "legendary_blitzcrank"),
                registerEntitySpawnEggs(LEGENDARY_BRAUM, legendaryMainColor, legendarySubColor, "legendary_braum"),

                registerEntitySpawnEggs(LEGENDARY_CHO_GATH, legendaryMainColor, legendarySubColor,  "legendary_cho_gath"),
                registerEntitySpawnEggs(LEGENDARY_CORKI, legendaryMainColor, legendarySubColor,   "legendary_corki"),
                registerEntitySpawnEggs(LEGENDARY_CYRO_BRAND, legendaryMainColor, legendarySubColor,  "legendary_cyro_brand"),
                registerEntitySpawnEggs(LEGENDARY_DARIUS, legendaryMainColor, legendarySubColor,  "legendary_darius"),
                registerEntitySpawnEggs(LEGENDARY_DRAVEN, legendaryMainColor, legendarySubColor,  "legendary_draven"),
                registerEntitySpawnEggs(LEGENDARY_DR_MUNDO, legendaryMainColor, legendarySubColor,   "legendary_dr_mundo"),
                registerEntitySpawnEggs(LEGENDARY_EKKO, legendaryMainColor, legendarySubColor,   "legendary_ekko"),
                registerEntitySpawnEggs(LEGENDARY_EZREAL, legendaryMainColor, legendarySubColor,   "legendary_ezreal"),
                registerEntitySpawnEggs(LEGENDARY_FIDDLESTICKS, legendaryMainColor, legendarySubColor,   "legendary_fiddlesticks"),
                registerEntitySpawnEggs(LEGENDARY_GALIO, legendaryMainColor, legendarySubColor,   "legendary_galio"),
                registerEntitySpawnEggs(LEGENDARY_GANGPLANK, legendaryMainColor, legendarySubColor,   "legendary_gangplank"),
                registerEntitySpawnEggs(LEGENDARY_GAREN, legendaryMainColor, legendarySubColor,  "legendary_garen"),
                registerEntitySpawnEggs(LEGENDARY_GRAGAS, legendaryMainColor, legendarySubColor,   "legendary_gragas"),
                registerEntitySpawnEggs(LEGENDARY_GRAVES, legendaryMainColor, legendarySubColor,   "legendary_graves"),
                registerEntitySpawnEggs(LEGENDARY_HECARIM, legendaryMainColor, legendarySubColor,  "legendary_hecarim"),
                registerEntitySpawnEggs(LEGENDARY_HEIMERDINGER, legendaryMainColor, legendarySubColor,  "legendary_heimerdinger"),
                registerEntitySpawnEggs(LEGENDARY_IVERN, legendaryMainColor, legendarySubColor,  "legendary_ivern"),
                registerEntitySpawnEggs(LEGENDARY_JARVAN_IV, legendaryMainColor, legendarySubColor,   "legendary_jarvan_iv"),
                registerEntitySpawnEggs(LEGENDARY_JAX, legendaryMainColor, legendarySubColor,  "legendary_jax"),
                registerEntitySpawnEggs(LEGENDARY_JAYCE, legendaryMainColor, legendarySubColor,  "legendary_jayce"),
                registerEntitySpawnEggs(LEGENDARY_JHIN, legendaryMainColor, legendarySubColor,   "legendary_jhin"),
                registerEntitySpawnEggs(LEGENDARY_KALISTA, legendaryMainColor, legendarySubColor,   "legendary_kalista"),
                registerEntitySpawnEggs(LEGENDARY_KARTHUS, legendaryMainColor, legendarySubColor,  "legendary_karthus"),
                registerEntitySpawnEggs(LEGENDARY_KASSADIN, legendaryMainColor, legendarySubColor,   "legendary_kassadin"),
                registerEntitySpawnEggs(LEGENDARY_KAYN, legendaryMainColor, legendarySubColor,  "legendary_kayn"),
                registerEntitySpawnEggs(LEGENDARY_KENNEN, legendaryMainColor, legendarySubColor,   "legendary_kennen"),
                registerEntitySpawnEggs(LEGENDARY_KHA_ZIX, legendaryMainColor, legendarySubColor,  "legendary_kha_zix"),
                registerEntitySpawnEggs(LEGENDARY_KLED, legendaryMainColor, legendarySubColor,  "legendary_kled"),
                registerEntitySpawnEggs(LEGENDARY_KOG_MAW, legendaryMainColor, legendarySubColor,  "legendary_kog_maw"),
                registerEntitySpawnEggs(LEGENDARY_LEE_SIN, legendaryMainColor, legendarySubColor,  "legendary_lee_sin"),
                registerEntitySpawnEggs(LEGENDARY_LUCIAN, legendaryMainColor, legendarySubColor,  "legendary_lucian"),
                registerEntitySpawnEggs(LEGENDARY_MALPHITE, legendaryMainColor, legendarySubColor, "legendary_malphite"),
                registerEntitySpawnEggs(LEGENDARY_MALZAHAR, legendaryMainColor, legendarySubColor,  "legendary_malzahar"),
                registerEntitySpawnEggs(LEGENDARY_MAOKAI, legendaryMainColor, legendarySubColor,  "legendary_maokai"),
                registerEntitySpawnEggs(LEGENDARY_MASTER_YI, legendaryMainColor, legendarySubColor,  "legendary_master_yi"),
                registerEntitySpawnEggs(LEGENDARY_MORDEKAISER, legendaryMainColor, legendarySubColor,  "legendary_mordekaiser"),
                registerEntitySpawnEggs(LEGENDARY_NASUS, legendaryMainColor, legendarySubColor,  "legendary_nasus"),
                registerEntitySpawnEggs(LEGENDARY_NAUTILUS, legendaryMainColor, legendarySubColor,  "legendary_nautilus"),
                registerEntitySpawnEggs(LEGENDARY_NOCTURNE, legendaryMainColor, legendarySubColor,  "legendary_nocturne"),
                registerEntitySpawnEggs(LEGENDARY_NUNU, legendaryMainColor, legendarySubColor, "legendary_nunu"),
                registerEntitySpawnEggs(LEGENDARY_OLAF, legendaryMainColor, legendarySubColor, "legendary_olaf"),
                registerEntitySpawnEggs(LEGENDARY_ORNN, legendaryMainColor, legendarySubColor,  "legendary_ornn"),
                registerEntitySpawnEggs(LEGENDARY_PANTHEON, legendaryMainColor, legendarySubColor,  "legendary_pantheon"),
                registerEntitySpawnEggs(LEGENDARY_PYKE, legendaryMainColor, legendarySubColor, "legendary_pyke"),
                registerEntitySpawnEggs(LEGENDARY_RAKAN, legendaryMainColor, legendarySubColor, "legendary_rakan"),
                registerEntitySpawnEggs(LEGENDARY_REK_SAI, legendaryMainColor, legendarySubColor,  "legendary_rek_sai"),
                registerEntitySpawnEggs(LEGENDARY_RENEKTON, legendaryMainColor, legendarySubColor,  "legendary_renekton"),
                registerEntitySpawnEggs(LEGENDARY_RENGAR, legendaryMainColor, legendarySubColor,  "legendary_rengar"),
                registerEntitySpawnEggs(LEGENDARY_RUMBLE, legendaryMainColor, legendarySubColor, "legendary_rumble"),
                registerEntitySpawnEggs(LEGENDARY_RYZE, legendaryMainColor, legendarySubColor, "legendary_ryze"),
                registerEntitySpawnEggs(LEGENDARY_SETT, legendaryMainColor, legendarySubColor, "legendary_sett"),
                registerEntitySpawnEggs(LEGENDARY_SHACO, legendaryMainColor, legendarySubColor,  "legendary_shaco"),
                registerEntitySpawnEggs(LEGENDARY_SHEN, legendaryMainColor, legendarySubColor, "legendary_shen"),
                registerEntitySpawnEggs(LEGENDARY_SINGED, legendaryMainColor, legendarySubColor, "legendary_singed"),
                registerEntitySpawnEggs(LEGENDARY_SION, legendaryMainColor, legendarySubColor,  "legendary_sion"),
                registerEntitySpawnEggs(LEGENDARY_SKARNER, legendaryMainColor, legendarySubColor,  "legendary_skarner"),
                registerEntitySpawnEggs(LEGENDARY_SWAIN, legendaryMainColor, legendarySubColor,  "legendary_swain"),
                registerEntitySpawnEggs(LEGENDARY_SYLAS, legendaryMainColor, legendarySubColor, "legendary_sylas"),
                registerEntitySpawnEggs(LEGENDARY_TAHM_KENCH, legendaryMainColor, legendarySubColor,  "legendary_tahm_kench"),
                registerEntitySpawnEggs(LEGENDARY_TALON, legendaryMainColor, legendarySubColor,  "legendary_talon"),
                registerEntitySpawnEggs(LEGENDARY_TARIC, legendaryMainColor, legendarySubColor,  "legendary_taric"),
                registerEntitySpawnEggs(LEGENDARY_THRESH, legendaryMainColor, legendarySubColor,  "legendary_thresh"),
                registerEntitySpawnEggs(LEGENDARY_TRUNDLE, legendaryMainColor, legendarySubColor,  "legendary_trundle"),
                registerEntitySpawnEggs(LEGENDARY_TRYNDAMERE, legendaryMainColor, legendarySubColor,  "legendary_tryndamere"),
                registerEntitySpawnEggs(LEGENDARY_TWISTED_FATE, legendaryMainColor, legendarySubColor,  "legendary_twisted_fate"),
                registerEntitySpawnEggs(LEGENDARY_TWITCH, legendaryMainColor, legendarySubColor, "legendary_twitch"),
                registerEntitySpawnEggs(LEGENDARY_UDYR, legendaryMainColor, legendarySubColor, "legendary_udyr"),
                registerEntitySpawnEggs(LEGENDARY_URGOT, legendaryMainColor, legendarySubColor,  "legendary_urgot"),
                registerEntitySpawnEggs(LEGENDARY_VARUS, legendaryMainColor, legendarySubColor, "legendary_varus"),
                registerEntitySpawnEggs(LEGENDARY_VEIGAR, legendaryMainColor, legendarySubColor,  "legendary_veigar"),
                registerEntitySpawnEggs(LEGENDARY_VEL_KOZ, legendaryMainColor, legendarySubColor,   "legendary_vel_koz"),
                registerEntitySpawnEggs(LEGENDARY_VIKTOR, legendaryMainColor, legendarySubColor,  "legendary_viktor"),
                registerEntitySpawnEggs(LEGENDARY_VLADIMIR, legendaryMainColor, legendarySubColor,  "legendary_vladimir"),
                registerEntitySpawnEggs(LEGENDARY_VOLIBEAR, legendaryMainColor, legendarySubColor,  "legendary_volibear"),
                registerEntitySpawnEggs(LEGENDARY_WARWICK, legendaryMainColor, legendarySubColor,  "legendary_warwick"),
                registerEntitySpawnEggs(LEGENDARY_WILLUMP, legendaryMainColor, legendarySubColor,   "legendary_willump"),
                registerEntitySpawnEggs(LEGENDARY_WUKONG, legendaryMainColor, legendarySubColor,  "legendary_wukong"),
                registerEntitySpawnEggs(LEGENDARY_XERATH, legendaryMainColor, legendarySubColor,   "legendary_xerath"),
                registerEntitySpawnEggs(LEGENDARY_XIN_ZHAO, legendaryMainColor, legendarySubColor,   "legendary_xin_zhao"),
                registerEntitySpawnEggs(LEGENDARY_YASUO, legendaryMainColor, legendarySubColor,   "legendary_yasuo"),
                registerEntitySpawnEggs(LEGENDARY_YORICK, legendaryMainColor, legendarySubColor,  "legendary_yorick"),
                registerEntitySpawnEggs(LEGENDARY_ZED, legendaryMainColor, legendarySubColor,   "legendary_zed"),
                registerEntitySpawnEggs(LEGENDARY_ZIGGS, legendaryMainColor, legendarySubColor,   "legendary_ziggs"),
                registerEntitySpawnEggs(LEGENDARY_ZILEAN, legendaryMainColor, legendarySubColor,   "legendary_zilean"),
                registerEntitySpawnEggs(BATTLE_BUNNY_JANNA, bunnyMainColor, bunnySubColor,   "battle_bunny_janna"),
                registerEntitySpawnEggs(BATTLE_BUNNY_RIVEN, bunnyMainColor, bunnySubColor,   "battle_bunny_riven")
                );
    }

    @Nonnull
    public static Item registerEntitySpawnEggs(EntityType<?> type, int color1, int color2, String name) {
        SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP));
        String egg_name = name + "_spawn_egg";
        item.setRegistryName(new ResourceLocation(LegendarySavages.MODID, egg_name));
        return item;
    }

    @Nonnull
    private static ResourceLocation location(@Nonnull String name) {
        return new ResourceLocation(MODID, name);
    }
}

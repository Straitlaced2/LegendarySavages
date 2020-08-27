package straitlaced.legendarysavages.server.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import straitlaced.legendarysavages.server.advancements.criterion.ModTriggers;
import straitlaced.legendarysavages.server.init.ModEntities;

import javax.annotation.Nonnull;

public class EntityChampionAatrox extends EntityChampion {
    public EntityChampionAatrox(EntityType<? extends EntityChampionAatrox> type, World p_i48553_2_) {
        super(type, p_i48553_2_);
    }

    public EntityChampionAatrox(FMLPlayMessages.SpawnEntity spawnEntity, World world) {
        super(ModEntities.CHAMPION_AATROX, world);
    }

    @Override
    public void triggerTaming(@Nonnull PlayerEntity player) {
        ModTriggers.GENTLE_CHAMPION_AATROX.trigger((ServerPlayerEntity)player, this);
    }

    @Override
    @Nonnull
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}

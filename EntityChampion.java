package straitlaced.legendarysavages.server.entity.monster;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import straitlaced.legendarysavages.LegendarySavages;
import straitlaced.legendarysavages.client.sound.LSSoundRegistry;
import straitlaced.legendarysavages.server.entity.monster.ai.DamageSourceOwned;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static net.minecraft.potion.Effects.*;
import static straitlaced.legendarysavages.server.entity.monster.ChampAiMode.*;

public abstract class EntityChampion extends MonsterEntity implements IRangedAttackMob, IEntityAdditionalSpawnData {

    private static final UUID CHAMPION_NULL_UUID = UUID.fromString("ea02fd50-553f-4a25-9d7c-8f956ed741c2");
    private static final ResourceLocation LOOT = new ResourceLocation(LegendarySavages.MODID, "legendary_champion_loot_table");

    private static final DataParameter<Integer> SKIN_ID = EntityDataManager.createKey(EntityChampion.class, DataSerializers.VARINT);
    private static final DataParameter<Float> SCALE = EntityDataManager.createKey(EntityChampion.class, DataSerializers.FLOAT);
    private static final DataParameter<Integer> AI_MODE = EntityDataManager.createKey(EntityChampion.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> ATTACK_MODE = EntityDataManager.createKey(EntityChampion.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> REST_TICKS = EntityDataManager.createKey(EntityChampion.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> CHASE_TICKS = EntityDataManager.createKey(EntityChampion.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> CHASE_MAX_TICKS = EntityDataManager.createKey(EntityChampion.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> LOVE_STRUCK_TICKS = EntityDataManager.createKey(EntityChampion.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> MOVE_TICKS = EntityDataManager.createKey(EntityChampion.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> MOVE_EXT = EntityDataManager.createKey(EntityChampion.class, DataSerializers.BOOLEAN);

    private static final DataParameter<Boolean> TAMED = EntityDataManager.createKey(EntityChampion.class, DataSerializers.BOOLEAN);
    private static final DataParameter<String> TAMER_UUID_STRING = EntityDataManager.createKey(EntityChampion.class, DataSerializers.STRING);

    private static final DataParameter<Optional<UUID>> TAMER_UUID = EntityDataManager.createKey(EntityChampion.class, DataSerializers.OPTIONAL_UNIQUE_ID);
    private static final DataParameter<Optional<UUID>> LAST_VICTIM_UUID = EntityDataManager.createKey(EntityChampion.class, DataSerializers.OPTIONAL_UNIQUE_ID);
    private static final DataParameter<Optional<UUID>> ATTACK_UUID = EntityDataManager.createKey(EntityChampion.class, DataSerializers.OPTIONAL_UNIQUE_ID);
    private static final DataParameter<Optional<UUID>> REVENGE_UUID = EntityDataManager.createKey(EntityChampion.class, DataSerializers.OPTIONAL_UNIQUE_ID);


    @Nonnull
    public Integer getSkinId() {
        return this.dataManager.get(SKIN_ID);
    }

    void setSkinId(final Integer skinId) {
        this.dataManager.set(SKIN_ID, skinId);
    }

    public void setScale(final Float scale) {
        this.dataManager.set(SCALE, scale);
    }

    public Float getScale() {
        return this.dataManager.get(SCALE);
    }

    private void setAiMode(@Nonnull final ChampAiMode aiMode) {
        this.dataManager.set(AI_MODE, aiMode.ordinal());
    }

    ChampAiMode getAiMode() {
        return ChampAiMode.values()[this.dataManager.get(AI_MODE)];
    }

    @Nonnull
    Integer getRestTicks() {
        return this.dataManager.get(REST_TICKS);
    }

    void setRestTicks(final Integer restTicks) {
        this.dataManager.set(REST_TICKS, restTicks);
    }

    @Nonnull
    private Integer getLoveStruckTricks() {
        return this.dataManager.get(LOVE_STRUCK_TICKS);
    }

    private void setLoveStruckTicks(final Integer loveStruckTicks) {
        this.dataManager.set(LOVE_STRUCK_TICKS, loveStruckTicks);
    }

    @Nonnull
    private Integer getChaseTicks() {
        return this.dataManager.get(CHASE_TICKS);
    }

    void setChaseTicks(final Integer chaseTicks) {
        this.dataManager.set(CHASE_TICKS, chaseTicks);
    }

    @Nonnull
    private Integer getChaseMaxTicks() {
        return this.dataManager.get(CHASE_MAX_TICKS);
    }

    private void setChaseMaxTicks(final Integer chaseMaxTicks) {
        this.dataManager.set(CHASE_MAX_TICKS, chaseMaxTicks);
    }

    @Nonnull
    private AttackMode getAttackMode() {
        return AttackMode.values()[this.dataManager.get(ATTACK_MODE)];
    }

    void setAttackMode(@Nonnull final AttackMode attackMode){
        this.dataManager.set(ATTACK_MODE, attackMode.ordinal());
    }

    @Nonnull
    Boolean isSpecialTamed() {
        return this.dataManager.get(TAMED);
    }

    private void setSpecialTamed(final Boolean isTamed){
        this.dataManager.set(TAMED, isTamed);
    }

    @Nonnull
    String getTamerUuidString() {
        return this.dataManager.get(TAMER_UUID_STRING);
    }

    private void setTamerUuidString(final String tamerUuidString){
        this.dataManager.set(TAMER_UUID_STRING, tamerUuidString);
    }

    @Nonnull
    private Integer getMoveTicks() {
        return this.dataManager.get(MOVE_TICKS);
    }

    private void setMoveTicks(final Integer moveTicks) {
        this.dataManager.set(MOVE_TICKS, moveTicks);
    }

    @Nonnull
    private Boolean isMoveExtension() {
        return this.dataManager.get(MOVE_EXT);
    }

    private void setMoveExtension(final Boolean isMoveExtension){
        this.dataManager.set(MOVE_EXT, isMoveExtension);
    }

    @Nullable
    public UUID getTamerUuid()
    {
        return this.dataManager.get(TAMER_UUID) .orElse(null);
    }

    public void setTamerUuid(@Nullable UUID uuid)
    {
        if (Objects.equals(uuid, CHAMPION_NULL_UUID)) this.dataManager.set(TAMER_UUID, Optional.empty());
        else this.dataManager.set(TAMER_UUID, Optional.ofNullable(uuid));
    }

    @Nullable
    public UUID getLastVictimUuid()
    {
        return this.dataManager.get(LAST_VICTIM_UUID) .orElse(null);
    }

    public void setLastVictimUuid(@Nullable UUID uuid)
    {
        if (Objects.equals(uuid, CHAMPION_NULL_UUID)) this.dataManager.set(LAST_VICTIM_UUID, Optional.empty());
        else this.dataManager.set(LAST_VICTIM_UUID, Optional.ofNullable(uuid));
    }

    @Nullable
    public UUID getAttackUuid()
    {
        return this.dataManager.get(ATTACK_UUID) .orElse(null);
    }

    public void setAttackUuid(@Nullable UUID uuid)
    {
        if (Objects.equals(uuid, CHAMPION_NULL_UUID)) this.dataManager.set(ATTACK_UUID, Optional.empty());
        else this.dataManager.set(ATTACK_UUID, Optional.ofNullable(uuid));
    }

    @Nullable
    public UUID getRevengeUuid()
    {
        return this.dataManager.get(REVENGE_UUID) .orElse(null);
    }

    public void setRevengeUuid(@Nullable UUID uuid)
    {
        if (Objects.equals(uuid, CHAMPION_NULL_UUID)) this.dataManager.set(REVENGE_UUID, Optional.empty());
        else this.dataManager.set(REVENGE_UUID, Optional.ofNullable(uuid));
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(SKIN_ID, 0);
        this.dataManager.register(SCALE, rand.nextFloat() + 1);
        this.dataManager.register(AI_MODE, 0);
        this.dataManager.register(REST_TICKS, 0);
        this.dataManager.register(LOVE_STRUCK_TICKS, 0);
        this.dataManager.register(ATTACK_MODE, 0);
        this.dataManager.register(CHASE_TICKS, 0);
        this.dataManager.register(CHASE_MAX_TICKS, 500);
        this.dataManager.register(MOVE_TICKS, 0);
        this.dataManager.register(MOVE_EXT, false);
        this.dataManager.register(TAMED, false);
        this.dataManager.register(TAMER_UUID_STRING, "");
        this.dataManager.register(TAMER_UUID, Optional.empty());
        this.dataManager.register(LAST_VICTIM_UUID, Optional.empty());
        this.dataManager.register(ATTACK_UUID, Optional.empty());
        this.dataManager.register(REVENGE_UUID, Optional.empty());
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("SkinId", this.getSkinId());
        nbt.putFloat("Scale", this.getScale());
        nbt.putInt("AiMode", this.getAiMode().ordinal());
        nbt.putInt("AttackMode", this.getAttackMode().ordinal());
        nbt.putInt("RestTicks", this.getRestTicks());
        nbt.putInt("ChaseTicks", this.getChaseTicks());
        nbt.putInt("ChaseMaxTicks", this.getChaseMaxTicks());
        nbt.putInt("LoveStruckTicks", this.getLoveStruckTricks());
        nbt.putInt("MoveTicks", this.getMoveTicks());
        nbt.putBoolean("MoveExtension", this.isMoveExtension());
        nbt.putBoolean("Tamed", this.isSpecialTamed());
        nbt.putString("TamerString", this.getTamerUuidString());
        if (this.getTamerUuid() != null) this.dataManager.set(TAMER_UUID, Optional.of(this.getTamerUuid()));
        if (this.getLastVictimUuid() != null) this.dataManager.set(LAST_VICTIM_UUID, Optional.of(this.getLastVictimUuid()));
        if (this.getAttackUuid() != null) this.dataManager.set(ATTACK_UUID, Optional.of(this.getAttackUuid()));
        if (this.getRevengeUuid() != null) this.dataManager.set(REVENGE_UUID, Optional.of(this.getRevengeUuid()));
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        super.deserializeNBT(nbt);
        this.setSkinId(nbt.getInt("SkinId"));
        this.setScale(nbt.getFloat("Scale"));
        this.setAiMode(ChampAiMode.values()[nbt.getInt("AiMode")]);
        this.setAttackMode(AttackMode.values()[nbt.getInt("AttackMode")]);
        this.setRestTicks(nbt.getInt("RestTicks"));
        this.setChaseTicks(nbt.getInt("ChaseTicks"));
        this.setChaseMaxTicks(nbt.getInt("ChaseMaxTicks"));
        this.setLoveStruckTicks(nbt.getInt("LoveStruckTicks"));
        this.setMoveTicks(nbt.getInt("MoveTicks"));
        this.setMoveExtension(nbt.getBoolean("MoveExtension"));
        this.setSpecialTamed(nbt.getBoolean("Tamed"));
        this.setTamerUuidString(nbt.getString("TamerString"));
        if (nbt.contains("TamerUuid"))
            this.setTamerUuid(nbt.getUniqueId("TamerUuid"));
        if (nbt.contains("LastVictimUuid"))
            this.setLastVictimUuid(nbt.getUniqueId("LastVictimUuid"));
        if (nbt.contains("RevengeUuid"))
            this.setRevengeUuid(nbt.getUniqueId("RevengeUuid"));
        if (nbt.contains("AttackUuid"))
            this.setAttackUuid(nbt.getUniqueId("AttackUuid"));
    }

    @Override
    public void writeSpawnData(PacketBuffer buffer) {
        PacketBuffer packetBuffer = new PacketBuffer(buffer);
        packetBuffer.writeInt(this.getSkinId());
        packetBuffer.writeFloat(this.getScale());
        packetBuffer.writeInt(this.getAiMode().ordinal());
        packetBuffer.writeInt(this.getAttackMode().ordinal());
        packetBuffer.writeInt(this.getRestTicks());
        packetBuffer.writeInt(this.getChaseTicks());
        packetBuffer.writeInt(this.getChaseMaxTicks());
        packetBuffer.writeInt(this.getLoveStruckTricks());
        packetBuffer.writeInt(this.getMoveTicks());
        packetBuffer.writeBoolean(this.isMoveExtension());
        packetBuffer.writeBoolean(this.isSpecialTamed());
        packetBuffer.writeString(this.getTamerUuidString());

        if (this.getTamerUuid() != null) packetBuffer.writeUniqueId(this.getTamerUuid());
        else packetBuffer.writeUniqueId(CHAMPION_NULL_UUID);
        if (this.getLastVictimUuid() != null) packetBuffer.writeUniqueId(this.getLastVictimUuid());
        else packetBuffer.writeUniqueId(CHAMPION_NULL_UUID);
        if (this.getAttackUuid() != null) packetBuffer.writeUniqueId(this.getAttackUuid());
        else packetBuffer.writeUniqueId(CHAMPION_NULL_UUID);
        if (this.getRevengeUuid() != null) packetBuffer.writeUniqueId(this.getRevengeUuid());
        else packetBuffer.writeUniqueId(CHAMPION_NULL_UUID);

        packetBuffer.writeBlockPos(this.getPosition());
    }

    @Override
    public void readSpawnData(PacketBuffer additionalData) {
        PacketBuffer packetBuffer = new PacketBuffer(additionalData);
        this.setSkinId(packetBuffer.readInt());
        this.setScale(packetBuffer.readFloat());
        this.setAiMode(ChampAiMode.values()[packetBuffer.readInt()]);
        this.setAttackMode(AttackMode.values()[packetBuffer.readInt()]);
        this.setRestTicks(packetBuffer.readInt());
        this.setChaseTicks(packetBuffer.readInt());
        this.setChaseMaxTicks(packetBuffer.readInt());
        this.setLoveStruckTicks(packetBuffer.readInt());
        this.setMoveTicks(packetBuffer.readInt());
        this.setMoveExtension(packetBuffer.readBoolean());
        this.setSpecialTamed(packetBuffer.readBoolean());
        this.setTamerUuidString(packetBuffer.readString());

        this.setTamerUuid(packetBuffer.readUniqueId());
        this.setLastVictimUuid(packetBuffer.readUniqueId());
        this.setAttackUuid(packetBuffer.readUniqueId());
        this.setRevengeUuid(packetBuffer.readUniqueId());

        packetBuffer.readBlockPos();
    }

    @Override
    public void notifyDataManagerChange(@Nonnull DataParameter<?> key) {
        super.notifyDataManagerChange(key);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        final double baseSpeed = this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue();
        //final double baseHealth = this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue();
        // Multiply base health and base speed by one and a half
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(baseSpeed * 1.5D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20);
        this.getAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(10);
    }

    protected EntityChampion(EntityType<? extends EntityChampion> type, World p_i48553_2_) {
        super(type, p_i48553_2_);
        this.moveController = new MovementController(this);
        this.navigator = new GroundPathNavigator(this, p_i48553_2_);
        this.isImmuneToFire();
        this.stepHeight = 1;
        this.entityCollisionReduction = 100;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.setPathPriority(PathNodeType.DANGER_CACTUS, -1.0F);
        this.setPathPriority(PathNodeType.DAMAGE_OTHER, -1.0F);
        this.setPathPriority(PathNodeType.DANGER_OTHER, -1.0F);
    }

    float getSmallRandomFloat(@Nonnull final Float min, @Nonnull final Float max) {
        int tries = 0;
        do {
            float randFloat = rand.nextFloat();
            if (randFloat >= min && randFloat <= max) return randFloat;
            tries++;
        } while (tries < 30);
        return rand.nextBoolean() ? max : min;
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(@Nonnull IWorld worldIn, @Nonnull DifficultyInstance difficultyIn, @Nonnull SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        ItemStack stack5 = new ItemStack(Items.BOW, 1);
        stack5.addEnchantment(Enchantments.UNBREAKING, 3);
        stack5.addEnchantment(Enchantments.MENDING, 1);
        stack5.addEnchantment(Enchantments.INFINITY, 1);
        stack5.addEnchantment(Enchantments.POWER, 5);
        stack5.addEnchantment(Enchantments.FLAME, 1);
        stack5.addEnchantment(Enchantments.PUNCH, 2);
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, stack5);

        ItemStack stack6 = new ItemStack(Items.DIAMOND_SWORD, 1);
        stack6.addEnchantment(Enchantments.UNBREAKING, 3);
        stack6.addEnchantment(Enchantments.MENDING, 1);
        stack6.addEnchantment(Enchantments.SHARPNESS, 5);
        stack6.addEnchantment(Enchantments.SWEEPING, 5);
        stack6.addEnchantment(Enchantments.FIRE_ASPECT, 5);
        stack6.addEnchantment(Enchantments.LOOTING, 5);
        this.setItemStackToSlot(EquipmentSlotType.OFFHAND, stack6);

        this.setChaseMaxTicks(rand.nextInt(3000)+500);
        this.setScale(this.getSmallRandomFloat(0.6f, 1f) + this.getSmallRandomFloat(0.6f, 0.825f));//todo
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    @Override
    public float getAIMoveSpeed() {
        return (float) this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue();
    }

    private void updateAI(){
        //this.tasks.addTask(0, new EntityAIAttackRanged(this, this.getAIMoveSpeed(), 3, 3, 32));// attack using sword, and bow, needed for the epic high bow shot leap, only suitable for range or tamed_rage
        //this.tasks.addTask(3, new EntityAIAttackMelee(this, this.getAIMoveSpeed(), true));
        //this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 1.5D, 32f));

        this.goalSelector.addGoal(0, new SwimGoal(this));
        //this.tasks.addTask(1, new AIVikingEscapeIce(this, this.getAIMoveSpeed()));

        switch(this.getAiMode()){


            case CHILL:

                this.goalSelector.addGoal(0, new LookRandomlyGoal(this));

                break;
            case WILD:
            case MELEE:
            default:

                this.goalSelector.addGoal(0, new WaterAvoidingRandomWalkingGoal(this, 1, 20));
                this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 16));
                this.goalSelector.addGoal(3, new LookRandomlyGoal(this));

                break;
            case TAME_RAGE:
            case RANGED:

                RangedBowAttackGoal<EntityChampion> aiAttackRangedBow = new RangedBowAttackGoal<>(this, this.getAIMoveSpeed(), 30, 32);
                this.goalSelector.addGoal(1, aiAttackRangedBow);
                this.goalSelector.addGoal(2, new LookRandomlyGoal(this));

                break;
            case LOVE_STRUCK:

                this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 1, 20));
                this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
                break;
            case TAME_HEAL:
                this.goalSelector.addGoal(1, new MeleeAttackGoal(this, this.getAIMoveSpeed(), true));
                this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
                this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 4));

                break;
            case TAME_MOVE:

                break;
            case TAME_CALM:

                this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1, 20));
                this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
                this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8));

                break;
            case TAME_CUDDLE:

                this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 8));

                break;
        }
    }

    @Override
    public void updateAITasks() {
        this.updateAI();
        super.updateAITasks();
    }

    @Override
    public boolean handleWaterMovement() {
        return super.handleWaterMovement();
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return super.onLivingFall(distance, 0);
    }

    @Nonnull
    private AxisAlignedBB getAttackBounds() {
        return this.getBoundingBox().grow(2);
    }

    private double getDistance(@Nonnull final BlockPos one, @Nonnull final BlockPos two) {
        Vec3d d = new Vec3d(two.getX() - one.getX(), two.getY() - one.getY(),two.getZ() - one.getZ());
        Vec3d dd = new Vec3d(d.x * d.x, d.y * d.y, d.z * d.z);
        return Math.sqrt(dd.x + dd.y + dd.z);
    }

    private double getDistance2D(@Nonnull final BlockPos one, @Nonnull final BlockPos two) {
        Vec3d d = new Vec3d(two.getX() - one.getX(), two.getY() - one.getY(),two.getZ() - one.getZ());
        Vec3d dd = new Vec3d(d.x * d.x, d.y * d.y, d.z * d.z);
        return Math.sqrt(dd.x + dd.z);
    }

    private void runBefriendSpecial(@Nonnull final PlayerEntity player) {
        if (!world.isRemote) {

            this.setSpecialTamed(true);
            this.setTamerUuidString(player.getUniqueID().toString());
            this.triggerTaming(player);
            this.setChaseTicks(0);
            this.setMoveTicks(5000);
            this.setLoveStruckTicks(0);
            this.setAiMode(ChampAiMode.TAME_MOVE);
            LegendarySavages.LOGGER.warn("In EntitySpecialBase.runTameVampire is tamed: " + this.isSpecialTamed());
            LegendarySavages.LOGGER.warn("In EntitySpecialBase.runTameVampire tamer uuid: " + this.getTamerUuidString());
        }
    }

    boolean isTamer(@Nonnull final PlayerEntity player) {
        return Objects.equals(player.getUniqueID().toString(), this.getTamerUuidString());
    }

    private void runSetAiModeMelee() {//@Nonnull final Double dist
        if (!world.isRemote) {
            this.setAiMode(ChampAiMode.MELEE);
            this.setAttackMode(AttackMode.MELEE);
            this.setChaseTicks(this.getChaseTicks() + 1);
        }
    }

    private void runSetLoveStruckMode() {//@Nonnull final Double dist
        if (!world.isRemote) {
            this.setAiMode(ChampAiMode.LOVE_STRUCK);
            this.setAttackMode(AttackMode.LOVE_STRUCK);
            this.setChaseTicks(this.getChaseTicks() + 1);
        }
    }

    private void runSetAiModeRanged(@Nonnull final PlayerEntity player) {
        if (!world.isRemote) {
            this.setAiMode(ChampAiMode.RANGED);
            this.setAttackMode(AttackMode.RANGED);
            this.setChaseTicks(0);
            this.setAttackTarget(player);
        }
    }

    private void runSetAiModeTameHeal() { //@Nonnull final Double dist
        if (!world.isRemote) {
            this.setAiMode(ChampAiMode.TAME_HEAL);
            this.setAttackMode(AttackMode.TAME_HEAL);
            this.setChaseTicks(this.getChaseTicks() + 1);
        }
    }

    private void runSetAiModeTameRage(@Nonnull final PlayerEntity player) {
        if (!world.isRemote) {
            this.setAiMode(TAME_RAGE);
            this.setAttackMode(AttackMode.TAME_RAGE);
            this.setChaseTicks(0);
            this.setAttackTarget(player);
        }
    }

    private void runSetAiModeChill() {
        if (!world.isRemote) {
            this.setAiMode(ChampAiMode.CHILL);
            this.setAttackMode(AttackMode.NONE);
            this.setChaseTicks(0);
        }
    }

    private void runMoveSetHome() {
        if (!world.isRemote) {
            this.setMoveTicks(0);
            this.setMoveExtension(false);
            this.setAiMode(TAME_CALM);
        }
    }

    @Override
    public void livingTick() {
        super.livingTick();

        if (!world.isRemote) {

            if (this.getRestTicks() > 0) this.setRestTicks(this.getRestTicks() - 1);
            if (this.getLoveStruckTricks() > 0) this.setLoveStruckTicks(this.getLoveStruckTricks() - 1);

            if (this.isSpecialTamed()) if (this.getTamerUuid() == null) {
                if (this.getTamerUuidString().isEmpty()) this.setSpecialTamed(false);
                else this.setTamerUuid(UUID.fromString(this.getTamerUuidString()));
            }

            if (this.getRestTicks() > 0) {
                this.runSetAiModeChill();
            } else {
                PlayerEntity player = world.getClosestPlayer(this.getPosX(), this.getPosY(), this.getPosZ(), 32, true);

                if (!this.isSpecialTamed()) {
                    if (player == null) {
                        this.setAiMode(WILD);
                        this.setAttackMode(AttackMode.NONE);
                    } else if (!player.isAlive()) {
                        this.setAiMode(WILD);
                        this.setAttackMode(AttackMode.NONE);
                    } else {
                        //double dist = this.getDistance(this.getPosition(), player.getPosition());
                        double delta = (this.getPosition().getY() - player.getPosition().getY()) / this.getDistance2D(this.getPosition(), player.getPosition());

                        if (this.getLoveStruckTricks() > 0) {
                            if (this.getChaseTicks() > this.getChaseMaxTicks()) {
                                if (Objects.equals(this.getLastVictimUuid(), player.getUniqueID()))
                                    this.runBefriendSpecial(player);
                                else this.runSetAiModeRanged(player);
                            } else this.runSetLoveStruckMode();
                        } else if (this.getAttackMode() == AttackMode.RANGED) this.runSetAiModeRanged(player);
                        else if (delta < -1.0 || delta > 1.0 && !Double.isInfinite(delta))
                            this.runSetAiModeRanged(player);
                        else if (this.getChaseTicks() > this.getChaseMaxTicks()) this.runSetAiModeRanged(player);
                            /*
                            else if (dist < 16) this.runSetAiModeMelee(dist);
                            else if (dist <= this.getChaseDistDouble()) this.runSetAiModeMelee(dist);
                            else if (this.getAttackMode() == AttackMode.NONE) this.runSetAiModeMelee(dist);


                             */
                        else this.runSetAiModeMelee();

                    }
                } else if (this.isSpecialTamed()) {
                    if (player == null) {
                        this.setAiMode(TAME_CALM);
                        this.setAttackMode(AttackMode.NONE);
                    } else if (!player.isAlive()) {
                        this.setAiMode(TAME_CALM);
                        this.setAttackMode(AttackMode.NONE);
                    } else {
                        if (this.isTamer(player)) {

                            //double delta = (this.getPosition().getY() - player.getPosition().getY()) / this.getDistance2D(this.getPosition(), player.getPosition());
                            if (this.getHealth() < this.getMaxHealth()) {
                                if (this.getAttackMode() == AttackMode.TAME_RAGE)
                                    this.runSetAiModeTameRage(player);// rage is set in attackEntityFrom
                                else if (this.getChaseTicks() > this.getChaseMaxTicks())
                                    this.runSetAiModeTameRage(player);
                                else this.runSetAiModeTameHeal();
                            } else if (this.getAiMode() == ChampAiMode.TAME_MOVE) {
                                if (this.getMoveTicks() > 0 && this.isMoveExtension()) {
                                    if (!this.isInWater()) {
                                        if (world.getBlockState(this.getPosition().down()).getMaterial().isSolid())
                                            this.runMoveSetHome();
                                    }
                                } else if (this.getMoveTicks() > 0) {
                                    if (this.getAiMode() != ChampAiMode.TAME_MOVE)
                                        this.setAiMode(ChampAiMode.TAME_MOVE);
                                } else if (this.getMoveTicks() <= 0) {
                                    if (world.getBlockState(this.getPosition().down()).getMaterial().isSolid())
                                        this.runMoveSetHome();
                                    else {
                                        this.setMoveTicks(rand.nextInt(1000));
                                        this.setMoveExtension(true);
                                        this.setAiMode(ChampAiMode.TAME_MOVE);
                                    }
                                }
                            } else if (this.getAiMode() != ChampAiMode.TAME_MOVE && this.getMoveTicks() > 0)
                                this.setAiMode(ChampAiMode.TAME_MOVE);
                            else if (this.getDistance(this.getPosition(), player.getPosition()) <= 3)
                                this.setAiMode(ChampAiMode.TAME_CUDDLE);
                            else this.setAiMode(TAME_CALM);
                        } else this.runSetAiModeRanged(player);
                    }
                }
            }

            if (Reference.DEBUG_CHAMPION) {
                if (this.ticksExisted % 100 == 0) {
                    LegendarySavages.LOGGER.info("EntitySpecialBase.onLivingUpdate Skin Id: " + this.getSkinId());

                    LegendarySavages.LOGGER.info("EntitySpecialBase.onLivingUpdate ai mode: " + this.getAiMode());
                    LegendarySavages.LOGGER.warn("In EntitySpecialBase.onLivingUpdate ChaseMode: " + this.getAttackMode());
                    LegendarySavages.LOGGER.info("EntitySpecialBase.onLivingUpdate attack target: " + this.getAttackUuid());
                    LegendarySavages.LOGGER.info("EntitySpecialBase.onLivingUpdate revenge target: " + this.getRevengeUuid());
                    LegendarySavages.LOGGER.warn("In EntitySpecialBase.onLivingUpdate is Last Victim UUID: " + this.getLastVictimUuid());

                    LegendarySavages.LOGGER.info("EntitySpecialBase.onLivingUpdate health: " + this.getHealth());
                    LegendarySavages.LOGGER.info("EntitySpecialBase.onLivingUpdate Rest Ticks: " + this.getRestTicks());

                    LegendarySavages.LOGGER.info("EntitySpecialBase.onLivingUpdate Is Tamed: " + this.isSpecialTamed());
                    LegendarySavages.LOGGER.info("EntitySpecialBase.onLivingUpdate tamer: " + this.getTamerUuidString());

                    LegendarySavages.LOGGER.warn("In EntitySpecialBase.onLivingUpdate Chase Ticks: " + this.getChaseTicks());
                    LegendarySavages.LOGGER.warn("In EntitySpecialBase.onLivingUpdate Chase Max Ticks: " + this.getChaseMaxTicks());

                    LegendarySavages.LOGGER.info("EntitySpecialBase.onLivingUpdate Move ticks remaining: " + this.getMoveTicks());
                    LegendarySavages.LOGGER.info("EntitySpecialBase.onLivingUpdate Is Move Extention: " + this.isMoveExtension());

                    LegendarySavages.LOGGER.warn("In EntitySpecialBase.onLivingUpdate Love Struck Ticks: " + this.getLoveStruckTricks());
                }
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (!world.isRemote) {

            switch(this.getAiMode()) {

                case TAME_CALM:
                case CHILL:
                case TAME_CUDDLE:
                case WILD:

                    break;
                case MELEE:
                case LOVE_STRUCK:
                    this.runMeleeAIMode();

                    break;
                case TAME_HEAL:
                    this.runTamedHealAIMode();

                    break;
                case TAME_MOVE:
                    this.runTamedMoveAIMode();

                    break;
                case TAME_RAGE:
                case RANGED:
                    this.runTameRageAIMode();

                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + this.getAiMode());
            }
        }
    }

    @Override
    public boolean canBeCollidedWith() {
        return super.canBeCollidedWith();
    }

    private void chaseLivingEntity(@Nonnull final LivingEntity e) {
        if (!world.isRemote) {
            if (!e.isAlive()) return;
            if (this.getAttackBounds().intersects(e.getBoundingBox())) this.attackEntityAsMob(e);
            else this.getMoveHelper().setMoveTo(e.getPosX(), e.getPosY(), e.getPosZ(), this.getAIMoveSpeed());
        }
    }

    private void huntLivingEntity(@Nonnull final LivingEntity e) {
        if (!world.isRemote) {
            if (!e.isAlive()) return;
            if (this.getAttackBounds().intersects(e.getBoundingBox())) this.attackEntityAsMob(e);
            else if (this.getEntitySenses().canSee(e)) this.attackEntityWithRangedAttack(e, 1.0f);
            else this.getMoveHelper().setMoveTo(e.getPosX(), e.getPosY(), e.getPosZ(), this.getAIMoveSpeed());
        }
    }

    private void runTameRageAIMode() {
        if (!world.isRemote) {

            PlayerEntity revenge = this.getRevengeUuid() == null ? null : world.getPlayerByUuid(this.getRevengeUuid());
            PlayerEntity target = this.getAttackUuid() == null ? null : world.getPlayerByUuid(this.getAttackUuid());

            if (revenge != null) huntLivingEntity(revenge);
            else if (target != null) huntLivingEntity(target);
            else {
                PlayerEntity tamer = this.getTamerUuid() == null ? null : world.getPlayerByUuid(this.getTamerUuid());
                if (tamer != null) huntLivingEntity(tamer);
                else {
                    PlayerEntity close = world.getClosestPlayer(this.getPosX(), this.getPosY(), this.getPosZ(), 32.0D, false);
                    if (close != null) huntLivingEntity(close);
                }
            }
        }
    }

    private void runTamedHealAIMode() {
        if (!world.isRemote) {
            PlayerEntity revenge = this.getRevengeUuid() == null ? null : world.getPlayerByUuid(this.getRevengeUuid());
            PlayerEntity target = this.getAttackUuid() == null ? null : world.getPlayerByUuid(this.getAttackUuid());

            if (revenge != null) chaseLivingEntity(revenge);
            else if (target != null) chaseLivingEntity(target);
            else {
                PlayerEntity tamer = this.getTamerUuid() == null ? null : world.getPlayerByUuid(this.getTamerUuid());
                if (tamer != null) chaseLivingEntity(tamer);
                else {
                    PlayerEntity close = world.getClosestPlayer(this.getPosX(), this.getPosY(), this.getPosZ(), 32.0D, false);
                    if (close != null) chaseLivingEntity(close);
                }
            }
        }
    }

    private void runMeleeAIMode() {
        if (!world.isRemote) {
            PlayerEntity target = world.getClosestPlayer(this.getPosX(), this.getPosY(), this.getPosZ(), 32.0D, false);
            if (target != null) {
                if (target.isAlive()) chaseLivingEntity(target);
            }
        }
    }

    private void runTamedMoveAIMode() {
        if (!world.isRemote) {
            if (!this.isSpecialTamed()) return;
            PlayerEntity tamer = this.getTamerUuid() == null ? null : world.getPlayerByUuid(this.getTamerUuid());
            if (tamer == null) return;
            if (!tamer.isAlive()) return;

            //int rot = MathHelper.floor((double) (tamer.rotationYaw * 4.0F / 360.0F) + 1.5D) & 3;
            int rot = MathHelper.floor((double) (tamer.rotationYaw * 8.0F / 360.0F) + 0.5D) & 7;
            //OreberriesGalore.LOGGER.warn("Rotation: " + rot);
            //OreberriesGalore.LOGGER.warn("Facing: " + tamer.getHorizontalFacing());
            switch (rot) {
                case 0: // south
                    this.getMoveHelper().setMoveTo(this.getPosX(), this.getPosY(), this.getPosZ() + 1, 1);
                    break;
                case 1: /// south west
                    this.getMoveHelper().setMoveTo(this.getPosX() - 1, this.getPosY(), this.getPosZ() + 1, 1);
                    break;
                case 2: //west
                    this.getMoveHelper().setMoveTo(this.getPosX() - 1, this.getPosY(), this.getPosZ(), 1);
                    break;
                case 3: // north west
                    this.getMoveHelper().setMoveTo(this.getPosX() - 1, this.getPosY(), this.getPosZ() - 1, 1);
                    break;
                case 4: // north
                    this.getMoveHelper().setMoveTo(this.getPosX(), this.getPosY(), this.getPosZ() - 1, 1);
                    break;
                case 5: // north east
                    this.getMoveHelper().setMoveTo(this.getPosX() + 1, this.getPosY(), this.getPosZ() - 1, 1);
                    break;
                case 6: // east
                    this.getMoveHelper().setMoveTo(this.getPosX() + 1, this.getPosY(), this.getPosZ(), 1);
                    break;
                case 7: // south east
                    this.getMoveHelper().setMoveTo(this.getPosX() + 1, this.getPosY(), this.getPosZ() + 1, 1);
                    break;
                default:
                    LegendarySavages.LOGGER.warn("Odd value" + rot);
                    break;
            }
            this.setMoveTicks(this.getMoveTicks() - 1);
        }
    }

    @Override
    public void swingArm(@Nonnull Hand hand) {
        super.swingArm(hand);
    }

    @Override
    protected void updateArmSwingProgress() {
        super.updateArmSwingProgress();
    }

    @Override
    public float getSwingProgress(float partialTickTime) {
        return super.getSwingProgress(partialTickTime);
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox() {
        return super.getCollisionBoundingBox();
    }

    @Override
    public void onCollideWithPlayer(@Nonnull PlayerEntity entityIn) {
        if (!world.isRemote) {
            if (entityIn.isCreative() || entityIn.isSpectator() || !entityIn.isAlive()) return;
            this.setAttackUuid(entityIn.getUniqueID());
            if (!this.isSpecialTamed()) {
                this.attackEntityAsMob(entityIn);
            } else {
                if (this.isTamer(entityIn)) {
                    if (this.getAiMode() == TAME_CALM || this.getAiMode() == WILD || this.getAiMode() == ChampAiMode.TAME_CUDDLE) {
                        this.setAiMode(ChampAiMode.TAME_CUDDLE);
                        this.setMotion(new Vec3d(0,0,0));
                    } else { // heal, move, rage
                        this.attackEntityAsMob(entityIn);
                    }
                } else {
                    this.attackEntityAsMob(entityIn);
                }
            }
        }
    }

    @Override
    public boolean attackEntityFrom(@Nonnull final DamageSource source, final float amount) {
        Entity entity = source.getTrueSource();
        if (this.isInvulnerableTo(source)) return false;
        if (entity instanceof LivingEntity) {
            this.setRevengeTarget((LivingEntity) entity);
            if (entity instanceof PlayerEntity) {
                if (amount > 0) {
                    this.setRevengeUuid(entity.getUniqueID());
                    if (source.getDamageType().equalsIgnoreCase("arrow")) {
                        //LegendarySavages.LOGGER.warn(String.format("EntitySpecialBase.attackEntityFrom hurt by %s damage %s", source.damageType, amount));
                        //LegendarySavages.LOGGER.warn(String.format("EntitySpecialBase.attackEntityFrom hurt by %s damage %s", source.getTrueSource(), amount));
                        if (!this.isSpecialTamed()) {
                            if( source.getImmediateSource() instanceof ArrowEntity) {
                                ArrowEntity tippedArrow = (ArrowEntity) source.getImmediateSource();
                                LegendarySavages.LOGGER.warn("EntitySpecialBase.attackEntityFrom immediate source " + source.getImmediateSource());
                                LegendarySavages.LOGGER.warn("EntitySpecialBase.attackEntityFrom arrow color: " + tippedArrow.getColor());//3694022
                                LegendarySavages.LOGGER.warn("EntitySpecialBase.attackEntityFrom arrow name: " + tippedArrow.getName());//1296a302-2afe-4661-94ca-1c6262bef4da this is arrow specific

                                if (tippedArrow.getColor()==3694022) {
                                    if (this.getLoveStruckTricks() <= 0) {
                                        if (Reference.DEBUG_CHAMPION) LegendarySavages.LOGGER.warn("EntitySpecialBase.attackEntityFrom setting love struck ticks to 6000 to: " + this.getName());
                                        this.setLoveStruckTicks(6000);
                                        this.setChaseTicks(0);
                                        this.setAiMode(ChampAiMode.LOVE_STRUCK);
                                        this.setAttackMode(AttackMode.LOVE_STRUCK);
                                    }
                                } else {
                                    if (rand.nextInt(4)==0) {
                                        this.setAiMode(RANGED);
                                        this.setAttackMode(AttackMode.RANGED);
                                    }
                                }
                            } else {
                                if (rand.nextInt(4)==0) {
                                    this.setAiMode(RANGED);
                                    this.setAttackMode(AttackMode.RANGED);
                                }
                            }
                        } else {

                            if (this.isTamer((PlayerEntity) entity)) {
                                if( source.getImmediateSource() instanceof ArrowEntity) {
                                    ArrowEntity tippedArrow = (ArrowEntity) source.getImmediateSource();
                                    if (tippedArrow.getColor() != 3694022) {
                                        double delta = (this.getPosition().getY() - entity.getPosition().getY()) / this.getDistance2D(this.getPosition(), entity.getPosition());
                                        //LegendarySavages.LOGGER.info("LegendarySpecialBase. delta between target and mob : " + delta);
                                        if (delta >= -1.0 && delta < 1.0) {
                                            //LegendarySavages.LOGGER.info("LegendarySpecialBase. setting TAME_RAGE as delta " + delta);
                                            if (rand.nextInt(4)==0) {
                                                this.setAiMode(TAME_RAGE);
                                                this.setAttackMode(AttackMode.TAME_RAGE);
                                            }
                                        }
                                    }
                                } else {
                                    double delta = (this.getPosition().getY() - entity.getPosition().getY()) / this.getDistance2D(this.getPosition(), entity.getPosition());
                                    //LegendarySavages.LOGGER.info("LegendarySpecialBase. delta between target and mob : " + delta);
                                    if (delta >= -1.0 && delta < 1.0) {
                                        //LegendarySavages.LOGGER.info("LegendarySpecialBase. setting TAME_RAGE as delta " + delta);
                                        if (rand.nextInt(4)==0) {
                                            this.setAiMode(TAME_RAGE);
                                            this.setAttackMode(AttackMode.TAME_RAGE);
                                        }
                                    }
                                }
                            } else {
                                if (rand.nextInt(4)==0) {
                                    this.setAiMode(RANGED);
                                    this.setAttackMode(AttackMode.RANGED);
                                }
                            }
                        }
                    }
                }
            }
        }

        return super.attackEntityFrom(source, amount);
    }

    @Override
    public boolean attackEntityAsMob(@Nonnull final Entity entityIn) {
        if (!world.isRemote) {
            if (!entityIn.isAlive()) return false;
            if (entityIn instanceof PlayerEntity) if (((PlayerEntity) entityIn).isCreative() || entityIn.isSpectator()) return false;
            if (entityIn instanceof LivingEntity) {
                if (this.getAttackBounds().intersects(entityIn.getBoundingBox())) {
                    if (entityIn instanceof PlayerEntity) {
                        if (this.getAiMode()== ChampAiMode.CHILL) return false;
                        PlayerEntity player = (PlayerEntity)entityIn;
                        if (player.isCreative() || player.isSpectator()) return false;
                        if (!this.isSpecialTamed()) {
                            this.swingArm(Hand.OFF_HAND);
                            entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) Objects.requireNonNull(this.getAttributes().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE)).getValue());
                        } else {
                            if (this.isTamer(player)) {
                                this.swingArm(Hand.OFF_HAND);
                                entityIn.attackEntityFrom(DamageSourceOwned.causeMobDamage(this), (float) Objects.requireNonNull(this.getAttributes().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE)).getValue());
                            } else {
                                this.swingArm(Hand.OFF_HAND);
                                entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) Objects.requireNonNull(this.getAttributes().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE)).getValue());
                            }
                        }
                    } else {
                        this.swingArm(Hand.OFF_HAND);
                        entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) Objects.requireNonNull(this.getAttributes().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE)).getValue());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onDeath(@Nonnull final DamageSource cause) {
        super.onDeath(cause);
    }

    @Override
    protected void onDeathUpdate() {
        super.onDeathUpdate();
    }

    @Nonnull
    protected ResourceLocation getLootTable() {
        return LOOT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return LSSoundRegistry.CHAMPION_LIVING;
    }

    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSourceIn) {
        return LSSoundRegistry.CHAMPION_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return LSSoundRegistry.CHAMPION_DEATH;
    }

    @Override
    protected boolean canEquipItem(@Nonnull final ItemStack stack) {
        return super.canEquipItem(stack);
    }

    @Override
    public boolean canPickUpLoot() {
        return false;
    }

    @Override
    protected boolean canDropLoot() {
        return false;
    }

    @Override
    public void setAttackTarget(LivingEntity entitylivingbaseIn) {
        super.setAttackTarget(entitylivingbaseIn);
    }

    @Override
    public void setRevengeTarget(LivingEntity livingBase) {
        super.setRevengeTarget(livingBase);
    }

    @Override
    public boolean isImmuneToExplosions() {
        return false;
    }


    @Override
    public boolean canBeLeashedTo(@Nonnull PlayerEntity player) {
        return false;
    }

    @Override
    protected boolean canBeRidden(@Nonnull final Entity entityIn) {
        return false;
    }

    @Override
    public boolean canBePushed() {
        return super.canBePushed();
    }

    @Override
    public boolean canBeSteered() {
        return false;
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }

    @Override
    public boolean canRenderOnFire() {
        return false;
    }

    @Override
    public boolean isNoDespawnRequired() {
        return true;
    }

    @Nonnull
    @Override
    public CombatTracker getCombatTracker() {
        return super.getCombatTracker();
    }

    @Override
    public void attackEntityWithRangedAttack(@Nonnull LivingEntity target, float distanceFactor) {
        if (!world.isRemote) {
            if (this.getAiMode()== ChampAiMode.RANGED || this.getAiMode()== TAME_RAGE) {
                if (this.getHeldItemMainhand().getItem() == Items.BOW || this.getHeldItemOffhand().getItem() == Items.BOW) {
                    //if (target instanceof ServerPlayerEntity) {
                        if (target.isAlive()) {
                            if (this.getEntitySenses().canSee(target)) {
                                switch (rand.nextInt(3)) {
                                    case 0:
                                    default:
                                        ArrowEntity arrow = new ArrowEntity(world, this);
                                        arrow.setEnchantmentEffectsFromEntity(this, distanceFactor);
                                        arrow.addTrackingPlayer((ServerPlayerEntity) target);

                                        double d0 = target.getPosX() - this.getPosX();
                                        double d1 = target.getBoundingBox().minY + (double) (target.getHeight() / 3.0F) - arrow.getPosY();
                                        double d2 = target.getPosZ() - this.getPosZ();
                                        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
                                        arrow.shoot(d0, d1 + d3 * 0.2, d2, 1.6F, (float) (14 - world.getDifficulty().getId() * 4));
                                        this.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1, 1 / (this.getRNG().nextFloat() * 0.4F + 0.8F));
                                        world.addEntity(arrow);
                                        break;
                                    case 1:
                                        SpectralArrowEntity spectralArrow = new SpectralArrowEntity(world, this);
                                        spectralArrow.setEnchantmentEffectsFromEntity(this, distanceFactor);
                                        spectralArrow.addTrackingPlayer((ServerPlayerEntity) target);

                                        double da0 = target.getPosX() - this.getPosX();
                                        double da1 = target.getBoundingBox().minY + (double) (target.getHeight() / 3.0F) - spectralArrow.getPosY();
                                        double da2 = target.getPosZ() - this.getPosZ();
                                        double da3 = MathHelper.sqrt(da0 * da0 + da2 * da2);
                                        spectralArrow.shoot(da0, da1 + da3 * 0.2, da2, 1.6F, (float) (14 - world.getDifficulty().getId() * 4));
                                        this.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1, 1 / (this.getRNG().nextFloat() * 0.4F + 0.8F));
                                        world.addEntity(spectralArrow);

                                        break;
                                    case 2:
                                        ArrowEntity tippedArrow = new ArrowEntity(world, this);
                                        tippedArrow.setEnchantmentEffectsFromEntity(this, distanceFactor);
                                        tippedArrow.addTrackingPlayer((ServerPlayerEntity) target);

                                        double db0 = target.getPosX() - this.getPosX();
                                        double db1 = target.getBoundingBox().minY + (double) (target.getHeight() / 3.0F) - tippedArrow.getPosY();
                                        double db2 = target.getPosZ() - this.getPosZ();
                                        double db3 = MathHelper.sqrt(db0 * db0 + db2 * db2);
                                        //arrow.setThrowableHeading(d0, d1 + d3 * 0.2, d2, 1.6F, (float)(14 - world.getDifficulty().getDifficultyId() * 4));


                                        int dice = rand.nextInt(ArrowPotion.values().length);
                                        ArrowPotion arrowPotion = ArrowPotion.values()[dice];
                                        switch (arrowPotion) {

                                            case ABSORPTION:
                                                tippedArrow.addEffect(new EffectInstance(ABSORPTION, 600, 8, true, true));
                                                break;
                                            case FIRE_RESISTANCE:
                                                tippedArrow.addEffect(new EffectInstance(FIRE_RESISTANCE, 600, 8, true, true));
                                                break;
                                            case GLOWING:
                                                tippedArrow.addEffect(new EffectInstance(GLOWING, 600, 8, true, true));
                                                break;
                                            case HASTE:
                                                tippedArrow.addEffect(new EffectInstance(HASTE, 600, 8, true, true));
                                                break;
                                            case HEALTH_BOOST:
                                                tippedArrow.addEffect(new EffectInstance(HEALTH_BOOST, 600, 8, true, true));
                                                break;
                                            case HUNGER:
                                                tippedArrow.addEffect(new EffectInstance(HUNGER, 600, 8, true, true));
                                                break;
                        /*case INSTANT_DAMAGE:
                            tippedArrow.addEffect(new PotionEffect(INSTANT_DAMAGE, 600, 8, true, true));
                            break;
                            */
                                            case INSTANT_HEALTH:
                                                tippedArrow.addEffect(new EffectInstance(INSTANT_HEALTH, 600, 8, true, true));
                                                break;
                                            case INVISIBILITY:
                                                tippedArrow.addEffect(new EffectInstance(INVISIBILITY, 600, 8, true, true));
                                                break;
                                            case JUMP_BOOST:
                                                tippedArrow.addEffect(new EffectInstance(JUMP_BOOST, 600, 8, true, true));
                                                break;
                                            case LEVITATION:
                                                tippedArrow.addEffect(new EffectInstance(LEVITATION, 600, 8, true, true));
                                                break;
                                            case LUCK:
                                                tippedArrow.addEffect(new EffectInstance(LUCK, 600, 8, true, true));
                                                break;
                                            case MINING_FATIGUE:
                                                tippedArrow.addEffect(new EffectInstance(MINING_FATIGUE, 600, 8, true, true));
                                                break;
                                            case NAUSEA:
                                                tippedArrow.addEffect(new EffectInstance(NAUSEA, 600, 8, true, true));
                                                break;
                                            case NIGHT_VISION:
                                                tippedArrow.addEffect(new EffectInstance(NIGHT_VISION, 600, 8, true, true));
                                                break;
                                            case POISON:
                                                tippedArrow.addEffect(new EffectInstance(POISON, 600, 8, true, true));
                                                break;
                                            case REGENERATION:
                                                tippedArrow.addEffect(new EffectInstance(REGENERATION, 600, 8, true, true));
                                                break;
                                            case RESISTANCE:
                                                tippedArrow.addEffect(new EffectInstance(RESISTANCE, 600, 8, true, true));
                                                break;
                                            case SATURATION:
                                                tippedArrow.addEffect(new EffectInstance(SATURATION, 600, 8, true, true));
                                                break;
                                            case SLOWNESS:
                                                tippedArrow.addEffect(new EffectInstance(SLOWNESS, 600, 8, true, true));
                                                break;
                                            case SPEED:
                                                tippedArrow.addEffect(new EffectInstance(SPEED, 600, 8, true, true));
                                                break;
                                            case STRENGTH:
                                                tippedArrow.addEffect(new EffectInstance(STRENGTH, 600, 8, true, true));
                                                break;
                                            case UNLUCK:
                                                tippedArrow.addEffect(new EffectInstance(UNLUCK, 600, 8, true, true));
                                                break;
                                            case WATER_BREATHING:
                                                tippedArrow.addEffect(new EffectInstance(WATER_BREATHING, 600, 8, true, true));
                                                break;
                                            case WEAKNESS:
                                                tippedArrow.addEffect(new EffectInstance(WEAKNESS, 600, 8, true, true));
                                                break;
                                            case WITHER:
                                                tippedArrow.addEffect(new EffectInstance(WITHER, 600, 8, true, true));
                                                break;
                                        }
                                        tippedArrow.shoot(db0, db1 + db3 * 0.20000000298023224, db2, 1.66F, (float) (14 - world.getDifficulty().getId() * 4));
                                        this.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1, 1 / (this.getRNG().nextFloat() * 0.4F + 0.8F));
                                        world.addEntity(tippedArrow);
                                        break;
                                }
                            }
                        }
                    //}
                }
            }
        }
    }

    public abstract void triggerTaming(@Nonnull final PlayerEntity player);
}


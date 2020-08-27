package straitlaced.legendarysavages.server.advancements.criterion;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import straitlaced.legendarysavages.server.entity.monster.EntityChampionAatrox;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GentleChampionAatroxTrigger implements ICriterionTrigger<GentleChampionAatroxTrigger.Instance> {
    private static final ResourceLocation ID = new ResourceLocation("legendarysavages:gentle_champion_aatrox");
    private final Map<PlayerAdvancements, GentleChampionAatroxTrigger.Listeners> listeners = Maps.newHashMap();

    @Nonnull
    public ResourceLocation getId() {
        return ID;
    }

    public void addListener(@Nonnull PlayerAdvancements playerAdvancementsIn, @Nonnull ICriterionTrigger.Listener<GentleChampionAatroxTrigger.Instance> listener) {
        GentleChampionAatroxTrigger.Listeners gentleChampionAatroxTrigger$listeners = this.listeners.get(playerAdvancementsIn);
        if (gentleChampionAatroxTrigger$listeners == null) {
            gentleChampionAatroxTrigger$listeners = new GentleChampionAatroxTrigger.Listeners(playerAdvancementsIn);
            this.listeners.put(playerAdvancementsIn, gentleChampionAatroxTrigger$listeners);
        }

        gentleChampionAatroxTrigger$listeners.add(listener);
    }

    public void removeListener(@Nonnull PlayerAdvancements playerAdvancementsIn, @Nonnull ICriterionTrigger.Listener<GentleChampionAatroxTrigger.Instance> listener) {
        GentleChampionAatroxTrigger.Listeners gentleChampionAatroxTrigger$listeners = this.listeners.get(playerAdvancementsIn);
        if (gentleChampionAatroxTrigger$listeners != null) {
            gentleChampionAatroxTrigger$listeners.remove(listener);
            if (gentleChampionAatroxTrigger$listeners.isEmpty()) {
                this.listeners.remove(playerAdvancementsIn);
            }
        }

    }

    public void removeAllListeners(@Nonnull PlayerAdvancements playerAdvancementsIn) {
        this.listeners.remove(playerAdvancementsIn);
    }

    @Nonnull
    public GentleChampionAatroxTrigger.Instance deserializeInstance(JsonObject json, @Nonnull JsonDeserializationContext context) {
        EntityPredicate entitypredicate = EntityPredicate.deserialize(json.get("entity"));
        return new GentleChampionAatroxTrigger.Instance(entitypredicate);
    }

    public void trigger(ServerPlayerEntity player, EntityChampionAatrox entity) {
        GentleChampionAatroxTrigger.Listeners gentleChampionAatroxTrigger$listeners = this.listeners.get(player.getAdvancements());
        if (gentleChampionAatroxTrigger$listeners != null) {
            gentleChampionAatroxTrigger$listeners.trigger(player, entity);
        }

    }

    public static class Instance extends CriterionInstance {
        private final EntityPredicate entity;

        public Instance(EntityPredicate entity) {
            super(GentleChampionAatroxTrigger.ID);
            this.entity = entity;
        }

        public static GentleChampionAatroxTrigger.Instance any() {
            return new GentleChampionAatroxTrigger.Instance(EntityPredicate.ANY);
        }

        public static GentleChampionAatroxTrigger.Instance func_215124_a(EntityPredicate p_215124_0_) {
            return new GentleChampionAatroxTrigger.Instance(p_215124_0_);
        }

        public boolean test(ServerPlayerEntity player, EntityChampionAatrox entity) {
            return this.entity.test(player, entity);
        }

        @Nonnull
        public JsonElement serialize() {
            JsonObject jsonobject = new JsonObject();
            jsonobject.add("entity", this.entity.serialize());
            return jsonobject;
        }
    }

    static class Listeners {
        private final PlayerAdvancements playerAdvancements;
        private final Set<Listener<GentleChampionAatroxTrigger.Instance>> listeners = Sets.newHashSet();

        public Listeners(PlayerAdvancements playerAdvancementsIn) {
            this.playerAdvancements = playerAdvancementsIn;
        }

        public boolean isEmpty() {
            return this.listeners.isEmpty();
        }

        public void add(ICriterionTrigger.Listener<GentleChampionAatroxTrigger.Instance> listener) {
            this.listeners.add(listener);
        }

        public void remove(ICriterionTrigger.Listener<GentleChampionAatroxTrigger.Instance> listener) {
            this.listeners.remove(listener);
        }

        public void trigger(ServerPlayerEntity player, EntityChampionAatrox entity) {
            List<Listener<GentleChampionAatroxTrigger.Instance>> list = null;

            for(ICriterionTrigger.Listener<GentleChampionAatroxTrigger.Instance> listener : this.listeners) {
                if (listener.getCriterionInstance().test(player, entity)) {
                    if (list == null) {
                        list = Lists.newArrayList();
                    }

                    list.add(listener);
                }
            }

            if (list != null) {
                for(ICriterionTrigger.Listener<GentleChampionAatroxTrigger.Instance> listener1 : list) {
                    listener1.grantCriterion(this.playerAdvancements);
                }
            }
        }
    }
}

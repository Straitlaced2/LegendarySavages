package straitlaced.legendarysavages.client.renders;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import straitlaced.legendarysavages.LegendarySavages;
import straitlaced.legendarysavages.client.models.ModelBiped64;
import straitlaced.legendarysavages.server.entity.monster.EntityChampionAlistar;

import javax.annotation.Nonnull;

public class RenderChampionAlistar extends LivingRenderer<EntityChampionAlistar, ModelBiped64<EntityChampionAlistar>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LegendarySavages.MODID, "textures/model/legendary/alistar_a.png");

    public RenderChampionAlistar(EntityRendererManager renderManager) {
        super(renderManager, new ModelBiped64<>(   1.2f, false), 0.3f);
        this.addLayer(new HeldItemLayer<>(this));
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull EntityChampionAlistar entity) {
        return TEXTURE;
    }

    public static class RenderFactory implements IRenderFactory<EntityChampionAlistar> {

        @Override
        public EntityRenderer<? super EntityChampionAlistar> createRenderFor(EntityRendererManager manager) {
            return new RenderChampionAlistar(manager);
        }
    }
}

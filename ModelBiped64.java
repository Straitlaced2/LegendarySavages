package straitlaced.legendarysavages.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.HandSide;

import javax.annotation.Nonnull;

public class ModelBiped64<T extends LivingEntity> extends BipedModel<T> {

    private final boolean smallArms;

    public ModelBiped64(float modelSizeIn, boolean smallArmsIn) {
        super(RenderType::getEntityCutoutNoCull, modelSizeIn, 0.0F, 64, 64);
        this.smallArms= smallArmsIn;
        textureWidth = 64;
        textureHeight = 64;

        /*
        this.bipedHead = new ModelRenderer(this, 0, 0);
      this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, modelSizeIn);
      this.bipedHead.setRotationPoint(0.0F, 0.0F + yOffsetIn, 0.0F);
      this.bipedHeadwear = new ModelRenderer(this, 32, 0);
      this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, modelSizeIn + 0.5F);
      this.bipedHeadwear.setRotationPoint(0.0F, 0.0F + yOffsetIn, 0.0F);

      this.bipedBody = new ModelRenderer(this, 16, 16);
      this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, modelSizeIn);
      this.bipedBody.setRotationPoint(0.0F, 0.0F + yOffsetIn, 0.0F);

      this.bipedRightArm = new ModelRenderer(this, 40, 16);
      this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
      this.bipedRightArm.setRotationPoint(-5.0F, 2.0F + yOffsetIn, 0.0F);

      this.bipedLeftArm = new ModelRenderer(this, 40, 16);
      this.bipedLeftArm.mirror = true;
      this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
      this.bipedLeftArm.setRotationPoint(5.0F, 2.0F + yOffsetIn, 0.0F);

      this.bipedRightLeg = new ModelRenderer(this, 0, 16);
      this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
      this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F + yOffsetIn, 0.0F);

      this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
      this.bipedLeftLeg.mirror = true;
      this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
      this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F + yOffsetIn, 0.0F);
         */

        /*
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, modelSizeIn);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHead.setTextureSize(64, 64);

        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, modelSizeIn);
        this.bipedBody.setRotationPoint(0.0F, 0F, 0.0F);
        this.bipedBody.setTextureSize(64, 64);

        if (this.smallArms) {

            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, modelSizeIn);
            this.bipedRightArm.setRotationPoint(-5.0F, 0.0F, 0.0F);
            this.bipedRightArm.rotateAngleZ = 0.0349066F;
            this.bipedRightArm.setTextureSize(64, 64);

            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
            this.bipedLeftArm.addBox(3.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, modelSizeIn);// not 0.9, not 0
            this.bipedLeftArm.setRotationPoint(5.0F, 0.0F, 0.0F);
            this.bipedLeftArm.rotateAngleZ = -0.0349066F;
            this.bipedLeftArm.setTextureSize(64, 64);
        } else {
            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
            this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
            this.bipedRightArm.rotateAngleZ = 0.0349066F;
            this.bipedRightArm.setTextureSize(64, 64);

            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
            this.bipedLeftArm.addBox(3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);//was 0.9f
            this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
            this.bipedLeftArm.rotateAngleZ = -0.0349066F;
            this.bipedLeftArm.setTextureSize(64, 64);

        }
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
        this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.bipedRightLeg.rotateAngleZ = 0.0174533F;
        this.bipedRightLeg.setTextureSize(64, 64);

        this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
        this.bipedLeftLeg.addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
        this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.bipedLeftLeg.rotateAngleZ = -0.0174533F;
        this.bipedLeftLeg.setTextureSize(64, 64);
         */

        /*
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, modelSizeIn);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHead.setTextureSize(64, 64);

        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, modelSizeIn);//was 8 wide, was x -4
        this.bipedBody.setRotationPoint(0.0F, 0F, 0.0F);
        this.bipedBody.setTextureSize(64, 64);

        if (this.smallArms) {

            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-2.9F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, modelSizeIn);
            this.bipedRightArm.setRotationPoint(-5.0F, 0F, 0.0F);
            this.bipedRightArm.rotateAngleZ = 0.0349066F;
            this.bipedRightArm.setTextureSize(64, 64);

            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
            this.bipedLeftArm.addBox(1.9F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, modelSizeIn);// not 0.9, not 0
            this.bipedLeftArm.setRotationPoint(5.0F, 0F, 0.0F);
            this.bipedLeftArm.rotateAngleZ = -0.0349066F;
            this.bipedLeftArm.setTextureSize(64, 64);
        } else {
            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-4.9F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
            this.bipedRightArm.setRotationPoint(-5.0F, 0F, 0.0F);
            this.bipedRightArm.rotateAngleZ = 0.0349066F;
            this.bipedRightArm.setTextureSize(64, 64);

            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
            this.bipedLeftArm.addBox(0.9F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);//was 0.9f
            this.bipedLeftArm.setRotationPoint(5.0F, 0F, 0.0F);
            this.bipedLeftArm.rotateAngleZ = -0.0349066F;
            this.bipedLeftArm.setTextureSize(64, 64);
        }

        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
        this.bipedRightLeg.setRotationPoint(-2F, 11, 0.0F);
        this.bipedRightLeg.rotateAngleZ = 0.0174533F;
        this.bipedRightLeg.setTextureSize(64, 64);

        this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
        this.bipedLeftLeg.addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
        this.bipedLeftLeg.setRotationPoint(2F, 11, 0.0F);
        this.bipedLeftLeg.rotateAngleZ = -0.0174533F;
        this.bipedLeftLeg.setTextureSize(64, 64);

         */

        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-3.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, modelSizeIn);//head origx = -4
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHead.setTextureSize(64, 64);

        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 10.0F, 12.0F, 4.0F, modelSizeIn);//was 8 wide, was x -4
        this.bipedBody.setRotationPoint(0.0F, 0F, 0.0F);
        this.bipedBody.setTextureSize(64, 64);

        if (this.smallArms) {

            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-4.1F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, modelSizeIn);//-4.1 perfect, -4.2 small gap
            this.bipedRightArm.setRotationPoint(-5.0F, 0F, 0.0F);
            this.bipedRightArm.rotateAngleZ = 0.0349066F;
            this.bipedRightArm.setTextureSize(64, 64);

            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
            this.bipedLeftArm.addBox(3.1F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, modelSizeIn);//3.1 perfect, 3.2 small gap
            this.bipedLeftArm.setRotationPoint(5.0F, 0F, 0.0F);
            this.bipedLeftArm.rotateAngleZ = -0.0349066F;
            this.bipedLeftArm.setTextureSize(64, 64);
        } else {
            this.bipedRightArm = new ModelRenderer(this, 40, 16);
            this.bipedRightArm.addBox(-5.3F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);//-5.3 perfect
            this.bipedRightArm.setRotationPoint(-5.0F, 0F, 0.0F);
            this.bipedRightArm.rotateAngleZ = 0.0349066F;
            this.bipedRightArm.setTextureSize(64, 64);

            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
            this.bipedLeftArm.addBox(3.2F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);// small gagp at 3.4, tiny gap 3.3
            this.bipedLeftArm.setRotationPoint(5.0F, 0F, 0.0F);
            this.bipedLeftArm.rotateAngleZ = -0.0349066F;
            this.bipedLeftArm.setTextureSize(64, 64);
        }

        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
        this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.bipedRightLeg.rotateAngleZ = 0.0174533F;
        this.bipedRightLeg.setTextureSize(64, 64);

        this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
        this.bipedLeftLeg.addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSizeIn);
        this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.bipedLeftLeg.rotateAngleZ = -0.0174533F;
        this.bipedLeftLeg.setTextureSize(64, 64);
    }

    @Nonnull
    protected Iterable<ModelRenderer> getHeadParts() {
        return ImmutableList.of(this.bipedHead);
    }

    @Nonnull
    protected Iterable<ModelRenderer> getBodyParts() {
        return ImmutableList.of(this.bipedBody, this.bipedRightArm, this.bipedLeftArm, this.bipedRightLeg, this.bipedLeftLeg);
    }

    public void translateHand(@Nonnull HandSide sideIn, @Nonnull MatrixStack matrixStackIn) {
        ModelRenderer modelrenderer = this.getArmForSide(sideIn);
        if (this.smallArms) {
            float f = 0.5F * (float)(sideIn == HandSide.RIGHT ? 1 : -1);
            modelrenderer.rotationPointX += f;
            modelrenderer.translateRotate(matrixStackIn);
            modelrenderer.rotationPointX -= f;
        } else {
            modelrenderer.translateRotate(matrixStackIn);
        }
    }
}
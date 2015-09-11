package info.loenwind.enderioaddons.machine.cobbleworks;

import info.loenwind.enderioaddons.machine.framework.GroupObjectWithIcon;
import info.loenwind.enderioaddons.machine.framework.RendererFrameworkMachine;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.obj.GroupObject;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RendererCobbleworks implements ISimpleBlockRenderingHandler {

  @Nonnull
  private final RendererFrameworkMachine frameRenderer;

  public RendererCobbleworks(@Nonnull RendererFrameworkMachine frameRenderer) {
    this.frameRenderer = frameRenderer;
    GroupObject controllerActive = new GroupObjectWithIcon(frameRenderer.getControllerPart(1), BlockCobbleworks.getBlock());
    GroupObject controllerPassive = new GroupObjectWithIcon(frameRenderer.getControllerPart(2), BlockCobbleworks.getBlock());

    frameRenderer.registerController(BlockCobbleworks.getBlock().getControllerModelName(),
        controllerActive, controllerPassive);
  }

  @Override
  public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
    frameRenderer.renderInventoryBlock(block, metadata, modelId, renderer);
  }

  @Override
  public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
    return frameRenderer.renderWorldBlock(world, x, y, z, block, modelId, renderer);
  }

  @Override
  public boolean shouldRender3DInInventory(int modelId) {
    return true;
  }

  @Override
  public int getRenderId() {
    return BlockCobbleworks.blockCobbleworks.getRenderType();
  }

}

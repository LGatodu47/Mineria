package com.mineria.mod.blocks.barrel.copper;

import com.mineria.mod.References;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiCopperWaterBarrel extends GuiContainer
{
    private static final ResourceLocation TEXTURE = new ResourceLocation(References.MODID, "textures/gui/copper_water_barrel.png");
    private final InventoryPlayer playerInv;
    private final TileEntityCopperWaterBarrel tile;

    public GuiCopperWaterBarrel(InventoryPlayer playerInv, TileEntityCopperWaterBarrel tile)
    {
        super(new ContainerCopperWaterBarrel(playerInv, tile));
        this.playerInv = playerInv;
        this.tile = tile;
        this.xSize = 176;
        this.ySize = 126;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        String name = this.tile.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(name, (this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2), 3, 4210752);
        this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 112, 32, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(this.guiLeft,  this.guiTop, 0, 0, this.xSize, this.ySize);
    }
}
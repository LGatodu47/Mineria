package com.mineria.mod.blocks.titane_extractor.slots;

public class SlotTitaneExtractorOutput// extends Slot
{
    /*
	private final EntityPlayer player;
    private int removeCount;
	
	public SlotTitaneExtractorOutput(EntityPlayer player, IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
		this.player = player;
	}
	
	public boolean isItemValid(ItemStack stack)
    {
        return false;
    }
	
	public ItemStack decrStackSize(int amount)
    {
        if (this.getHasStack())
        {
            this.removeCount += Math.min(amount, this.getStack().getCount());
        }

        return super.decrStackSize(amount);
    }
	
	public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack)
    {
        this.onCrafting(stack);
        super.onTake(thePlayer, stack);
        return stack;
    }
	
	protected void onCrafting(ItemStack stack, int amount)
    {
        this.removeCount += amount;
        this.onCrafting(stack);
    }
	
	protected void onCrafting(ItemStack stack)
    {
        stack.onCrafting(this.player.world, this.player, this.removeCount);
        this.removeCount = 0;
    }

     */
}

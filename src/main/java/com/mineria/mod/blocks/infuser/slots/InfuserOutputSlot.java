package com.mineria.mod.blocks.infuser.slots;

import com.mineria.mod.init.ItemsInit;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class InfuserOutputSlot extends SlotItemHandler
{
    public InfuserOutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition)
    {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(@Nonnull ItemStack stack)
    {
        return stack.isItemEqual(new ItemStack(ItemsInit.CUP));
    }
}

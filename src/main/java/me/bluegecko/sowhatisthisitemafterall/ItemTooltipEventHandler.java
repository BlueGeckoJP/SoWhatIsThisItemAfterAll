package me.bluegecko.sowhatisthisitemafterall;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class ItemTooltipEventHandler {
    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        List<ITextComponent> toolTip = event.getToolTip();

        toolTip.add(ITextComponent.nullToEmpty(""));

        toolTip.add(ITextComponent.nullToEmpty(String.valueOf(itemStack.getItem().getRegistryName())).copy().withStyle(TextFormatting.GRAY));

        if (itemStack.getMaxDamage() != 0) {
            toolTip.add(ITextComponent.nullToEmpty(String.format("Durability: %s/%s", itemStack.getMaxDamage() - itemStack.getDamageValue(), itemStack.getMaxDamage())).copy().withStyle(TextFormatting.GRAY));
        }

        if (!itemStack.getItem().getTags().isEmpty()) {
            toolTip.add(ITextComponent.nullToEmpty("Tags:").copy().withStyle(TextFormatting.GRAY));
            for (ResourceLocation resourceLocation : itemStack.getItem().getTags()) {
                toolTip.add(ITextComponent.nullToEmpty(" " + resourceLocation).copy().withStyle(TextFormatting.DARK_AQUA));
            }
        }
    }
}

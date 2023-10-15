package binaris.optional_enchants.mixin;

import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Mixin(Block.class)
public abstract class BlockMixin {
    @Inject(at = @At("RETURN"), method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", cancellable = true)
    private static void DroppedStacksInject(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir){
        // AutoSmelt
        List<ItemStack> itemStacks = new ArrayList<>();
        List<ItemStack> returnValue = cir.getReturnValue();

        if(EnchantUtils.hasEnchant(stack, OptionalEnchants_Enchantments.AUTO_SMELT)){

            for(ItemStack item : returnValue){
                Optional<RecipeEntry<SmeltingRecipe>> recipe = world.getRecipeManager().getFirstMatch(RecipeType.SMELTING, new SimpleInventory(item), world);

                if (recipe.isPresent()) {

                    DynamicRegistryManager registryManager =  world.getRegistryManager();
                    ItemStack smelted = recipe.get().value().getResult(registryManager);

                    smelted.setCount(item.getCount());
                    itemStacks.add(smelted);
                } else {
                    itemStacks.add(item);
                }
            }
            cir.setReturnValue(itemStacks);
        }

        // Terraforming
        if(entity instanceof PlayerEntity player){
            if(EnchantUtils.hasEnchant(player, OptionalEnchants_Enchantments.TERRAFORMING, EquipmentSlot.MAINHAND)){
                cir.setReturnValue(Collections.singletonList(ItemStack.EMPTY));
            }
        }

        // Telekinesis
        if (entity instanceof PlayerEntity player) {
            if (EnchantUtils.hasEnchant(player, OptionalEnchants_Enchantments.TELEKINESIS, EquipmentSlot.MAINHAND)) {
                for (ItemStack itemStack : returnValue) {
                    player.getInventory().insertStack(itemStack);
                }
            }
        }
    }
}

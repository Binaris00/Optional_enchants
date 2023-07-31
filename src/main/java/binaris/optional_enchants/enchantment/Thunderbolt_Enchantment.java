package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.config.OptionalEnchantsConfig;
import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Thunderbolt_Enchantment extends SimpleEnchantBuilder {
    public Thunderbolt_Enchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.CROSSBOW, new EquipmentSlot[]{EquipmentSlot.OFFHAND, EquipmentSlot.MAINHAND}, 1, false, false, new Enchantment[]{Enchantments.PIERCING}, null, true, true, "thunderbolt");
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (user.getRandom().nextInt(100) <= OptionalEnchantsConfig.CONFIG.getOrDefault("thunderbolt.probability", 30)) {
            if (target instanceof LivingEntity livingEntity && EnchantUtils.getLevel(user, OptionalEnchants_Enchantments.THUNDERBOLT) >= 1) {
                LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(livingEntity.getWorld());
                BlockPos blockPos = target.getBlockPos();

                lightning.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos));
                target.getEntityWorld().spawnEntity(lightning);
            }
        }
    }
}
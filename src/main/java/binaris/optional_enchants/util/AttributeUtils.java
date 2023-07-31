package binaris.optional_enchants.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;

import java.util.UUID;

public class AttributeUtils {
    public static void modAttributeBase(LivingEntity entity, EntityAttribute entityAttribute, int inVar, UUID uuid, String str, double base, EntityAttributeModifier.Operation operation) {
        EntityAttributeInstance instance = entity.getAttributeInstance(entityAttribute);

        if (instance != null) {
            instance.addTemporaryModifier(new EntityAttributeModifier(uuid,
                    str,
                    base * inVar,
                    operation));
        }
    }
}

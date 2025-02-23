package com.mrbysco.dimpaintings.registry;

import com.mrbysco.dimpaintings.DimPaintings;
import com.mrbysco.dimpaintings.entity.DimensionalPaintingEntity;
import com.mrbysco.dimpaintings.item.DimensionalPaintingItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PaintingRegistry {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, DimPaintings.MOD_ID);
	public static final DeferredRegister<DimensionPaintingType> DIM_PAINTINGS = DeferredRegister.create(DimensionPaintingType.class, DimPaintings.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DimPaintings.MOD_ID);

	public static final RegistryObject<DimensionPaintingType> OVERWORLD = DIM_PAINTINGS.register("overworld", () -> new DimensionPaintingType(new ResourceLocation("overworld"), 64, 32));
	public static final RegistryObject<DimensionPaintingType> NETHER = DIM_PAINTINGS.register("nether", () -> new DimensionPaintingType(new ResourceLocation("the_nether"), 64, 32));
	public static final RegistryObject<DimensionPaintingType> END = DIM_PAINTINGS.register("end", () -> new DimensionPaintingType(new ResourceLocation("the_end"), 64, 32));

	public static final RegistryObject<Item> OVERWORLD_PAINTING = ITEMS.register("overworld_painting", () -> new DimensionalPaintingItem(new Item.Properties().tab(ItemGroup.TAB_MISC), OVERWORLD));
	public static final RegistryObject<Item> NETHER_PAINTING = ITEMS.register("nether_painting", () -> new DimensionalPaintingItem(new Item.Properties().tab(ItemGroup.TAB_MISC), NETHER));
	public static final RegistryObject<Item> END_PAINTING = ITEMS.register("end_painting", () -> new DimensionalPaintingItem(new Item.Properties().tab(ItemGroup.TAB_MISC), END));

	public static final RegistryObject<EntityType<DimensionalPaintingEntity>> DIMENSIONAL_PAINTING = ENTITIES.register("dimensional_painting", () ->
			register("dimensional_painting", EntityType.Builder.<DimensionalPaintingEntity>of(DimensionalPaintingEntity::new, EntityClassification.MISC)
					.sized(0.5F, 0.5F)
					.clientTrackingRange(10).updateInterval(Integer.MAX_VALUE)
					.setCustomClientFactory(DimensionalPaintingEntity::new)));

	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder) {
		return builder.build(id);
	}
}
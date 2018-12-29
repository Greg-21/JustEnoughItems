package mezz.jei.ingredients;

import mezz.jei.api.ingredients.IIngredientBlacklist;
import mezz.jei.api.ingredients.IIngredientHelper;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.config.IHideModeConfig;
import mezz.jei.util.ErrorUtil;

public class IngredientBlacklist implements IIngredientBlacklist {
	private final IIngredientRegistry ingredientRegistry;
	private final IngredientBlacklistInternal internal;
	private final IHideModeConfig hideModeConfig;

	public IngredientBlacklist(IIngredientRegistry ingredientRegistry, IngredientBlacklistInternal internal, IHideModeConfig hideModeConfig) {
		this.ingredientRegistry = ingredientRegistry;
		this.internal = internal;
		this.hideModeConfig = hideModeConfig;
	}

	@Override
	public <V> void addIngredientToBlacklist(V ingredient) {
		ErrorUtil.checkNotNull(ingredient, "ingredient");

		IIngredientHelper<V> ingredientHelper = ingredientRegistry.getIngredientHelper(ingredient);
		internal.addIngredientToBlacklist(ingredient, ingredientHelper);
	}

	@Override
	public <V> void removeIngredientFromBlacklist(V ingredient) {
		ErrorUtil.checkNotNull(ingredient, "ingredient");

		IIngredientHelper<V> ingredientHelper = ingredientRegistry.getIngredientHelper(ingredient);
		internal.removeIngredientFromBlacklist(ingredient, ingredientHelper);
	}

	@Override
	public <V> boolean isIngredientBlacklisted(V ingredient) {
		ErrorUtil.checkNotNull(ingredient, "ingredient");

		IIngredientHelper<V> ingredientHelper = ingredientRegistry.getIngredientHelper(ingredient);
		return internal.isIngredientBlacklistedByApi(ingredient, ingredientHelper) ||
			hideModeConfig.isIngredientOnConfigBlacklist(ingredient, ingredientHelper);
	}
}

package mezz.jei.test.lib;

import mezz.jei.config.IIngredientFilterConfig;
import mezz.jei.config.SearchMode;

public class TestIngredientFilterConfig implements IIngredientFilterConfig {
	@Override
	public SearchMode getModNameSearchMode() {
		return SearchMode.ENABLED;
	}

	@Override
	public SearchMode getTooltipSearchMode() {
		return SearchMode.ENABLED;
	}

	@Override
	public SearchMode getOreDictSearchMode() {
		return SearchMode.ENABLED;
	}

	@Override
	public SearchMode getCreativeTabSearchMode() {
		return SearchMode.ENABLED;
	}

	@Override
	public SearchMode getColorSearchMode() {
		// TODO enable testing color search
		return SearchMode.DISABLED;
	}

	@Override
	public SearchMode getResourceIdSearchMode() {
		return SearchMode.ENABLED;
	}

	@Override
	public boolean getSearchAdvancedTooltips() {
		return false;
	}
}

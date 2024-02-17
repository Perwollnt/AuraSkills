package dev.aurelium.auraskills.bukkit.trait;

import dev.aurelium.auraskills.api.trait.Trait;
import dev.aurelium.auraskills.api.trait.Traits;
import dev.aurelium.auraskills.bukkit.AuraSkills;
import dev.aurelium.auraskills.bukkit.skills.fighting.FightingAbilities;
import dev.aurelium.auraskills.common.user.User;
import dev.aurelium.auraskills.api.util.NumberUtil;
import org.bukkit.entity.Player;

import java.util.Locale;

public class CritDamageTrait extends TraitImpl {

    CritDamageTrait(AuraSkills plugin) {
        super(plugin, Traits.CRIT_DAMAGE);
    }

    @Override
    public double getBaseLevel(Player player, Trait trait) {
        return Traits.CRIT_DAMAGE.optionDouble("base");
    }

    @Override
    public String getMenuDisplay(double value, Trait trait, Locale locale) {
        return NumberUtil.format1(value) + "%";
    }

    @Override
    protected void reload(Player player, Trait trait) {
        User user = plugin.getUser(player);
        plugin.getAbilityManager().getAbilityImpl(FightingAbilities.class).reloadCritDamage(player, user);
    }

}

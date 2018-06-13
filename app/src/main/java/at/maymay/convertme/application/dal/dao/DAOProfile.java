package at.maymay.convertme.application.dal.dao;

import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.ICategoryContainer;
import at.maymay.convertme.application.core.Profile;
import at.maymay.convertme.application.core.dao.IDAOProfile;
import at.maymay.convertme.application.core.model.Unit;

public class DAOProfile implements IDAOProfile {

    @Override
    public List<Profile> loadAll(ICategoryContainer container) {
        if (container == null)
            throw new NullPointerException("Invalid container, NULL-PTR!");

        List<Profile> profiles = new ArrayList<>();

        List<Unit> units_austria = new ArrayList<>();
        List<Unit> units_united_states = new ArrayList<>();
        List<Unit> units_england = new ArrayList<>();

        units_austria.add(container.length().getUnitByShortcut("m"));
        units_austria.add(container.currency().getUnitByShortcut("EUR"));
        units_austria.add(container.weight().getUnitByShortcut("kg"));
        units_austria.add(container.volume().getUnitByShortcut("L"));
        units_austria.add(container.speed().getUnitByShortcut("km/h"));
        units_austria.add(container.temperature().getUnitByShortcut("°C"));

        units_united_states.add(container.length().getUnitByShortcut("yd"));
        units_united_states.add(container.currency().getUnitByShortcut("USD"));
        units_united_states.add(container.weight().getUnitByShortcut("lb"));
        units_united_states.add(container.volume().getUnitByShortcut("uslg"));
        units_united_states.add(container.speed().getUnitByShortcut("mile/h"));
        units_united_states.add(container.temperature().getUnitByShortcut("°F"));

        units_england.add(container.length().getUnitByShortcut("ft"));
        units_england.add(container.currency().getUnitByShortcut("GBP"));
        units_england.add(container.weight().getUnitByShortcut("kg"));
        units_england.add(container.volume().getUnitByShortcut("L"));
        units_england.add(container.speed().getUnitByShortcut("mile/h"));
        units_england.add(container.temperature().getUnitByShortcut("°C"));

        Profile austria = new Profile("Austria", "AUT", units_austria);
        Profile usa = new Profile("United States", "USA", units_united_states);
        Profile england = new Profile("England", "EN", units_england);

        profiles.add(austria);
        profiles.add(usa);
        profiles.add(england);

        return profiles;
    }
}

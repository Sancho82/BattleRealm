package strategyGame.descriptions;

public class Descriptions {

    private static final String ARCHER_DESCRIPTION =
                    "<html><font color=white><Strong>" + "Archer:<br>" +
                    "Ranged unit with a low move range. Able to inflict " +
                    "great damage from a distance, but vulnerable in close " +
                    "quarters combat." +
                    "</Strong></font></html>";

    private static final String ARCHERY_DESCRIPTION =
                    "<html><font color=white><Strong>" + "Archery:<br>" +
                    "Building able to train archers." +
                    "</Strong></font></html>";

    private static final String CASTLE_DESCRIPTION =
                    "<html><font color=white><Strong>" + "Castle:<br>" +
                    "Central building, able to train warriors. Player loses, " +
                    "if castle is destroyed." +
                    "</Strong></font></html>";

    private static final String MEDICAMP_DESCRIPTION =
                    "<html><font color=white><Strong>" + "Medicamp:<br>" +
                    "Building able to heal units." +
                    "</Strong></font></html>";

    private static final String PALADIN_DESCRIPTION =
                    "<html><font color=white><Strong>" + "Paladin:<br>" +
                    "Powerful, but expensive unit with a high move range. " +
                    "Able to inflict great damage in close quarters combat." +
                    "</Strong></font></html>";

    private static final String STABLES_DESCRIPTION =
                    "<html><font color=white><Strong>" + "Stables:<br>" +
                    "Building able to train paladins." +
                    "</Strong></font></html>";

    private static final String WARRIOR_DESCRIPTION =
                    "<html><font color=white><Strong>" + "Warrior:<br>" +
                    "Basic unit with an average move range. Able to inflict " +
                    "decent damage in close quarters combat." +
                    "</Strong></font></html>";

    public static String getArcherDescription() {
        return ARCHER_DESCRIPTION;
    }

    public static String getArcheryDescription() {
        return ARCHERY_DESCRIPTION;
    }

    public static String getCastleDescription() {
        return CASTLE_DESCRIPTION;
    }

    public static String getMedicampDescription() {
        return MEDICAMP_DESCRIPTION;
    }

    public static String getPaladinDescription() {
        return PALADIN_DESCRIPTION;
    }

    public static String getStablesDescription() {
        return STABLES_DESCRIPTION;
    }

    public static String getWarriorDescription() {
        return WARRIOR_DESCRIPTION;
    }
}

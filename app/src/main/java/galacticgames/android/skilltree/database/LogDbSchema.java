package galacticgames.android.skilltree.database;

public class LogDbSchema {
    public static final class LogTable{
        public static final String NAME = "logs";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String SKILLUUID = "skilluuid";
            public static final String HOURS = "hours";
            public static final String MINUTES = "minutes";
            public static final String DATE = "date";
            public static final String NOTES = "notes";
        }
    }
}

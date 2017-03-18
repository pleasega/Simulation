package simulation;

import java.util.ArrayList;

/**
 * Created by LPC on 18/3/2017.
 */
public class Main {
    public static void main(String[] args)
    {
        // initTeams();
        ArrayList<Club> teams = new ArrayList<Club>();

        Club barcelona = new Club("Barcelona", 92, 84, 84);
        Club bvb = new Club("Borussia Dortmund", 85, 80, 82);
        Club realmadrid = new Club("Real Madrid", 88, 86, 86);
        Club bayern = new Club("Bayern Munich", 90, 84, 87);

        Club home = bayern;
        Club away = barcelona;
        Match match = new Match(home, away, "knockout");
        Match matchReverse = new Match(away, home, "knockout");

        int homeGoalsAgg = match.getHomeGoals() + matchReverse.getAwayGoals();
        int awayGoalsAgg = match.getAwayGoals() + matchReverse.getHomeGoals();

        System.out.println();
        System.out.println("Aggregate Score: " + home.getName() + " " + homeGoalsAgg + "  -  " + awayGoalsAgg + " " + away.getName());
        if (homeGoalsAgg == awayGoalsAgg)
        {
            if (match.getAwayGoals() < matchReverse.getAwayGoals())
            {
                System.out.println(home.getName() + " wins on away goals.");
            }
            else if (match.getAwayGoals() > matchReverse.getAwayGoals())
            {
                System.out.println(away.getName() + " wins on away goals.");
            }
            else if (match.getAwayGoals() == matchReverse.getAwayGoals() && match.getMatchType().equals("knockout"))
            {
                System.out.println("");
            }

        }

    }
}

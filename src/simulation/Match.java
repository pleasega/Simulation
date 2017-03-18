package simulation;

import static simulation.Helper.generateRandomDouble;
import static simulation.Helper.generateRandomInt;
import static simulation.Helper.round;

/**
 * Created by LPC on 18/3/2017.
 */
public class Match {
    private Club homeTeam;
    private Club awayTeam;
    private int homeGoals;
    private int awayGoals;
    private int matchTime;
    private String matchType;
    private double homeTeamPossession;
    private double awayTeamPossession;

    public Match(Club homeTeam, Club awayTeam, String matchType)
    {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchType = matchType;

        playMatch(matchType);
    }

    public void playMatch(String matchType)
    {
        double homeTeamQuality = ((this.homeTeam.getAttackRating() + this.homeTeam.getMidfieldRating() + this.homeTeam.getDefenseRating()) / 3) + 3;
        double awayTeamQuality = (this.awayTeam.getAttackRating() + this.awayTeam.getMidfieldRating() + this.awayTeam.getDefenseRating()) / 3;

        if (matchType.equals("knockout"))
        {
            matchTime = generateRandomDouble(0.0,100.0) <= 85 ? 90 : 120;
        }
        else if (matchType.equals("league"))
        {
            matchTime = 90;
        }

        System.out.println("Match Time: " + matchTime);
        generateGoals(matchTime);
        generatePossession(homeTeamQuality, awayTeamQuality);
    }

    private double realisticiseDifference(double ratingDifference)
    {
        double ratingDifferenceLimit = 6;
        if (ratingDifference > ratingDifferenceLimit)
        {
            ratingDifference = ratingDifferenceLimit + ((ratingDifference - ratingDifferenceLimit) / 5);
        }
        return ratingDifference < 0 ? 1 : ratingDifference;
    }
    private void generateGoals(int matchTime)
    {
        double homeTeamDifference = realisticiseDifference((1 + this.homeTeam.getAttackRating() - this.awayTeam.getDefenseRating() + (this.homeTeam.getMidfieldRating() - this.awayTeam.getMidfieldRating())) + generateRandomInt(-6, 6));
        double awayTeamDifference = realisticiseDifference((this.awayTeam.getAttackRating() - this.homeTeam.getDefenseRating() + (this.awayTeam.getMidfieldRating() - this.homeTeam.getMidfieldRating())) + generateRandomInt(-6, 6));

        homeGoals = realisticiseGoals((int) (generateRandomDouble(0,1.5) * homeTeamDifference));
        awayGoals = realisticiseGoals((int) (generateRandomDouble(0,1) * awayTeamDifference));

        if (generateRandomInt(1,100) < 20)
        {
            int tempSwapVar = homeGoals;
            homeGoals = awayGoals;
            awayGoals = tempSwapVar;
        }
        if (matchType.equals("knockout") && homeGoals == awayGoals)
        {
            generateGoals(matchTime);
        }
        else
        {
            System.out.println("Goals: " + this.homeTeam.getName() + " " + homeGoals + "  -  " + awayGoals + " " + this.awayTeam.getName());
        }
    }

    private int realisticiseGoals(int goals)
    {
        int extraGoals = 0;
        int goalsUnrealisticLimit = 3;
        if (goals > goalsUnrealisticLimit)
        {
            extraGoals = (goals - goalsUnrealisticLimit) / 3;
            return goalsUnrealisticLimit + extraGoals;
        }
        else
        {
            return goals;
        }
    }

    private void generatePossession(double homeTeamQuality, double awayTeamQuality)
    {
        double qualityDifference = homeTeamQuality - awayTeamQuality;
        if (homeTeamQuality > awayTeamQuality)
        {
            homeTeamPossession = generateRandomDouble(25.0,65.0) + qualityDifference;
            awayTeamPossession = 100 - homeTeamPossession;
        }
        else
        {
            awayTeamPossession = generateRandomDouble(25.0,65.0) + qualityDifference;
            homeTeamPossession = 100 - awayTeamPossession;
        }

        System.out.println("Possession: " + this.homeTeam.getName() + " " + round(homeTeamPossession) + "%  -  " + round(awayTeamPossession) + "% " + this.awayTeam.getName());
    }


    public int getHomeGoals()
    {
        return homeGoals;
    }

    public int getAwayGoals()
    {
        return awayGoals;
    }

    public String getMatchType()
    {
        return matchType;
    }
}

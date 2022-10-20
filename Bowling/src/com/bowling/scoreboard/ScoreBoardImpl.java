    package com.bowling.scoreboard;

    import com.bowling.constants.AppConstants;
    import com.bowling.factory.BonusFactory;
    import com.bowling.model.Bonus;

    public class ScoreBoardImpl implements ScoreBoard{
    private int rollingScore[] ;

    public ScoreBoardImpl(){
       rollingScore = new int[AppConstants.MAX_ROLLS];
    }

    @Override
    public void roll(int noOfPins , int currIndex ){
        if(rollingScore[currIndex] == AppConstants.MAX_ROLLS-1 && (rollingScore[currIndex-1] + rollingScore[currIndex-2]==10)){
            rollingScore[currIndex] = noOfPins; // storing extra chance score
            return;
         }
        rollingScore[currIndex] = noOfPins;
    }

    @Override
    public int score(){

        int totalScore =0;
        int index=0;
        for(int i=0;i<AppConstants.TOTAL_SETS;i++){
            if(isStrike(index)){
             totalScore = totalScore + AppConstants.TOTAL_PINS + BonusFactory.getStrategy(Bonus.STRIKE).bonus();
             index = index+2;
            }
            else if(isSpare(index)){
                totalScore = totalScore + AppConstants.TOTAL_PINS + BonusFactory.getStrategy(Bonus.SPARE).bonus();
                index = index+2;
            }
            else{ // default
                totalScore = totalScore + rollingScore[index] + rollingScore[index+1];
                index = index+2;
            }
        }

        return totalScore + rollingScore[index]; // agar 20th index mein kuch hoga tohh add kar lenge otherwise 0 hi sahi
    }

        private boolean isSpare(int index) {
        return (rollingScore[index] + rollingScore[index+1]) == 10;
        }

        private boolean isStrike(int index) {
        return rollingScore[index] == 10;
        }




    }

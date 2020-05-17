public class Country implements VirusSpreadListener{
    private String name;
    private int population, healthy, sick, cured, difficulty;
    private double sicknessProbability, cureProbability;

    public Country( int population, String name,int difficulty){
        this.name = name;
        this.population = population;
        this.healthy = population;
        this.difficulty = difficulty;

        this.sick = 1;
        sicknessProbability = 0.5; // values 0.0 - 1.0 mean 0% to 100% chance
        cureProbability= 0.3;  // -||-
    }

    @Override
    public void SpreadVirus() {
        //Actually metod maitain spreading virus but also curing population
        double rand = Math.random();

        int ammount = sick*(int)(Math.random()*difficulty+1);
        if(rand<sicknessProbability){
            if(ammount>healthy) {
                ammount = healthy;
            }
            healthy -= ammount;
            sick += ammount;
        }

        rand = Math.random();
        int ammountCured = (int)((Math.random()*3/difficulty)+1);
        if(rand<cureProbability){
            if(ammountCured>sick) {
                ammountCured = sick;
            }
            sick -= ammountCured;
            cured += ammountCured;
            Points.increasePoints(ammountCured);
        }

        //TEST
        System.out.println(name + "\nsick: "+sick+"\nhealthy: "+healthy+"\ncured: "+ cured+"\n\n");
    }

    public int getSick() {
        return sick;
    }

    public int getCured() {
        return cured;
    }
}

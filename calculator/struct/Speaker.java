/**
 * A class representing a speaker.
 * William Wells
 * This code is protected by copyright.
 */
public class Speaker {

    private int resistance; //impedance, int representing an ohm
    private int size; // measurement of speaker, optional
    private String name;  //optional  


    public Speaker(int resistance)
    {   
        this(resistance, "Generic Speaker");
    }

    public Speaker(int resistance, String name)
    {
        this(resistance, name, -1);
    }

    public Speaker(int resistance, String name, int size)
    {
        if (isValidResistance(resistance)) this.resistance = resistance;
        if (isValid(name)) this.name = name;
        this.size = size;
    }


    public String getName()
    {
        return this.name;
    }


    public int getResistance()
    {
        return this.resistance;
    }


    public int getSize()
    {
        return this.size;
    }


    /**
     * A String containing the speaker's configuration and name
     */
    public String toString()
    {
        String description = getName() + ". Resistance: " + getResistance();
        if (getSize() > 0)
        {
            description = getName() + " is a " + getSize() + " inch driver, with a resistance of " + getResistance() + "\u03A9.";
        } 
       
       
        return description;
    }


    /**
     * A String displaying the speaker name, resistance, and terminals.
     * @return String
     */
    public String draw()
    {
        String display = getName() + "    (" + getResistance() + "\u03A9)" + "   +" + "  -";

        return display; 
    }


    /***********************private methods****************/
    private boolean isValidResistance(int resist)
    {
        boolean valid = false;
        if (resist >= 4 && resist <= 16 && resist % 2 == 0) valid = true;

        return valid;
    }

    private boolean isValid(String toTest)
    {
        boolean valid = false;
        if (toTest != null && toTest.trim().length() > 0) valid = true;

        return valid;
    }




}

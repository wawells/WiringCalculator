package struct;
/**
 * A class representing a speaker.
 * William Wells
 * This code is protected by copyright.
 */
public class Speaker {

    private int resistance; //impedance, int representing an ohm
    private String name;  //optional  


    public Speaker(int resistance)
    {   
        this(resistance, "Generic Speaker");
    }

    public Speaker(int resistance, String name)
    {
        //this(resistance, name);
        if (isValid(resistance)) this.resistance = resistance;
        if (isValid(name)) this.name = name;
    }

    // public Speaker(int resistance, String name, int size)
    // {
    //     if (isValidResistance(resistance)) this.resistance = resistance;
    //     if (isValid(name)) this.name = name;
    //     this.size = size;
    // }


    public String getName()
    {
        return this.name;
    }


    public int getResistance()
    {
        return this.resistance;
    }

    public boolean setName(String name)
    {
        boolean set = false;
        if (isValid(name))
        {
            this.name = name;
            set = true;
        }
        return set;
    }


    public boolean setResistance(int resistance)
    {
        boolean set = false;
        if (isValid(resistance))
        {
            this.resistance = resistance;
            set = true;
        }
        return set;

    }

    /**
     * A String containing the speaker's configuration and name
     */
    public String toString()
    {
        return getResistance() + ";" + getName();
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
    private boolean isValid(int resist)
    {
        return (resist >= 4 && resist <= 16 && resist % 2 == 0);
    }

    private boolean isValid(String toTest)
    {
        return (toTest != null && toTest.trim().length() > 0);
    }




}

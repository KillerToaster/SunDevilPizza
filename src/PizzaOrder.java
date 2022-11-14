import java.io.Serializable;

public class PizzaOrder implements Serializable
{
    private String id;
    private String pizzaType;
    private boolean mushroom;
    private boolean olives;
    private boolean onion;
    private boolean extraCheese;
    private String status;

    //constructor
    public PizzaOrder(String idInput, String typeInput, boolean mush, boolean olive,
                      boolean onions, boolean cheese, String stat)
    {
        id = idInput;
        pizzaType = typeInput;
        mushroom = mush;
        olives = olive;
        onion = onions;
        extraCheese = cheese;
        status = stat;
    }

    //accessor methods

    public String getID()
    {
        return id;
    }

    public String getType()
    {
        return pizzaType;
    }

    public String getToppings()
    {
        String toppings = "";
        if(mushroom == true)
            toppings = toppings + "mushroom ";
        if(olives == true)
            toppings = toppings + "olives ";
        if(onion == true)
            toppings = toppings + "onion ";
        if(extraCheese == true)
            toppings = toppings + "extra cheese";

        return toppings;
    }

    public String getStatus()
    {
        return status;
    }

    //mutator methods
    public void changeStatus(String newStatus)
    {
        status = newStatus;
    }
}

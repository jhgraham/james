package kalah.rest;

import java.util.Comparator;


public class NumericalOrderStringComparator implements Comparator<String>
{

    @Override
    public int compare(String arg0, String arg1)
    {
        Integer i1 = intValue(arg0);
        Integer i2 = intValue(arg1);
        if(i1 == null && i2 == null)
        {
            return arg0.compareTo(arg1);
        }
        else if(i1 == null)
        {
            return -1;
        }
        else if(i2 == null)
        {
            return 1;
        }
        else
        {
            return i1.compareTo(i2);
        }
    }

    
    private static Integer intValue(String str)
    {
        try
        {
            return Integer.valueOf(str);
        }
        catch(NumberFormatException ex)
        {
            return null;
        }
    }
}
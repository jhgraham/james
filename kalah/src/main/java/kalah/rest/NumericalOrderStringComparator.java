package kalah.rest;

import java.util.Comparator;


/**
 * Comparator class used to ensure the Status Map is sorted in Numerical order
 * as strings.
 * @author James
 *
 */
public class NumericalOrderStringComparator implements Comparator<String>
{

    /*
     * Comparison
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
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

    /** Return an integer value (if applicable)
     * 
     * @param str
     * @return
     */
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
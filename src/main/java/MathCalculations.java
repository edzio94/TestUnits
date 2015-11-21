/**
 * Created by lukasz on 08.11.15.
 */
public class MathCalculations {

    public int FibonaciResult(int n)
    {

        if (n ==0 )
            return 0;
        else if (n==1)
            return 1;

        else
            return FibonaciResult(n - 1)+FibonaciResult(n-2);
    }
    public int factorial(int n)
    {
        if (n==1)
            return 1;
        if(n==0)
            return 1;
        else
            return n*factorial(n-1);


    }


}

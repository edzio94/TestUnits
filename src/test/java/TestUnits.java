import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by lukasz on 08.11.15.
 */
public class TestUnits {

    private static ArrayList<String> DOMAINS_SET;
    private static ArrayList<String> DOMAINS_ANSWERS;


    private static MathCalculations mathCalculations;
    private static DomainParser domainParser;
    private static DataHandler dataHandler;



    @Mock
    private static WebsiteConnector websiteConnector = Mockito.mock(WebsiteConnector.class);

    @Mock
    private static DatabaseConnector databaseConnector = Mockito.mock( DatabaseConnector.class);

    @BeforeClass
    public static void initialize() {
        System.out.println("Creating Test Class !");
        DOMAINS_SET = new ArrayList<String>();

        DOMAINS_SET.add("www.wykop.pl");
        DOMAINS_SET.add("www.stackoverflow.com");
        DOMAINS_SET.add("www.wikipedia.org");

        DOMAINS_ANSWERS = new ArrayList<String>();

        DOMAINS_ANSWERS.add("wykop");
        DOMAINS_ANSWERS.add("stackoverflow");
        DOMAINS_ANSWERS.add("wikipedia");

        mathCalculations = new MathCalculations();
        domainParser = new DomainParser();
        dataHandler = new DataHandler();
    }

    @Before
    public void init_Test()
    {
        System.out.println("===================");
    }

    int SHOULD_BE = 12;
    @Test (expected = ArithmeticException.class)
    public void  divisionWithException()
    {
        System.out.println("Division by zero");
        int p =  12/0;
        System.out.println("P = "+p);
    }
    int EXPECTED_RESULT = 5;
    int FIBONACI_ARGUMENT = 5;

    @Test
    public void FibonaciResultTest()
    {
        System.out.println("FibonaciResult Test");
        assertEquals(EXPECTED_RESULT, mathCalculations.FibonaciResult(FIBONACI_ARGUMENT));
    }


    @Test//(expected = StringIndexOutOfBoundsException.class)
    public void GET_DOMAIN_TEST()
    {
        System.out.println("Get Domain Test");
        for (int i = 0 ; i < DOMAINS_SET.size(); i++) {
            assertEquals(DOMAINS_ANSWERS.get(i), domainParser.getDomain(DOMAINS_SET.get(i)));
        }

    }


    @Test
    public void JustPrintingStuff()
    {
        System.out.println("PrintingStuff Test");
    }

    @Test(timeout = 1000)
    public void CheckConnectionFromWebsiteConnectorClass()
    {
        System.out.println("Connecting with website Test");
        websiteConnector.getConnection("http://www.example.com");
        System.out.println(websiteConnector.myURLConnection);
    }

    @Test(timeout = 1000)
    public void CheckConnectionToDatabaseFromDatabaseConnectorClass() throws SQLException {
        System.out.println("Connecting to Database Test");
        Connection connTest = databaseConnector.getConn();
        System.out.println(connTest);
    }

    @Test
    public void CheckAddingPersonToListFunctionality()
    {
        dataHandler.addPerson("123", "w22", 44);
    }
    int EXPECTED_FACTORIAL_RESULT= 24;
    int N = 4;

    @Test
    public void CheckingFactorialResult()
    {
        assertEquals(EXPECTED_FACTORIAL_RESULT,mathCalculations.factorial(N));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void PrintPerson(){
        int n = 4;
        if(n > dataHandler.persons.size() -1)
            System.out.println(IndexOutOfBoundsException.class);
        dataHandler.printPerson(4);
    }
    @Test
    public void checkForLessThanZero()
    {
        mathCalculations.factorial(-5);
    }
    @Test
    public void wrongURL()
    {
        websiteConnector.getConnection("fasfsadas");
    }


}

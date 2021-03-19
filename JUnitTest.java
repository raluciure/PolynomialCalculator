import org.junit.Assert;
import org.junit.Test;

public class JUnitTest extends Model {

    @Test
    public void additionTest(){
        Polynomial p=new Polynomial("3x^2+2x^1+1");
        Polynomial q=new Polynomial("2x^2+3");
        Polynomial res=addition(p,q);

        String correctRes="+5x^2+2x+4";
        String result=res.toString(res);
        Assert.assertEquals(correctRes,result);
    }

    @Test
    public void subtractionTest(){
        Polynomial p=new Polynomial("3x^2+2x^1+1");
        Polynomial q=new Polynomial("2x^2+3");
        Polynomial res=subtraction(p,q);

        String correctRes="+x^2+2x-2";
        String result=res.toString(res);
        Assert.assertEquals(correctRes,result);
    }

    @Test
    public void multiplyTest(){
        Polynomial p=new Polynomial("3x^2+2x^1+1");
        Polynomial q=new Polynomial("1x^1");
        Polynomial res=multiply(p,q);

        String correctRes="+3x^3+2x^2+x";
        String result=res.toString(res);
        Assert.assertEquals(correctRes,result);
    }

    @Test
    public void derivateTest(){
        Polynomial p=new Polynomial("3x^2+2x^1+1");
        Polynomial res=derivative(p);

        String correctRes="+6x+2";
        String result=res.toString(res);
        Assert.assertEquals(correctRes,result);
    }

    @Test
    public void integrationTest(){
        Polynomial p=new Polynomial("3x^2+2x^1+1");
        Polynomial res=integration(p);

        String correctRes="+x^3+x^2+x";
        String result=res.toString(res);
        Assert.assertEquals(correctRes,result);
    }

    @Test
    public void toStringTest(){
        Polynomial p=new Polynomial("3x^2+2x^1+1");

        String correctRes="+3x^2+2x+1";
        String result=p.toString(p);
        Assert.assertEquals(correctRes,result);
    }



}

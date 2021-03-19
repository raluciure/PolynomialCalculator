import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> polynomial;

    public Polynomial(){
        this.polynomial=new ArrayList<Monomial>();
    }

    public Polynomial(String input){
        this.polynomial=parseString(input);
    }

    public ArrayList<Monomial> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(ArrayList<Monomial> polynomial) {
        this.polynomial = polynomial;
    }

    public void add(Monomial monomial)
    {
        polynomial.add(monomial);
    }

   //RegEx

   
    public static ArrayList<Monomial> parseString(String input){
        ArrayList<Monomial> p=new ArrayList<Monomial>();
        Pattern pattern=Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher=pattern.matcher(input);
        String m;
        while (matcher.find()){
            Monomial aux=new Monomial(0,0);
            m=matcher.group(1);
            int coef=0;
            int grad=0;

            if(m.indexOf('x')==-1){
                coef=Integer.parseInt(m);
                grad=0;
            } else{
                coef=Integer.parseInt(m.substring(0,m.indexOf('x')));
                grad=Integer.parseInt(m.substring(m.indexOf('^')+1,m.length()));
            }
            aux.setCoef(coef);
            aux.setGrad(grad);
            p.add(aux);

        }

        return p;

    }
    
    public String toString(Polynomial p){
        String output="";

        while(p.getPolynomial().size()!=0){
            int coef=p.getPolynomial().get(0).getCoef();
            int grad=p.getPolynomial().get(0).getGrad();

            if(coef>0 && coef !=1){
                if (grad==0)
                    output+="+"+coef;
                else if(grad==1)
                    output+="+"+coef+"x";
                else
                    output+="+"+coef+"x^"+grad;
            }
            else if (coef==1){
                if (grad==0)
                    output+="+"+coef;
                else if (grad==1)
                    output+="+"+"x";
                else
                    output+="+"+"x^"+grad;
            }
            else{
                if(grad==0)
                    output+=coef;
                else if(grad==1)
                    output+=coef+"x";
                else
                    output+=coef+"x^"+grad;

            }

            p.getPolynomial().remove(0);
        }

        return output;

    }
}

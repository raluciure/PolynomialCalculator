public class Model {
    Polynomial result;

    public Model(){
        this.result=new Polynomial();
    }

    public Polynomial addition(Polynomial pol1, Polynomial pol2){
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();

        p1.setPolynomial(pol1.getPolynomial());
        p2.setPolynomial((pol2.getPolynomial()));

        while (p1.getPolynomial().size()!=0 && p2.getPolynomial().size()!=0)
        {
            int gradP1=p1.getPolynomial().get(0).getGrad();
            int gradP2=p2.getPolynomial().get(0).getGrad();

            if (gradP1==gradP2){
                int coef=p1.getPolynomial().get(0).getCoef()+p2.getPolynomial().get(0).getCoef();
                p1.getPolynomial().remove(0);
                p2.getPolynomial().remove(0);
                result.add(new Monomial(coef,gradP1));
            }
            else if(gradP1<gradP2){
                result.add(p2.getPolynomial().get(0));
                p2.getPolynomial().remove(0);
            }
            else{
                result.add(p1.getPolynomial().get(0));
                p1.getPolynomial().remove(0);
            }
        }

        while(p1.getPolynomial().size()!=0){
            result.add(p1.getPolynomial().get(0));
            p1.getPolynomial().remove(0);
        }

        while(p2.getPolynomial().size()!=0){
            result.add(p2.getPolynomial().get(0));
            p2.getPolynomial().remove(0);
        }

        return result;
    }

    public Polynomial subtraction(Polynomial pol1, Polynomial pol2){
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();

        p1.setPolynomial(pol1.getPolynomial());
        p2.setPolynomial(pol2.getPolynomial());

        while(p1.getPolynomial().size()!=0 && p2.getPolynomial().size()!=0){
            int gradP1=p1.getPolynomial().get(0).getGrad();
            int gradP2=p2.getPolynomial().get(0).getGrad();

            if (gradP1==gradP2){
                int coef=p1.getPolynomial().get(0).getCoef()-p2.getPolynomial().get(0).getCoef();
                p1.getPolynomial().remove(0);
                p2.getPolynomial().remove(0);
                result.add(new Monomial(coef,gradP1));
            }

            else if(gradP1>gradP2){
                result.add(p1.getPolynomial().get(0));
                p1.getPolynomial().remove(0);
            }
            else{
                result.add(new Monomial(-p2.getPolynomial().get(0).getCoef(),p2.getPolynomial().get(0).getGrad()));
                p2.getPolynomial().remove(0);
            }
        }

        while(p1.getPolynomial().size()!=0){
            result.add(p1.getPolynomial().get(0));
            p1.getPolynomial().remove(0);
        }

        while(p2.getPolynomial().size()!=0){
            result.add(new Monomial(-p2.getPolynomial().get(0).getCoef(),p2.getPolynomial().get(0).getGrad()));
            p2.getPolynomial().remove(0);
        }

        return result;
    }

    public Polynomial multiply(Polynomial pol1, Polynomial pol2){
        for(Monomial m1:pol1.getPolynomial()){
            for(Monomial m2: pol2.getPolynomial()){
                int coef=m1.getCoef()*m2.getCoef();
                int grad=m1.getGrad()+m2.getGrad();
                result.add(new Monomial(coef,grad));
            }
        }

        return result;
    }

    public Polynomial derivative(Polynomial pol){
        for(Monomial m:pol.getPolynomial()){
            if(m.getGrad()!=0){
                int coef=m.getCoef()*m.getGrad();
                int grad=m.getGrad()-1;
                result.add(new Monomial(coef,grad));
            }
        }
        return result;
    }

    public Polynomial integration(Polynomial pol){
        for(Monomial m:pol.getPolynomial()){
            int coef=m.getCoef()/(m.getGrad()+1);
            int grad=m.getGrad()+1;
            result.add(new Monomial(coef,grad));
        }
        return result;
    }
}

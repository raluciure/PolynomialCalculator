public class Monomial {
    private int coef;
    private int grad;

    Monomial(int coef, int grad)
    {
        this.coef=coef;
        this.grad=grad;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public Monomial div(Monomial m){
        Monomial result = new Monomial(this.coef / m.getCoef(), this.grad - m.getGrad());
        return result;
    }
}

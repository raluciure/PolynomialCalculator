import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        this.view.addListener(new AddListener());
        this.view.subListener(new SubListener());
        this.view.mulListener(new MulListener());
        this.view.derListener(new DerivativeListener());
        this.view.integrationListener(new IntegrationListener());
        this.view.clearListener(new ClearListener());
        this.view.divListener(new DivListener());

    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polynomial pol1 = new Polynomial();
            Polynomial pol2 = new Polynomial();

            try {
                String pol1String = view.firstPol.getText();
                String pol2String = view.secondPol.getText();

                pol1.setPolynomial(pol1.parseString(pol1String));
                pol2.setPolynomial(pol2.parseString(pol2String));

                Polynomial polRes = model.addition(pol1, pol2);
                view.resultPol.setText(polRes.toString(polRes));
            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }

        }
    }

    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polynomial pol1 = new Polynomial();
            Polynomial pol2 = new Polynomial();

            try {
                String pol1String = view.firstPol.getText();
                String pol2String = view.secondPol.getText();

                pol1.setPolynomial(pol1.parseString(pol1String));
                pol2.setPolynomial(pol2.parseString(pol2String));

                Polynomial polRes = model.subtraction(pol1, pol2);
                view.resultPol.setText(polRes.toString(polRes));
            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }

        }
    }

    class MulListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polynomial pol1 = new Polynomial();
            Polynomial pol2 = new Polynomial();

            try {
                String pol1String = view.firstPol.getText();
                String pol2String = view.secondPol.getText();

                pol1.setPolynomial(pol1.parseString(pol1String));
                pol2.setPolynomial(pol2.parseString(pol2String));

                Polynomial polRes = model.multiply(pol1, pol2);
                view.resultPol.setText(polRes.toString(polRes));
            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }

        }
    }

    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.resultPol.setText("Nu s-a realizat operatia.");
        }
    }
    class DerivativeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polynomial pol1 = new Polynomial();
            Polynomial pol2 = new Polynomial();

            try {
                String pol1String = view.firstPol.getText();

                pol1.setPolynomial(pol1.parseString(pol1String));

                Polynomial polRes = model.derivative(pol1);
                view.resultPol.setText(polRes.toString(polRes));
            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }

        }
    }

    class IntegrationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polynomial pol1 = new Polynomial();

            try {
                String pol1String = view.firstPol.getText();

                pol1.setPolynomial(pol1.parseString(pol1String));

                Polynomial polRes = model.integration(pol1);
                view.resultPol.setText(polRes.toString(polRes));
            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }

        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                view.firstPol.setText("");
                view.secondPol.setText("");
                view.resultPol.setText("");
            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }

        }
    }
}

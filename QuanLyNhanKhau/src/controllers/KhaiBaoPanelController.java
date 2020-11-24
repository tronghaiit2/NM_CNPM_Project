package controllers;

import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTextField;



/**
 *
 * @author Dung
 */
public class KhaiBaoPanelController {
    private JButton JBtn;
    private JTextField JTextField1;
    private Choice Choice1;

    public KhaiBaoPanelController(JButton jBtn, JTextField jTextField1) {
        this.JBtn = jBtn;
        this.JTextField1 = jTextField1;
    }
    
    //getter and setter
    public JButton getJBtn() {
        return JBtn;
    }

    public void setJBtn(JButton JBtn) {
        this.JBtn = JBtn;
    }

    public JTextField getJTextField1() {
        return JTextField1;
    }

    public void setJTextField1(JTextField JTextField1) {
        this.JTextField1 = JTextField1;
    }

    public Choice getChoice1() {
        return Choice1;
    }

    public void setChoice1(Choice Choice1) {
        this.Choice1 = Choice1;
    }
    
    
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
    private Container cp;
    private JLabel jlbid = new JLabel("ID: ");
    private JLabel jlbpw = new JLabel("PassWord: ");
    private JTextField jtfid = new JTextField();
    private JPasswordField jpwf = new JPasswordField();
    private JButton jbtexit = new JButton("Exit");
    private JButton jbtlogin = new JButton("Login");

    private Dimension dis = Toolkit.getDefaultToolkit().getScreenSize();
    private int frW = 300, frH = 150, disW, disH;

    public LoginFrame(){
        initComp();
    }

    private void initComp(){
        disW = dis.width;
        disH = dis.height;
        this.setBounds(disW/2-frW/2,disH/2-frH/2,frW,frH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cp = this.getContentPane();
        cp.setLayout(new GridLayout(3,2,3,3));
        cp.add(jlbid);
        jlbid.setHorizontalAlignment(SwingConstants.RIGHT);
        cp.add(jtfid);
        cp.add(jlbpw);
        jlbpw.setHorizontalAlignment(SwingConstants.RIGHT);
        cp.add(jpwf);
        cp.add(jbtexit);
        cp.add(jbtlogin);

        jbtexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jbtlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtfid.getText().equals("h304") && new String(jpwf.getPassword()).equals("23323456")){
                    MainFrame mfm = new MainFrame(LoginFrame.this);
                    mfm.setVisible(true);
                    LoginFrame.this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(LoginFrame.this,"Error");
                }

            }
        });


    }
}

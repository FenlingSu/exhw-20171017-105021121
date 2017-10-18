import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    private Dimension dis = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 400, frmH = 500, disW, disH;
    private Container cp;
    private JTextField jtf = new JTextField();
    private JPanel jpn = new JPanel(new GridLayout(4,3));
    private JButton jbtn[] = new JButton[10];
    private JButton jbtndelete = new JButton("Delete");
    private JButton jbtndot = new JButton(".");
    private int ran, j=0;
    private Random random = new Random();
    private int[] arr = new int[10];


    LoginFrame loginFrame;
    public MainFrame(LoginFrame login){
        loginFrame = login;
        initComp();
    }

    private void initComp(){
        disW = dis.width;
        disH = dis.height;
        this.setBounds(disW/2-frmW/2,disH/2-frmH/2,frmW,frmH);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });

        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(jtf, BorderLayout.NORTH);
        jtf.setEditable(false);
        cp.add(jpn, BorderLayout.CENTER);

        for(int j=0; j<10; j++)
            arr[j] = j;

        for (int j = 0; j < 10; j++) {                          //參考網路做法(洗牌法)
            ran = random.nextInt(10);
            int tmp = arr[ran];
            arr[ran] = arr[j];
            arr[j] = tmp;
        }

        for(int i =0; i<10 ;i++) {

            jbtn[i] = new JButton(Integer.toString(arr[i]));
            jpn.add(jbtn[i]);
            jbtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tempbtn = (JButton) e.getSource();
                    jtf.setText(jtf.getText() + tempbtn.getText());
                }
            });
        }

        jpn.add(jbtndot);
        jbtndot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText(jtf.getText()+".");
            }
        });
        jpn.add(jbtndelete);
        jbtndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
            }
        });


    }
}
